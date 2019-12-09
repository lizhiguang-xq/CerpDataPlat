package org.ssm.cxf;

import javax.jws.WebService;

import org.apache.cxf.interceptor.Fault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Component;
import org.ssm.dufy.constant.CommonConstant;
import org.ssm.dufy.entity.User;
import org.ssm.dufy.service.IGoodsService;
import org.ssm.dufy.service.IInsiderService;
import org.ssm.dufy.service.IPointPolicyService;
import org.ssm.dufy.service.IPrimiumOrderService;
import org.ssm.dufy.service.ISaInvnoService;

/**
 * endpointInterface  接口地址的全路径
 * serviceName   接口名称
 * targetNamespace   与接口中的命名空间一直,一般是接口报名的倒置
 * @author Administrator
 *
 */
@Component("cerpDataInteractiveService")
@WebService(endpointInterface="org.ssm.cxf.CerpDataInteractiveService",serviceName="CerpDataInteractiveService",targetNamespace="http://cxf.ssm.org/")
public class CerpDataInteractiveServiceImpl implements CerpDataInteractiveService {

	@Autowired
	private IGoodsService goodsService;
	
	@Autowired
	private IInsiderService insiderService;
	
	@Autowired
	private IPointPolicyService pointPolicyService;
	
	@Autowired
	private IPrimiumOrderService primiumOrderService;
	
//	@Autowired
//	private IPlacePointService placePointService;

	@Autowired
	private ISaInvnoService saInvnoService;
	
	@Autowired
    private EhCacheCacheManager cacheManager;

	@Override
	public String tslCerpDataInteractive(String userName, String passWord, String oper, String xmlData) {
		
		User u = (User)cacheManager.getCache("userDataCache").get(userName).get();
		String entryid = "";		
		if(u!=null) {
			entryid = u.getEntryid().toString();
		} else {
			throw new Fault(new IllegalArgumentException("非法请求,独立单元为空"));
		}
		
		String retxml = "";
//		if(CommonConstant.OPER_GETGOODS.equals(oper.toLowerCase())) {
//			retxml = goodsService.getGoods(entryid, xmlData); //获取货品信息
//		} else if(CommonConstant.OPER_GETSTOCK.equals(oper.toLowerCase())){
//			retxml = goodsService.getStock(entryid, xmlData); //获取库存信息
//		} else if(CommonConstant.OPER_GETPLACEPOINT.equals(oper.toLowerCase())){
//			retxml = placePointService.getPlacePoint(entryid, xmlData); //获取门店信息
//		} else {
//			throw new Fault(new IllegalArgumentException("操作:"+oper+",未开发"));
//		}
			
		if(CommonConstant.OPER_GETGOODS_LNJFSC.equals(oper.toLowerCase())) {
			retxml = goodsService.getGoods_Lnjfsc(entryid, xmlData); //获取 【辽宁积分商城】 【货品信息】
		} else if(CommonConstant.OPER_GETSTOCK_LNJFSC.equals(oper.toLowerCase())) {
			retxml = goodsService.getStock_Lnjfsc(entryid, xmlData); //获取 【辽宁积分商城】 【库存信息】
		} else if(CommonConstant.OPER_GETINSIDER_LNJFSC.equals(oper.toLowerCase())) {
			retxml = insiderService.getInsider_Lnjfsc(entryid, xmlData); //获取 【辽宁积分商城】 【会员信息】
		} else if(CommonConstant.OPER_GETPOINTPOLICY_LNJFSC.equals(oper.toLowerCase())) {
			retxml = pointPolicyService.getPointPolicy_Lnjfsc(entryid, xmlData); //获取 【辽宁积分商城】 【积分政策】
		} else if(CommonConstant.OPER_GETSAINVO_INFO_DGYS.equals(oper.toLowerCase())){
			retxml = saInvnoService.getSaInvno_Dgys(entryid, xmlData); //获取 【东莞药事平台】 【销售发票】
		} else {
			throw new Fault(new IllegalArgumentException("操作:"+oper+",未开发"));
		}
		return retxml;
	}
	
	@Override
	public String tslCerpDataUpdate(String userName, String passWord, String oper, String xmlData) {
		
		User u = (User)cacheManager.getCache("userDataCache").get(userName).get();
		String entryid = "";		
		if(u!=null) {
			entryid = u.getEntryid().toString();
		} else {
			throw new Fault(new IllegalArgumentException("非法请求,独立单元为空"));
		}
		
		String retxml = "";
		if(CommonConstant.OPER_CREATE_PRIMIUM_ORDER_LNJFSC.equals(oper.toLowerCase())) {
			retxml = primiumOrderService.createPrimiumOrder(entryid, xmlData); //生成赠品订单
		} else {
			throw new Fault(new IllegalArgumentException("操作:"+oper+",未开发"));
		}
		return retxml;
	}
}
