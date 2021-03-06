package org.ssm.dufy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.ssm.dufy.dao.IUserDao;
import org.ssm.dufy.entity.User;
import org.ssm.dufy.redis.RUserDao;
import org.ssm.dufy.service.IUserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class IUserServiceImpl  implements IUserService{

	@Autowired
	public IUserDao udao;
	
	@Autowired
	public RUserDao rdao;
	
	@Override
	public User getUserById(int id) {
		return udao.selectByPrimaryKey(id);
	}

	@Override
	public User getUser(User u) {
		// TODO Auto-generated method stub
		return udao.findUser(u);
	}

	
	@Override
//	@Cacheable(value = { "userDataCache" }, key="#uName")//缓存数据
	public User getUserByName(String uName) {
		User user = rdao.getUser(uName);
		if(user!=null) {
//			rdao.setUser(user);
			return user;
		} else {
			user = udao.findUserByName(uName);
			if(user!=null) {
				rdao.setUser(user);
				return user;
			} else {
				return null;
			}
		}
	}

    @Override
    public List<User> pageQueryUserData(Map<String, Object> map) {
		return udao.pageQueryUserDate(map);
    }

	@Override
	public int pageQueryTotalSize(Map<String, Object> map) {
		return udao.pageQueryTotalSize(map);
	}

	@Override
	public void insertUser(User user) {
		udao.insertUser(user);
	}

	@Override
	public int updateByPrimaryKey(User user) {
		return udao.updateByPrimaryKey(user);
	}

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return udao.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteUsers(Map<String, Object> map) {
        return udao.deleteUsers(map);
    }

	@Override
	public void insertUserRoles(HashMap<String, Object> map) {
		udao.insertUserRoles(map);
	}

	@Override
	public void deleteUserRoles(HashMap<String, Object> map) {
		udao.deleteUserRoles(map);
	}

	@Override
	public List<Integer> queryRolesidByUserid(Integer id) {
		return udao.queryRolesidByUserid(id);
	}


}
