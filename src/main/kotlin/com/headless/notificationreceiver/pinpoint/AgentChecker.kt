package com.headless.notificationreceiver.pinpoint

abstract class AgentChecker<T>(protected open val detectedValue: List<T>) : Checker<T>() {
    override val getDetectedValue: List<T>
        get() = detectedValue
}