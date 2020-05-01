package com.hzh.web.query;

import com.hzh.web.entity.Job;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSpecification implements Specification<Job> {
    private JobQuery jobQuery;

    @Override
    public Predicate toPredicate(Root<Job> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder builder) {
        if (StringUtils.isNotBlank(jobQuery.getJobName())) {
            return builder.equal(root.get("jobName"), jobQuery.getJobName());
        }
        return null;
    }
}
