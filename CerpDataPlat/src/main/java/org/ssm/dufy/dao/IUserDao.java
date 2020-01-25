package org.ssm.dufy.dao;

import org.ssm.dufy.entity.User;

import java.util.List;
import java.util.Map;

public interface IUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User findUser(User user);
    
    User findUserByName(String uName);

    List<User> pageQueryUserDate(Map<String, Object> map);

    int pageQueryTotalSize(Map<String, Object> map);

    void insertUser(User user);

    int deleteUsers(Map<String, Object> map);
}