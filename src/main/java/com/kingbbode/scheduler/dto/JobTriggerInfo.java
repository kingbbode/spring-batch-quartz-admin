package com.kingbbode.scheduler.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobTriggerInfo {
    private String cronExpression;
}
