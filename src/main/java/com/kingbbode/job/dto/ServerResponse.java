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

import java.util.List;

@Builder
@Getter
public class ServerResponse {
    private String name;
    private String version;
    private List<String> job;
}
