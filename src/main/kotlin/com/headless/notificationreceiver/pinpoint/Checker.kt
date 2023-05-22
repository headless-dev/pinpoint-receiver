package com.headless.notificationreceiver.pinpoint

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    property = "type")
@JsonSubTypes(value = [
    JsonSubTypes.Type(value = LongValueAgentChecker::class, name = "LongValueAgentChecker"),
    JsonSubTypes.Type(value = LongValueAlarmChecker::class, name = "LongValueAlarmChecker"),
    JsonSubTypes.Type(value = BooleanValueAgentChecker::class, name = "BooleanValueAgentChecker"),
    JsonSubTypes.Type(value = DataSourceAlarmListValueAgentChecker::class, name = "DataSourceAlarmListValueAgentChecker"),
])
abstract class Checker<T> {
    open val name: String? = null
    abstract val getDetectedValue: List<T>
}