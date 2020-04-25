package com.hzh.web.service;

import com.hzh.web.model.Job;
import com.hzh.web.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepository jobRepository;

    @Override
    @Transactional
    public com.hzh.web.entity.Job createJob(Job job) {
        com.hzh.web.entity.Job j = new com.hzh.web.entity.Job();
        j.setJobName(job.getJobName());
        //先将数据保存到数据库，然后再调用RPC接口.
        com.hzh.web.entity.Job save = jobRepository.save(j);
        if (true) {
            //RPC throws exception.
            throw new NullPointerException();
        }
        return save;
    }

    @Override
    public List<Job> getJobs() {
        return jobRepository.findAll().stream().map(this::toJob).collect(Collectors.toList());
    }

    private Job toJob(com.hzh.web.entity.Job j) {
        Job job = new Job();
        job.setId(j.getId());
        job.setJobName(j.getJobName());
        return job;
    }

}
