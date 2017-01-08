package com.battlemech.maddog.poc.kafka

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class SendMessageJob {

    @Autowired
    SenderHandler senderService

    @Scheduled(initialDelayString = "5000", fixedDelayString = "10000")
    void sendMessageJob(){
        senderService.sendMessageSync("default.t", "Test Message")
    }

}
