package org.ssm.dufy.service;

import org.ssm.dufy.entity.Employee;

public interface IEmployeeService {

	public Employee getEmployeeById(int id);
	
	public Employee getEmployee(Employee e);
}

