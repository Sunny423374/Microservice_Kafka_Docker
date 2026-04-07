package com.Microservice.Service1.kafka;

import com.Microservice.Service1.dto.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "topic1")
    public void listen(OrderDto orderDto) {

        log.info("Received OrderDto topic 1: {}", orderDto);

    }

    @KafkaListener(topics = "topic2")
    public void listen2(OrderDto orderDto) {
        log.info("Received OrderDto topic 2: {}", orderDto);
    }

    @KafkaListener(topics = "topic3")
    public void listen3(String msg) {
        log.info("Received Data topic 3: {}", msg);
    }
}
