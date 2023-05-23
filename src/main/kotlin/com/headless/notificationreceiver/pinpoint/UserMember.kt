package com.headless.notificationreceiver.pinpoint

data class UserMember (
    val id: String,
    val name: String,
    val email: String?,
    val department: String?,
    val phoneNumber: String?,
    val phoneCountryCode: String?
)