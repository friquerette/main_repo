package fr.friquerette.myweebapp2.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

@SpringBootApplication
public class Application {
	public static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String... arg) {
		// print internal state
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		StatusPrinter.print(lc);
		logger.info("coucou");
		logger.debug("coucou");
	}

}
