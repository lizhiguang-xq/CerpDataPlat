package org.ssm.dufy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/manage")
public class UserManageController {
    @RequestMapping("/index")
    public String index(){
        return "/user/manage/index";

    }
}

