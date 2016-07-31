package com.friquerette.myFirstSpringBootProject;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.friquerette.myFirstSpringBootProject" })
@EntityScan(basePackages = { "com.friquerette.myFirstSpringBootProject.domain" })
@EnableJpaRepositories(basePackages = { "com.friquerette.myFirstSpringBootProject.repositories" })
public class OracleDatabaseConfig {

	@Primary
	@Bean(name = "dataSourceOracle")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "mysqlEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("dataSourceOracle") DataSource dataSource) {
		return builder.dataSource(dataSource)//
				.packages("com.friquerette.myFirstSpringBootProject.domain")//
				.persistenceUnit("oraclePU").build();
	}

	@Primary
	@Bean(name = "oracleTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("mysqlEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

//	@Bean(name = "jdbcTemplateOracle")
//	public JdbcTemplate jdbcTemplate(@Qualifier("dataSourceOracle") DataSource dataSource) {
//		return new JdbcTemplate(dataSource);
//	}
}
