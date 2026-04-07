package com.Microservice.Service1.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducer {

    @Bean
    public NewTopic createKafkaTopic() {
        return new NewTopic("topic1", 3, (short) 3);
    }

    @Bean
    public NewTopic createKafkaTopic2() {
        return new NewTopic("topic2", 3, (short) 3);
    }

    @Bean
    public NewTopic createKafkaTopic3() {
        return new NewTopic("topic3", 3, (short) 3);
    }
}
