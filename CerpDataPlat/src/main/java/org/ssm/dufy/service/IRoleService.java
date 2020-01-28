package org.ssm.dufy.service;

import org.ssm.dufy.entity.Role;

import java.util.List;
import java.util.Map;

public interface IRoleService {

	public Role getRoleById(int id);
	
	public Role getRole(Role role);

	List<Role> pageQueryRoleData(Map<String, Object> map);

    int pageQueryTotalSize(Map<String, Object> map);

    void insertRole(Role role);

	int updateByPrimaryKey(Role role);

    int deleteByPrimaryKey(Integer id);

    int deleteRoles(Map<String, Object> map);
}

