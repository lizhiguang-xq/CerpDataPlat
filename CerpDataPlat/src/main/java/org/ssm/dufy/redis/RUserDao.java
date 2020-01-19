package org.ssm.dufy.redis;

//import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
import org.ssm.dufy.entity.User;

import java.util.concurrent.TimeUnit;

@Repository
public class RUserDao {
	
	@Autowired
	RedisTemplate<String, User> redisTemplate;
	
	public void setUser(User user) {
		ValueOperations<String, User> ops = redisTemplate.opsForValue();
		ops.set(user.getUser_name(), user, 360, TimeUnit.SECONDS);
//		ops.set(user.getUser_name(), user);
	}
	
	public User getUser(String username) {
		ValueOperations<String, User> ops = redisTemplate.opsForValue();
		return ops.get(username);
	}

}
