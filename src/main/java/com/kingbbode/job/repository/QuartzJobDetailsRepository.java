package com.kingbbode.job.repository;

/*
 * Created By Kingbbode
 * blog : http://kingbbode.github.io
 * github : http://github.com/kingbbode
 *
 * Author                    Date                     Description
 * ------------------       --------------            ------------------
 * kingbbode                2017-10-20
 */


import com.kingbbode.job.domain.QrtzJobDetails;
import com.kingbbode.job.domain.QrtzJobDetailsId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuartzJobDetailsRepository extends JpaRepository<QrtzJobDetails, QrtzJobDetailsId> {
    List<QrtzJobDetails> findByIdSchedName(String SchedulerName);
}
