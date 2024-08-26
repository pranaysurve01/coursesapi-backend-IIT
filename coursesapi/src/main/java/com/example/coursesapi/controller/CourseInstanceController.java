package com.example.coursesapi.controller;

import com.example.coursesapi.model.CourseInstance;
import com.example.coursesapi.service.CourseInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/instances")
public class CourseInstanceController {

    @Autowired
    private CourseInstanceService courseInstanceService;

    @PostMapping
    public ResponseEntity<CourseInstance> createCourseInstance(@RequestBody CourseInstance courseInstance) {
        CourseInstance createdInstance = courseInstanceService.createCourseInstance(courseInstance);
        return ResponseEntity.ok(createdInstance);
    }

    @GetMapping("/{year}/{semester}")
    public ResponseEntity<List<CourseInstance>> getCourseInstancesByYearAndSemester(@PathVariable int year, @PathVariable int semester) {
        List<CourseInstance> instances = courseInstanceService.getCourseInstancesByYearAndSemester(year, semester);
        return ResponseEntity.ok(instances);
    }

    @GetMapping("/{year}/{semester}/{id}")
    public ResponseEntity<CourseInstance> getCourseInstanceById(@PathVariable int year, @PathVariable int semester, @PathVariable Long id) {
        Optional<CourseInstance> courseInstance = courseInstanceService.getCourseInstance(id);
        return courseInstance.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{year}/{semester}/{id}")
    public ResponseEntity<Void> deleteCourseInstance(@PathVariable int year, @PathVariable int semester, @PathVariable Long id) {
        courseInstanceService.deleteCourseInstance(id);
        return ResponseEntity.noContent().build();
    }
}
