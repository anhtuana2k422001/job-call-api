package vn.com.hoanhtuan.jobcallapi;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vn.com.hoanhtuan.jobcallapi.job.CallApi;

@SpringBootApplication
@Slf4j
public class JobCallApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobCallApiApplication.class, args);
		LOGGER.info("******************** JobCallApiApplication started ******************** ");

		// quartz
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();

		String time = "0 */10 * * * ?"; // 10p a times

		try{
			// jobDetail
			JobDetail jobDetail = JobBuilder.newJob().ofType(CallApi.class)
					.withIdentity("RUN_QUARTZ", "JOB_GROUP")
					.withDescription("Description job")
					.storeDurably(true)
					.build();

			Trigger jobTrigger =  TriggerBuilder.newTrigger().withIdentity("RUN_QUARTZ", "JOB_GROUP")
					.startNow().withSchedule(CronScheduleBuilder.cronSchedule(time))
					.build();

			Scheduler scheduler = schedulerFactory.getScheduler();
			scheduler.scheduleJob(jobDetail, jobTrigger);
			scheduler.start();

		}catch(SchedulerException e) {
			LOGGER.error("Scheduler error");
        }


    }

}
