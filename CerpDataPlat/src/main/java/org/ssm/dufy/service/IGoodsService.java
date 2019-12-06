package org.ssm.dufy.service;

import java.util.List;

import org.ssm.dufy.entity.cerppojo.Goods;

public interface IGoodsService {

	public Goods getGoodsById(int id);
	
	public List<Goods> getGoodsByParam(String entryid, String goodsid, String sys_modifydate, int ym);
	
	public String getGoods(String entryid, String xmldata);
	
	public String getStock(String entryid, String xmldata);
	
	public String getGoods_Lnjfsc(String entryid, String xmldata);
	
	public String getStock_Lnjfsc(String entryid, String xmldata);
}

