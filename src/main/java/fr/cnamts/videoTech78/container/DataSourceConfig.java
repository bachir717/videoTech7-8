package fr.cnamts.videoTech78.container;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.boot.jdbc.DataSourceBuilder;


@Configuration
@PropertySources({ @PropertySource("classpath:datasource.properties") })
public class DataSourceConfig {

    @Autowired
	private Environment env;

    @Bean
    public DataSource dataSource() {
        /*DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(env.getProperty("dataSource.driver-class-name"));
        dataSourceBuilder.url(env.getProperty("dataSource.url"));
        dataSourceBuilder.username(env.getProperty("dataSource.url"));
        dataSourceBuilder.password(env.getProperty("dataSource.password"));
        return dataSourceBuilder.build();*/

        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(env.getProperty("datasource.driver-class-name"));
        dataSourceBuilder.url(env.getProperty("datasource.url"));
        dataSourceBuilder.username(env.getProperty("datasource.username"));
        dataSourceBuilder.password(env.getProperty("datasource.password"));
        return dataSourceBuilder.build();
    }
 
    @Bean
    public JdbcTemplate jdbcTemplate() {
       return new JdbcTemplate(dataSource());
    }
 
    @Bean
    public TransactionManager transactionManager() {
       return new DataSourceTransactionManager(dataSource());
    }


}