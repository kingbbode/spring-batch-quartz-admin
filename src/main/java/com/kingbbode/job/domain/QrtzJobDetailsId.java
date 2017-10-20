package com.kingbbode.job.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * QrtzJobDetailsId generated by hbm2java
 */
@Getter
@Setter
@Embeddable
public class QrtzJobDetailsId  implements java.io.Serializable {

    @Column(name="SCHED_NAME", nullable=false, length=120)
    private String schedName;

    @Column(name="JOB_NAME", nullable=false, length=200)
    private String jobName;

    @Column(name="JOB_GROUP", nullable=false, length=200)
    private String jobGroup;
}

