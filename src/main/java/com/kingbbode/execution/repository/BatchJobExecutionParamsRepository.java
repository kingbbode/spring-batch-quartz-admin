package com.kingbbode.execution.repository;

/*
 * Created By Kingbbode
 * blog : http://kingbbode.github.io
 * github : http://github.com/kingbbode
 *
 * Author                    Date                     Description
 * ------------------       --------------            ------------------
 * kingbbode                2017-10-20
 */


import com.kingbbode.execution.domain.BatchJobExecutionParams;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BatchJobExecutionParamsRepository extends JpaRepository<BatchJobExecutionParams, BatchJobExecutionParams.BatchJobExecutionParamsId>{
    List<BatchJobExecutionParams> findByIdJobExecutionId(Long jobExecutionId);
}
