package org.ssm.dufy.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.ssm.dufy.entity.User;
import org.ssm.dufy.service.IUserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user/manage")
public class UserManageController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/index")
    public String index(@RequestParam(required = false, defaultValue = "1") Integer pageno, @RequestParam(required = false, defaultValue = "2") Integer pagesize, Model model){
        //分页查询
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", (pageno - 1)*pagesize);
        map.put("size", pagesize);

        List<User> users = userService.pageQueryUserData(map);

        model.addAttribute("users", users);
        return "/user/manage/index";

    }
}

