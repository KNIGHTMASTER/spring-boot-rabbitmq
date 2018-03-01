package com.zisal.messaging.producer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created on Mar 1, 2018
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringBootApplication
@EnableScheduling
public class ProducerApplication implements CommandLineRunner {

    public static void main(String [] args) {
        SpringApplication.run(ProducerApplication.class);
    }

    @Override
    public void run(String... strings) throws Exception {
    }
}
