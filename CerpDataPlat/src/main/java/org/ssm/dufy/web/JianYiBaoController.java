package org.ssm.dufy.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ssm.common.utility.CommonUtils;
import org.ssm.common.utility.StringUtil;
import org.ssm.dufy.bean.jianyibao.Coupon;
import org.ssm.dufy.bean.jianyibao.JianYiBaoRetMsg;
import org.ssm.dufy.bean.jianyibao.Member;
import org.ssm.dufy.bean.jianyibao.SalesData;
import org.ssm.dufy.service.ICerpJybService;

import java.util.List;

@Controller
@RequestMapping("/JianYiBao")
public class JianYiBaoController {

    @Autowired
    private ICerpJybService jybService;

    private static String key = "jianyibao123";

    private static Logger logger = LoggerFactory.getLogger("loger");

    @ResponseBody
    @RequestMapping(value = "/queryMember", method = RequestMethod.GET)
    public JianYiBaoRetMsg queryMember(@RequestParam(name = "mobile", required = false) String mobile, @RequestParam(name = "vipNo", required = false) String vipNo,
                                    @RequestParam(name = "sign", required = true) String sign){
        logger.info("---[JianYiBao]---[queryMember]---mobile:"+mobile+"---vipNo:"+vipNo+"---sign:"+sign);
        JianYiBaoRetMsg resp = new JianYiBaoRetMsg();
        if(!StringUtil.isEmpty(mobile)) {
            if (!this.check("mobile="+mobile, sign)) {
                resp.setCode("0002");
                return resp;
            }
            List<Member> memberList = jybService.queryMemberByMobile(mobile);
            if(memberList == null || memberList.size() < 1) {
                resp.setCode("0001");
            } else {
                resp.setData(memberList);
                resp.setCode("0000");
                resp.setMessage("success");
            }
        } else if (!StringUtil.isEmpty(vipNo)) {
            if (!this.check("vipNo="+vipNo, sign)) {
                resp.setCode("0002");
                return resp;
            }
            List<Member> memberList = jybService.queryMemberByVipNo(vipNo);
            if(memberList == null || memberList.size() < 1) {
                resp.setCode("0001");
            } else {
                resp.setData(memberList);
                resp.setCode("0000");
                resp.setMessage("success");
            }
        } else {
            resp.setCode("0003");
        }
        return resp;
    }

    @ResponseBody
    @RequestMapping(value = "/querySalesData", method = RequestMethod.GET)
    public JianYiBaoRetMsg querySalesData(@RequestParam(name = "endDate", required = true) String endDate, @RequestParam(name = "startDate", required = true) String startDate,
                                          @RequestParam(name = "sign", required = true) String sign){
        logger.info("---[JianYiBao]---[querySalesData]---startDate:"+startDate+"---endDate:"+endDate+"---sign:"+sign);
        JianYiBaoRetMsg resp = new JianYiBaoRetMsg();
        if (!this.check("endDate="+endDate+"&startDate="+startDate, sign)) {
            resp.setCode("0002");
            return resp;
        }
        List<SalesData> salesDataList = jybService.querySalesData(endDate+" 23:59:59", startDate+" 00:00:00");
        if(salesDataList == null || salesDataList.size() < 1) {
            resp.setCode("0001");
        } else {
            resp.setData(salesDataList);
            resp.setCode("0000");
            resp.setMessage("success");
        }
        return resp;
    }

    @ResponseBody
    @RequestMapping(value = "/queryCoupon", method = RequestMethod.GET)
    public JianYiBaoRetMsg queryCoupon(@RequestParam(name = "endDate", required = true) String endDate, @RequestParam(name = "startDate", required = true) String startDate,
                                    @RequestParam(name = "sign", required = true) String sign){
        logger.info("---[JianYiBao]---[queryCoupon]---startDate:"+startDate+"---endDate:"+endDate+"---sign:"+sign);
        JianYiBaoRetMsg resp = new JianYiBaoRetMsg();
        if (!this.check("endDate="+endDate+"&startDate="+startDate, sign)) {
            resp.setCode("0002");
            return resp;
        }
        List<Coupon> couponList = jybService.queryCoupon(endDate + "23:59:59", startDate+" 00:00:00");
        if(couponList == null || couponList.size() < 1) {
            resp.setCode("0001");
        } else {
            resp.setData(couponList);
            resp.setCode("0000");
            resp.setMessage("success");
        }
        return resp;
    }

    private boolean check(String content, String md5Str) {
        if(!md5Str.equals(CommonUtils.stringToMD5(content+key))) {
            return false;
        }
        return true;
    }
}
