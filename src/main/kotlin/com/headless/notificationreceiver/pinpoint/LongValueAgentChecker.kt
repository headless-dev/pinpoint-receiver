package com.headless.notificationreceiver.pinpoint

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonTypeName

@JsonTypeName("LongValueAgentChecker")
data class LongValueAgentChecker
@JsonCreator
constructor(override val name: String, override val detectedValue: List<DetectedAgent<Long>>)
    : AgentChecker<DetectedAgent<Long>>(detectedValue)