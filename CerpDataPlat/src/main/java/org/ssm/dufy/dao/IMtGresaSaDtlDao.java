package org.ssm.dufy.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IMtGresaSaDtlDao {

    List<Map<String, Object>> selectByOrderid(@Param("orderid") String orderid);

    int updateState(@Param("orderid") String orderid);

    List<Map<String, Object>> selectById(@Param("orderid") String orderid);

    int updateStateByDocid(@Param("rsaid") String rsaid);

    int updateDocByDocid(@Param("rsaid") String rsaid,@Param("zx_delivery_name") String zx_delivery_name,@Param("zx_paytype") String zx_paytype,@Param("zx_receiptdate") String zx_receiptdate);

}
