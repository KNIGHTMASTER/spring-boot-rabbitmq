package com.zisal.messaging.subscriber.one.config;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarable;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * Created on 3/4/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Configuration
public class TopicConfig  {

    @Value("${rabbitmq.topic.exchange}")
    private String exchangeName;

    @Value("${rabbitmq.topic.queue}")
    private String queue1Name;

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(exchangeName);
    }

    @Bean
    public Queue queueTopic() {
        return new Queue(queue1Name);
    }

    @Bean
    public List<Declarable> topicBindings() {
        return Arrays.asList(
                topicExchange(),
                queueTopic(),
                BindingBuilder.bind(queueTopic()).to(topicExchange()).with("*.topic"),
                BindingBuilder.bind(queueTopic()).to(topicExchange()).with("*.topic.*")
        );
    }
}