package com.headless.notificationreceiver.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class WebhookReceiver {

    @PostMapping("/slack")
    fun slack(@RequestBody)
}