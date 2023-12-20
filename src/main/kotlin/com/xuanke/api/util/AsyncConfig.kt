package com.xuanke.api.util

import org.springframework.boot.SpringBootConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.AsyncConfigurer
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.Executor

@SpringBootConfiguration
@EnableAsync

class AsyncConfig : AsyncConfigurer{
    @Bean
    fun taskExecutor(): ThreadPoolTaskExecutor{
        val executor = ThreadPoolTaskExecutor()
        executor.apply {
            corePoolSize = 10
            maxPoolSize = 100
            queueCapacity = 1000
            setThreadNamePrefix("Thread")
            initialize()
        }
        return executor
    }

    override fun getAsyncExecutor(): Executor? {
        return taskExecutor()
    }
}