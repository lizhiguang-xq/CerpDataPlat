package org.ssm.dufy.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ssm.dufy.bean.AjaxResult;
import org.ssm.dufy.bean.Page;
import org.ssm.dufy.entity.Role;
import org.ssm.dufy.entity.User;
import org.ssm.dufy.service.IRoleService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/role")
public class RoleManageController {

    @Autowired
    IRoleService roleService;

    @ResponseBody
    @RequestMapping("/doAssign")
    public Object doAssign( Integer roleid, Integer[] permissionids ) {
        AjaxResult result = new AjaxResult();

        try {

            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("roleid", roleid);
            paramMap.put("permissionids", permissionids);
            roleService.insertRolePermission(paramMap);

            result.setSuccess(true);
        } catch ( Exception e ) {
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;
    }

    @RequestMapping("/assign")
    public String assign() {
        return "role/assign";
    }

    @RequestMapping("/updateRole")
    @ResponseBody
    public Object updateUser(Role role){
        AjaxResult ajaxResult = new AjaxResult();
        try{
            roleService.updateByPrimaryKey(role);
            ajaxResult.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setSuccess(false);
        }
        return ajaxResult;
    }

    @RequestMapping("/editRole")
    public String editRole(Integer id, Model model) {
        Role role = roleService.getRoleById(id);
        model.addAttribute("role", role);
        return "role/edit";
    }

    @RequestMapping("/deleteRoles")
    @ResponseBody
    public Object deleteRoles(Integer[] chkRoleId) {
        AjaxResult ajaxResult = new AjaxResult();

        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("roleids", chkRoleId);
            roleService.deleteRoles(map);

            ajaxResult.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setSuccess(false);
        }

        return ajaxResult;
    }

    @RequestMapping("/deleteRole")
    @ResponseBody
    public Object deleteRole(Integer id) {
        AjaxResult ajaxResult = new AjaxResult();
        try{
            roleService.deleteByPrimaryKey(id);
            ajaxResult.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.setSuccess(false);
        }

        return ajaxResult;

    }

    @RequestMapping("/insertRole")
    @ResponseBody
    public Object insertRole(Role role) {
        AjaxResult ajaxResult = new AjaxResult();
        try{
            roleService.insertRole(role);
            ajaxResult.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.setSuccess(false);
        }

        return ajaxResult;
    }

    @RequestMapping("/add")
    public String add() {
        return "role/add";
    }

    @RequestMapping("/queryPage")
    @ResponseBody
    public Object queryPage(String queryText, Integer pageno, Integer pagesize) {
        AjaxResult ajaxResult = new AjaxResult();

        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("start", (pageno - 1) * pagesize);
            map.put("size", pagesize);
            map.put("queryText", queryText);
            List<Role> roles = roleService.pageQueryRoleData(map);

            //查询页码信息
            Integer totalpageno = 0;
            int totlesize = roleService.pageQueryTotalSize(map);
            if (totlesize % pagesize == 0) {
                totalpageno = totlesize / pagesize;
            } else {
                totalpageno = totlesize / pagesize + 1;
            }

            Page<Role> rolePage = new Page<>();

            rolePage.setDatas(roles);
            rolePage.setPageno(pageno);
            rolePage.setTotalpageno(totalpageno);
            rolePage.setTotalsize(totlesize);

            ajaxResult.setData1(rolePage);
            ajaxResult.setSuccess(true);
        }catch (Exception e) {
            e.printStackTrace();
            ajaxResult.setSuccess(false);
        } finally {

        }
        return ajaxResult;
    }

    @RequestMapping("/index")
    public String index() {
        return "role/index";
    }
}
