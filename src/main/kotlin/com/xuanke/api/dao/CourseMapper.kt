package com.xuanke.api.dao

import com.xuanke.api.entity.school.Course
import org.apache.ibatis.annotations.Mapper

@Mapper
interface CourseMapper {
    fun listCourses(offset: Int, limit: Int): List<Course>

    fun countCourses(): Int
    
    fun selectCourseByCourseId(courseId: Long): Course?

    fun isCourseExists(courseId: Long): Int

    fun replaceCourseByCourseId(course: Course)

    fun deleteCourseByCourseId(courseId: Long): Int
}