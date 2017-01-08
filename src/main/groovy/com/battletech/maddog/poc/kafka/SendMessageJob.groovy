package com.battletech.maddog.poc.kafka

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class SendMessageJob {

    @Autowired
    SenderHandler senderHandler

    @Scheduled(initialDelayString = "5000", fixedDelayString = "10000")
    void sendMessageJob(){
        senderHandler.sendMessageSync("default.t", "Test Message ${System.currentTimeMillis()}")
    }

}
