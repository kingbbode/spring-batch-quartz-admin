package com.kingbbode.scheduler.controller;

/*
 * Created By Kingbbode
 * blog : http://kingbbode.github.io
 * github : http://github.com/kingbbode
 *
 * Author                    Date                     Description
 * ------------------       --------------            ------------------
 * kingbbode                2017-10-20
 */


import com.kingbbode.scheduler.dto.*;
import com.kingbbode.scheduler.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchedulerController {

    @Autowired
    private SchedulerService schedulerService;

    @GetMapping("/schedulers")
    public List<SchedulerResponse> schedulers() {
        return schedulerService.getSchedulerList();
    }

    @GetMapping("/scheduler/{schedulerName}/job/{jobName}")
    public SchedulerDetailResponse schedulerDetail(JobRequest jobRequest) {
        return schedulerService.getSchedulerDetail(jobRequest);
    }
    
    @PostMapping("/scheduler/{schedulerName}/job/{jobName}/trigger/{triggerName}")
    public ResponseEntity<String> alterJob(JobUpdateRequest jobUpdateRequest) {
        schedulerService.updateTrigger(jobUpdateRequest);
        return ResponseEntity.ok("Success");
    }
    
    @PostMapping("/scheduler/{schedulerName}/job/{jobName}/execute")
    public ResponseEntity<String> execute(JobExecuteRequest jobExecuteRequest) {
        schedulerService.executeJob(jobExecuteRequest);
        return ResponseEntity.ok("Success");
    }
}
