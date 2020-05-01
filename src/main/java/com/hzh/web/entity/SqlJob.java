package com.hzh.web.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "t_sql_job")
@Data
public class SqlJob {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sqlJobId;

    @Column(columnDefinition = "text")
    private String sql;

}
