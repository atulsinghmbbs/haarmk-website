package com.haarmk.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haarmk.exception.JobException;
import com.haarmk.exception.UserException;
import com.haarmk.model.Job;
import com.haarmk.model.User;
import com.haarmk.repository.JobRepository;
import com.haarmk.repository.UserRepository;
import com.haarmk.service.UserService;

@Service
public class UserServiceImpl implements UserService  {
	
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private JobRepository jobrepo;

	@Override
	public User adduser(User user) throws UserException {
		
        User adduser = userrepo.save(user);
		
		if(adduser == null) {
			
			throw new UserException("Enter valid information");
		}else {
		
		     return adduser;
		}
	}

	@Override
	public User Applyforajob(Integer userid , Integer jobid) throws UserException , JobException{
	    User user1 = null;
	    Job job1 = null;
	   Optional<User> user = userrepo.findById(userid);
	   
	   if(user.isPresent()) {
		   
		  user1= user.get();
	   }else {
		   throw new UserException("user is not present");
	   }
		
	   Optional<Job> job = jobrepo.findById(jobid);
	   
	   if(job.isPresent()) {
		   
		   job1 = job.get();
		   job1.getApplicants().add(user1);
		   user1.getJobs().add(job1);
		   userrepo.save(user1);
		   
	   }else {
		   throw new UserException("job is not present");
	   }
	   
	   
		return user1;
	}

	@Override
	public List<Job> getjobsauser(Integer userid) throws JobException,UserException {
		User user = null;
		List<Job> jobs =null;
		Optional<User> optUser = userrepo.findById(userid);
		
		
		if(optUser.isPresent()) {
			user = optUser.get();
			jobs = user.getJobs();
			if(jobs.size() <= 0) {
				throw new JobException("No jobs are found!!");
			}
			return jobs;
			
		}else {
			throw new UserException("No user exist with this userId ");
		}
		
		
	}

}
