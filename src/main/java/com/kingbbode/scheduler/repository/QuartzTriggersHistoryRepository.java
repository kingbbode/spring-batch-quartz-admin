package com.kingbbode.scheduler.repository;

import com.kingbbode.scheduler.domain.QrtzSimpleTriggersHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by YG-MAC on 2017. 10. 22..
 */
public interface QuartzTriggersHistoryRepository extends JpaRepository<QrtzSimpleTriggersHistory, Long> {
    List<QrtzSimpleTriggersHistory> findBySchedNameAndJobName(String schedName, String jobName);
}
