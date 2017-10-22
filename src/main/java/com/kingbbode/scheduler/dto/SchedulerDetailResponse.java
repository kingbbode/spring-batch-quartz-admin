package com.kingbbode.scheduler.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by YG-MAC on 2017. 10. 21..
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class SchedulerDetailResponse {

    private String jobName;
    private List<CronTrigger> cronTriggerList;
    private List<SimpleTrigger> simpleTriggerList;

    @Getter
    @Builder
    public static class CronTrigger {
        private String name;
        private String cronExpression;
    }
    @Getter
    @Builder
    public static class SimpleTrigger {
        private String name;
        private int repeat;
        private int repeatInterval;
        private String executor;
        private long executeTimeStamp
                ;
    }
}
