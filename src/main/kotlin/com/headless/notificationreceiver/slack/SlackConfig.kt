package com.headless.notificationreceiver.slack

import com.slack.api.Slack
import com.slack.api.methods.MethodsClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SlackConfig {
    @Bean
    fun slackClient(): MethodsClient {
        return Slack.getInstance().methods(System.getenv("SLACK_TOKEN"))
    }
}