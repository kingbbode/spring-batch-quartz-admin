package com.kingbbode.job.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * QrtzSimpleTriggers generated by hbm2java
 */
@Getter
@Setter
@Entity
@Table(name="QRTZ_SIMPLE_TRIGGERS")
public class QrtzSimpleTriggers  implements java.io.Serializable {

    @EmbeddedId
    private QrtzTriggersId id;

    @OneToOne(fetch=FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private QrtzTriggers qrtzTriggers;

    @Column(name="REPEAT_COUNT", nullable=false)
    private long repeatCount;

    @Column(name="REPEAT_INTERVAL", nullable=false)
    private long repeatInterval;

    @Column(name="TIMES_TRIGGERED", nullable=false)
    private long timesTriggered;
}

