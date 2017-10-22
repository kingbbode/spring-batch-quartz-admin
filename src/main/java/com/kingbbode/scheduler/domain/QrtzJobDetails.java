package com.kingbbode.scheduler.domain;

import com.kingbbode.scheduler.dto.SchedulerDetailResponse;
import com.kingbbode.scheduler.dto.SchedulerResponse;
import lombok.Getter;
import lombok.Setter;
import org.quartz.JobDataMap;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
    private Set<QrtzTriggers> qrtzTriggerses = new HashSet<>();

    public SchedulerResponse toSchedulerResponse() {
        String[] name = this.id.getSchedName().split("-");
        return SchedulerResponse.builder()
                .name(name[0])
                .version(name.length < 2 ? "undefined" : name[1])
                .jobName(this.id.getJobName())
                .build();
    }

    public SchedulerDetailResponse toSchedulerDetailResponse() {
        return SchedulerDetailResponse.builder()
                .jobName(this.id.getJobName())
                .cronTriggerList(
                        qrtzTriggerses.stream().filter(QrtzTriggers::isCronType)
                            .map(QrtzTriggers::getQrtzCronTriggers)
                            .map(QrtzCronTriggers::toCronTriggerResponse)
                            .collect(Collectors.toList())
                        )
                .build();
    }
}


