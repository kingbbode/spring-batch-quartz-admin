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


import com.kingbbode.job.domain.QrtzSimpleTriggers;
import com.kingbbode.job.domain.QrtzTriggersId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuartzSimpleTriggerRepository extends JpaRepository<QrtzSimpleTriggers, QrtzTriggersId> {
}
