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


import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class JobExecuteRequest extends JobRequest{
    private int repeatCount;
    private int repeatInterval;
    private Map<String, String> parameters;
}
