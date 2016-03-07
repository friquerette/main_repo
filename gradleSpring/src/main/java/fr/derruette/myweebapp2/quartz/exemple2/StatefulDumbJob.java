package fr.derruette.myweebapp2.quartz.exemple2;

import java.util.Date;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@DisallowConcurrentExecution
public class StatefulDumbJob implements Job {

	public static final String NUM_EXECUTIONS = "NumExecutions";
	public static final String EXECUTION_DELAY = "ExecutionDelay";

	public StatefulDumbJob() {
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.err.println("---" + context.getJobDetail().getKey() + " executing.[" + new Date() + "]");

		JobDataMap map = context.getJobDetail().getJobDataMap();

		int executeCount = 0;
		if (map.containsKey(NUM_EXECUTIONS)) {
			executeCount = map.getInt(NUM_EXECUTIONS);
		}

		executeCount++;
		map.put(NUM_EXECUTIONS, executeCount);

		long delay = 5000l;
		if (map.containsKey(EXECUTION_DELAY)) {
			delay = map.getLong(EXECUTION_DELAY);
		}

		try {
			System.out.println("I'm running !!!");
			Thread.sleep(delay);
			Thread.sleep(600L * 1000L);
			System.out.println("I finished to run");
		} catch (Exception ignore) {
		}

		System.err.println("  -" + context.getJobDetail().getKey() + " complete (" + executeCount + ").");
	}
}
