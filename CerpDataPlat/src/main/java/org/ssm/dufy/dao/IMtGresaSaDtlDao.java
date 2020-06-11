package org.ssm.dufy.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IMtGresaSaDtlDao {

    List<Map<String, Object>> selectByOrderid(@Param("orderid") String orderid);

    int updateState(@Param("orderid") String orderid);

}
