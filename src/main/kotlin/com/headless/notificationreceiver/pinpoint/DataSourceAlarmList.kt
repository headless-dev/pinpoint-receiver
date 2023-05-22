package com.headless.notificationreceiver.pinpoint

class DataSourceAlarmList : ArrayList<DataSourceAlarm>() {
    override fun toString(): String {
        val agentValues = StringBuilder()
        for (dataSourceAlarm in this) {
            agentValues.append(dataSourceAlarm.toString()).append("\n")
        }
        return agentValues.toString()
    }
}