package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.app.entity.Course;
import com.app.service.CourseService;

import java.io.IOException;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/{courseId}/upload-videos")
    public ResponseEntity<Course> uploadVideos(@PathVariable Long courseId,
                                               @RequestParam("videos") MultipartFile[] videos) throws IOException {
        Course updatedCourse = courseService.uploadVideos(courseId, videos);
        return ResponseEntity.ok(updatedCourse);
    }
}
