package org.ssm.dufy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssm.common.utility.JAXBUtil;
import org.ssm.common.utility.StringUtil;
import org.ssm.cxf.struct.mtds.ORDERINFO_REQ;
import org.ssm.cxf.struct.mtds.ORDERINFO_RESP;
import org.ssm.cxf.struct.mtds.ORDERPAYSTATUSREQ;
import org.ssm.cxf.struct.mtds.ORDERPAYSTATUSRESP;
import org.ssm.dufy.dao.IMtGresaSaDtlDao;
import org.ssm.dufy.service.IMtGresaSaDtlService;

import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.Map;

@Service
public class IMtGresaSaDtlServiceImpl implements IMtGresaSaDtlService {

    @Autowired
    private IMtGresaSaDtlDao iMtGresaSaDtlDao;

    @Override
    public String updatePayStatus(String entryid, String xmldata) {
        ORDERPAYSTATUSREQ req = JAXBUtil.unmarshToObjBinding(ORDERPAYSTATUSREQ.class, xmldata, "UTF-8");
        String retxml = "";
        List<ORDERINFO_REQ> lists = req.getORDERINFO();
        if(lists.size()>0){
            ORDERPAYSTATUSRESP resp = new ORDERPAYSTATUSRESP();
            List<ORDERINFO_RESP> rlist = resp.getORDERINFO();
            for(int i=0;i<lists.size();i++){
                ORDERINFO_RESP rp = new ORDERINFO_RESP();
                ORDERINFO_REQ order = lists.get(i);
                rp.setORDERNO(order.getORDERNO());
                String orderid = order.getORDERNO().replace("DS","");
                List<Map<String, Object>> list = iMtGresaSaDtlDao.selectById(orderid);
                if(list.size()>0){
                    if(StringUtil.doNullInt(list.get(0).get("ZX_MENTE_PAYSTATE"))==1){
                        rp.setERRCODE("0");
                        rp.setERRMSG("付款状态已更新");
                    }else{
                        int result = iMtGresaSaDtlDao.updateStateByDocid(StringUtil.doNullStr(list.get(0).get("RSAID")));
                        if(result>0){
                            rp.setERRCODE("0");
                            rp.setERRMSG("付款状态更新成功");
                        }else{
                            rp.setERRCODE("-1");
                            rp.setERRMSG("付款状态更新失败");
                        }
                    }
                }else{
                    rp.setERRCODE("-99");
                    rp.setERRMSG("未查询到零售单");
                }
                rlist.add(rp);
            }
            try {
                retxml = JAXBUtil.marshToXmlBinding(ORDERPAYSTATUSRESP.class, resp, "UTF-8");
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
        return retxml;
    }
}
