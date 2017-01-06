package org.maddog.poc.kafka.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class ReceiverService {
    static final Logger LOG = LoggerFactory.getLogger(ReceiverService.class)

    @KafkaListener(topics = ["default.t"])
    void receiveMessage(String message) {
        LOG.info("received message='{}'", message)
    }
}
