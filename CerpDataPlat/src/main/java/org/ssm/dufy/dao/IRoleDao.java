package org.ssm.dufy.dao;

import org.apache.ibatis.annotations.Select;
import org.ssm.dufy.entity.Role;

import java.util.List;
import java.util.Map;

public interface IRoleDao {

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    Role findRole(Role role);

    List<Role> pageQueryRoleDate(Map<String, Object> map);

    int pageQueryTotalSize(Map<String, Object> map);

    void insertRole(Role user);

    int deleteRoles(Map<String, Object> map);

    @Select("select id, name, comment from role_t")
    List<Role> queryAllRoles();
}
