package fr.friquerette.myweebapp2.quartz.exemple2;

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

public class MisfireExampleJob2 {

	public static void main(String... args) throws SchedulerException {
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();

		JobDetail job = JobBuilder.newJob(StatefulDumbJob.class).withIdentity("statefulJob2", "group1")
				.usingJobData(StatefulDumbJob.EXECUTION_DELAY, 10000L).build();

		SimpleTrigger trigger = TriggerBuilder.newTrigger()//
				.withIdentity("trigger2", "group1")//
				.startAt(new Date())
				.withSchedule(//
						SimpleScheduleBuilder//
								.simpleSchedule()//
								.withIntervalInSeconds(3)//
								.repeatForever()//
								// set misfire instruction
								// .withMisfireHandlingInstructionNowWithExistingCount()//
								.withMisfireHandlingInstructionNextWithRemainingCount())
				.build();
		sched.scheduleJob(job, trigger);
		sched.start();
	}
}
