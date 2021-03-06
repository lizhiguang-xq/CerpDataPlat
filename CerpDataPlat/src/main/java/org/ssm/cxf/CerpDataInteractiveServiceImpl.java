package org.ssm.cxf;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.cxf.interceptor.Fault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Component;
import org.ssm.dufy.constant.CommonConstant;
import org.ssm.dufy.entity.User;
import org.ssm.dufy.redis.RUserDao;
import org.ssm.dufy.service.*;

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

	@Resource
	private WebServiceContext context;

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
	private IInvnoService invnoService;

	@Autowired
	private ISxhsCerpBmsSaDocDtlService pjcerpService;

	@Autowired
	private ISalesInfoService salesService;
	
//	@Autowired
//    private EhCacheCacheManager cacheManager;
	
	@Autowired
	private IUserService userService;

	@Autowired
	private IWyCerpBmsSaDocDtlService wycerpService;

	@Autowired
	private IElemeService elemeService;

	@Autowired
	private IMtGresaSaDtlService mtGresaSaDtlService;

	@Autowired
	private IOmsService omsService;
	@Autowired
	private ICommonIntefaceServcie commonIntefaceServcie;

	@Override
	public String tslCerpDataInteractive(String userName, String passWord, String oper, String xmlData) {

		MessageContext messageContext = context.getMessageContext();
		HttpServletRequest request = (HttpServletRequest) messageContext.get(MessageContext.SERVLET_REQUEST);
//		User u = (User)cacheManager.getCache("userDataCache").get(userName).get();
//		User u = userService.getUserByName(userName);
		User u = (User)request.getAttribute("UserInfo");
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
			retxml = invnoService.getSaInvno_Dgys(entryid, xmlData); //获取 【东莞药事平台】 【销售发票】
		} else if(CommonConstant.OPER_GETSUINVO_INFO_DGYS.equals(oper.toLowerCase())){
			retxml = invnoService.getSuInvno_Dgys(entryid, xmlData); //获取 【东莞药事平台】 【采购发票】
		} else if(CommonConstant.OPER_GETSAINVNO_INFO_SXHS.equals(oper.toLowerCase())) {
			retxml = pjcerpService.getSaInvno_Sxhs(entryid, xmlData); //【平嘉】根据销售单号获取销售单信息
		} else if(CommonConstant.OPER_GETGOODS_INFO_NORMAL.equals(oper.toLowerCase())) {
			retxml = goodsService.getGoods_normal(entryid, xmlData); //【增城妇幼保健】根据货品ID获取货品信息
		} else if(CommonConstant.OPER_GETSAINVNO_INFO_ZCFY.equals(oper.toLowerCase())) {
			retxml = salesService.selectNotTranslateCodeAndNotApplyOrderSalesInfo(entryid, xmlData); //【增城妇幼保健】根据销售单号获取销售单信息
		} else if(CommonConstant.OPER_GETSAINVNO_INFO_WY.equals(oper.toLowerCase())) {
			retxml = wycerpService.getSaInvno_WY(entryid, xmlData); //【微医】根据外接系统订单id获取销售单信息
		} else if(CommonConstant.OPER_GETGOODSCLASSTYPE_ELM.equals(oper.toLowerCase())) {
			retxml = elemeService.getGoodsClassType(entryid, xmlData); //【饿了么】获取分类信息
		} else if(CommonConstant.OPER_GETGOODS_ELM.equals(oper.toLowerCase())) {
			retxml = elemeService.getGoodsInfo(entryid, xmlData); //【饿了么】获取货品信息
		} else if(CommonConstant.OPER_GETGOODS_QTY_ELM.equals(oper.toLowerCase())) {
			retxml = elemeService.getGoodsQty(entryid, xmlData); //【饿了么】获取库存
		} else if(CommonConstant.OPER_GETGOODS_PRICE_ELM.equals(oper.toLowerCase())) {
			retxml = elemeService.getGoodsPrice(entryid, xmlData); //【饿了么】获取货价
		} else if(CommonConstant.OPER_GETUSERINFO_ELM.equals(oper.toLowerCase())) {
			retxml = elemeService.getUsers(entryid, xmlData); //【饿了么】查询用户信息
		} else if(CommonConstant.OPER_GETGOODS_QTY_CLASSTYPEID_ELM.equals(oper.toLowerCase())) {
			retxml = elemeService.getGoodsQtyByClasstypeid(entryid, xmlData); //【饿了么】根据分类查询库存
		} else if(CommonConstant.OPER_GETGOODS_PRICE_CLASSTYPEID_ELM.equals(oper.toLowerCase())) {
			retxml = elemeService.getGoodsPriceByClasstypeid(entryid, xmlData); //【饿了么】根据分类查询价格
		} else if(CommonConstant.OPER_GETGOODS_QTY_COMMON.equals(oper.toLowerCase())) {
			retxml = commonIntefaceServcie.getGoodsQty(entryid, xmlData); //【通用类型】根据货品ID获取库存
		} else {
			throw new Fault(new IllegalArgumentException("操作:"+oper+",未开发"));
		}
		return retxml;
	}
	
	@Override
	public String tslCerpDataUpdate(String userName, String passWord, String oper, String xmlData) {
		
//		User u = (User)cacheManager.getCache("userDataCache").get(userName).get();
		User u = userService.getUserByName(userName);
		String entryid = "";		
		if(u!=null) {
			entryid = u.getEntryid().toString();
		} else {
			throw new Fault(new IllegalArgumentException("非法请求,独立单元为空"));
		}
		
		String retxml = "";
		if(CommonConstant.OPER_CREATE_PRIMIUM_ORDER_LNJFSC.equals(oper.toLowerCase())) {
			retxml = primiumOrderService.createPrimiumOrder(entryid, xmlData); //生成赠品订单
		} else if(CommonConstant.OPER_CREATE_APPLY_ORDER_SXHS.equals(oper.toLowerCase())) {
			retxml = pjcerpService.createApplyOrder(entryid, xmlData); //生成1067订单
		} else if(CommonConstant.OPER_CREATE_APPLY_ORDER_WY.equals(oper.toLowerCase())) {
			retxml = wycerpService.createApplyOrder(entryid, xmlData); //微医 生成1067订单
		} else if(CommonConstant.OPER_CREATEORDER_ELM.equals(oper.toLowerCase())) {
			retxml = elemeService.createOrder(entryid, xmlData); //【饿了么】生成10067零售订单
		} else if(CommonConstant.OPER_UPDATE_PAYSTATUS_MT.equals(oper.toLowerCase())) {
			retxml = mtGresaSaDtlService.updatePayStatus(entryid, xmlData); //【饿了么】生成10067零售订单
		} else if(CommonConstant.OPER_ORDER_OMS.equals(oper.toLowerCase())) {
			retxml = omsService.applyOrder(entryid, xmlData); //【OMS】生成82002零售订单
		} else if(CommonConstant.OPER_ORDER_CREATE_COMMON.equals(oper.toLowerCase())) {
			retxml = commonIntefaceServcie.createOrder(entryid, xmlData); //【OMS】生成82002零售订单
		} else if(CommonConstant.OPER_ORDER_CANCEL_COMMON.equals(oper.toLowerCase())) {
			retxml = commonIntefaceServcie.cancelOrder(entryid, xmlData); //【OMS】生成82002零售订单
		} else {
			throw new Fault(new IllegalArgumentException("操作:"+oper+",未开发"));
		}
		return retxml;
	}
}
