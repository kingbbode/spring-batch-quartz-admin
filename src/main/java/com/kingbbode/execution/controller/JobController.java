package com.kingbbode.execution.controller;

/*
 * Created By Kingbbode
 * blog : http://kingbbode.github.io
 * github : http://github.com/kingbbode
 *
 * Author                    Date                     Description
 * ------------------       --------------            ------------------
 * kingbbode                2017-10-20
 */

import com.kingbbode.execution.dto.ExecutionDetailRequest;
import com.kingbbode.execution.dto.ExecutionRequest;
import com.kingbbode.execution.dto.JobExecutionDetailResponse;
import com.kingbbode.execution.dto.JobExecutionResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobController {

    @GetMapping("/job/{jobName}/executions")
    public List<JobExecutionResponse> jobsExecutions(ExecutionRequest executionRequest) {
        return null;
    }

    @GetMapping("/job/{jobName}/execution/{executionId}")
    public List<JobExecutionDetailResponse> jobsExecutionsDetail(ExecutionDetailRequest executionDetailRequest) {
        return null;
    }
}
