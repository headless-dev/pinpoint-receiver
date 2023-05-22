package com.headless.notificationreceiver.pinpoint

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonTypeName

@JsonTypeName("LongValueAlarmChecker")
data class LongValueAlarmChecker
@JsonCreator
constructor(override val name: String, override val detectedValue: Long) : AlarmChecker<Long>(detectedValue)