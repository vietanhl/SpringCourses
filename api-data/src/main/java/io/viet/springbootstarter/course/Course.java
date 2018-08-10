package io.viet.springbootstarter.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.viet.springbootstarter.topic.Topic;



//Connecting to the DB
@Entity
public class Course {
	
	
	
	@Id
	private String id;
	private String name;
	private String description;
	
	//to let Spring know this is a foreign key. Many to one relationship, ie many courses for one topic
	@ManyToOne
	private Topic topic;

	
	
	//empty constructor so the object is easier to initialise
	public Course() {}
	public Course(String id, String name, String description, String topicId) {
		this.id=id;
		this.name=name;
		this.description=description;
		
		//so when I construct a course, a topic Id will be taken into account.
		this.topic = new Topic (topicId,"","");	
	}
	
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
