package org.ssm.dufy.job;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ssm.dufy.entity.Employee;
import org.ssm.dufy.entity.User;
import org.ssm.dufy.service.IEmployeeService;
import org.ssm.dufy.service.IUserService;

//@Component
public class HelloWorldJob implements Job{

	@Autowired
	private IEmployeeService employeeService;
		
	@Autowired
	private IUserService userService;
	/**
	 * "0/10 * * * * ?  
	 */
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		Employee e = employeeService.getEmployeeById(25897);
		System.out.println("----hello world---" + new Date() + "say by :" + e.getEmployeeName());
	}

}
