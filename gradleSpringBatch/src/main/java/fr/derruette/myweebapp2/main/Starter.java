package fr.derruette.myweebapp2.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

public class Starter {
	public static final Logger logger = LoggerFactory.getLogger(Starter.class);

	public static void main(String... arg) {
		// print internal state
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		StatusPrinter.print(lc);
		logger.info("coucou");
		logger.debug("coucou");
	}
}
