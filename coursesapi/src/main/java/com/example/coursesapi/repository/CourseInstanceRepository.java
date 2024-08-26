package com.example.coursesapi.repository;

import com.example.coursesapi.model.CourseInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long> {

    // Method to find course instances by year and semester
    List<CourseInstance> findByYearAndSemester(int year, int semester);

    // Method to find a specific course instance by year, semester, and course ID  NEW
    CourseInstance findByYearAndSemesterAndCourseId(int year, int semester, Long courseId);

    // Method to delete a specific course instance by year, semester, and course ID  NEW
    void deleteByYearAndSemesterAndCourseId(int year, int semester, Long courseId);
}