package ru.senko.robotfactory.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;


/**
 * Слушатель входящих сообщений от robot-shop
 */
@Slf4j
@Service
public class RobotFactoryListener {

    @RabbitListener(queues = {"${application.rabbitmq.queue.robot-shop-out.topic}"})
    public void listen(String message) {
        log.info("receive message: {}", message);
    }

}
