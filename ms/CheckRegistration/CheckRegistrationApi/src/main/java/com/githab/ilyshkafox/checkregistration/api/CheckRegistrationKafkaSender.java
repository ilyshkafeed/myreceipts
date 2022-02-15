package com.githab.ilyshkafox.checkregistration.api;

import com.githab.ilyshkafox.checkregistration.api.dto.ReceiptNewMsq;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@ConditionalOnProperty("spring.kafka.producer.bootstrap-servers")
@RequiredArgsConstructor
public class CheckRegistrationKafkaSender {
    private final KafkaTemplate<String, Object> template;

    public Mono<Void> sendReceipt(ReceiptNewMsq msg) {
        return Mono.fromRunnable(() -> template.send(KafkaTopicConfig.TOPIC_RECEIPT, msg));
    }
}
