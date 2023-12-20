package com.xuanke.api.service

import com.xuanke.api.XuankeException
import com.xuanke.api.entity.school.Course

/**
 * 课程信息管理接口
 */
interface CourseService {
    /**
     * 根据给定的页码和条目数读取课程信息。
     * @param page 页码
     * @param limit 每一页条目的最大数量
     */
    fun readCourseList(page : UInt, limit : UInt) : List<Course>

    fun readCourseCount(): UInt

    /**
     * 根据给定课程 id 查找课程
     * @param courseId 给定的课程 id
     * @throws XuankeException 找不到对应课程时抛出异常
     */
    @Throws(XuankeException::class)
    fun readCourseByCourseId(courseId: Course.Id): Course

    fun isCourseExists(courseId: Course.Id): Boolean

    /** 如果对应 id 的课程已经存在则更新课程信息，否则创建新的课程 */
    fun writeCourse(course: Course)

    /** 删除对应 id 课程 */
    fun deleteCourse(courseId: Course.Id)
}