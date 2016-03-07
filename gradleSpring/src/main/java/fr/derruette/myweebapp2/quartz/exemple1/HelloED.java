package fr.derruette.myweebapp2.quartz.exemple1;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@DisallowConcurrentExecution
public class HelloED implements Job {
	private static final Logger logger = LoggerFactory.getLogger(HelloED.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		logger.info("Hello Quartz!");

		try {
			// TODO : Job Listener
			logger.info("I'm running !!!");
			Scheduler scheduler = context.getScheduler();

			for (JobExecutionContext jobCtxt : scheduler.getCurrentlyExecutingJobs()) {
				logger.info("\t- " + jobCtxt.getJobDetail().toString());
				if (jobCtxt.getFireInstanceId().equals(context.getFireInstanceId())) {
					logger.info("YES I'm find me");
				}
			}
			Thread.sleep(15000L);
			logger.info("I finished to run");
		} catch (Exception ignore) {
		}

	}

}