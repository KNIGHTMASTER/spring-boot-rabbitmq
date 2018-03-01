package com.zisal.messaging.subscriber.one;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created on 3/1/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class FanoutListener {

    @RabbitListener(queues = {"fanout-queue"})
    public void receiveMessageFromFanout(String message) {
        System.out.println("Received fanout 1 message: " + message);
    }
}
