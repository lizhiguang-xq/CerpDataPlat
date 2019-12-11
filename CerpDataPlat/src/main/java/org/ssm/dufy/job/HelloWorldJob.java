package org.ssm.dufy.job;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.ssm.dufy.entity.Employee;
import org.ssm.dufy.service.IEmployeeService;
import org.ssm.dufy.service.IUserService;


public class HelloWorldJob implements Job{

	private static final String APPLICATION_CONTEXT_KEY = "applicationContextKey";
	
	private ApplicationContext getApplicationContext(JobExecutionContext context) throws Exception {
			ApplicationContext appCtx = null;
			appCtx = (ApplicationContext) context.getScheduler().getContext().get(APPLICATION_CONTEXT_KEY);
			if (appCtx == null) {
				throw new JobExecutionException("No application context available in scheduler context for key \"" + APPLICATION_CONTEXT_KEY + "\"");
			}
			return appCtx;
	}
	
	/**
	 * "0/10 * * * * ?  
	 */
	@Override
	public void execute(JobExecutionContext jobContext) throws JobExecutionException {
		
		ApplicationContext applicationContext = null;
		try {
			applicationContext = getApplicationContext(jobContext);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		IEmployeeService employeeService = (IEmployeeService) applicationContext.getBean("employeeService");
		
		Employee e = employeeService.getEmployeeById(25897);
		System.out.println("----hello world---" + new Date() + "say by :" + e.getEmployeeName());
	}
}
