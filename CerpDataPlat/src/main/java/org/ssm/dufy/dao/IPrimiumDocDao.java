package org.ssm.dufy.dao;

import org.apache.ibatis.annotations.Select;
import org.ssm.dufy.entity.cerpbusi.PrimiumDoc;

public interface IPrimiumDocDao {
	@Select("select ZX_JF_INSIDER_PRIMIUM_DOC_SEQ.Nextval seqid from dual")
	Integer getPrimiumDocSeqId();
	
	int insertPrimiumDoc(PrimiumDoc primiumdoc);
}
