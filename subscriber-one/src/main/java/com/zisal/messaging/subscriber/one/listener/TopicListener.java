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
public class TopicListener implements IReceiver<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(FanoutListener.class);

    @RabbitListener(queues = "${rabbitmq.topic.queue}")
    @Override
    public void receive(String p_DATA) {
        LOGGER.info("Receved Topic Exchange Message : "+p_DATA);
    }
}
