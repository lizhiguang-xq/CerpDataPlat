package org.ssm.dufy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssm.dufy.dao.IRoleDao;
import org.ssm.dufy.entity.Role;
import org.ssm.dufy.service.IRoleService;

import java.util.List;
import java.util.Map;


@Service("roleService")
public class IRoleServiceImpl implements IRoleService{

	@Autowired
	public IRoleDao roleDao;
	
	@Override
	public Role getRoleById(int id) {
		return roleDao.selectByPrimaryKey(id);
	}

	@Override
	public Role getRole(Role u) {
		return roleDao.findRole(u);
	}
	
    @Override
    public List<Role> pageQueryRoleData(Map<String, Object> map) {
		return roleDao.pageQueryRoleDate(map);
    }

	@Override
	public int pageQueryTotalSize(Map<String, Object> map) {
		return roleDao.pageQueryTotalSize(map);
	}

	@Override
	public void insertRole(Role role) {
		roleDao.insertRole(role);
	}

	@Override
	public int updateByPrimaryKey(Role role) {
		return roleDao.updateByPrimaryKey(role);
	}

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return roleDao.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteRoles(Map<String, Object> map) {
        return roleDao.deleteRoles(map);
    }

    @Override
    public List<Role> queryAllRoles() {
        return roleDao.queryAllRoles();
    }
}
