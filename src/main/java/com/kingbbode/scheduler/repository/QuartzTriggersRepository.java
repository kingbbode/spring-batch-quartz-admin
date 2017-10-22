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


import com.kingbbode.scheduler.domain.QrtzTriggers;
import com.kingbbode.scheduler.domain.QrtzTriggersId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuartzTriggersRepository extends JpaRepository<QrtzTriggers, QrtzTriggersId> {
    Optional<QrtzTriggers> findByIdSchedNameAndIdTriggerNameAndJobNameAndTriggerType(String schedName, String triggerName, String jobName, String type);
}
