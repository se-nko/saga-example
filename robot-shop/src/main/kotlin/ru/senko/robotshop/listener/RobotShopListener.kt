package ru.senko.robotshop.listener

import mu.KotlinLogging
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

@Service
class RobotShopListener {

    private val log = KotlinLogging.logger {}

    @RabbitListener(queues = ["\${application.rabbitmq.queue.robot-factory-out.topic}"])
    fun listen(message : String) {
        log.info("receive the message: $message")
    }

}