package com.xuanke.api

import com.xuanke.api.controller.CourseSelectionController
import com.xuanke.api.entity.school.Course
import com.xuanke.api.entity.school.Student
import com.xuanke.api.service.CourseSelectionService
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class Consumer(@Autowired private val _service: CourseSelectionService) {

    @RabbitListener(queues = ["local.middleware.mq.basic.info.queue.xuanke"],  containerFactory = "singleListenerContainer")
    fun consumeMsg(@Payload msg: CourseSelectionController.CourseSelectionParam)  // 该参数应该作为消息的有效负载进行处理。
    {
        _service.addCourseSelection(Student.Id(msg.studentId!!), Course.Id(msg.courseId!!))
    }
}