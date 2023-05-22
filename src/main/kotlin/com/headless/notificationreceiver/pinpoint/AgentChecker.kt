package com.headless.notificationreceiver.pinpoint

abstract class AlarmChecker<T>(private val detectedValue: T) : Checker() {
    override val getDetectedValueString: String
        get() = detectedValue.toString()
}