package com.xuanke.api.util

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.DirectExchange
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.amqp.core.Queue
import org.springframework.boot.SpringBootConfiguration
import org.springframework.context.annotation.Bean

@SpringBootConfiguration
class QueueConfig(@Autowired private val env: Environment) {

    /**
     * 定义交换机和队列
     */
    @Bean("basicQueue")
    fun basicQueue(): Queue{
        return Queue(env.getProperty("mq.basic.info.queue.name"), true)
    }

    @Bean
    fun basicExchange(): DirectExchange{
        return DirectExchange(env.getProperty("mq.basic.info.exchange.name") ,true, false)
    }

    /**
     * 定义队列要绑定到哪个交换机上，同时指定routingKey是什么
     */
    @Bean
    fun basicBinding(): Binding{
        return BindingBuilder.bind(basicQueue()).to(basicExchange()).with(env.getProperty("mq.basic.info.routing.key.name"))
    }
}