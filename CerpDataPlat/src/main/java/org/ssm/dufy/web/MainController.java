package org.ssm.dufy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {
    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request ){
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/user/login";
    }
}
