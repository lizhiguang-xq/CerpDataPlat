package org.ssm.dufy.dao;

import org.apache.ibatis.annotations.Select;
import org.ssm.dufy.entity.cerpbusi.CerpStIoDoc;

public interface IStIoDocDao {
	@Select("select bms_st_io_doc_seq.Nextval seqid from dual")
	Integer getStIoDocSeqId();
	
	int insertStIoDoc(CerpStIoDoc stiodoc);
}
