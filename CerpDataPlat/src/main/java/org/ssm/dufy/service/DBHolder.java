package org.ssm.dufy.service;


public class DBHolder {
    public static final String DEFAULT = "dataSource";
    public static final String CERP = "cerpdataSource";
    public static final String CERPZS = "cerpzsdataSource";
    //用ThreadLocal来设置当前线程使用哪个dataSource

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
    
    public static void setDefaultDB() {
        contextHolder.set(DEFAULT);
    }
    public static void setCerpDB() {
        contextHolder.set(CERP);
    }
    public static void setCerpZsDB() {
        contextHolder.set(CERPZS);
    }
    public static String getCustomerType() {
        return contextHolder.get();
    }

    public static void clearDB() {
        contextHolder.remove();
    }
}
