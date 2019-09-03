package com.zisal.messaging.producer.config;

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

    @Value("${rabbitmq.fanout.exchange}")
    private String exchangeName;

    @Value("${rabbitmq.fanout.exchange-reply}")
    private String exchangeReplyName;

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(exchangeName);
    }

    @Bean
    public FanoutExchange fanoutExchangeReply() {
        return new FanoutExchange(exchangeReplyName);
    }

    @Value("${rabbitmq.fanout.queue}")
    private String queueName;

    @Bean
    public Queue queueFanout() {
        return new Queue(queueName);
    }

    @Value("${rabbitmq.fanout.queue-reply}")
    private String queueReplyName;

    @Bean
    public Queue queueFanoutReply() {
        return new Queue(queueReplyName);
    }

    @Bean
    public List<Declarable> fanoutBindings() {
        return Arrays.asList(
                fanoutExchange(),
                queueFanout(),
                BindingBuilder.bind(queueFanout()).to(fanoutExchange())
        );
    }

    @Bean
    public List<Declarable> fanoutBindingsReply() {
        return Arrays.asList(
                fanoutExchangeReply(),
                queueFanoutReply(),
                BindingBuilder.bind(queueFanoutReply()).to(fanoutExchangeReply())
        );
    }
}
