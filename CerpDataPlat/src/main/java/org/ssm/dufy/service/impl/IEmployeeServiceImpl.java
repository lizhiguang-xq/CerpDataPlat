package org.ssm.dufy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssm.dufy.dao.IEmployeeDao;
import org.ssm.dufy.entity.Employee;
import org.ssm.dufy.service.IEmployeeService;

@Service("employeeService")
public class IEmployeeServiceImpl  implements IEmployeeService{

	@Autowired
	public IEmployeeDao edao;
	
	@Override
	public Employee getEmployeeById(int id) {
		return edao.selectByPrimaryKey(id);
	}

	@Override
	public Employee getEmployee(Employee e) {
		return edao.findEmployee(e);
	}

}
