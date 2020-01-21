package org.ssm.dufy.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ssm.dufy.bean.AjaxResult;
import org.ssm.dufy.bean.Page;
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
}

