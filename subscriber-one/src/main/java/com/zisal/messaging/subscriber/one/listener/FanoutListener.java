package com.zisal.messaging.subscriber.one.listener;

import com.zisal.messaging.shared.IReceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * Created on 3/1/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class FanoutListener implements IReceiver<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(FanoutListener.class);

    @RabbitListener(queues = "${rabbitmq.fanout.queue}")
    @Override
    public void receive(String p_DATA) {
        LOGGER.info("Received Fanout Exchange Message : "+p_DATA);
    }
}
