package org.ssm.dufy.service;

import org.ssm.dufy.entity.Permission;
import org.ssm.dufy.entity.User;

import java.util.List;

public interface IPermissionService {

	Permission queryRootPermission();

	List<Permission> queryChildPermissions(Integer pid);

	List<Permission> queryAll();

	void insertPermission(Permission permission);

	Permission queryById(Integer id);

	void updatePermission(Permission permission);

	void deletePermission(Permission permission);

	List<Integer> queryPermissionidsByRoleid(Integer roleid);

	List<Permission> queryPermissionsByUser(User dbUser);

}
