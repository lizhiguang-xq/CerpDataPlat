package org.ssm.dufy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ssm.dufy.entity.cerppojo.SaInvno;

public interface ISaInvnoDao {
	
	List<SaInvno> getSaInvnoDetailBySalesid(@Param("entryid")String entryid, @Param("salesid")String salesid);
}
