package com.battlemech.maddog.poc.kafka

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Service

@Service
class ReceiverHandler {
    static final Logger LOG = LoggerFactory.getLogger(ReceiverHandler.class)

    @KafkaListener(topics = ["default.t"])
    void listen(@Payload String message,
                @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) def key,
                @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        LOG.info("received key='{}'", key)
        LOG.info("received topic='{}'", topic)
        LOG.info("received message='{}'", message)
    }
}
