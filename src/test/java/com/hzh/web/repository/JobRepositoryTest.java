package com.hzh.web.repository;

import com.hzh.web.entity.Job;
import com.hzh.web.entity.SqlJob;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class JobRepositoryTest {

    @Autowired
    private JobRepository jobRepository;

    @Test
    @Transactional
    public void testOneToOneMapping() {
        Job job = new Job();
        job.setJobName("getMovies");
        SqlJob sqlJob = new SqlJob();
        sqlJob.setSql("SELECT * FROM ml_movies;");
        job.setSqlJob(sqlJob);
        Job save = jobRepository.save(job);

        Optional<Job> jobOptional = jobRepository.findById(save.getId());
        Assert.assertTrue(jobOptional.isPresent());
        Job readJob = jobOptional.get();
        Assert.assertEquals("getMovies", readJob.getJobName());
        Assert.assertNotNull(readJob.getSqlJob());
        Assert.assertEquals("SELECT * FROM ml_movies;", readJob.getSqlJob().getSql());
    }

}