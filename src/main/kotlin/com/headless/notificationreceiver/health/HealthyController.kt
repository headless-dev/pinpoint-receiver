package com.headless.notificationreceiver.health

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/health")
class HealthyController {

    @GetMapping
    fun health(): ResponseEntity<String> {
        return ResponseEntity.ok().body("ok")
    }
}