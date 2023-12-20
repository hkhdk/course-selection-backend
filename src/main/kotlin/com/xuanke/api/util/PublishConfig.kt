//package com.xuanke.api.util
//
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory
//import org.springframework.amqp.rabbit.core.RabbitTemplate
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.SpringBootConfiguration
//import org.springframework.context.annotation.Bean
//
//@SpringBootConfiguration
//class PublishConfig(@Autowired private val connectionFactory: CachingConnectionFactory) {
//    @Bean("rabbitMQTemplate")
//    fun rabbitTemplate(): RabbitTemplate
//    {
//        connectionFactory.apply {
//            setPublisherConfirmType(CachingConnectionFactory.ConfirmType.SIMPLE)
//            isPublisherReturns = true
//        }
//
//        val rabbitTemplate = RabbitTemplate(connectionFactory)
//
//        rabbitTemplate.setMandatory(true)
//
//        rabbitTemplate.setConfirmCallback { _, _, _ ->         // 发送成功
//            println("msg send success")
//        }
//
//        rabbitTemplate.setReturnsCallback { p0 ->              // 发送失败
//            println("msg send fail $p0")
//        }
//
//        return rabbitTemplate
//    }
//}