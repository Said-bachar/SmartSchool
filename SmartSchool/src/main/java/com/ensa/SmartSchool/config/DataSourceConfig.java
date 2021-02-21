package com.ensa.SmartSchool.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfig {


	@Value("${database.driver}")
	private String driver; 
	
	@Value("${database.userName}")
	private String userName;
	
	@Value("${database.password}")
	private String password;
	
	@Value("${database.url}")
	private String url;
	
	
	@Bean
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(this.driver);
        dataSource.setUrl(this.url);
        dataSource.setUsername(this.userName);
        dataSource.setPassword(this.password);

        return dataSource;
    }
	
	@Bean
	JdbcTemplate jdbcTemplate() {
		
		return new JdbcTemplate(mysqlDataSource());
	}
}
