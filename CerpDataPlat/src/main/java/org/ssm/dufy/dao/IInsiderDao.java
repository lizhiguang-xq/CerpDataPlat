package org.ssm.dufy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.ssm.dufy.entity.cerppojo.Insider;

public interface IInsiderDao {
	List<Insider> getInsider_Lnjfsc(@Param("insiderid")String insiderid, @Param("mobile")String mobile, @Param("ym")int ym);
	
	@Select("select insiderid, integral from gpcs_insider a where a.insiderid = #{insiderid} for update")
	List<Map<String, String>> getLintegralbyId_forupdate(@Param("insiderid")String insiderid);
	
	int updateIntegralById(Insider insider);
}
