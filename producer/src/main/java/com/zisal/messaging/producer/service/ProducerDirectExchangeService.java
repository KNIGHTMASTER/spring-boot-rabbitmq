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
public class ProducerDirectExchangeService implements IProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${rabbitmq.direct.exchange}")
    private String exchangeName;

    @Value("${rabbitmq.direct.route1}")
    private String route1;

    @Value("${rabbitmq.direct.route2}")
    private String route2;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerDirectExchangeService.class);

    @Scheduled(fixedDelay = 1000L)
    @Override
    public void send() {
        int a = new Random().nextInt();
        LOGGER.info("Direct Exchange Send "+a);
        this.amqpTemplate.convertAndSend(exchangeName, route1, "Content From Direct Exchange Producer : " +a);
        this.amqpTemplate.convertAndSend(exchangeName, route2, "Content From Direct Exchange Producer : " +a);
    }

}
