package com.zisal.messaging.producer;

import com.zisal.messaging.producer.service.ProducerDirectExchangeService;
import com.zisal.messaging.producer.service.ProducerDynamicFanoutExchangeService;
import com.zisal.messaging.producer.service.ProducerFanoutExchangeService;
import com.zisal.messaging.producer.service.ProducerTopicExchangeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created on Mar 1, 2018
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringBootApplication
@EnableScheduling
public class ProducerApplication {

    public static void main(String [] args) {
        SpringApplication.run(ProducerApplication.class);
    }

    @Bean
    @ConditionalOnProperty(value = "messaging.direct.enabled", havingValue = "true")
    public ProducerDirectExchangeService producerDirectExchangeService() {
        return new ProducerDirectExchangeService();
    }

    @Bean
    @ConditionalOnProperty(value = "messaging.topic.enabled", havingValue = "true")
    public ProducerTopicExchangeService producerTopicExchangeService() {
        return new ProducerTopicExchangeService();
    }

    @Bean
    @ConditionalOnProperty(value = "messaging.fanout.enabled", havingValue = "true")
    public ProducerFanoutExchangeService producerFanoutExchangeService() {
        return new ProducerFanoutExchangeService();
    }

//    @Bean
    public ProducerDynamicFanoutExchangeService producerDynamicFanoutExchangeService() {
        return new ProducerDynamicFanoutExchangeService();
    }
}
