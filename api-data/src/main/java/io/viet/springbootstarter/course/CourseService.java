package io.viet.springbootstarter.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;
	
	
	public List<Course> getAllCourses(String topicId) {
	List<Course> courses = new ArrayList<>();
	//add each of the database to the list
	//filter by topicId
	courseRepository.findByTopicId(topicId).forEach(courses::add);
	return courses;
	}
	
	public Optional<Course> getCourse(String id) {
		//1. Streams all the topics, filters it by getting the id and comparing it with the id passed in. Find the first one and get it.
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id);
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
		
	}

	public void updateCourse(Course course) {
		
		courseRepository.save(course);
		
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
			}
		
	

	
}
