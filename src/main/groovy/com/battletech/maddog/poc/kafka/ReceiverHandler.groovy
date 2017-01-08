package com.battletech.maddog.poc.kafka

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class ReceiverHandler {
    static final Logger LOG = LoggerFactory.getLogger(ReceiverHandler.class)

    @KafkaListener(topics = ["default.t"])

    void listen(ConsumerRecord<?,?> consumerRecord){
        LOG.info("received data='{}'", consumerRecord)
    }
}
