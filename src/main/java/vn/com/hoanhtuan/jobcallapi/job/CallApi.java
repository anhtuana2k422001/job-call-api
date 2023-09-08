package vn.com.hoanhtuan.jobcallapi.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Slf4j
public class CallApi implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOGGGER.info("------ Ho Anh Tuan ------");
    }
}
