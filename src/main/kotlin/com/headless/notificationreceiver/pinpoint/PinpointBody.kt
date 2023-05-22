package com.headless.notificationreceiver.pinpoint


data class PinpointBody (
    val pinpointUrl: String = "",
    val batchEnv: String = "",
    val applicationId: String = "",
    val serviceType: String = "",
    val userGroup: UserGroup?,
    val unit: String = "",
    val checker: Checker<Any>?,
    val threshold: Int = 0,
    val notes: String = "",
    val sequenceCount: Int = 0,
)