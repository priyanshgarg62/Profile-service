package com.amdocs.media.Profileservice.config;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.amdocs.media.Profileservice.controller.ProfileController;
import com.amdocs.media.Profileservice.model.Profile;
import com.amdocs.media.Profileservice.model.UserDAO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EventListener {

	@Autowired
	ProfileController profileController;

	ObjectMapper objMapper = new ObjectMapper();

	private final Logger logger = LoggerFactory.getLogger(Producer.class);

	@KafkaListener(topics = "methodtype", groupId = "group_id")
	public String consume(String message) throws IOException {
		logger.info(String.format("#### -> Consumed message -> %s", message));

		UserDAO userDAO = objMapper.readValue(message, UserDAO.class);
		System.out.println(userDAO.getTopic());

		Profile userprofile = new Profile();
		userprofile.setUsername(userDAO.getUserName());
		userprofile.setAddress(userDAO.getAddress());
		userprofile.setPhonenumber(userDAO.getPhonenumber());

		if (userDAO.getTopic().toString().equals("PUT")) {
			try {
			logger.info(String.format("inside event listener"));
			profileController.updateProfile(userprofile);
			System.out.println("inside event listener");
			return "PROFILE UPDATED SUCCESSFULLY";
			}catch(Exception e)
			{
				return "Error Handled in try block";
			}

		} else if (userDAO.getTopic().toString().equals("DELETE")) {
			logger.info(String.format("inside delete event listener"));
			profileController.deleteUser(userprofile);
			return "PROFILE DELETED SUCCESSFULLY";

		}
		
		else {
			logger.info(String.format("Event NotFound"));
			return "Event Not FOUND";
		}

	}
}