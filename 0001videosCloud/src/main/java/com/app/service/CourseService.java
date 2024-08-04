package com.app.service;

import com.app.entity.Course;
import com.app.repository.CourseRepository;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CourseService {

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private CourseRepository courseRepository;

    public Course uploadVideos(Long courseId, MultipartFile[] videos) throws IOException {
        List<String> videoUrls = new ArrayList<>();

        for (MultipartFile video : videos) {
            Map uploadResult = cloudinary.uploader().upload(video.getBytes(),
                    ObjectUtils.asMap("resource_type", "video"));
            String videoUrl = uploadResult.get("url").toString();
            videoUrls.add(videoUrl);
        }

        Course course = courseRepository.findById(courseId).orElse(new Course());
        course.setVideoUrls(videoUrls);
        return courseRepository.save(course);
    }
}
