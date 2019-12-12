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
import org.ssm.dufy.dao.ISaInvnoDao;
import org.ssm.dufy.entity.cerppojo.SaInvno;
import org.ssm.dufy.service.ISaInvnoService;

@Service("invnoService")
public class ISaInvnoServiceImpl implements ISaInvnoService {

	@Autowired
	public ISaInvnoDao sainvnodao;

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

}
