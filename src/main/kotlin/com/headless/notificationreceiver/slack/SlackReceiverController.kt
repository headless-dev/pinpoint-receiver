package com.headless.notificationreceiver.slack

import com.headless.notificationreceiver.pinpoint.PinpointBody
import com.headless.notificationreceiver.pinpoint.SlackSender
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class SlackReceiverController(private val slackSender: SlackSender) {

    @PostMapping("/slack")
    fun slack(@RequestBody pinpointBody: PinpointBody) {
        slackSender.send(pinpointBody)
    }
}