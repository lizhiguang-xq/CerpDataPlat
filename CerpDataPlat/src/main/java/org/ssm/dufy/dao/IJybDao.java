package org.ssm.dufy.dao;

import org.apache.ibatis.annotations.Param;
import org.ssm.dufy.bean.jianyibao.Coupon;
import org.ssm.dufy.bean.jianyibao.Member;
import org.ssm.dufy.bean.jianyibao.SalesData;

import java.util.List;

public interface IJybDao {
    List<Member> queryMemberByMobile(@Param("mobile")String mobile);
    List<Member> queryMemberByVipNo(@Param("vipNo")String vipNo);
    List<SalesData> querySalesData(@Param("endDate")String endDate, @Param("startDate")String startDate);
    List<Coupon> queryCoupon(@Param("endDate")String endDate, @Param("startDate")String startDate);
}
