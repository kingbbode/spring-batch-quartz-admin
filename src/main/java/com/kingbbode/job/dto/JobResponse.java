package com.kingbbode.job.dto;

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

@Builder
@Getter
public class JobResponse {
    private String name;
    private String cronExpression;
}
