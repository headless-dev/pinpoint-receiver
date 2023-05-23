package com.headless.notificationreceiver.pinpoint

import com.slack.api.methods.MethodsClient
import com.slack.api.model.Attachment
import com.slack.api.model.Field
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class SlackSender(private val slackClient: MethodsClient) {

    private val log = LoggerFactory.getLogger(javaClass)
    fun send(pinpointBody: PinpointBody) {
        log.info("Body: {}", pinpointBody)
        val attachment = Attachment()
        attachment.color = System.getenv("SLACK_ATTACHMENT_COLOR")
        attachment.title = System.getenv("SLACK_ATTACHMENT_TITLE")
        attachment.titleLink = System.getenv("SLACK_ATTACHMENT_TITLE_LINK")

        val checker = pinpointBody.checker
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
        val valueString = StringBuilder()
        val checker = pinpointBody.checker
        for (agent in checker.getDetectedValue) {
            if (agent is DetectedAgent<*>) {
                valueString.append("${agent.agentValue}(${agent.agentId})")
            } else {
                valueString.append(agent)
            }
        }
        val env = System.getenv("SLACK_ATTACHMENT_VALUE")
        return env.replace("\$name", checker.name)
            .replace("\$value", valueString.toString())
            .replace("\$pinpointUrl", pinpointBody.pinpointUrl ?: "\$pinpointUrl")
            .replace("\$batchEnv", pinpointBody.batchEnv)
            .replace("\$applicationId", pinpointBody.applicationId)
            .replace("\$serviceType", pinpointBody.serviceType)
            .replace("\$userGroupId", pinpointBody.userGroup.userGroupId)
            .replace("\$userGroupMembers", pinpointBody.userGroup.userGroupMembers.toString())
            .replace("\$unit", pinpointBody.unit ?: "")
            .replace("\$threshold", pinpointBody.threshold.toString())
            .replace("\$notes", pinpointBody.notes ?: "")
            .replace("\$sequenceCount", pinpointBody.sequenceCount.toString())
    }
}