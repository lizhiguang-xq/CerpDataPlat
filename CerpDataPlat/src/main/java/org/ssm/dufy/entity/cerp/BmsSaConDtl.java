package org.ssm.dufy.entity.cerp;

import java.math.BigDecimal;
import java.util.Date;

public class BmsSaConDtl {
    private Long condtlid;

    private Long conid;

    private Long goodsid;

    private Long goodsdtlid;

    private Long priceid;

    private BigDecimal goodsqty;

    private String goodsuseunit;

    private BigDecimal goodsuseqty;

    private BigDecimal unitprice;

    private BigDecimal totalLine;

    private BigDecimal wholesaleprice;

    private BigDecimal resaleprice;

    private BigDecimal discount;

    private Long timepriceid;

    private BigDecimal timeprice;

    private BigDecimal accstqty;

    private String dtlmemo;

    private Long invalidflag;

    private Long invalidmanid;

    private Date invalidtime;

    private Long speciallotflag;

    private String lotmemo;

    private String printno;

    private Integer printline;

    private Long lowerflag;

    private BigDecimal saplaceqty;

    private BigDecimal customlastprice;

    private Long usestatus;

    private BigDecimal usepacksize;

    private Long reqprintquflag;

    private Long agreementflag;

    private Long agrcondtlid;

    private BigDecimal oldunitprice;

    private Long contype;

    private BigDecimal zxCheckgarss;

    private BigDecimal zxCheckgrassrate;

    private Long zxCheckpricetype;

    private BigDecimal zxCheckprice;

    private BigDecimal taxrate;

    private String zxOutersysOrderid;

    private String zxOutersysOrderindex;

    private String zxOutersysSupplyid;

    private Long zxOutersysId;

    private String zxOutersysOldsupplyid;

    private String zxOutersysGoodsid;

    private String zxOutersysCustomid;

    private String zxOutersysMemo;

    private Long zxSucondtlid;

    private BigDecimal oosrecFlag;

    public Long getCondtlid() {
        return condtlid;
    }

    public void setCondtlid(Long condtlid) {
        this.condtlid = condtlid;
    }

    public Long getConid() {
        return conid;
    }

    public void setConid(Long conid) {
        this.conid = conid;
    }

    public Long getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Long goodsid) {
        this.goodsid = goodsid;
    }

    public Long getGoodsdtlid() {
        return goodsdtlid;
    }

    public void setGoodsdtlid(Long goodsdtlid) {
        this.goodsdtlid = goodsdtlid;
    }

    public Long getPriceid() {
        return priceid;
    }

    public void setPriceid(Long priceid) {
        this.priceid = priceid;
    }

    public BigDecimal getGoodsqty() {
        return goodsqty;
    }

    public void setGoodsqty(BigDecimal goodsqty) {
        this.goodsqty = goodsqty;
    }

    public String getGoodsuseunit() {
        return goodsuseunit;
    }

    public void setGoodsuseunit(String goodsuseunit) {
        this.goodsuseunit = goodsuseunit == null ? null : goodsuseunit.trim();
    }

    public BigDecimal getGoodsuseqty() {
        return goodsuseqty;
    }

    public void setGoodsuseqty(BigDecimal goodsuseqty) {
        this.goodsuseqty = goodsuseqty;
    }

    public BigDecimal getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }

    public BigDecimal getTotalLine() {
        return totalLine;
    }

    public void setTotalLine(BigDecimal totalLine) {
        this.totalLine = totalLine;
    }

    public BigDecimal getWholesaleprice() {
        return wholesaleprice;
    }

    public void setWholesaleprice(BigDecimal wholesaleprice) {
        this.wholesaleprice = wholesaleprice;
    }

    public BigDecimal getResaleprice() {
        return resaleprice;
    }

    public void setResaleprice(BigDecimal resaleprice) {
        this.resaleprice = resaleprice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Long getTimepriceid() {
        return timepriceid;
    }

    public void setTimepriceid(Long timepriceid) {
        this.timepriceid = timepriceid;
    }

    public BigDecimal getTimeprice() {
        return timeprice;
    }

    public void setTimeprice(BigDecimal timeprice) {
        this.timeprice = timeprice;
    }

    public BigDecimal getAccstqty() {
        return accstqty;
    }

    public void setAccstqty(BigDecimal accstqty) {
        this.accstqty = accstqty;
    }

    public String getDtlmemo() {
        return dtlmemo;
    }

    public void setDtlmemo(String dtlmemo) {
        this.dtlmemo = dtlmemo == null ? null : dtlmemo.trim();
    }

    public Long getInvalidflag() {
        return invalidflag;
    }

    public void setInvalidflag(Long invalidflag) {
        this.invalidflag = invalidflag;
    }

    public Long getInvalidmanid() {
        return invalidmanid;
    }

    public void setInvalidmanid(Long invalidmanid) {
        this.invalidmanid = invalidmanid;
    }

    public Date getInvalidtime() {
        return invalidtime;
    }

    public void setInvalidtime(Date invalidtime) {
        this.invalidtime = invalidtime;
    }

    public Long getSpeciallotflag() {
        return speciallotflag;
    }

    public void setSpeciallotflag(Long speciallotflag) {
        this.speciallotflag = speciallotflag;
    }

    public String getLotmemo() {
        return lotmemo;
    }

    public void setLotmemo(String lotmemo) {
        this.lotmemo = lotmemo == null ? null : lotmemo.trim();
    }

    public String getPrintno() {
        return printno;
    }

    public void setPrintno(String printno) {
        this.printno = printno == null ? null : printno.trim();
    }

    public Integer getPrintline() {
        return printline;
    }

    public void setPrintline(Integer printline) {
        this.printline = printline;
    }

    public Long getLowerflag() {
        return lowerflag;
    }

    public void setLowerflag(Long lowerflag) {
        this.lowerflag = lowerflag;
    }

    public BigDecimal getSaplaceqty() {
        return saplaceqty;
    }

    public void setSaplaceqty(BigDecimal saplaceqty) {
        this.saplaceqty = saplaceqty;
    }

    public BigDecimal getCustomlastprice() {
        return customlastprice;
    }

    public void setCustomlastprice(BigDecimal customlastprice) {
        this.customlastprice = customlastprice;
    }

    public Long getUsestatus() {
        return usestatus;
    }

    public void setUsestatus(Long usestatus) {
        this.usestatus = usestatus;
    }

    public BigDecimal getUsepacksize() {
        return usepacksize;
    }

    public void setUsepacksize(BigDecimal usepacksize) {
        this.usepacksize = usepacksize;
    }

    public Long getReqprintquflag() {
        return reqprintquflag;
    }

    public void setReqprintquflag(Long reqprintquflag) {
        this.reqprintquflag = reqprintquflag;
    }

    public Long getAgreementflag() {
        return agreementflag;
    }

    public void setAgreementflag(Long agreementflag) {
        this.agreementflag = agreementflag;
    }

    public Long getAgrcondtlid() {
        return agrcondtlid;
    }

    public void setAgrcondtlid(Long agrcondtlid) {
        this.agrcondtlid = agrcondtlid;
    }

    public BigDecimal getOldunitprice() {
        return oldunitprice;
    }

    public void setOldunitprice(BigDecimal oldunitprice) {
        this.oldunitprice = oldunitprice;
    }

    public Long getContype() {
        return contype;
    }

    public void setContype(Long contype) {
        this.contype = contype;
    }

    public BigDecimal getZxCheckgarss() {
        return zxCheckgarss;
    }

    public void setZxCheckgarss(BigDecimal zxCheckgarss) {
        this.zxCheckgarss = zxCheckgarss;
    }

    public BigDecimal getZxCheckgrassrate() {
        return zxCheckgrassrate;
    }

    public void setZxCheckgrassrate(BigDecimal zxCheckgrassrate) {
        this.zxCheckgrassrate = zxCheckgrassrate;
    }

    public Long getZxCheckpricetype() {
        return zxCheckpricetype;
    }

    public void setZxCheckpricetype(Long zxCheckpricetype) {
        this.zxCheckpricetype = zxCheckpricetype;
    }

    public BigDecimal getZxCheckprice() {
        return zxCheckprice;
    }

    public void setZxCheckprice(BigDecimal zxCheckprice) {
        this.zxCheckprice = zxCheckprice;
    }

    public BigDecimal getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(BigDecimal taxrate) {
        this.taxrate = taxrate;
    }

    public String getZxOutersysOrderid() {
        return zxOutersysOrderid;
    }

    public void setZxOutersysOrderid(String zxOutersysOrderid) {
        this.zxOutersysOrderid = zxOutersysOrderid == null ? null : zxOutersysOrderid.trim();
    }

    public String getZxOutersysOrderindex() {
        return zxOutersysOrderindex;
    }

    public void setZxOutersysOrderindex(String zxOutersysOrderindex) {
        this.zxOutersysOrderindex = zxOutersysOrderindex == null ? null : zxOutersysOrderindex.trim();
    }

    public String getZxOutersysSupplyid() {
        return zxOutersysSupplyid;
    }

    public void setZxOutersysSupplyid(String zxOutersysSupplyid) {
        this.zxOutersysSupplyid = zxOutersysSupplyid == null ? null : zxOutersysSupplyid.trim();
    }

    public Long getZxOutersysId() {
        return zxOutersysId;
    }

    public void setZxOutersysId(Long zxOutersysId) {
        this.zxOutersysId = zxOutersysId;
    }

    public String getZxOutersysOldsupplyid() {
        return zxOutersysOldsupplyid;
    }

    public void setZxOutersysOldsupplyid(String zxOutersysOldsupplyid) {
        this.zxOutersysOldsupplyid = zxOutersysOldsupplyid == null ? null : zxOutersysOldsupplyid.trim();
    }

    public String getZxOutersysGoodsid() {
        return zxOutersysGoodsid;
    }

    public void setZxOutersysGoodsid(String zxOutersysGoodsid) {
        this.zxOutersysGoodsid = zxOutersysGoodsid == null ? null : zxOutersysGoodsid.trim();
    }

    public String getZxOutersysCustomid() {
        return zxOutersysCustomid;
    }

    public void setZxOutersysCustomid(String zxOutersysCustomid) {
        this.zxOutersysCustomid = zxOutersysCustomid == null ? null : zxOutersysCustomid.trim();
    }

    public String getZxOutersysMemo() {
        return zxOutersysMemo;
    }

    public void setZxOutersysMemo(String zxOutersysMemo) {
        this.zxOutersysMemo = zxOutersysMemo == null ? null : zxOutersysMemo.trim();
    }

    public Long getZxSucondtlid() {
        return zxSucondtlid;
    }

    public void setZxSucondtlid(Long zxSucondtlid) {
        this.zxSucondtlid = zxSucondtlid;
    }

    public BigDecimal getOosrecFlag() {
        return oosrecFlag;
    }

    public void setOosrecFlag(BigDecimal oosrecFlag) {
        this.oosrecFlag = oosrecFlag;
    }
}