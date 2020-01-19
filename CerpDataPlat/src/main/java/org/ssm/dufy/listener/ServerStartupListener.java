package org.ssm.dufy.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServerStartupListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //将web应用名称保存到application范围中
        ServletContext application = servletContextEvent.getServletContext();
        application.setAttribute("APP_PATH", application.getContextPath());
        application.setAttribute("PAGE_TITEL", "CERP接口平台");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
