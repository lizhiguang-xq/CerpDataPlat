package org.ssm.dufy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.ssm.dufy.entity.cerppojo.Stock;

public interface IStockDao {
	
	List<Stock> getStockByParam(@Param("goodsid")String goodsid, @Param("storageid")String storageid, @Param("placepointid")String placepointid, @Param("ym")int ym);
	
	List<Stock> getStock_Lnjfsc(@Param("goodsid")String goodsid, @Param("entrycompanyid")String entrycompanyid, @Param("ym")int ym);
	
	@Select("select 1 from bms_st_qty_lst where goodsid in (${goodsids}) and storageid = #{storageid} for update")
	List<String> lockStockByParam_Lnjfsc(@Param("goodsids")String goodsids, @Param("storageid")String storageid);
	
	@Select("select max(storageid) storageid from bms_st_def where storagetype = 2 and phystoreid = #{entrycompanyid}")
	String getStorageidByParam_Lnjfsc(@Param("entrycompanyid")String entrycompanyid);
	
	@Select("select entryid from bms_st_def where storageid = #{storageid}")
	String getEntryidByStorageid(@Param("storageid")String storageid);
	
	List<Stock> getStQtySumStock_Lnjfsc(@Param("goodsid")String goodsid, @Param("storageid")String storageid);
		
	int deleteBmsStQtyLstByParam(Stock stock);
	
	int updateBmsStQtyLstByParam(Stock stock);
	
}
