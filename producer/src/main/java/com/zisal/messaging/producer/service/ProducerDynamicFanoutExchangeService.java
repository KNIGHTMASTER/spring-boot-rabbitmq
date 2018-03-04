package com.zisal.messaging.producer.service;

import com.zisal.messaging.producer.IProducer;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Random;

/**
 * Created on 3/2/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ProducerDynamicFanoutExchangeService implements IProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

//    @Value("${rabbitmq.dynamic.fanout.exchange}")
    private String exchangeName;

    @Scheduled(fixedDelay = 1000L)
    @Override
    public void send() {
        int a = new Random().nextInt();
        System.out.println("sending fanout "+a);
        amqpTemplate.convertAndSend(exchangeName,"", "This is content from dynamic queue "+a);
    }

    /*@Scheduled(fixedDelay = 1000L)
    public void send2() {
        int a = new Random().nextInt();
        amqpTemplate.convertAndSend(exchangeName, "#.route2.#", "This is content 2 from dynamic queue "+a);
    }*/
}
