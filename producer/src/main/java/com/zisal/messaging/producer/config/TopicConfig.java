package com.zisal.messaging.producer.config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created on 3/1/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Configuration
public class TopicConfig {

    @Value("${rabbitmq.topic.exchange}")
    private String exchangeName;

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(exchangeName);
    }
}
