package com.haarmk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.haarmk.exception.JobException;
import com.haarmk.exception.UserException;
import com.haarmk.model.Job;
import com.haarmk.model.User;
import com.haarmk.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userservice;

	@PostMapping("/user1")
	public ResponseEntity<User> adduser(@RequestBody User user) throws UserException{
		
		User adduser = userservice.adduser(user);
		
		return new ResponseEntity<User>(adduser , HttpStatus.OK);
		
	}
	
	
	@PostMapping("/Applyjob")
	public ResponseEntity<User> applyforajob(@RequestParam Integer userid , Integer jobid) throws UserException{
		
		User addjob = userservice.Applyforajob(userid, jobid);
		
		return new ResponseEntity<User>(addjob , HttpStatus.OK);
		
	}
	
	
	@GetMapping("/getjobsuser")
	public ResponseEntity<List<Job>> getjobsforauser(@RequestParam Integer userid) throws JobException,UserException{
		
		List<Job> addjob = userservice.getjobsauser(userid);
		
		return new ResponseEntity<List<Job>>(addjob , HttpStatus.OK);
		
	}
	
	
}
