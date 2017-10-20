package com.kingbbode.execution.service;

/*
 * Created By Kingbbode
 * blog : http://kingbbode.github.io
 * github : http://github.com/kingbbode
 *
 * Author                    Date                     Description
 * ------------------       --------------            ------------------
 * kingbbode                2017-10-20
 */


import com.kingbbode.execution.repository.BatchJobExecutionParamsRepository;
import com.kingbbode.execution.repository.BatchJobInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobExecutionService {
    
    @Autowired
    private BatchJobInstanceRepository batchJobInstanceRepository;
    
    @Autowired
    private BatchJobExecutionParamsRepository batchJobExecutionParamsRepository;
    
}
