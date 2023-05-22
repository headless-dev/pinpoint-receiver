package com.headless.notificationreceiver.pinpoint

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonTypeName

@JsonTypeName("DataSourceAlarmListValueAgentChecker")
data class DataSourceAlarmListValueAgentChecker
@JsonCreator
constructor(override val name: String, override val detectedValue: List<DetectedAgent<DataSourceAlarmList>>)
    : AgentChecker<DetectedAgent<DataSourceAlarmList>>(detectedValue)