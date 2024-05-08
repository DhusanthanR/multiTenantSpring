package com.demo.multiTenant.tenant;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


public class RoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return TenantContext.getCurrentTenant();
    }
}


//public class RoutingDataSource extends AbstractRoutingDataSource {
//
//    private Map<Object, DataSource> dataSourcesMap = new HashMap<>();
//
//    @Override
//    protected Object determineCurrentLookupKey() {
//        return TenantContext.getCurrentTenant();  // Returns the key for the current tenant
//    }
//
//    @Override
//    public void afterPropertiesSet() {
//        super.afterPropertiesSet();
//        // Ensures that the data source initialization is complete before using it
//        if (dataSourcesMap.isEmpty()) {
//            throw new IllegalArgumentException("You must configure at least one data source.");
//        }
//    }
//
//    public void addTargetDataSource(String key, DataSource dataSource) {
//        dataSourcesMap.put(key, dataSource);
//        setTargetDataSources(new HashMap<>(dataSourcesMap));  // Cast to Map<Object, Object>
//        afterPropertiesSet();  // Reinitialize the routing datasource
//    }
//
//    public DataSource getCurrentDataSource() {
//        Object key = determineCurrentLookupKey();
//        return dataSourcesMap.get(key);  // Cast is not necessary since map is typed
//    }
//}
