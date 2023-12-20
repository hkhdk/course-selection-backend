package com.xuanke.api.service

import com.xuanke.api.entity.school.Course
import com.xuanke.api.entity.school.CourseSelection
import com.xuanke.api.entity.school.Student

interface CourseSelectionService {
    fun readCourseSelections(page : UInt, limit : UInt) : List<CourseSelection>

    fun readCourseSelectionsCount() : UInt

    fun addCourseSelection(studentId: Student.Id, courseId: Course.Id)

    fun deleteCourseSelectionById(selectionId: CourseSelection.Id)
}