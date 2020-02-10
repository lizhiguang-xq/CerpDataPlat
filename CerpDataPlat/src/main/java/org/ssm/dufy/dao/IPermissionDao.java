package org.ssm.dufy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import org.ssm.dufy.entity.Permission;
import org.ssm.dufy.entity.User;

public interface IPermissionDao {

	@Select("select * from permission_t where pid is null")
	Permission queryRootPermission();

	@Select("select * from permission_t where pid = #{pid}")
	List<Permission> queryChildPermissions(Integer pid);

	@Select("select * from permission_t")
	List<Permission> queryAll();

	void insertPermission(Permission permission);

	@Select("select * from permission_t where id = #{id}")
	Permission queryById(Integer id);

	void updatePermission(Permission permission);

	void deletePermission(Permission permission);

	@Select("select permissionid from role_permission_t where roleid = #{roleid}")
	List<Integer> queryPermissionidsByRoleid(Integer roleid);

	List<Permission> queryPermissionsByUser(User dbUser);

}
