package org.ssm.dufy.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssm.common.utility.JAXBUtil;
import org.ssm.common.utility.StringUtil;
import org.ssm.cxf.struct.sainvno.INVNODETIL;
import org.ssm.cxf.struct.sainvno.SAINVNOINFO;
import org.ssm.cxf.struct.sainvno.SAINVNOINFOREQ;
import org.ssm.cxf.struct.sainvno.SAINVNOINFORESP;
import org.ssm.cxf.struct.suinvno.*;
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
		List<SuInvno> suglgxdetail = (List<SuInvno>) suinvnodao.getSuInvnoDetailBySalesid(entryid, salesid);
		
		SUINVNOINFORESP suinvnoinforesp = new SUINVNOINFORESP();
		
		if(suglgxdetail.size() == 0) {
			suinvnoinforesp.setReturncode("-1");
			suinvnoinforesp.setReturnmsg("没有数据");
		} else {
			suinvnoinforesp.setReturncode("0");
			suinvnoinforesp.setReturnmsg("");
		}

		SUGLGXINFO suglgxinfo = new SUGLGXINFO();
		suinvnoinforesp.setJhglgxinfo(suglgxinfo);
		List<SUGLGXDETIL> suglgxinfolist = suinvnoinforesp.getJhglgxinfo().getJhglgxdetil();
		Map<String,String> fpmap = new HashMap<String,String>();

		for(SuInvno i : suglgxdetail) {
			if(StringUtil.isEmpty(i.getInvcode()) || StringUtil.isEmpty(i.getInvno())) {
				suinvnoinforesp.setReturncode("-1");
				suinvnoinforesp.setReturnmsg("未开票:"+i.getIodtlid());
				suglgxinfolist.clear();
				break;
			}

			SUGLGXDETIL glgxdetil = new SUGLGXDETIL();
			glgxdetil.setIodtlid(i.getIodtlid());
			glgxdetil.setInvcode(i.getInvcode());
			glgxdetil.setInvno(i.getInvno());
			glgxdetil.setFpmxbm(i.getSusetdtlid());

			suglgxinfolist.add(glgxdetil);

			fpmap.put(i.getInvcode()+i.getInvno(),i.getInvcode()+"_"+i.getInvno());
		}

		SUINVNOINFO suinvnoinfo = new SUINVNOINFO();
		suinvnoinforesp.setJhinvnoinfo(suinvnoinfo);
		List<SUINVNODETIL> suinvnoinfolist = suinvnoinforesp.getJhinvnoinfo().getJhinvnodetil();

		for(String key : fpmap.keySet()){
			String str = fpmap.get(key);
			String[] inv = str.split("_");

			List<SuInvno> suinvnodetail = (List<SuInvno>) suinvnodao.getSuInvoiceInfo(inv[0],inv[1]);
			String jshj = suinvnodao.getSuInvoiceTotal(inv[0],inv[1]);
			for(SuInvno i : suinvnodetail) {
				if(i.getLplx().equals("1")) {
					if(StringUtil.isEmpty(i.getShtxdh())){
						suinvnoinforesp.setReturncode("-1");
						suinvnoinforesp.setReturnmsg("发票随货同行单号信息不全");
						suglgxinfolist.clear();
						break;
					}
				}

				SUINVNODETIL invnodetil = new SUINVNODETIL();
				invnodetil.setInvcode(i.getInvcode());
				invnodetil.setInvno(i.getInvno());
				invnodetil.setFphszje(jshj);
				invnodetil.setFpmxbm(i.getSusetdtlid());
				invnodetil.setGfmc(i.getEntryname());
				invnodetil.setHsje(i.getTotal_line());
				invnodetil.setKprq(i.getInvdate());
				invnodetil.setXfmc(i.getSupplyname());
				invnodetil.setShtxdh(i.getShtxdh());
				invnodetil.setLplx(i.getLplx());
				invnodetil.setLotno(i.getLotno());
				invnodetil.setUnitprice(i.getUnitprice());
				invnodetil.setGoodsid(i.getGoodsid());
				invnodetil.setGoodsqty(i.getGoodsqty());
				invnodetil.setOutersysgoodsid(i.getOutersysgoodsid());
				invnodetil.setInvaliddate(i.getInvaliddate());
				invnodetil.setProddate(i.getProddate());
				suinvnoinfolist.add(invnodetil);
			}
		}
		
		try {
			retxml = JAXBUtil.marshToXmlBinding(SUINVNOINFORESP.class, suinvnoinforesp, "UTF-8");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return retxml;
	}

}
