package com.githab.ilyshkafox.checkregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
//@EnableKafkaStreams
@SpringBootApplication
public class CheckRegistrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CheckRegistrationApplication.class, args);
    }

}
