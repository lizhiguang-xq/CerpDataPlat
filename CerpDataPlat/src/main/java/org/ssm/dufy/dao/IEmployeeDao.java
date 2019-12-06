package org.ssm.dufy.dao;

import org.ssm.dufy.entity.Employee;

public interface IEmployeeDao {
	Employee findEmployee(Employee employee);
	
	Employee selectByPrimaryKey(Integer employeeId);
}
