package org.ssm.dufy.service.impl;

import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssm.common.utility.JAXBUtil;
import org.ssm.common.utility.StringUtil;
import org.ssm.cxf.struct.insider.INSIDERINFO;
import org.ssm.cxf.struct.insider.INSIDERINFOREQ;
import org.ssm.cxf.struct.insider.INSIDERINFORESP;
import org.ssm.dufy.dao.IInsiderDao;
import org.ssm.dufy.entity.cerppojo.Insider;
import org.ssm.dufy.service.IInsiderService;

@Service("insiderService")
public class IInsiderServiceImpl implements IInsiderService {

	@Autowired
	public IInsiderDao insiderdao;

	@Override
	public String getInsider_Lnjfsc(String entryid, String xmldata) {

		INSIDERINFOREQ insiderinfo_req = JAXBUtil.unmarshToObjBinding(INSIDERINFOREQ.class, xmldata, "UTF-8");
		String insiderid = insiderinfo_req.getINSIDERID();
		String mobile = insiderinfo_req.getMOBILE();
		String ym = insiderinfo_req.getYM();
		if(StringUtil.isEmpty(ym) || !StringUtil.isNumeric(ym)) ym = "1";
		
		String retxml = "";		
		List<Insider> insiderlist = (List<Insider>) insiderdao.getInsider_Lnjfsc(insiderid, mobile, Integer.valueOf(ym));
		INSIDERINFORESP insiderinforesp = new INSIDERINFORESP();
		List<INSIDERINFO> insiderinfolist = insiderinforesp.getINSIDERINFO();
		
		for(Insider i : insiderlist) {
			INSIDERINFO insiderinfo = new INSIDERINFO();
			insiderinfo.setInsiderid(i.getInsiderid());
			insiderinfo.setInsidername(i.getInsidername());
			insiderinfo.setSex(i.getSex());
			insiderinfo.setBirthdate(i.getBirthdate());
			insiderinfo.setEntrycompanyid(i.getEntrycompanyid());
			insiderinfo.setIntegral(i.getIntegral());
			insiderinfo.setMobile(i.getMobile());
			insiderinfolist.add(insiderinfo);
		}
		
		try {
			retxml = JAXBUtil.marshToXmlBinding(INSIDERINFORESP.class, insiderinforesp, "UTF-8");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return retxml;
	}

}
