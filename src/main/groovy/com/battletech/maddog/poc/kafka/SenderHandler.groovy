package com.battletech.maddog.poc.kafka

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Component
import org.springframework.util.concurrent.ListenableFuture
import org.springframework.util.concurrent.ListenableFutureCallback

@Component
class SenderHandler {

    static final Logger LOG = LoggerFactory.getLogger(SenderHandler.class)

    @Autowired
    KafkaTemplate<Integer,String> kafkaTemplate

    void sendMessageAsync(String topic, String message) {
        ListenableFuture<SendResult<?, String>> future = kafkaTemplate.send(topic, message)
        future.addCallback(
                new ListenableFutureCallback<SendResult<Integer,String>>() {

                    @Override
                    void onSuccess(SendResult<Integer,String> result) {
                        LOG.info("sent message='{}' with offset={}", message, result.getRecordMetadata().offset())
                    }

                    @Override
                    void onFailure(Throwable ex) {
                        LOG.error("unable to send message='{}'", message, ex)
                    }
                })
    }

    void sendMessageSync(String topic, String message){
        ListenableFuture<SendResult<Integer, String>> future = kafkaTemplate.send(topic, message)
        try{
            SendResult<Integer, String> result = future.get()
            LOG.info("sent message='{}' with offset={}", message, result.getRecordMetadata().offset())

        } catch (Exception ex){
            LOG.error("unable to send message='{}'", message, ex)
        }
    }
}
