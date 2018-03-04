package com.zisal.messaging.subscriber.two;

import com.zisal.messaging.subscriber.two.listener.DirectListener;
import com.zisal.messaging.subscriber.two.listener.FanoutListener;
import com.zisal.messaging.subscriber.two.listener.TopicListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

/**
 * Created on Mar 1, 2018
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringBootApplication
public class SubscriberTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubscriberTwoApplication.class);
    }

    @Bean
    @ConditionalOnProperty(value = "messaging.direct.enabled", havingValue = "true")
    public DirectListener directListener() {
        return new DirectListener();
    }

    @Bean
    @ConditionalOnProperty(value = "messaging.topic.enabled", havingValue = "true")
    public TopicListener topicListener() {
        return new TopicListener();
    }

    @Bean
    @ConditionalOnProperty(value = "messaging.fanout.enabled", havingValue = "true")
    public FanoutListener fanoutListener() {
        return new FanoutListener();
    }

}
