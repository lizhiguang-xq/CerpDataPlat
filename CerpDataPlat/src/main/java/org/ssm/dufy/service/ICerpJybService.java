package org.ssm.dufy.service;

import org.ssm.dufy.bean.jianyibao.Coupon;
import org.ssm.dufy.bean.jianyibao.Member;
import org.ssm.dufy.bean.jianyibao.SalesData;

import java.util.List;

public interface ICerpJybService {
    List<Member> queryMemberByMobile(String mobile);
    List<Member> queryMemberByVipNo(String vipNo);
    List<SalesData> querySalesData(String endDate, String startDate);
    List<Coupon> queryCoupon(String endDate, String startDate);
}
