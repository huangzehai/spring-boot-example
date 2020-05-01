package com.hzh.web.repository;

import com.hzh.web.entity.Job;
import com.hzh.web.entity.SqlJob;
import com.hzh.web.query.JobQuery;
import com.hzh.web.query.JobSpecification;
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
        Job savedMovieJob = jobRepository.save(createMoviesJob());
        Optional<Job> jobOptional = jobRepository.findById(savedMovieJob.getId());
        Assert.assertTrue(jobOptional.isPresent());
        Job readJob = jobOptional.get();
        Assert.assertEquals("getMovies", readJob.getJobName());
        Assert.assertNotNull(readJob.getSqlJob());
        Assert.assertEquals("SELECT * FROM ml_movies;", readJob.getSqlJob().getSql());
    }

    @Test
    public void testSpecification() {
        jobRepository.save(createMoviesJob());
        jobRepository.save(createDeviceCountJob());
        JobQuery jobQueryWithoutJobName = new JobQuery();
        List<Job> jobs = jobRepository.findAll(new JobSpecification(jobQueryWithoutJobName));
        Assert.assertNotNull(jobs);
        Assert.assertEquals(2, jobs.size());

        JobQuery jobQueryWithJobName = new JobQuery();
        jobQueryWithJobName.setJobName("getMovies");
        jobs = jobRepository.findAll(new JobSpecification(jobQueryWithJobName));
        Assert.assertEquals(1, jobs.size());
    }

    private Job createMoviesJob() {
        Job job = new Job();
        job.setJobName("getMovies");
        SqlJob sqlJob = new SqlJob();
        sqlJob.setSql("SELECT * FROM ml_movies;");
        job.setSqlJob(sqlJob);
        return job;
    }

    private Job createDeviceCountJob() {
        Job job = new Job();
        job.setJobName("getDeviceCount");
        SqlJob sqlJob = new SqlJob();
        sqlJob.setSql("SELECT count(*) FROM devices;");
        job.setSqlJob(sqlJob);
        return job;
    }

}