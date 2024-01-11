package ru.senko.robotshop.sender

import mu.KotlinLogging
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class RobotFactorySender @Autowired constructor(_rabbitTemplate : RabbitTemplate) {

    private val log = KotlinLogging.logger {}

    @Value("\${application.rabbitmq.queue.robot-factory-in.routing-key}")
    lateinit var routingKey: String

    private val rabbitTemplate: RabbitTemplate

    init {
        this.rabbitTemplate = _rabbitTemplate
    }

    fun sendMessage(message: String) {
        log.info("send the message routingKey: $routingKey content: $message")
        rabbitTemplate.convertAndSend(routingKey, message)
    }

}