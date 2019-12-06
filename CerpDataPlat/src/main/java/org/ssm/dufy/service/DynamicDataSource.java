package org.ssm.dufy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {
	private static Logger log = LoggerFactory.getLogger("loger");
    @Override
    protected Object determineCurrentLookupKey() {
        String dataSourceName = DBHolder.getCustomerType()==null?DBHolder.DEFAULT:DBHolder.getCustomerType();
        log.info("current datasource:"+dataSourceName);
        return dataSourceName;
    }

}
