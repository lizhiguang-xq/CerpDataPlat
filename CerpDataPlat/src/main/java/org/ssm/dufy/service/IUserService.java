package org.ssm.dufy.service;

import org.ssm.dufy.entity.User;

import java.util.List;
import java.util.Map;

public interface IUserService {

	public User getUserById(int id);
	
	public User getUser(User u);
	
	public User getUserByName(String uName);

	List<User> pageQueryUserData(Map<String, Object> map);

    int pageQueryTotalSize(Map<String, Object> map);

    void insertUser(User user);
}

