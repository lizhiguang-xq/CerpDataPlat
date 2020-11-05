/**
 * Copyright 2020 bejson.com
 */
package org.ssm.cxf.struct.pjyj.recv;
import org.ssm.common.utility.DecimalUtils;

import java.util.Date;

/**
 * Auto-generated: 2020-10-20 14:56:41
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Goods implements Comparable {

    private String rowid;
    private String goodscode;
    private String batchno;
    private String producedate;
    private String validate;
    private String qty;
    public void setRowid(String rowid) {
        this.rowid = rowid;
    }
    public String getRowid() {
        return rowid;
    }

    public void setGoodscode(String goodscode) {
        this.goodscode = goodscode;
    }
    public String getGoodscode() {
        return goodscode;
    }

    public void setBatchno(String batchno) {
        this.batchno = batchno;
    }
    public String getBatchno() {
        return batchno;
    }

    public void setProducedate(String producedate) {
        this.producedate = producedate;
    }
    public String getProducedate() {
        return producedate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }
    public String getValidate() {
        return validate;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }
    public String getQty() {
        return qty;
    }

    @Override
    public int compareTo(Object o) {
        String orowid=((Goods)o).getRowid();
        String oqty = ((Goods)o).getQty();
        int compRid = DecimalUtils.comparaDecimal(this.rowid,orowid);
        if(compRid == 0) {
            return DecimalUtils.comparaDecimal(oqty,this.qty);
        }
        return compRid;
    }
}