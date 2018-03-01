package com.zisal.messaging.subscriber.one;

import org.springframework.stereotype.Component;

/**
 * Created on 3/1/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class SubscriberOneService {

    /*@RabbitListener(queues="${rabbitmq.queue}", containerFactory="simpleRabbitListenerContainerFactory")
    public void receive(@Payload String p_ContentMessage){
        System.out.println("Content Message " + p_ContentMessage);
    }*/
}
