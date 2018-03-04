package com.zisal.messaging.producer.service;

import com.zisal.messaging.producer.IProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Random;

/**
 * Created on 3/1/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ProducerFanoutExchangeService implements IProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${rabbitmq.fanout.exchange}")
    private String exchangeName;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerDirectExchangeService.class);

    @Scheduled(fixedDelay = 1000L)
    @Override
    public void send() {
        int a = new Random().nextInt();
        LOGGER.info("Fanout Exchange Send "+a);
        this.amqpTemplate.convertAndSend(exchangeName,"", "Content From Fanout Exchange Producer" +a);
    }

}
