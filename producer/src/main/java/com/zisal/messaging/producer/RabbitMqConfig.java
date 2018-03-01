package com.zisal.messaging.producer;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
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
public class RabbitMqConfig {

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

    @Value("${rabbitmq.exchange}")
    String exchangeName;

    @Value("${rabbitmq.exfanout}")
    String fanoutExchangeName;

    @Value("${rabbitmq.queue}")
    String queueName;

    @Value("${rabbitmq.quefanout}")
    String fanoutQueueName;

    @Value("${rabbitmq.quefanout2}")
    String fanoutQueueName2;

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(exchangeName, true, false);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(fanoutExchangeName);
    }

    @Bean
    public Queue queue() {
        return new Queue(queueName);
    }

    @Bean
    public Queue queueFanout() {
        return new Queue(fanoutQueueName);
    }

    @Bean
    public Queue queueFanout2() {
        return new Queue(fanoutQueueName2);
    }

    @Bean
    public ProducerService producerService() {
        return new ProducerService();
    }

    @Bean
    public List<Declarable> topicBindings() {
        return Arrays.asList(
                queue(),
                topicExchange(),
                BindingBuilder.bind(queue()).to(topicExchange()).with("*.broadcast.*")
        );
    }

    @Bean
    public List<Declarable> fanoutBindings() {
        return Arrays.asList(
                queueFanout(),
                queueFanout2(),
                fanoutExchange(),
                BindingBuilder.bind(queueFanout()).to(fanoutExchange()),
                BindingBuilder.bind(queueFanout2()).to(fanoutExchange())
        );
    }
}
