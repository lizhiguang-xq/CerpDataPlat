package org.ssm.dufy.dao;

import org.apache.ibatis.annotations.Param;
import org.ssm.dufy.entity.cerp.BmsSaConDoc;
import org.ssm.dufy.entity.cerp.BmsSaConDtl;

import java.util.List;
import java.util.Map;

public interface ISxhsCerpBmsSaDocDtlDao {

    List<Map<String, Object>> checkapplayorder(@Param("entryid")String entryid, @Param("customid")String customid, @Param("orderid")String orderid);

    Long getdocseqvalue();

    Long getdtlseqvalue();

    List<Map<String, Object>> getcustominfo(@Param("entryid")String entryid, @Param("customid")String customid);

    List<Map<String, Object>> getagentinfo(@Param("entryid")String entryid, @Param("agentid")String agentid);

    List<Map<String, Object>> getCredit(@Param("customid")String customid, @Param("agentid")String agentid);

    int insertDoc(BmsSaConDoc record);

    int insertDtl(BmsSaConDtl record);

    Long getTranPosId(@Param("entryid")String entryid, @Param("companyid")String companyid, @Param("tranposname")String tranposname);

    List<Long> getChooseTranPosId(@Param("entryid")String entryid, @Param("companyid")String companyid);

    List<Map<String, Object>> getErpGoodsInfo(@Param("entryid")String entryid, @Param("goodsid")String goodsid);

    List<Map<String, Object>> select(@Param("entryid")String entryid, @Param("salesid")String salesid);

    String getseqvalue(String seq);
}
