package com.kingbbode.scheduler.service;

/*
 * Created By Kingbbode
 * blog : http://kingbbode.github.io
 * github : http://github.com/kingbbode
 *
 * Author                    Date                     Description
 * ------------------       --------------            ------------------
 * kingbbode                2017-10-20
 */

import com.kingbbode.scheduler.domain.QrtzJobDetails;
import com.kingbbode.scheduler.domain.QrtzSimpleTriggersHistory;
import com.kingbbode.scheduler.domain.QrtzTriggers;
import com.kingbbode.scheduler.domain.QrtzTriggersId;
import com.kingbbode.scheduler.dto.*;
import com.kingbbode.scheduler.repository.QuartzJobDetailsRepository;
import com.kingbbode.scheduler.repository.QuartzTriggersHistoryRepository;
import com.kingbbode.scheduler.repository.QuartzTriggersRepository;
import netscape.security.ForbiddenTargetException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class SchedulerService {

    @Autowired
    private QuartzJobDetailsRepository quartzJobDetailsRepository;

    @Autowired
    private QuartzTriggersRepository quartzTriggersRepository;

    @Autowired
    private QuartzTriggersHistoryRepository quartzTriggersHistoryRepository;

    public List<SchedulerResponse> getSchedulerList() {
        return this.quartzJobDetailsRepository.findAll()
                .stream()
                .map(QrtzJobDetails::toSchedulerResponse)
                .collect(Collectors.toList());
    }

    public SchedulerDetailResponse getSchedulerDetail(JobRequest jobRequest) {
        SchedulerDetailResponse schedulerDetailResponse =
                this.quartzJobDetailsRepository.findByIdSchedNameAndIdJobName(jobRequest.getSchedulerName(), jobRequest.getJobName())
                    .toSchedulerDetailResponse();
        schedulerDetailResponse.setSimpleTriggerList(
                this.quartzTriggersHistoryRepository.findBySchedNameAndJobName(jobRequest.getSchedulerName(), jobRequest.getJobName())
                    .stream()
                    .map(QrtzSimpleTriggersHistory::toSimpleTrigger)
                    .collect(Collectors.toList())
        );
        return schedulerDetailResponse;
    }

    public void updateTrigger(JobUpdateRequest jobUpdateRequest) {
        Optional<QrtzTriggers> qrtzTriggers = this.quartzTriggersRepository.findByIdSchedNameAndIdTriggerNameAndJobNameAndTriggerType(jobUpdateRequest.getSchedulerName(), jobUpdateRequest.getTriggerName(), jobUpdateRequest.getJobName(), "CRON");
        if(!qrtzTriggers.isPresent()) {
            throw new ForbiddenTargetException("not found trigger.");
        }
        qrtzTriggers.get().getQrtzCronTriggers().updateCron(jobUpdateRequest.getCronExpression());
    }

    public void executeJob(JobExecuteRequest jobExecuteRequest) {
        LocalDateTime now = LocalDateTime.now();
        saveTrigger(jobExecuteRequest, now);
        saveHistory(jobExecuteRequest, now);
    }

    private void saveHistory(JobExecuteRequest jobExecuteRequest, LocalDateTime now) {
        QrtzSimpleTriggersHistory history = QrtzSimpleTriggersHistory.builder()
                .schedName(jobExecuteRequest.getSchedulerName())
                .jobName(jobExecuteRequest.getJobName())
                .triggerName("OneTimeTrigger-" + now.toString())
                .repeat(jobExecuteRequest.getRepeatCount())
                .repeatInterval(jobExecuteRequest.getRepeatInterval())
                .executor("admin")
                .executeDateTime(now)
                .build();
        this.quartzTriggersHistoryRepository.save(history);
    }

    private void saveTrigger(JobExecuteRequest jobExecuteRequest, LocalDateTime now) {
        QrtzTriggersId qrtzTriggersId = QrtzTriggersId.builder()
                .schedName(jobExecuteRequest.getSchedulerName())
                .triggerName("OneTimeTrigger-" + now.toString())
                .triggerGroup("OneTimeTrigger")
                .build();

        QrtzTriggers qrtzTriggers = new QrtzTriggers.SimpleTriggerBuilder()
                .id(qrtzTriggersId)
                .jobName(jobExecuteRequest.getJobName())
                .jobGroup("DEFAULT")
                .repeatCount(jobExecuteRequest.getRepeatCount())
                .repeatInterval(jobExecuteRequest.getRepeatInterval())
                .param(jobExecuteRequest.getParameters())
                .startTime(now)
                .build();

        this.quartzTriggersRepository.save(qrtzTriggers);
    }
}
