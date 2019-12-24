package org.ssm.dufy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ssm.dufy.entity.cerppojo.SuInvno;

public interface ISuInvnoDao {
	
	List<SuInvno> getSuInvnoDetailBySalesid(@Param("entryid")String entryid, @Param("salesid")String salesid);

	List<SuInvno> getSuInvoiceInfo(@Param("invcode")String invcode, @Param("invno")String invno);

}
