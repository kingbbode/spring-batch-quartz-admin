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


import com.kingbbode.application.exceptions.NotFoundException;
import com.kingbbode.execution.domain.BatchJobExecution;
import com.kingbbode.execution.domain.BatchJobInstance;
import com.kingbbode.execution.dto.ExecutionDetailRequest;
import com.kingbbode.execution.dto.JobExecutionResponse;
import com.kingbbode.execution.dto.StepExecutionResponse;
import com.kingbbode.execution.repository.BatchJobExecutionRepository;
import com.kingbbode.execution.repository.BatchJobInstanceRepository;
import com.kingbbode.scheduler.dto.JobRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JobExecutionService {
    
    private final BatchJobInstanceRepository batchJobInstanceRepository;
    
    private final BatchJobExecutionRepository batchJobExecutionRepository;

    @Autowired
    public JobExecutionService(BatchJobInstanceRepository batchJobInstanceRepository, BatchJobExecutionRepository batchJobExecutionRepository) {
        this.batchJobInstanceRepository = batchJobInstanceRepository;
        this.batchJobExecutionRepository = batchJobExecutionRepository;
    }

    public List<JobExecutionResponse> getExecutionList(JobRequest jobRequest) {
        return batchJobInstanceRepository.findByJobNameOrderByJobInstanceIdDesc(jobRequest.getMergedJobName())
                .map(BatchJobInstance::getBatchJobExecutions)
                .flatMap(Set::stream)
                .map(BatchJobExecution::toJobExecutionInfo)
                .collect(Collectors.toList());
    }

    
    public List<StepExecutionResponse> getStepExecutionList(ExecutionDetailRequest executionDetailRequest) {
       BatchJobExecution batchJobExecution =  batchJobExecutionRepository.findOne(Long.valueOf(executionDetailRequest.getExecutionId()))
               .orElseThrow(NotFoundException::new);
        return batchJobExecution.toJobExecutionDetailResponse();
        
    }
}
