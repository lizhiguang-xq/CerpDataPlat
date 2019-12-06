package org.ssm.dufy.dao;

import org.apache.ibatis.annotations.Select;
import org.ssm.dufy.entity.cerpbusi.CerpStIoDtl;

public interface IStIoDtlDao {
	@Select("select bms_st_io_dtl_seq.Nextval seqid from dual")
	Integer getStIoDtlSeqId();
	
	int insertStIoDtl(CerpStIoDtl stiodtl);
}
