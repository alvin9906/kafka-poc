package org.maddog.poc.kafka.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Component
import org.springframework.util.concurrent.ListenableFuture
import org.springframework.util.concurrent.ListenableFutureCallback

@Component
class SenderService {

    static final Logger LOG = LoggerFactory.getLogger(SenderService.class)

    @Autowired
    KafkaTemplate<Integer, String> kafkaTemplate

    void sendMessage(String topic, String message) {
        // the KafkaTemplate provides asynchronous send methods returning a
        // Future
        ListenableFuture<SendResult<Integer, String>> future = kafkaTemplate.send(topic, message)
        // you can register a callback with the listener to receive the result
        // of the send asynchronously
        future.addCallback(
                new ListenableFutureCallback<SendResult<Integer, String>>() {

                    @Override
                    void onSuccess(
                            SendResult<Integer, String> result) {
                        LOG.info("sent message='{}' with offset={}", message, result.getRecordMetadata().offset())
                    }

                    @Override
                    void onFailure(Throwable ex) {
                        LOG.error("unable to send message='{}'", message, ex)
                    }
                })

        // alternatively, to block the sending thread, to await the result,
        // invoke the future’s get() method
    }
}
