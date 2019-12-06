package org.ssm.dufy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ssm.dufy.entity.cerppojo.PointPolicy;

public interface IPointPolicyDao {
	
	List<PointPolicy> getPointPolicy_Lnjfsc(@Param("entrycompanyid")String entrycompanyid, @Param("goodsid")String goodsid, @Param("sys_modifydate")String sys_modifydate, @Param("ym")int ym);
}
