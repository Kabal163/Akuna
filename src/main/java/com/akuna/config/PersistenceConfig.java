package com.akuna.config;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/*@Configuration
@PropertySource("/persistence-postgres.properties")
@ComponentScan({ "com.akuna.security.entities", "com.akuna.journal.entities" })*/
public class PersistenceConfig {

//    @Autowired
//    private Environment env;
//
///*    @Bean
//    public LocalSessionFactoryBean sessionFactory()
//    {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(restDataSource());
//        sessionFactory.setPackagesToScan("com.akuna.security.entities", "com.akuna.journal.entities");
//        sessionFactory.setHibernateProperties(hibernateProperties());
//
//        return sessionFactory;
//    }*/
//
//    @Bean
//    public EntityManagerFactory entityManagerFactory() {
//
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(true);
//
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setJpaVendorAdapter(vendorAdapter);
//        factory.setPackagesToScan("com.akuna.security.entities", "com.akuna.journal.entities");
//        factory.setDataSource(restDataSource());
//        factory.afterPropertiesSet();
//
//        return factory.getObject();
//    }
//
//    @Bean
//    public DataSource restDataSource()
//    {
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
//        dataSource.setUrl(env.getProperty("jdbc.url"));
//        dataSource.setUsername(env.getProperty("jdbc.user"));
//        dataSource.setPassword(env.getProperty("jdbc.pass"));
//
//        return dataSource;
//    }
//
///*    @Bean
//    @Autowired
//    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
//    {
//        HibernateTransactionManager txManager = new HibernateTransactionManager();
//        txManager.setSessionFactory(sessionFactory);
//
//        return txManager;
//    }*/
//
//    @Bean
//    public PersistenceExceptionTranslationPostProcessor exceptionTranslation()
//    {
//        return new PersistenceExceptionTranslationPostProcessor();
//    }
//
//    Properties hibernateProperties()
//    {
//        return new Properties()
//        {
//            {
//                setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
//                setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
//                setProperty("hibernate.globally_quoted_identifiers", "true");
//            }
//        };
//    }
}
