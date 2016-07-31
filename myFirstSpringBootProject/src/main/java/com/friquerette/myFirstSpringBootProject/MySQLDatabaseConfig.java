package com.friquerette.myFirstSpringBootProject;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

//@Configuration
//@EnableTransactionManagement
//@ComponentScan({ "com.friquerette.myFirstSpringBootProject" })
//@EntityScan(basePackages = { "com.friquerette.myFirstSpringBootProject.domain" })
//@EnableJpaRepositories(basePackages = { "com.friquerette.myFirstSpringBootProject.repositories" })
public class MySQLDatabaseConfig {

	@Bean(name = "dataSourceMySQL")
	@ConfigurationProperties(prefix = "mysql.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "mysqlEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("dataSourceMySQL") DataSource mysqlDataSource) {
		return builder//
				.dataSource(mysqlDataSource)//
				.packages("com.friquerette.myFirstSpringBootProject.domain")//
				.persistenceUnit("mysqlPU")//
				.build();
	}

	@Bean(name = "mysqlTransactionManager")
	public PlatformTransactionManager mysqlTransactionManager(
			@Qualifier("mysqlEntityManagerFactory") EntityManagerFactory mysqlEntityManagerFactory) {
		return new JpaTransactionManager(mysqlEntityManagerFactory);
	}

	@Bean(name = "jdbcTemplateMySQL")
	public JdbcTemplate jdbcTemplate(@Qualifier("dataSourceMySQL") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
