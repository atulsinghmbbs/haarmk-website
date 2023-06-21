package com.haarmk.service;

import java.util.List;

import com.haarmk.exception.JobException;
import com.haarmk.exception.UserException;
import com.haarmk.model.Job;
import com.haarmk.model.User;

public interface UserService {

	public User adduser (User user) throws UserException ;
	
	public User Applyforajob (Integer userid , Integer jobid) throws UserException , JobException;
	
	public List<Job> getjobsauser(Integer userid) throws JobException,UserException; 
	
	
}
