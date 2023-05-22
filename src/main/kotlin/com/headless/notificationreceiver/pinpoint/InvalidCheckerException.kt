package com.headless.notificationreceiver.pinpoint

class InvalidCheckerException(private val pinpointBody: Any) : RuntimeException() {
    override val message: String
        get() = "Checker is not found $pinpointBody"
}