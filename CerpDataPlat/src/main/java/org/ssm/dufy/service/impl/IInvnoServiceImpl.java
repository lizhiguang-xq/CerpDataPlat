package org.ssm.dufy.service.impl;

import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssm.common.utility.JAXBUtil;
import org.ssm.common.utility.StringUtil;
import org.ssm.cxf.struct.sainvno.INVNODETIL;
import org.ssm.cxf.struct.sainvno.SAINVNOINFO;
import org.ssm.cxf.struct.sainvno.SAINVNOINFOREQ;
import org.ssm.cxf.struct.sainvno.SAINVNOINFORESP;
import org.ssm.cxf.struct.suinvno.SUINVNODETIL;
import org.ssm.cxf.struct.suinvno.SUINVNOINFO;
import org.ssm.cxf.struct.suinvno.SUINVNOINFOREQ;
import org.ssm.cxf.struct.suinvno.SUINVNOINFORESP;
import org.ssm.dufy.dao.ISaInvnoDao;
import org.ssm.dufy.dao.ISuInvnoDao;
import org.ssm.dufy.entity.cerppojo.SaInvno;
import org.ssm.dufy.entity.cerppojo.SuInvno;
import org.ssm.dufy.service.IInvnoService;

@Service("invnoService")
public class IInvnoServiceImpl implements IInvnoService {

	@Autowired
	public ISaInvnoDao sainvnodao;
	
	@Autowired
	public ISuInvnoDao suinvnodao;

	@Override
	public String getSaInvno_Dgys(String entryid, String xmldata) {

		SAINVNOINFOREQ sainvnoinfo_req = JAXBUtil.unmarshToObjBinding(SAINVNOINFOREQ.class, xmldata, "UTF-8");
		String salesid = sainvnoinfo_req.getSalesid();
		entryid = sainvnoinfo_req.getEntryid();
		
		String retxml = "";		
		List<SaInvno> sainvnodetail = (List<SaInvno>) sainvnodao.getSaInvnoDetailBySalesid(entryid, salesid);
		
		SAINVNOINFORESP sainvnoinforesp = new SAINVNOINFORESP();
		
		if(sainvnodetail.size() == 0) {
			sainvnoinforesp.setReturncode("-1");
			sainvnoinforesp.setReturnmsg("没有数据");
		} else {
			sainvnoinforesp.setReturncode("0");
			sainvnoinforesp.setReturnmsg("");
		}
		
		SAINVNOINFO sainvnoinfo = new SAINVNOINFO();
		sainvnoinforesp.setSainvnoinfo(sainvnoinfo);
		List<INVNODETIL> sainvnoinfolist = sainvnoinforesp.getSainvnoinfo().getInvnodetil();
		
		for(SaInvno i : sainvnodetail) {
			
			if(StringUtil.isEmpty(i.getInvcode()) || StringUtil.isEmpty(i.getInvno())) {
				sainvnoinforesp.setReturncode("-1");
				sainvnoinforesp.setReturnmsg("未开票:"+i.getIodtlid());
				sainvnoinfolist.clear();
				break;
			}
			
			INVNODETIL invnodetil = new INVNODETIL();
			invnodetil.setInvcode(i.getInvcode());
			invnodetil.setInvno(i.getInvno());
			invnodetil.setIodtlid(i.getIodtlid());
			invnodetil.setZxJsdate(i.getZx_jsdate());
			invnodetil.setTotal(i.getTotal());
			
			sainvnoinfolist.add(invnodetil);
		}
		
		try {
			retxml = JAXBUtil.marshToXmlBinding(SAINVNOINFORESP.class, sainvnoinforesp, "UTF-8");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return retxml;
	}
	
	@Override
	public String getSuInvno_Dgys(String entryid, String xmldata) {

		SUINVNOINFOREQ suinvnoinfo_req = JAXBUtil.unmarshToObjBinding(SUINVNOINFOREQ.class, xmldata, "UTF-8");
		String salesid = suinvnoinfo_req.getSalesid();
		entryid = suinvnoinfo_req.getEntryid();
		
		String retxml = "";		
		List<SuInvno> suinvnodetail = (List<SuInvno>) suinvnodao.getSuInvnoDetailBySalesid(entryid, salesid);
		
		SUINVNOINFORESP suinvnoinforesp = new SUINVNOINFORESP();
		
		if(suinvnodetail.size() == 0) {
			suinvnoinforesp.setReturncode("-1");
			suinvnoinforesp.setReturnmsg("没有数据");
		} else {
			suinvnoinforesp.setReturncode("0");
			suinvnoinforesp.setReturnmsg("");
		}
		
		SUINVNOINFO suinvnoinfo = new SUINVNOINFO();
		suinvnoinforesp.setJhinvnoinfo(suinvnoinfo);
		List<SUINVNODETIL> suinvnoinfolist = suinvnoinforesp.getJhinvnoinfo().getJhinvnodetil();
		
		for(SuInvno i : suinvnodetail) {
			
			if(StringUtil.isEmpty(i.getInvcode()) || StringUtil.isEmpty(i.getInvno())) {
				suinvnoinforesp.setReturncode("-1");
				suinvnoinforesp.setReturnmsg("未开票:"+i.getIodtlid());
				suinvnoinfolist.clear();
				break;
			}
			
			SUINVNODETIL invnodetil = new SUINVNODETIL();
			invnodetil.setInvcode(i.getInvcode());
			invnodetil.setInvno(i.getInvno());
			invnodetil.setIodtlid(i.getIodtlid());
			invnodetil.setFphszje(i.getTotal_in());
			invnodetil.setFpmxbm(i.getSusetdtlid());
			invnodetil.setGfmc(i.getEntryname());
			invnodetil.setHsje(i.getTotal_line());
			invnodetil.setKprq(i.getInvdate());
			invnodetil.setXfmc(i.getSupplyname());
			invnodetil.setShtxdh(i.getShtxdh());
			invnodetil.setLplx(i.getLplx());


			suinvnoinfolist.add(invnodetil);
		}
		
		try {
			retxml = JAXBUtil.marshToXmlBinding(SUINVNOINFORESP.class, suinvnoinforesp, "UTF-8");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return retxml;
	}

}
