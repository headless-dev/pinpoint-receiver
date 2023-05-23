package com.headless.notificationreceiver.pinpoint


data class PinpointBody (
    val pinpointUrl: String?,
    val batchEnv: String,
    val applicationId: String,
    val serviceType: String,
    val userGroup: UserGroup,
    val checker: Checker<Any>,
    val unit: String?,
    val threshold: Int,
    val notes: String?,
    val sequenceCount: Int,
)