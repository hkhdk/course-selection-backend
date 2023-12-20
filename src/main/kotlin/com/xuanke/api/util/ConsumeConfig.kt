package com.xuanke.api.util

import org.springframework.amqp.core.AcknowledgeMode
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringBootConfiguration
import org.springframework.context.annotation.Bean

@SpringBootConfiguration
class ConsumeConfig(@Autowired private val connectionFactory: CachingConnectionFactory) {
    @Bean("singleListenerContainer")
    fun listenerContainerFactory(): SimpleRabbitListenerContainerFactory
    {
        val containerFactory = SimpleRabbitListenerContainerFactory()
        containerFactory.apply {
            setConnectionFactory(connectionFactory)
            setMessageConverter(Jackson2JsonMessageConverter())
            setConcurrentConsumers(5)
            setMaxConcurrentConsumers(5)
            setPrefetchCount(10)    /** 一次最多只能预取10条消息，消费完了再取   */
            setAcknowledgeMode(AcknowledgeMode.AUTO)
        }
        return containerFactory
    }
}