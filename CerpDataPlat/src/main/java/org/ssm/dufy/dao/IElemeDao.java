package org.ssm.dufy.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IElemeDao {

    List<Map<String, Object>> getGoodsClassType(@Param("entryid")String entryid, @Param("classtypeid")String classtypeid);

    List<Map<String, Object>> getGoods(@Param("entryid")String entryid, @Param("classid")String classid, @Param("placepointid")String placepointid, @Param("priceid")String priceid);

    List<Map<String, Object>> getGoodsQty(@Param("entryid")String entryid, @Param("placepointid")String placepointid, @Param("array")String[] array);

    List<Map<String, Object>> getGoodsPrice(@Param("entryid")String entryid, @Param("placepointid")String placepointid, @Param("priceid")String priceid, @Param("lasteventtime")String lasteventtime, @Param("array")String[] array);

    List<Map<String, Object>> getChangeGoodsIds(@Param("placepointid")String placepointid, @Param("lasteventtime")String lasteventtime, @Param("goodsids")String[] goodsids);

    List<Map<String, Object>> getUserinfos(@Param("entryid")String entryid, @Param("employeeids")String[] employeeids);

    List<Map<String, Object>> getChangeGoodsIdsByClasstypeid(@Param("entryid")String entryid, @Param("placepointid")String placepointid, @Param("classtypeid")String classtypeid, @Param("lasteventtime")String lasteventtime);

    List<Map<String, Object>> getGoodsQtyByClasstypeid(@Param("entryid")String entryid, @Param("placepointid")String placepointid, @Param("classtypeid")String classtypeid, @Param("array")String[] array);

    List<Map<String, Object>> getGoodsPriceByClasstypeid(@Param("entryid")String entryid, @Param("placepointid")String placepointid, @Param("priceid")String priceid, @Param("lasteventtime")String lasteventtime, @Param("classtypeid")String classtypeid);
}
