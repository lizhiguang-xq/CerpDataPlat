package org.ssm.dufy.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ssm.dufy.bean.AjaxResult;
import org.ssm.dufy.bean.Page;
import org.ssm.dufy.entity.Role;
import org.ssm.dufy.entity.User;
import org.ssm.dufy.service.IRoleService;
import org.ssm.dufy.service.IUserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user/manage")
public class UserManageController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/deleteUsers")
    @ResponseBody
    public Object deleteUsers(Integer[] chkUserId) {
        AjaxResult ajaxResult = new AjaxResult();

        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("userids", chkUserId);
            userService.deleteUsers(map);

            ajaxResult.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setSuccess(false);
        }

        return ajaxResult;
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public Object deleteUser(Integer id){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            userService.deleteByPrimaryKey(id);
            ajaxResult.setSuccess(true);
        }catch (Exception e) {
            e.printStackTrace();
            ajaxResult.setSuccess(false);
        }
        return ajaxResult;
    }


    @RequestMapping("/updateUser")
    @ResponseBody
    public Object updateUser(User user){
        AjaxResult ajaxResult = new AjaxResult();
        try{
            userService.updateByPrimaryKey(user);
            ajaxResult.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setSuccess(false);
        }
        return ajaxResult;
    }

    @RequestMapping("/editUser")
    public String editUser(Integer id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user/manage/edit";
    }

    @RequestMapping("/assign")
    public String assign(Integer id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);

        List<Role> roles = roleService.queryAllRoles();
//        model.addAttribute("roles", roles);

        List<Role> assignedRoles = new ArrayList<Role>();
        List<Role> unassignedRoles = new ArrayList<Role>();

        List<Integer> assignedRoleIds = userService.queryRolesidByUserid(id);

        for(Role role : roles) {
            if(assignedRoleIds.contains(role.getId())) {
                assignedRoles.add(role);
            } else {
                unassignedRoles.add(role);
            }
        }

        model.addAttribute("assignedRoles", assignedRoles);
        model.addAttribute("unassignedRoles", unassignedRoles);
        return "user/manage/assign";
    }

    @RequestMapping("/add")
    public String add() {
        return "user/manage/add";
    }

    @RequestMapping("/insertUser")
    @ResponseBody
    public Object insertUser(User user) {
        AjaxResult ajaxResult = new AjaxResult();
        try{
            userService.insertUser(user);
            ajaxResult.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.setSuccess(false);
        }
        return ajaxResult;
    }

    @RequestMapping("/index")
    public String index() {
        return "user/manage/index";
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
            List<User> users = userService.pageQueryUserData(map);

            //查询页码信息
            Integer totalpageno = 0;
            int totlesize = userService.pageQueryTotalSize(map);
            if (totlesize % pagesize == 0) {
                totalpageno = totlesize / pagesize;
            } else {
                totalpageno = totlesize / pagesize + 1;
            }

            Page<User> userPage = new Page<>();

            userPage.setDatas(users);
            userPage.setPageno(pageno);
            userPage.setTotalpageno(totalpageno);
            userPage.setTotalsize(totlesize);

            ajaxResult.setData1(userPage);
            ajaxResult.setSuccess(true);
        }catch (Exception e) {
            e.printStackTrace();
            ajaxResult.setSuccess(false);
        } finally {

        }
        return ajaxResult;
    }

    @RequestMapping("/index1")
    public String index1(@RequestParam(required = false, defaultValue = "1") Integer pageno, @RequestParam(required = false, defaultValue = "2") Integer pagesize, Model model){
        //分页查询
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", (pageno - 1)*pagesize);
        map.put("size", pagesize);

        List<User> users = userService.pageQueryUserData(map);

        model.addAttribute("users", users);

        //查询页码信息
        Integer totalpageno = 0;
        int totlesize = userService.pageQueryTotalSize(map);
        if(totlesize % pagesize == 0) {
            totalpageno = totlesize / pagesize;
        } else {
            totalpageno = totlesize / pagesize + 1;
        }
        model.addAttribute("pageno", pageno); //当前第几页
        model.addAttribute("totalpageno", totalpageno); //总共多少页
        return "index1";

    }

    @RequestMapping("/doAssign")
    @ResponseBody
    public Object doAssign(Integer userid, Integer[] unassignroleids) {
        AjaxResult ajaxResult = new AjaxResult();

        try {
            //增加关系表数据
            HashMap<String, Object> map = new HashMap<>();
            map.put("userid", userid);
            map.put("roleids", unassignroleids);

            userService.insertUserRoles(map);

            ajaxResult.setSuccess(true);
        }catch (Exception e) {
            e.printStackTrace();
            ajaxResult.setSuccess(false);
        }

        return ajaxResult;
    }

    @RequestMapping("/undoAssign")
    @ResponseBody
    public Object undoAssign(Integer userid, Integer[] assignroleids) {
        AjaxResult ajaxResult = new AjaxResult();

        try {
            //删除关系表数据
            HashMap<String, Object> map = new HashMap<>();
            map.put("userid", userid);
            map.put("roleids", assignroleids);

            userService.deleteUserRoles(map);

            ajaxResult.setSuccess(true);
        }catch (Exception e) {
            e.printStackTrace();
            ajaxResult.setSuccess(false);
        }

        return ajaxResult;
    }
}

