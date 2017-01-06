package org.maddog.poc.kafka

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling

@Configuration
@EnableAutoConfiguration
@EnableScheduling
@ComponentScan(['org.maddog.poc.kafka'])
class KafkaApp {

    static void main(String[] args) {
        SpringApplication.run(KafkaApp.class, args)
    }
}
