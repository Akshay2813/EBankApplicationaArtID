package com.learnspringboot.ranga.springbootlearnwithRanga;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
//	http://localhost:8080/courses
	
	@RequestMapping("/courses")
	public List<Course> getCourseDetails()
	{
		return  Arrays.asList(
				new Course (1,"Learn AWS","Akshay"),
				new Course (2,"Learn Azure","Ajay"),
				new Course (3,"Learn Python","Amruta")
				);
	}
	

}
