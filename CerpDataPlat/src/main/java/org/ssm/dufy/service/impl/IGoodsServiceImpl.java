package org.ssm.dufy.service.impl;

import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssm.common.utility.JAXBUtil;
import org.ssm.common.utility.StringUtil;
import org.ssm.cxf.struct.goodsinfo.GOODSINFO;
import org.ssm.cxf.struct.goodsinfo.GOODSINFOREQ;
import org.ssm.cxf.struct.goodsinfo.GOODSINFORESP;
import org.ssm.cxf.struct.stock.STOCKINFO;
import org.ssm.cxf.struct.stock.STOCKINFOREQ;
import org.ssm.cxf.struct.stock.STOCKINFORESP;
import org.ssm.dufy.dao.IGoodsDao;
import org.ssm.dufy.dao.IStockDao;
import org.ssm.dufy.entity.cerppojo.Goods;
import org.ssm.dufy.entity.cerppojo.Stock;
import org.ssm.dufy.service.IGoodsService;

@Service("goodsService")
public class IGoodsServiceImpl implements IGoodsService {

	@Autowired
	public IGoodsDao goodsdao;
	
	@Autowired
	public IStockDao stockdao;
	
	@Override
	public Goods getGoodsById(int id) {
		return null;
	}

	@Override
	public List<Goods> getGoodsByParam(String entryid, String goodsid, String sys_modifydate, int ym) {
		
		@SuppressWarnings("unchecked")
		List<Goods> goodslist = (List<Goods>) goodsdao.getGoodsByParam(entryid, goodsid, sys_modifydate, ym);
		return goodslist;
	}

	@Override
	public String getGoods(String entryid, String xmldata) {		
		GOODSINFOREQ goodsinfo_req= JAXBUtil.unmarshToObjBinding(GOODSINFOREQ.class, xmldata, "UTF-8");
		String goodsid = goodsinfo_req.getGOODSID();
		String sys_modifydate = goodsinfo_req.getSYSMODIFYDATE();
		String ym = goodsinfo_req.getYM();		
		if(StringUtil.isEmpty(ym) || !StringUtil.isNumeric(ym)) ym = "1";
		
		String retxml = "";		
		List<Goods> goodslist = (List<Goods>) goodsdao.getGoodsByParam(entryid, goodsid, sys_modifydate, Integer.valueOf(ym));
		GOODSINFORESP goodsinforesp = new GOODSINFORESP();
		List<GOODSINFO> goodsinfolist = goodsinforesp.getGOODSINFO();
		
		for(Goods g : goodslist) {
			GOODSINFO goodsinfo = new GOODSINFO();
			goodsinfo.setGoodsid(g.getGoodsid());
			goodsinfo.setGoodsname(g.getGoodsname());
			goodsinfo.setGoodstype(g.getGoodstype());
			goodsinfo.setGoodsunit(g.getGoodsunit());
			goodsinfo.setCurrencyname(g.getCurrencyname());
			goodsinfo.setEntryid(g.getEntryid());
			goodsinfo.setBarcode(g.getBarcode());
			goodsinfo.setFactoryname(g.getFactoryname());
			goodsinfo.setSysModifydate(g.getSys_modifydate());
			goodsinfolist.add(goodsinfo);
		}
		
		try {
			retxml = JAXBUtil.marshToXmlBinding(GOODSINFORESP.class, goodsinforesp, "UTF-8");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return retxml;
	}

	@Override
	public String getGoods_Lnjfsc(String entryid, String xmldata) {
		GOODSINFOREQ goodsinfo_req= JAXBUtil.unmarshToObjBinding(GOODSINFOREQ.class, xmldata, "UTF-8");
		String goodsid = goodsinfo_req.getGOODSID();
		String sys_modifydate = goodsinfo_req.getSYSMODIFYDATE();
		String entrycompanyid = goodsinfo_req.getENTRYCOMPANYID();
		String ym = goodsinfo_req.getYM();		
		if(StringUtil.isEmpty(ym) || !StringUtil.isNumeric(ym)) ym = "1";
		
		String retxml = "";		
		List<Goods> goodslist = (List<Goods>) goodsdao.getGoods_Lnjfsc(entrycompanyid, goodsid, sys_modifydate, Integer.valueOf(ym));
		GOODSINFORESP goodsinforesp = new GOODSINFORESP();
		List<GOODSINFO> goodsinfolist = goodsinforesp.getGOODSINFO();
		
		for(Goods g : goodslist) {
			GOODSINFO goodsinfo = new GOODSINFO();
			goodsinfo.setGoodsid(g.getGoodsid());
			goodsinfo.setGoodsname(g.getGoodsname());
			goodsinfo.setGoodstype(g.getGoodstype());
			goodsinfo.setGoodsunit(g.getGoodsunit());
			goodsinfo.setCurrencyname(g.getCurrencyname());
			goodsinfo.setEntryid(g.getEntryid());
			goodsinfo.setBarcode(g.getBarcode());
			goodsinfo.setFactoryname(g.getFactoryname());
			goodsinfo.setSysModifydate(g.getSys_modifydate());
			goodsinfo.setEntrycompanyid(g.getEntrycompanyid());
			goodsinfolist.add(goodsinfo);
		}
		
		try {
			retxml = JAXBUtil.marshToXmlBinding(GOODSINFORESP.class, goodsinforesp, "UTF-8");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return retxml;
	}

	@Override
	public String getStock(String entryid, String xmldata) {
		STOCKINFOREQ stockinfo_req = JAXBUtil.unmarshToObjBinding(STOCKINFOREQ.class, xmldata, "UTF-8");
		String goodsid = stockinfo_req.getGOODSID();
		String storageid = stockinfo_req.getSTORAGEID();
		String placepoint = stockinfo_req.getPLACEPOINTID();
		String ym = stockinfo_req.getYM();		
		if(StringUtil.isEmpty(ym) || !StringUtil.isNumeric(ym)) ym = "1";
		
		String retxml = "";		
		List<Stock> stocklist = (List<Stock>) stockdao.getStockByParam(goodsid, storageid, placepoint, Integer.valueOf(ym));
		STOCKINFORESP stockinforesp = new STOCKINFORESP();
		List<STOCKINFO> stockinfolist = stockinforesp.getSTOCKINFO();
		
		for(Stock s : stocklist) {
			STOCKINFO stockinfo = new STOCKINFO();
			stockinfo.setGoodsid(s.getGoodsid());
			stockinfo.setQty(s.getQty());
			stockinfolist.add(stockinfo);
		}
		
		try {
			retxml = JAXBUtil.marshToXmlBinding(STOCKINFORESP.class, stockinforesp, "UTF-8");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return retxml;
	}
	
	@Override
	public String getStock_Lnjfsc(String entryid, String xmldata) {
		STOCKINFOREQ stockinfo_req = JAXBUtil.unmarshToObjBinding(STOCKINFOREQ.class, xmldata, "UTF-8");
		String goodsid = stockinfo_req.getGOODSID();
		String entrycompanyid = stockinfo_req.getENTRYCOMPANYID();
		String ym = stockinfo_req.getYM();
		if(StringUtil.isEmpty(ym) || !StringUtil.isNumeric(ym)) ym = "1";
		
		String retxml = "";		
		List<Stock> stocklist = (List<Stock>) stockdao.getStock_Lnjfsc(goodsid, entrycompanyid, Integer.valueOf(ym));
		STOCKINFORESP stockinforesp = new STOCKINFORESP();
		List<STOCKINFO> stockinfolist = stockinforesp.getSTOCKINFO();
		
		for(Stock s : stocklist) {
			STOCKINFO stockinfo = new STOCKINFO();
			stockinfo.setGoodsid(s.getGoodsid());
			stockinfo.setQty(s.getQty());
			stockinfolist.add(stockinfo);
		}
		
		try {
			retxml = JAXBUtil.marshToXmlBinding(STOCKINFORESP.class, stockinforesp, "UTF-8");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return retxml;
	}

}
