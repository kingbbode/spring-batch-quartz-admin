package com.kingbbode.scheduler.dto;

/*
 * Created By Kingbbode
 * blog : http://kingbbode.github.io
 * github : http://github.com/kingbbode
 *
 * Author                    Date                     Description
 * ------------------       --------------            ------------------
 * kingbbode                2017-10-20
 */


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JobUpdateRequest extends JobRequest {
    private String triggerName;
    private String cronExpression;
}
