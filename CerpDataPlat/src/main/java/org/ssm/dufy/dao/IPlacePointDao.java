package org.ssm.dufy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ssm.dufy.entity.cerppojo.PlacePoint;

public interface IPlacePointDao {
	
	List<PlacePoint> getPlacePointByParam(@Param("entryid")String entryid, @Param("placepointid")String placepointid, @Param("ym")int ym);
}
