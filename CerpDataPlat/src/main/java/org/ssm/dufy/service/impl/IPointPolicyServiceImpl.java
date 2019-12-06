package org.ssm.dufy.service.impl;

import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssm.common.utility.JAXBUtil;
import org.ssm.common.utility.StringUtil;
import org.ssm.cxf.struct.pointpolicy.POINTPOLICYINFO;
import org.ssm.cxf.struct.pointpolicy.POINTPOLICYINFOREQ;
import org.ssm.cxf.struct.pointpolicy.POINTPOLICYINFORESP;
import org.ssm.dufy.dao.IPointPolicyDao;
import org.ssm.dufy.entity.cerppojo.PointPolicy;
import org.ssm.dufy.service.IPointPolicyService;

@Service("pointPolicyService")
public class IPointPolicyServiceImpl implements IPointPolicyService {

	@Autowired
	public IPointPolicyDao pointPolicydao;

	@Override
	public String getPointPolicy_Lnjfsc(String entryid, String xmldata) {

		POINTPOLICYINFOREQ pointpolicyinfo_req = JAXBUtil.unmarshToObjBinding(POINTPOLICYINFOREQ.class, xmldata, "UTF-8");
		String goodsid = pointpolicyinfo_req.getGOODSID();
		String entrycompanyid = pointpolicyinfo_req.getENTRYCOMPANYID();
		String sys_modifydate = pointpolicyinfo_req.getSYSMODIFYDATE();
		String ym = pointpolicyinfo_req.getYM();
		if(StringUtil.isEmpty(ym) || !StringUtil.isNumeric(ym)) ym = "1";
		
		String retxml = "";		
		List<PointPolicy> pointpolicylist = (List<PointPolicy>) pointPolicydao.getPointPolicy_Lnjfsc(entrycompanyid, goodsid, sys_modifydate, Integer.valueOf(ym));
		POINTPOLICYINFORESP pointpolicyinforesp = new POINTPOLICYINFORESP();
		List<POINTPOLICYINFO> pointpolicyinfolist = pointpolicyinforesp.getINSIDERINFO();
		
		for(PointPolicy p : pointpolicylist) {
			POINTPOLICYINFO pointpolicyinfo = new POINTPOLICYINFO();
			
			pointpolicyinfo.setRepintegraldefid(p.getRepintegraldefid());
			pointpolicyinfo.setGoodsid(p.getGoodsid());
			pointpolicyinfo.setEntrycompanyid(p.getEntrycompanyid());
			pointpolicyinfo.setIntegral(p.getIntegral());
			pointpolicyinfo.setBegindate(p.getBegindate());
			pointpolicyinfo.setEnddate(p.getEnddate());
			
			pointpolicyinfolist.add(pointpolicyinfo);
		}
		
		try {
			retxml = JAXBUtil.marshToXmlBinding(POINTPOLICYINFORESP.class, pointpolicyinforesp, "UTF-8");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return retxml;
	}

}
