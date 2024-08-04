package com.app.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.entity.Course;

public interface CourseService {
	// save a course along with video File
	Course saveCourseWithVideo(Course course , MultipartFile videoFile);
	
	

}
