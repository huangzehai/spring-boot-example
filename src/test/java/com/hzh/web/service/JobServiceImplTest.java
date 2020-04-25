package com.hzh.web.service;

import com.hzh.web.model.Job;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class JobServiceImplTest {

    @Autowired
    private JobService jobService;

    @Test
    void createJob() throws Exception {
        Job job = new Job();
        job.setJobName("query top 10 phone brands");
        try {
            jobService.createJob(job);
        } catch (Exception e) {
            log.error("Fail to create job.", e);
        }

        log.info("List jobs:");
        jobService.getJobs().forEach(System.out::println);
    }
}