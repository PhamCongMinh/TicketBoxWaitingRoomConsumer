package org.ticketbox.scheduler.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class JobExample implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Job is running");
    }
}
