package com.xuanke.api

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component
import java.io.UnsupportedEncodingException

@Component
class Publisher (@Autowired private val rabbitTemplate: RabbitTemplate,
                 @Autowired private val environment: Environment){

    /**
     * 定义生产者发送消息的方法，把消息通过指定的交换机和 routingKey 发到指定的队列里
     */
    fun sendMsg(msg: Any){
        try {
            rabbitTemplate.apply {
                messageConverter = Jackson2JsonMessageConverter()
                setExchange(environment.getProperty("mq.basic.info.exchange.name"))
                routingKey = environment.getProperty("mq.basic.info.routing.key.name").toString()
            }

//            val message = MessageBuilder.withBody(msg.toByteArray(Charsets.UTF_8))
//                .setDeliveryMode(MessageDeliveryMode.PERSISTENT).build()

            rabbitTemplate.convertAndSend(msg)
            println("publisher send message!")

        }catch (e: UnsupportedEncodingException){
            e.printStackTrace()
        }
    }
}