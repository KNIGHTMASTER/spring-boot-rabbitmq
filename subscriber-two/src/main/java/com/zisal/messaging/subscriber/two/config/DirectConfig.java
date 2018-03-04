package com.zisal.messaging.subscriber.two.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created on 3/1/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Configuration
public class DirectConfig {

    @Value("${rabbitmq.direct.queue}")
    private String queueName;

    @Value("${rabbitmq.direct.exchange}")
    private String exchangeName;

    @Value("${rabbitmq.direct.route2}")
    private String route2;

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(exchangeName);
    }

    @Bean
    public Queue queueDirect() {
        return new Queue(queueName);
    }

    @Bean
    public Binding directBinding() {
        return BindingBuilder.bind(queueDirect()).to(directExchange()).with(route2);
    }
}
