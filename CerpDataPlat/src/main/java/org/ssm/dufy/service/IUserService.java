package org.ssm.dufy.service;

import org.ssm.dufy.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IUserService {

	public User getUserById(int id);
	
	public User getUser(User u);
	
	public User getUserByName(String uName);

	List<User> pageQueryUserData(Map<String, Object> map);

    int pageQueryTotalSize(Map<String, Object> map);

    void insertUser(User user);

	int updateByPrimaryKey(User record);

    int deleteByPrimaryKey(Integer id);

    int deleteUsers(Map<String, Object> map);

    void insertUserRoles(HashMap<String, Object> map);

    void deleteUserRoles(HashMap<String, Object> map);

    List<Integer> queryRolesidByUserid(Integer id);
}

