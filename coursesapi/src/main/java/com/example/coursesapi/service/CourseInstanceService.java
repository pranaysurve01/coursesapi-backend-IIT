package com.example.coursesapi.service;

import com.example.coursesapi.model.CourseInstance;
import com.example.coursesapi.repository.CourseInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseInstanceService {

    @Autowired
    private CourseInstanceRepository courseInstanceRepository;

    public CourseInstance createCourseInstance(CourseInstance courseInstance) {
        try {
            return courseInstanceRepository.save(courseInstance);
        } catch (Exception e) {
            throw new RuntimeException("Error creating course instance", e);
        }
    }

    public List<CourseInstance> getCourseInstancesByYearAndSemester(int year, int semester) {
        List<CourseInstance> instances = courseInstanceRepository.findByYearAndSemester(year, semester);

        // Ensuring that associated course is fetched
        instances.forEach(instance -> {
            if (instance.getCourse() != null) {
                instance.getCourse().getTitle(); // This ensures the course is loaded
            }
        });

        return instances;
    }

    public Optional<CourseInstance> getCourseInstance(Long id) {
        return courseInstanceRepository.findById(id);
    }

    public void deleteCourseInstance(Long id) {
        try {
            courseInstanceRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting course instance", e);
        }
    }
}
