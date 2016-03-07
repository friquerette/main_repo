package fr.friquerette.myweebapp2.quartz.exemple1;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO : ajouter un listener au job quartz pour essayer d'interrompre le
 * traitement si plus de n instances sont démarrées
 * 
 * @author Rick
 *
 */
public class SimpleTriggerExampleED {

	private static final Logger logger = LoggerFactory.getLogger(SimpleTriggerExampleED.class);

	public static void main(String[] args) throws Exception {

		JobDetail job = JobBuilder.newJob(HelloED.class)//
				.withIdentity("dummyJobName", "group1")//
				.build();

		Trigger trigger = TriggerBuilder//
				.newTrigger()//
				.withIdentity("dummyTriggerName", "group1")//
				.withSchedule(CronScheduleBuilder//
						.cronSchedule("0/2 * * * * ?")//
						.withMisfireHandlingInstructionFireAndProceed()//
		// .withMisfireHandlingInstructionDoNothing()//
		// .withMisfireHandlingInstructionIgnoreMisfires()//
		).build();

		// schedule it
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);
		logger.debug("wait the job starting");
		Thread.sleep(5000);
		for (JobExecutionContext jobCtxt : scheduler.getCurrentlyExecutingJobs()) {
			logger.info(jobCtxt.getJobDetail().toString() + jobCtxt.getFireInstanceId());
		}
		logger.debug("wait before finishing");
		Thread.sleep(10000);
		scheduler.shutdown();

		logger.info("finished");
	}

}