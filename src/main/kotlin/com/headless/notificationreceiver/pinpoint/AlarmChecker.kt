package com.headless.notificationreceiver.pinpoint

abstract class AlarmChecker<T>(protected open val detectedValue: T) : Checker<T>() {
    override val getDetectedValue: List<T>
        get() = listOf(detectedValue)
}