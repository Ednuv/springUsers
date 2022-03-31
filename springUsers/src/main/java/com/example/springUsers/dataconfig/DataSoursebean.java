package com.example.springUsers.dataconfig;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class DataSoursebean {

	/*@ConfigurationProperties(prefix="spring.datasource")
	@Bean
	@Primary
	public DataSource getDataSource() {
		return DataSourceBuilder
				.create()
				.url("jdbc:mysql://${MYSQL_HOST:localhost}:3306/test")
				.username("root")
				.password("root")
				.build();
	}*/
}
