package ru.senko.robotshop.controller

import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.senko.robotshop.sender.RobotFactorySender

@RestController
@RequestMapping("api/v1/rabbit")
class RabbitMqTestController @Autowired constructor(_sender : RobotFactorySender) {

    private val sender: RobotFactorySender

    init {
        this.sender = _sender
    }

    @GetMapping("/send")
    @Operation(summary = "Отправить сообщение в rabbit mq")
    fun findProductsList(@RequestParam message: String) {
        this.sender.sendMessage(message)
    }

}