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
import com.haarmk.service.JobService;

@Service
public class JobServiceImpl implements JobService {
	
	@Autowired
	private JobRepository jobrepo;

	@Override
	public Job addjob(Job job) throws JobException {
        Job addjob = jobrepo.save(job);
		
		if(addjob == null) {
			
			throw new UserException("Enter valid information");
		}else {
		
		     return addjob;
		}
		
	}

	@Override
	public List<Job> getjobs() throws JobException {
		List<Job> jobs = jobrepo.findAll();
		if(jobs.size() <= 0) {
			throw new JobException("no jobs are found!!");
		}
		return jobs;
	}

	@Override
	public List<User> getapplicantsforajob(Integer jobid) throws JobException ,UserException{
		Job job = null;
		List<User> users = null;
		Optional<Job> job1 = jobrepo.findById(jobid);
		if(job1.isPresent()) {
			job = job1.get();
			users = job.getApplicants();
			if(users.size() <= 0) {
				throw new UserException("no applicants found!!");
			}
			return users;
		}else {
			throw new JobException("No job found!!");
		}
		
	}

}
