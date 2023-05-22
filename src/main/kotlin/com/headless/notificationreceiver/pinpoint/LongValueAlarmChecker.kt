package com.headless.notificationreceiver.pinpoint

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonTypeName

@JsonTypeName("LongValueAgentChecker")
class LongValueAgentChecker
@JsonCreator
constructor(detectedValue: List<DetectedAgent<Long>>) : AgentChecker<DetectedAgent<Long>>(detectedValue)