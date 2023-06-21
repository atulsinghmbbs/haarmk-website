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
import com.haarmk.service.JobService;

@RestController
@RequestMapping("/job")
public class JobController {
	
	@Autowired
	private JobService jobservice;

	@PostMapping("/job1")
	public ResponseEntity<Job> addjob(@RequestBody Job job) throws JobException{
		
		Job addjob =   jobservice.addjob(job) ;
		
		return new ResponseEntity<Job>(addjob , HttpStatus.OK);
		
	}
	
	@GetMapping("/getjob")
	public ResponseEntity<List<Job> > getjob() throws JobException{
		
		List<Job> jobs =   jobservice.getjobs() ;
		
		return new ResponseEntity<List<Job> >(jobs , HttpStatus.OK);
		
	}
	
	
	@GetMapping("/getapplicantsforajob")
	public ResponseEntity<List<User> > getapplicantsforajob (@RequestParam Integer jobid) throws JobException ,UserException{
		
		List<User> users =   jobservice.getapplicantsforajob(jobid) ;
		
		return new ResponseEntity<List<User> >(users , HttpStatus.OK);
		
	}
	

}
