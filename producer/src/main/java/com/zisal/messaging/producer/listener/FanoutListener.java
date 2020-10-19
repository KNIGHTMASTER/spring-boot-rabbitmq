package com.zisal.messaging.producer.listener;

import com.rabbitmq.client.Channel;
import com.zisal.messaging.shared.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * Created on 3/1/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class FanoutListener implements IReceiver<String> {

    @Autowired private EventDetailDAO eventDetailDAO;
    @Autowired private EventDAO eventDAO;

    private static final Logger LOGGER = LoggerFactory.getLogger(FanoutListener.class);

    @RabbitListener(queues = "${rabbitmq.fanout.queue-reply}")
    public void receive(ReplyDTO p_DATA, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        LOGGER.info("Received Fanout Exchange Reply Message : "+p_DATA.toString());
        try {
            channel.basicAck(tag, false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        EventDetail eventDetail = new EventDetail();
        eventDetail.setReceiverName(p_DATA.getReceiverName());
        eventDetail.setStatus(p_DATA.isStatus());
        eventDetail.setEventId(p_DATA.getEventId());
        eventDetailDAO.save(eventDetail);

        /*Get Status for Header*/
        List<EventDetail> eventDetails = eventDetailDAO.findByEventId(p_DATA.getEventId());
        boolean result = true;
        for (EventDetail ed : eventDetails) {
            if (ed.getReceiverName().equals("sub-one") || ed.getReceiverName().equals("sub-two")) {
                if (!ed.getStatus()) {
                    result = false;
                    break;
                }
            }
        }

        /*Change Status for Header*/
        Event event = eventDAO.findById(p_DATA.getEventId());
        event.setStatus(result);
        eventDAO.save(event);
    }

    @Override
    public void receive(String p_DATA) {
    }
}
