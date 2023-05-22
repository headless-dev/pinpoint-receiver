package com.headless.notificationreceiver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NotificationReceiverApplication

fun main(args: Array<String>) {
    runApplication<NotificationReceiverApplication>(*args)
}
