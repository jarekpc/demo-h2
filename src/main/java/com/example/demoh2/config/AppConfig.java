package com.example.demoh2.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.demoh2.repositories",
        entityManagerFactoryRef = "userEntityManagerFactory",
        transactionManagerRef = "userTransactionManager")
public class AppConfig {

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAutoMode;

    @Value("${spring.jpa.show-sql}")
    private String showSQL;

    @Value("${buduj}")
    private boolean initialized;

    @Primary
    @Bean
    public DataSourceProperties userDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    public DataSource dataSource() {
        DataSourceProperties dataSourceProperties = userDataSourceProperties();
        return DataSourceBuilder.create().driverClassName(dataSourceProperties.getDriverClassName())
                .url(dataSourceProperties.getUrl())
                .username(dataSourceProperties.getUsername())
                .build();
    }


    @Primary
    @Bean(name = "userEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean userEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource());
        factory.setPackagesToScan(new String[]{"com.example.demoh2.entity"});
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.hbm2ddl.auto", ddlAutoMode);
        jpaProperties.put("hibernate.show-sql", showSQL);
        factory.setJpaProperties(jpaProperties);

        return factory;
    }

    @Primary
    @Bean
    public PlatformTransactionManager userTransactionManager() {
        EntityManagerFactory factory = userEntityManagerFactory().getObject();
        return new JpaTransactionManager(factory);
    }

    @Bean
    public DataSourceInitializer anotherDataSourceInitializer() {
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(dataSource());
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.addScript(new ClassPathResource("insert-data.sql"));
        dataSourceInitializer.setDatabasePopulator(databasePopulator);
        System.out.println("Initialized: " + initialized);
        dataSourceInitializer.setEnabled(initialized);
        return dataSourceInitializer;
    }

}
