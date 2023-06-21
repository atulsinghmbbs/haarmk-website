package com.haarmk.service;

import java.util.List;

import com.haarmk.exception.JobException;
import com.haarmk.exception.UserException;
import com.haarmk.model.Job;
import com.haarmk.model.User;

public interface JobService {
	
	public Job addjob (Job job) throws JobException;
	
	public List<Job> getjobs() throws JobException; 
	
	public List<User> getapplicantsforajob (Integer jobid) throws JobException ,UserException; 

}
