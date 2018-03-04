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
public class DirectListener implements IReceiver<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DirectListener.class);

    @RabbitListener(queues = "${rabbitmq.direct.queue}")
    @Override
    public void receive(String p_DATA) {
        LOGGER.info("Received Direct Exchange Message : "+p_DATA);
    }
}
