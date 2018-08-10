package io.viet.springbootstarter.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	@Autowired
	private TopicRepository topicRepository;
	
	
	public List<Topic> getAllTopics() {
	List<Topic> topics = new ArrayList<>();
	//add each of the database to the list
	topicRepository.findAll().forEach(topics::add);
	return topics;
	}
	
	public Optional<Topic> getTopic(String id) {
		//1. Streams all the topics, filters it by getting the id and comparing it with the id passed in. Find the first one and get it.
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id);
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
		
	}

	public void updateTopic(String id, Topic topic) {
		
		topicRepository.save(topic);
		
	}

	public void deleteTopic(String id, Topic topic) {
		topicRepository.deleteById(id);
			}
		
	

	
}
