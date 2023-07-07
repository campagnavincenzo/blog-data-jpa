package it.campagnavincenzo.blog.appconfig;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * DatabaseConfig
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class DatabaseConfig {

	@Value("${spring.datasource.username}")
	private String mysqlUserName;
	@Value("${spring.datasource.password}")
	private String mysqlPassword;
	@Value("${spring.datasource.url}")
	private String mysqlUrl;

	@Bean("mysql")
	public DataSource createPostgredDataSource() {

		HikariConfig config = new HikariConfig();
		config.setUsername(mysqlUserName);
		config.setPassword(mysqlPassword);
		config.setJdbcUrl(mysqlUrl);

		return new HikariDataSource(config);
	}

	@Bean
	public AuditorAware<Long> auditorProvider() {
		return new UserAuditorAware();
	}

}