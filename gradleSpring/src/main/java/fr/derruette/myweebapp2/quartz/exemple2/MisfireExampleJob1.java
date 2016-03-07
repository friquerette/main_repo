package fr.derruette.myweebapp2.quartz.exemple2;

import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Job #1 is scheduled to run every 3 seconds indefinitely. An execution delay
 * of 10 seconds is passed into the job:
 * 
 * 
 * @author Rick
 *
 */
public class MisfireExampleJob1 {

	public static void main(String... args) throws SchedulerException {
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();

		JobDetail job = JobBuilder.newJob(StatefulDumbJob.class).withIdentity("statefulJob1", "group1")
				.usingJobData(StatefulDumbJob.EXECUTION_DELAY, 10000L).build();

		SimpleTrigger trigger = TriggerBuilder.newTrigger()//
				.withIdentity("trigger1", "group1")//
				.startAt(new Date())//
				.withSchedule(//
						SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever()//
		).build();

		sched.scheduleJob(job, trigger);
		sched.start();
	}
}
