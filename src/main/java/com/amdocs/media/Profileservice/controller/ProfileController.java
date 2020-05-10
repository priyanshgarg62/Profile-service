package com.amdocs.media.Profileservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.media.Profileservice.model.Profile;
import com.amdocs.media.Profileservice.service.ProfileService;

@RestController
@RequestMapping("/assignment")
public class ProfileController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProfileService profileService;

	@GetMapping("/profile/{username}")
	public Profile getProfile(@PathVariable("username") String username) {
		return profileService.getProfile(username);

	}

	@PostMapping(path = "/profile")
	public String createProfile(@RequestBody Profile user) throws Exception {

		logger.info("UserName Password inside Post {}", user);
		profileService.createProfile(user);

		return "Profile Created Successfully";

	}

	@PutMapping(path = "/profile")
	public String updateProfile(@RequestBody Profile user) throws Exception {
		logger.info("PUT API EXECUTED With DataSet ->", user);
		profileService.updateProfile(user);
		return "Profile Updated Successfully";
	}

	@DeleteMapping("/profile")
	public void deleteUser(@RequestBody Profile user) {
		profileService.deleteProfile(user);
	}

}