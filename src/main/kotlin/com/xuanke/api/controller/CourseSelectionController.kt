package com.xuanke.api.controller


import com.xuanke.api.Publisher
import com.xuanke.api.UserTokenInterceptor
import com.xuanke.api.badRequest
import com.xuanke.api.entity.school.CourseSelection
import com.xuanke.api.service.CourseSelectionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.config.annotation.InterceptorRegistration

@RestController
@RequestMapping("/selection")
class CourseSelectionController(@Autowired private val _courseSelectionService: CourseSelectionService,
    @Autowired private val _publisher: Publisher
) {
    @Component
    private class UserTokenTarget : UserTokenInterceptor.Target {
        override fun addRules(registration: InterceptorRegistration) {
            registration.addPathPatterns("/selection/**")
        }
    }

    data class PagedCourseSelectionList(
        val page: Int,
        val limit: Int,
        val total: Int,
        val list: List<CourseSelection>,
    )

    @GetMapping(path = ["/list"])
    fun getCourseSelectionList(
        @RequestParam(name = "page", defaultValue = "1") page: Int,
        @RequestParam(name = "limit", defaultValue = "50") limit: Int,
    ): PagedCourseSelectionList {
        if (page <= 0) {
            throw badRequest("page must > 0")
        }
        if (limit <= 0) {
            throw badRequest("limit must > 0")
        }
        return PagedCourseSelectionList(
            page,
            limit,
            _courseSelectionService.readCourseSelectionsCount().toInt(),
            _courseSelectionService.readCourseSelections(page.toUInt(), limit.toUInt())
        )
    }

    data class CourseSelectionParam(
        val studentId: Long?,
        val courseId: Long?,
    )

    @PostMapping("/add")
    fun addCourseSelection(@RequestBody param: CourseSelectionParam) {
        if (param.studentId == null || param.courseId == null) {
            throw badRequest("sff")
        }
        _publisher.sendMsg(param)
    }


}