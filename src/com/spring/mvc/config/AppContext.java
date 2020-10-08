package com.spring.mvc.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class AppContext {

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] {
				
				"com.spring.mvc.entity"		// package to represents the entity classes
		});
		sessionFactory.setHibernateProperties(hibernateProperties());
		
		return sessionFactory;
	}

	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/db_demo?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		return dataSource;
	}

	public Properties hibernateProperties() {

		Properties properties = new Properties();
		properties.getProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		properties.getProperty("hibernate.show_sql", "true");
		properties.getProperty("hibernate.format_sql", "true");
		properties.getProperty("hibernate.hbm2ddl.auto", "update");
		
		return properties;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		
		transactionManager.setSessionFactory(sessionFactory().getObject());
		
		return transactionManager;
	}
}
