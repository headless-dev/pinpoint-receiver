package com.headless.notificationreceiver.pinpoint

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonTypeName

@JsonTypeName("BooleanValueAgentChecker")
data class BooleanValueAgentChecker
@JsonCreator
constructor(override val detectedValue: List<DetectedAgent<Boolean>>)
    : AgentChecker<DetectedAgent<Boolean>>(detectedValue)