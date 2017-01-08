package com.battletech.maddog.poc.kafka

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling

@Configuration
@EnableAutoConfiguration
@EnableScheduling
@ComponentScan(['com.battletech.maddog.poc.kafka'])
class KafkaExampleApp {

    static void main(String[] args) {
        SpringApplication.run(KafkaExampleApp.class, args)
    }
}
