package org.ssm.dufy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ssm.dufy.entity.cerppojo.Goods;

public interface IGoodsDao {
	
	List<Goods> getGoodsByParam(@Param("entryid")String entryid, @Param("goodsid")String goodsid, @Param("sys_modifydate")String sys_modifydate, @Param("ym")int ym);
	
	List<Goods> getGoods_Lnjfsc(@Param("entrycompanyid")String entrycompanyid, @Param("goodsid")String goodsid, @Param("sys_modifydate")String sys_modifydate, @Param("ym")int ym);
}
