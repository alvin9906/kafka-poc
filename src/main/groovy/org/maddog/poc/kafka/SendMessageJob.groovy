package org.maddog.poc.kafka

import org.maddog.poc.kafka.service.SenderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Profile("include-sender")
@Component
class SendMessageJob {

    @Autowired
    SenderService senderService

    @Scheduled(initialDelayString = "5000", fixedDelayString = "10000")
    void sendMessageJob(){
        senderService.sendMessage("default.t", "Test Message")
    }

}
