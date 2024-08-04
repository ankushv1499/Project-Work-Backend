package com.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.app.entity.Course;
import com.app.service.CourseService;

@Controller
public class CourseController {
	
	@Autowired
	private CourseService courseservice;
	
	@PostMapping("/courses/save")
	public String saveCourse(@ModelAttribute Course course , @RequestParam("videoFile") MultipartFile videoFile) throws IOException {
		courseservice.saveCourseWithVideo(course, videoFile);
		return "Done";
		
	}

}
