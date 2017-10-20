package com.kingbbode.execution.dto;

/*
 * Created By Kingbbode
 * blog : http://kingbbode.github.io
 * github : http://github.com/kingbbode
 *
 * Author                    Date                     Description
 * ------------------       --------------            ------------------
 * kingbbode                2017-10-20
 */


import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Builder
@Getter
public class JobExecutionDetailResponse {
    
    private Map<String, String> parameters;
    private StepExecutionDto stepExecutionDto;
    
    @Builder
    @Getter
    public static class StepExecutionDto {
        private Long id;
        private String name;
        private Long createTIme;
        private Long endTime;
        private String status;
        private Integer commitCount;
        private Integer readCount;
        private Integer filterCount;
        private Integer writeCount;
        private Integer readSkipCount;
        private Integer writeSkipCount;
        private Integer processSkipCount;
        private Integer rollbackCount;
    }
}
