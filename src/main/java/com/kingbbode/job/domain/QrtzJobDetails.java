package com.kingbbode.job.domain;

import lombok.Getter;
import lombok.Setter;
import org.quartz.JobDataMap;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * QrtzJobDetails generated by hbm2java
 */
@Getter
@Setter
@Entity
@Table(name="QRTZ_JOB_DETAILS")
public class QrtzJobDetails  implements java.io.Serializable {

    @EmbeddedId
    private QrtzJobDetailsId id;

    @Column(name="DESCRIPTION", length=250)
    private String description;


    @Column(name="JOB_CLASS_NAME", nullable=false, length=250)
    private String jobClassName;

    @Column(name="IS_DURABLE", nullable=false, length=1)
    private String isDurable;

    @Column(name="IS_NONCONCURRENT", nullable=false, length=1)
    private String isNonconcurrent;

    @Column(name="IS_UPDATE_DATA", nullable=false, length=1)
    private String isUpdateData;

    @Column(name="REQUESTS_RECOVERY", nullable=false, length=1)
    private String requestsRecovery;

    @Column(name="JOB_DATA")
    private JobDataMap jobData;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="qrtzJobDetails")
    private Set<QrtzTriggers> qrtzTriggerses = new HashSet<QrtzTriggers>(0);
}


