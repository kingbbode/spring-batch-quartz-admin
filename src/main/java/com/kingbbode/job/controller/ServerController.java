package com.kingbbode.job.controller;

/*
 * Created By Kingbbode
 * blog : http://kingbbode.github.io
 * github : http://github.com/kingbbode
 *
 * Author                    Date                     Description
 * ------------------       --------------            ------------------
 * kingbbode                2017-10-20
 */


import com.kingbbode.job.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServerController {
    @GetMapping("/servers")
    public List<ServerResponse> servers() {
        return null;
    }
    
    @GetMapping("/server/{serverName}/jobs")
    public List<JobResponse> jobs(ServerRequest serverRequest) {
        return null;
    }

    @GetMapping("/server/{serverName}/job/{jobName}")
    public List<JobResponse> jobDetail(JobRequest JobRequest) {
        return null;
    }
    
    @PutMapping("/server/{serverName}/job/{jobName}")
    public ResponseEntity<String> alterJob(JobUpdateRequest jobUpdateRequest) {
        return ResponseEntity.ok("Success");
    }
    
    @PostMapping("/server/{serverName}/job/{jobName}/execute")
    public ResponseEntity<String> execute(JobExecuteRequest jobExecuteRequest) {
        return ResponseEntity.ok("Success");
    }
}
