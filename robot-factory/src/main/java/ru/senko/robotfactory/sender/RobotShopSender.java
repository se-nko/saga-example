package ru.senko.robotfactory.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


/**
 * Класс-отправитель сообщений во входную очередь robot-factory.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RobotShopSender {

    @Value("${application.rabbitmq.queue.robot-factory-in.routing-key}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {
        log.info("send message with routingKey: {}, message: {}", routingKey, message);
        rabbitTemplate.convertAndSend(routingKey, message);
    }

}
