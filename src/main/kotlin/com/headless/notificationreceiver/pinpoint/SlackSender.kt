package com.headless.notificationreceiver.pinpoint

import com.slack.api.methods.MethodsClient
import com.slack.api.model.Attachment
import com.slack.api.model.Field
import org.springframework.stereotype.Component

@Component
class SlackSender(private val slackClient: MethodsClient) {

    fun send(pinpointBody: PinpointBody) {
        val attachment = Attachment()
        attachment.color = System.getenv("SLACK_ATTACHMENT_COLOR")
        attachment.title = System.getenv("SLACK_ATTACHMENT_TITLE")
        attachment.titleLink = System.getenv("SLACK_ATTACHMENT_TITLE_LINK")

        val checker = pinpointBody.checker ?: throw InvalidCheckerException(pinpointBody)
        val infoField = Field()
        infoField.title = checker.name
        infoField.value = "Threshold: ${pinpointBody.threshold}"

        val textField = Field()
        textField.title = pinpointBody.applicationId
        textField.value = getValue(pinpointBody)
        attachment.fields = arrayListOf(infoField, textField)
        slackClient.chatPostMessage { it.channel(System.getenv("SLACK_CHANNEL_ID")).attachments(listOf(attachment)) }
    }

    private fun getValue(pinpointBody: PinpointBody): String {
        var env = System.getenv("SLACK_ATTACHMENT_VALUE")
        for (field in pinpointBody::class.java.fields) {
            field.canAccess(true)
            env = env.replace("\$${field.name}", field.get(this).toString())
        }
        val valueString = StringBuilder()
        val checker = pinpointBody.checker!!
        for (agent in checker.getDetectedValue) {
            if (agent is DetectedAgent<*>) {
                valueString.append("${agent.agentValue}(${agent.agentId})")
            } else {
                valueString.append(agent)
            }
        }
        return env.replace("\$name", checker.name ?: "").replace("\$value", valueString.toString())
    }
}