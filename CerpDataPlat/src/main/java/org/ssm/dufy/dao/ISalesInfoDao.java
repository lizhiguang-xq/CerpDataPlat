package org.ssm.dufy.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ISalesInfoDao {


    //根据销售单单号获取销售单信息，销售单在医院对码，非接口订单， 仅上传销售单信息用于医院收货用
    List<Map<String, Object>> selectNotTranslateCodeAndNotApplyOrderAndOnlyUpload(@Param("entryid")String entryid, @Param("salesid")String salesid);
}
