package io.viet.springbootstarter.course;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.viet.springbootstarter.topic.Topic;

@RestController
public class CourseController {
	
	//initialises once so there's only one copy. This connects TopicService as it depends on it.
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Optional<Course> getTopic(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	//tells Spring MVC your request payload will contain a payload of this request body.
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic (topicId, "",""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
		course.setTopic(new Topic (topicId, "",""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	public void deleteCourse( @PathVariable String id) {
		courseService.deleteCourse(id);
	}
	
}
