package org.ssm.dufy.dao;

import org.apache.ibatis.annotations.Select;
import org.ssm.dufy.entity.cerpbusi.PrimiumDtl;

public interface IPrimiumDtlDao {
	@Select("select ZX_JF_INSIDER_PRIMIUM_DTL_SEQ.Nextval seqid from dual")
	Integer getPrimiumDtlSeqId();
	
	int insertPrimiumDtl(PrimiumDtl primiumdtl);
}
