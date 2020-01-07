package org.ssm.dufy.service;

import java.util.List;
import java.util.Map;

public interface ISxhsCerpBmsSaDocDtlService {

    public String createApplyOrder(String entryid, String xmldata);

    public String getSaInvno_Sxhs(String entryid, String xmldata);
}
