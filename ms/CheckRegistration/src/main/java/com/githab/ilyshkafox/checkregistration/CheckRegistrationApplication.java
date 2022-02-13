package com.githab.ilyshkafox.checkregistration;

import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@EnableKafka
//@EnableKafkaStreams
@SpringBootApplication
public class CheckRegistrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CheckRegistrationApplication.class, args);
    }

}
