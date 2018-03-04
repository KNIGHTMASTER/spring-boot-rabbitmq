package com.zisal.messaging.subscriber.two.config;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarable;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * Created on 3/1/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Configuration
public class FanoutConfig {

    @Value("${rabbitmq.fanout.queue}")
    private String queueName;

    @Value("${rabbitmq.fanout.exchange}")
    private String exchangeName;

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(exchangeName);
    }

    @Bean
    public Queue queueFanout() {
        return new Queue(queueName);
    }

    @Bean
    public List<Declarable> fanoutBindings() {
        return Arrays.asList(
                fanoutExchange(),
                queueFanout(),
                BindingBuilder.bind(queueFanout()).to(fanoutExchange())
        );
    }
}
