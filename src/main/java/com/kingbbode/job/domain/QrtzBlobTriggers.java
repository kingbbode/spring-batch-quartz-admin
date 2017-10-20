package com.kingbbode.job.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * QrtzBlobTriggers generated by hbm2java
 */
@Getter
@Setter
@Entity
@Table(name="QRTZ_BLOB_TRIGGERS")
public class QrtzBlobTriggers  implements java.io.Serializable {

    @EmbeddedId
    private QrtzTriggersId id;

    @OneToOne(fetch=FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private QrtzTriggers qrtzTriggers;

    @Column(name="BLOB_DATA")
    private byte[] blobData;

}


