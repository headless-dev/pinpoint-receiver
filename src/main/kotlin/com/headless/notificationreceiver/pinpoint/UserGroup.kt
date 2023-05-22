package com.headless.notificationreceiver.pinpoint

data class UserGroup (
    val userGroupId: String,
    val userGroupMembers: List<UserMember>
)