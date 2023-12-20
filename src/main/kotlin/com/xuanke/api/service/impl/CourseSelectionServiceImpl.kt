package com.xuanke.api.service.impl

import com.xuanke.api.conflict
import com.xuanke.api.dao.CourseSelectionMapper
import com.xuanke.api.entity.school.Course
import com.xuanke.api.entity.school.CourseSelection
import com.xuanke.api.entity.school.Student
import com.xuanke.api.service.CourseSelectionService
import com.xuanke.api.service.CourseService
import com.xuanke.api.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CourseSelectionServiceImpl(
    @Autowired private val _courseSelectionMapper: CourseSelectionMapper,
    @Autowired private val _studentService: StudentService,
    @Autowired private val _courseService: CourseService,
) :
    CourseSelectionService {
    override fun readCourseSelections(page: UInt, limit: UInt): List<CourseSelection> {
        return _courseSelectionMapper.listSelections(((page - 1u) * limit).toInt(), limit.toInt())
    }

    override fun readCourseSelectionsCount(): UInt {
        return _courseSelectionMapper.countSelections().toUInt()
    }

    override fun addCourseSelection(studentId: Student.Id, courseId: Course.Id) {
        if (!_studentService.isStudentExists(studentId)) {
            throw conflict("Not found the student.")
        }
        if (!_courseService.isCourseExists(courseId)) {
            throw conflict("Not found the course.")
        }
        _courseSelectionMapper.insertSelection(studentId.value, courseId.value)
    }

    override fun deleteCourseSelectionById(selectionId: CourseSelection.Id) {
        _courseSelectionMapper.deleteSelectionBySelectionId(selectionId.value)
    }
}