package com.app.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.entity.Course;
import com.app.repository.CourseRespository;

@Service
public class CourseServiceImpl implements CourseService {
	
	
	@Autowired
	private CourseRespository courseRepository;
	
	private static final String UPLOAD_FOLDER = "D:\\IACSD\\video\\";//specify your upload directory

	@Override
	public Course saveCourseWithVideo(Course course, MultipartFile videoFile) {
		if(!videoFile.isEmpty()) {
			try {
				//save the file to the server
				byte[] bytes = videoFile.getBytes();
				Path path = Paths.get(UPLOAD_FOLDER + videoFile.getOriginalFilename());
				Files.write(path,bytes);
				
				//set the video path to the course entity
				course.setVideoPath(path.toString());
				
				// save the course to the database
				return courseRepository.save(course);
				
			}catch(IOException e) {
				e.printStackTrace();
				//handle the exception or rethrow it
			}
		}
		
		
		return null;
	}

}
