package com.zisal.messaging.subscriber.one.listener;

import com.rabbitmq.client.Channel;
import com.zisal.messaging.shared.IReceiver;
import com.zisal.messaging.subscriber.one.producer.ProducerFanoutExchangeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created on 3/1/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class FanoutListener implements IReceiver<String> {

    @Autowired
    private ProducerFanoutExchangeService producerFanoutExchangeService;

    private static final Logger LOGGER = LoggerFactory.getLogger(FanoutListener.class);

//    @RabbitListener(queues = "${rabbitmq.fanout.queue}")
    @Override
    public void receive(String p_DATA) {
        LOGGER.info("Received Fanout Exchange Message : "+p_DATA);
    }

    @RabbitListener(queues = "${rabbitmq.fanout.queue}")
    public void receive2(String p_DATA, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        LOGGER.info("Received Fanout Exchange Message : "+p_DATA);
        try {
            channel.basicAck(tag, false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        producerFanoutExchangeService.sendMessage("REPLY MESSAGE "+p_DATA);
    }
}
