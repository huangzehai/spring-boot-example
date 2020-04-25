package com.hzh.web.service;

import com.hzh.web.model.Job;

import java.util.List;

public interface JobService {
    com.hzh.web.entity.Job createJob(Job job);

    List<Job> getJobs();
}
