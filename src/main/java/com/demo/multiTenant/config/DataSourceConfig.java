package com.demo.multiTenant.config;

import com.demo.multiTenant.tenant.RoutingDataSource;

//import java.util.HashMap;
//import java.util.Map;
//import java.util.stream.Stream;
//import java.util.stream.StreamSupport;
//import javax.sql.DataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.AbstractEnvironment;
//import org.springframework.core.env.MutablePropertySources;
//import org.springframework.core.env.PropertySource;
//import org.springframework.core.env.MapPropertySource;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import com.demo.multiTenant.tenant.RoutingDataSource;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//@Configuration
//public class DataSourceConfig {
//
////	private static final Logger log = LoggerFactory.getLogger(DataSourceConfig.class);
////
////    @Autowired
////    private ApplicationContext context;
//
////    @Value("${spring.datasource.username}")
////    private String username;
////
////    @Value("${spring.datasource.password}")
////    private String password;
////
////    @Value("${spring.datasource.driver-class-name}")
////    private String driverClassName;
////    
//	@Autowired
//	private TenantDataSourcesProperties tenantProperties;
////
////    @Bean
////    public DataSource dataSource() {
////        RoutingDataSource routingDataSource = new RoutingDataSource();
////        Map<Object, Object> targetDataSources = new HashMap<>();
////
////        MutablePropertySources propSrcs = ((AbstractEnvironment) context.getEnvironment()).getPropertySources();
////        Stream<PropertySource<?>> stream = StreamSupport.stream(propSrcs.spliterator(), false);
////
////        stream
////            .filter(ps -> ps instanceof MapPropertySource)
////            .map(ps -> ((MapPropertySource) ps).getSource())
////            .forEach(map -> map.forEach((key, value) -> {
////                if (key.startsWith("tenants.datasources")) {
////                    String tenantId = key.split("\\.")[2];
////                    targetDataSources.put(tenantId, tenantDataSource(tenantId));
////                }
////            }));
////
////        routingDataSource.setTargetDataSources(targetDataSources);
////        routingDataSource.setDefaultTargetDataSource(defaultDataSource());
////        return routingDataSource;
////    }
////
////    private DataSource defaultDataSource() {
////        return buildDataSource(
////            context.getEnvironment().getProperty("spring.datasource.jdbc-url"),
////            username,
////            password
////        );
////    }
////
////    private DataSource tenantDataSource(String tenantId) {
////    	 log.info("Configuring data source for tenantId={}", tenantId);
////        String propertyPrefix = "tenants.datasources." + tenantId + ".jdbc-url";
////        return buildDataSource(
////            context.getEnvironment().getProperty(propertyPrefix),
////            username,
////            password
////        );
////    }
////
////    private DataSource buildDataSource(String url, String username, String password) {
////        DriverManagerDataSource dataSource = new DriverManagerDataSource();
////        dataSource.setDriverClassName(driverClassName);
////        dataSource.setUrl(url);
////        dataSource.setUsername(username);
////        dataSource.setPassword(password);
////        return dataSource;
////    }
//	
//
//
////	@Bean
////	public DataSource dataSource() {
////	    RoutingDataSource routingDataSource = new RoutingDataSource();
////	    Map<Object, Object> targetDataSources = new HashMap<>();
////
////	    tenantProperties.getDatasources().forEach((tenantId, url) -> {
////	        targetDataSources.put(tenantId, buildDataSource(url, username, password));
////	    });
////
////	    routingDataSource.setTargetDataSources(targetDataSources);
////	    routingDataSource.setDefaultTargetDataSource(defaultDataSource());
////	    return routingDataSource;
////	}
////	 @Bean
////	    public DataSource dataSource() {
////	        RoutingDataSource routingDataSource = new RoutingDataSource();
////	        Map<Object, Object> targetDataSources = new HashMap<>();
////
////	        tenantProperties.getDatasources().forEach((key, value) -> {
////	            DriverManagerDataSource dataSource = new DriverManagerDataSource();
////	            dataSource.setUrl(value.getJdbcUrl());
////	            dataSource.setUsername(value.getUsername());
////	            dataSource.setPassword(value.getPassword());
////	            dataSource.setDriverClassName(value.getDriverClassName());
////
////	            targetDataSources.put(key, dataSource);
////	        });
////
////	        routingDataSource.setTargetDataSources(targetDataSources);
////	        routingDataSource.afterPropertiesSet();  // Necessary to update the internal state
////	        return routingDataSource;
////	    }
//
//	 @Bean
//	 public DataSource dataSource() {
//	     RoutingDataSource routingDataSource = new RoutingDataSource();
//	     Map<Object, Object> targetDataSources = new HashMap<>();
//
//	     tenantProperties.getDatasources().forEach((key, value) -> {
//	         DriverManagerDataSource dataSource = new DriverManagerDataSource();
//	         dataSource.setUrl(value.getJdbcUrl());
//	         dataSource.setUsername(value.getUsername());
//	         dataSource.setPassword(value.getPassword());
//	         dataSource.setDriverClassName(value.getDriverClassName());
//
//	         System.out.println("Adding data source for tenant: " + key); // Log information
//	         targetDataSources.put(key, dataSource);
//	     });
//
//	     routingDataSource.setTargetDataSources(targetDataSources);
//	     routingDataSource.afterPropertiesSet();  // Necessary to update the internal state
//	     return routingDataSource;
//	 }
//}
//import java.util.HashMap;
//import java.util.Map;
//import java.util.stream.Stream;
//import java.util.stream.StreamSupport;
//import javax.sql.DataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.AbstractEnvironment;
//import org.springframework.core.env.MutablePropertySources;
//import org.springframework.core.env.PropertySource;
//import org.springframework.core.env.MapPropertySource;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import com.demo.multiTenant.tenant.RoutingDataSource;
//
//@Configuration
//public class DataSourceConfig {
//
//    @Autowired
//    private ApplicationContext context;
//
//    @Value("${spring.datasource.username}")
//    private String username;
//
//    @Value("${spring.datasource.password}")
//    private String password;
//
//    @Value("${spring.datasource.driver-class-name}")
//    private String driverClassName;
//
//    @Bean
//    public DataSource dataSource() {
//        RoutingDataSource routingDataSource = new RoutingDataSource();
//        Map<Object, Object> targetDataSources = new HashMap<>();
//
//        MutablePropertySources propSrcs = ((AbstractEnvironment) context.getEnvironment()).getPropertySources();
//        Stream<PropertySource<?>> stream = StreamSupport.stream(propSrcs.spliterator(), false);
//
//        stream
//            .filter(ps -> ps instanceof MapPropertySource)
//            .map(ps -> ((MapPropertySource) ps).getSource())
//            .forEach(map -> map.forEach((key, value) -> {
//                if (key.startsWith("tenants.datasources")) {
//                    String tenantId = key.split("\\.")[2];
//                    targetDataSources.put(tenantId, tenantDataSource(tenantId));
//                }
//            }));
//
//        routingDataSource.setTargetDataSources(targetDataSources);
//        routingDataSource.setDefaultTargetDataSource(defaultDataSource());
//        return routingDataSource;
//    }
//
//    private DataSource defaultDataSource() {
//        return buildDataSource(
//            context.getEnvironment().getProperty("spring.datasource.jdbc-url"),
//            username,
//            password
//        );
//    }
//
//    private DataSource tenantDataSource(String tenantId) {
//        String propertyPrefix = "tenants.datasources." + tenantId + ".jdbc-url";
//        return buildDataSource(
//            context.getEnvironment().getProperty(propertyPrefix),
//            username,
//            password
//        );
//    }
//
//    private DataSource buildDataSource(String url, String username, String password) {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        return dataSource;
//    }
//}

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

    @Autowired
    private TenantDataSourcesProperties tenantDataSourcesProperties;

    @Bean
    public DataSource dataSource() {
        Map<Object, Object> targetDataSources = new HashMap<>();
        tenantDataSourcesProperties.getDatasources().forEach((tenantId, props) -> {
            targetDataSources.put(tenantId, buildDataSource(props));
        });

        RoutingDataSource routingDataSource = new RoutingDataSource();
        routingDataSource.setTargetDataSources(targetDataSources);
        routingDataSource.setDefaultTargetDataSource(buildDataSource(tenantDataSourcesProperties.getDefaultDataSourceProperties()));
        routingDataSource.afterPropertiesSet(); // Initialize the routing data source
        return routingDataSource;
    }

    private DataSource buildDataSource(TenantDataSourcesProperties.DataSourceProperties properties) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(properties.getJdbcUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        dataSource.setDriverClassName(properties.getDriverClassName());
        return dataSource;
    }
}



