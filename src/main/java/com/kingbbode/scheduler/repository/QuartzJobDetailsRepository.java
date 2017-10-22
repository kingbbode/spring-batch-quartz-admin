package com.kingbbode.scheduler.repository;

/*
 * Created By Kingbbode
 * blog : http://kingbbode.github.io
 * github : http://github.com/kingbbode
 *
 * Author                    Date                     Description
 * ------------------       --------------            ------------------
 * kingbbode                2017-10-20
 */


import com.kingbbode.scheduler.domain.QrtzJobDetails;
import com.kingbbode.scheduler.domain.QrtzJobDetailsId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuartzJobDetailsRepository extends JpaRepository<QrtzJobDetails, QrtzJobDetailsId> {
    QrtzJobDetails findByIdSchedNameAndIdJobName(String SchedulerName, String jobName);
}
