package com.xuanke.api.dao

import com.xuanke.api.entity.school.CourseSelection
import org.apache.ibatis.annotations.Mapper

@Mapper
interface CourseSelectionMapper {
    fun listSelections(offset: Int, limit: Int): List<CourseSelection>

    fun countSelections(): Int

    fun selectCourseByCourseId(): List<CourseSelection>

    fun insertSelection(studentId: Long, courseId: Long)

    fun deleteSelectionBySelectionId(selectionId: Int)
}