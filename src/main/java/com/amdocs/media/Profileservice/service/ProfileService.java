package com.amdocs.media.Profileservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.media.Profileservice.model.Profile;
import com.amdocs.media.Profileservice.repository.ProfileRepository;

@Service
public class ProfileService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProfileRepository profileRepository;

	public Profile getProfile(String username) {
		return profileRepository.findById(username).get();
	}

	public void createProfile(Profile userDAO) {
		logger.info("UserName Password inside Post {}", userDAO);

		Profile profile = new Profile();
		profile.setUsername(userDAO.getUsername());
		profile.setAddress(userDAO.getAddress());
		profile.setPhonenumber(userDAO.getPhonenumber());
		try {
			logger.info("UserName Password inside Post {}", profile);

			profileRepository.save(profile);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateProfile(Profile userDAO) {
		Profile profile = profileRepository.findById(userDAO.getUsername()).get();

		profile.setAddress(userDAO.getAddress());
		profile.setPhonenumber(userDAO.getPhonenumber());
		logger.info("Profile Updated Successfully", profile);
		try {

			logger.info("UserName Password inside Put {}", profile);

			profileRepository.save(profile);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void deleteProfile(Profile userDAO) {
		profileRepository.deleteById(userDAO.getUsername());
		System.out.println("inside delete method");
	}

}
