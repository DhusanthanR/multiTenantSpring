//package com.demo.multiTenant.config;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Map;
//
//@Configuration
//@EnableConfigurationProperties
//@ConfigurationProperties(prefix = "tenants")
//public class TenantDataSourcesProperties {
//	private Map<String, DataSourceProperties> datasources;
//
//    public Map<String, DataSourceProperties> getDatasources() {
//        return datasources;
//    }
//
//    public void setDatasources(Map<String, DataSourceProperties> datasources) {
//        this.datasources = datasources;
//    }
//
//    public static class DataSourceProperties {
//        private String jdbcUrl;
//        private String username;
//        private String password;
//        private String driverClassName;
//
//        // Getters and setters
//
//        public String getJdbcUrl() {
//            return jdbcUrl;
//        }
//
//        public void setJdbcUrl(String jdbcUrl) {
//            this.jdbcUrl = jdbcUrl;
//        }
//
//        public String getUsername() {
//            return username;
//        }
//
//        public void setUsername(String username) {
//            this.username = username;
//        }
//
//        public String getPassword() {
//            return password;
//        }
//
//        public void setPassword(String password) {
//            this.password = password;
//        }
//
//        public String getDriverClassName() {
//            return driverClassName;
//        }
//
//        public void setDriverClassName(String driverClassName) {
//            this.driverClassName = driverClassName;
//        }
//    }
//}
//
//package com.demo.multiTenant.config;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.stereotype.Component;
//
//import java.util.Map;
//
//@Component
//@ConfigurationProperties(prefix = "tenants")
//public class TenantDataSourcesProperties {
//    private Map<String, DataSourceProperties> datasources;
//
//    public Map<String, DataSourceProperties> getDatasources() {
//        return datasources;
//    }
//
//    public void setDatasources(Map<String, DataSourceProperties> datasources) {
//        this.datasources = datasources;
//    }
//
//    public static class DataSourceProperties {
//        private String jdbcUrl;
//        private String username;
//        private String password;
//        private String driverClassName;
//
//        public String getJdbcUrl() {
//            return jdbcUrl;
//        }
//
//        public void setJdbcUrl(String jdbcUrl) {
//            this.jdbcUrl = jdbcUrl;
//        }
//
//        public String getUsername() {
//            return username;
//        }
//
//        public void setUsername(String username) {
//            this.username = username;
//        }
//
//        public String getPassword() {
//            return password;
//        }
//
//        public void setPassword(String password) {
//            this.password = password;
//        }
//
//        public String getDriverClassName() {
//            return driverClassName;
//        }
//
//        public void setDriverClassName(String driverClassName) {
//            this.driverClassName = driverClassName;
//        }
//    }
//}
package com.demo.multiTenant.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "tenants")
public class TenantDataSourcesProperties {
    private Map<String, DataSourceProperties> datasources;
    private DataSourceProperties defaultDataSourceProperties; // Assuming you add this

    public Map<String, DataSourceProperties> getDatasources() {
        return datasources;
    }

    public void setDatasources(Map<String, DataSourceProperties> datasources) {
        this.datasources = datasources;
    }

    public DataSourceProperties getDefaultDataSourceProperties() {
        return defaultDataSourceProperties;
    }

    public void setDefaultDataSourceProperties(DataSourceProperties defaultDataSourceProperties) {
        this.defaultDataSourceProperties = defaultDataSourceProperties;
    }

    public static class DataSourceProperties {
        private String jdbcUrl;
        private String username;
        private String password;
        private String driverClassName;

        public String getJdbcUrl() {
            return jdbcUrl;
        }

        public void setJdbcUrl(String jdbcUrl) {
            this.jdbcUrl = jdbcUrl;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getDriverClassName() {
            return driverClassName;
        }

        public void setDriverClassName(String driverClassName) {
            this.driverClassName = driverClassName;
        }
    }
}
