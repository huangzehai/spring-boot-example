package com.hzh.web.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "t_job")
@Data
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String jobName;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn
    private SqlJob sqlJob;
}
