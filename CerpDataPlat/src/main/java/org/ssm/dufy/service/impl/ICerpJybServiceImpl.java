package org.ssm.dufy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssm.dufy.bean.jianyibao.Coupon;
import org.ssm.dufy.bean.jianyibao.Member;
import org.ssm.dufy.bean.jianyibao.SalesData;
import org.ssm.dufy.dao.IJybDao;
import org.ssm.dufy.service.ICerpJybService;

import java.util.List;
@Service("jybService")
public class ICerpJybServiceImpl implements ICerpJybService {
    @Autowired
    public IJybDao jybDao;

    @Override
    public List<Member> queryMemberByMobile(String mobile) {
        return jybDao.queryMemberByMobile(mobile);
    }

    @Override
    public List<Member> queryMemberByVipNo(String vipNo) {
        return jybDao.queryMemberByVipNo(vipNo);
    }

    @Override
    public List<SalesData> querySalesData(String endDate, String startDate) {
        return jybDao.querySalesData(endDate, startDate);
    }

    @Override
    public List<Coupon> queryCoupon(String endDate, String startDate) {
        return jybDao.queryCoupon(endDate, startDate);
    }
}
