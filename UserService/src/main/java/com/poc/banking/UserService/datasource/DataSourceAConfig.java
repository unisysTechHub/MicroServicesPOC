//package com.poc.banking.UserService.datasource;
//
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import jakarta.persistence.EntityManagerFactory;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//    basePackages = "com.example.datasourcea.repo",
//    entityManagerFactoryRef = "entityManagerFactoryA",
//    transactionManagerRef = "transactionManagerA"
//)
//
//@EntityScan(basePackages = {"com.banking.auth.entity","com.poc.banking.*"})
//public class DataSourceAConfig {
//  @Value("${spring.jpa.properties.hibernate.dialect}")
//  private String hibernateDialect;
//
//    @Bean
//    @ConfigurationProperties("spring.datasource.ds1")
//    public DataSource dataSourceA() {
//        return DataSourceBuilder.create().build();
//    }
//
//     @Bean(name="entityManagerFactoryA")
//  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
//      LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
//      factoryBean.setDataSource(dataSource);
//      factoryBean.setPackagesToScan("com.poc.banking.UserService.entity"); // Update with your entity package
//      factoryBean.setJpaProperties(hibernateProperties());
//      return factoryBean;
//  }
//     
//   private Properties hibernateProperties() {
//       Properties properties = new Properties();
//       properties.setProperty("hibernate.dialect", hibernateDialect);
//       properties.setProperty("hibernate.show_sql", "true");
//       properties.setProperty("hibernate.format_sql", "true");
//       return properties;
//   }
//
//    @Bean
//    public PlatformTransactionManager transactionManagerA(
//            @Qualifier("entityManagerFactoryA") EntityManagerFactory entityManagerFactory) {
//        return new JpaTransactionManager(entityManagerFactory);
//    }
//}
