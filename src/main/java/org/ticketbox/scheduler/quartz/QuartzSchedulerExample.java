package org.ticketbox.scheduler.quartz;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class QuartzSchedulerExample {
   public static void main(String[] args) throws Exception {
       SchedulerFactory schedulerFactory = new StdSchedulerFactory();
       Scheduler scheduler = schedulerFactory.getScheduler();

       JobDetail job = newJob(JobExample.class)
               .withIdentity("JobExample", "group1")
               .build();

       Date startTime = new Date();
       Trigger trigger = newTrigger()
               .withIdentity("MyTrigger", "group1")
               .startAt(startTime)
               .withSchedule(cronSchedule("0/30 * * * * ? *"))
               .build();

       scheduler.scheduleJob(job, trigger);
       scheduler.start();
   }
}
