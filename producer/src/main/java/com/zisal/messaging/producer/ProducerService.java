package com.zisal.messaging.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created on 3/1/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ProducerService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${rabbitmq.routingkey}")
    private String routingKey;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.exfanout}")
    private String fanout;

//    @Scheduled(fixedDelay = 1000L)
    public void send() {
        int a = new Random().nextInt();
        System.out.println("producer send String "+a);
        this.rabbitTemplate.convertAndSend("example-queue", "hello from rabbit producer "+a, a);
    }

//    @Scheduled(fixedDelay = 2000L)
    public void sendTopic() {
        int a = new Random().nextInt();
        System.out.println("producer send String "+a);
        this.rabbitTemplate.convertAndSend("example-topic", "hello from rabbit producer "+a);
    }

    //@Scheduled(fixedDelay = 2000L)
    public void sendExchange(){
        int a = new Random().nextInt();
        System.out.println("producer send String "+a);
        this.amqpTemplate.convertAndSend(exchange, "info.broadcast.example","Content from Exchange "+a);
    }

    @Scheduled(fixedDelay = 2000L)
    public void sendFanout(){
        int a = new Random().nextInt();
        System.out.println("producer send String fanout "+a);
        this.amqpTemplate.convertAndSend(fanout, "","Content from Fanout "+a);
    }

//    @Scheduled(fixedDelay = 2000L)
    public void sendObject() {
        System.out.println("producer send Object");
        ExampleDTO exampleDTO = new ExampleDTO();
        exampleDTO.setId(1L);
        exampleDTO.setName("John");
        exampleDTO.setAmount(new BigDecimal(1000));

        ExampleDTO exampleDTO2 = new ExampleDTO();
        exampleDTO2.setId(2L);
        exampleDTO2.setName("Doe");
        exampleDTO2.setAmount(new BigDecimal(2000));

        List<ExampleDTO> data = new ArrayList<>();
        data.add(exampleDTO);
        data.add(exampleDTO2);
        this.rabbitTemplate.convertAndSend("example-queue-object", data);
    }
}
