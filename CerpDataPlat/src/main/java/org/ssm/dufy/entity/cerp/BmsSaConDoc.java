package org.ssm.dufy.entity.cerp;

import java.math.BigDecimal;
import java.util.Date;

public class BmsSaConDoc {
    private Long conid;

    private String conno;

    private Long contype;

    private Long customid;

    private String customname;

    private Long salerid;

    private Long salesdeptid;

    private Date signdate;

    private String signaddress;

    private Long signmanid;

    private Date validbegindate;

    private Date validenddate;

    private String summary;

    private Long invtype;

    private Long settletypeid;

    private Long delivermethod;

    private Long tranmethod;

    private Long targetposid;

    private Long urgentflag;

    private Long tranpriority;

    private Date targetdate;

    private BigDecimal total;

    private Long inputmanid;

    private Date credate;

    private Integer dtlLines;

    private String memo;

    private Long entryid;

    private Long fmid;

    private BigDecimal exchange;

    private Long usestatus;

    private Long creditflag;

    private BigDecimal credit;

    private BigDecimal recmoney;

    private Long creditdaysflag;

    private Long creditdays;

    private Date recdate;

    private Long lowpriceflag;

    private Long approveflag;

    private Long approvemanid;

    private Date approvedate;

    private String approvememo;

    private Long confirmanid;

    private Date confirmdate;

    private Long printcount;

    private Long printmanid;

    private Date printdate;

    private Long comefrom;

    private Date assessdate;

    private Long wfusestatus;

    private Long wfprocess;

    private String wfmemo;

    private Long agentid;

    private Long cnscommitflag;

    private Long finishflag;

    private Long nowmsflag;

    private Date planinvdate;

    private Long invdemand;

    private Date predespdate;

    private String contactman;

    private Long zxStsetid;

    private String zxIsb2bsend;

    private String zxOutersysOrderid;

    private String zxOutersysCredate;

    private String zxOutersysStorageaddress;

    private String zxOutersysStoragename;

    private Long reactflag;

    private Long zxOmsflag;

    private BigDecimal charges;

    public Long getConid() {
        return conid;
    }

    public void setConid(Long conid) {
        this.conid = conid;
    }

    public String getConno() {
        return conno;
    }

    public void setConno(String conno) {
        this.conno = conno == null ? null : conno.trim();
    }

    public Long getContype() {
        return contype;
    }

    public void setContype(Long contype) {
        this.contype = contype;
    }

    public Long getCustomid() {
        return customid;
    }

    public void setCustomid(Long customid) {
        this.customid = customid;
    }

    public String getCustomname() {
        return customname;
    }

    public void setCustomname(String customname) {
        this.customname = customname == null ? null : customname.trim();
    }

    public Long getSalerid() {
        return salerid;
    }

    public void setSalerid(Long salerid) {
        this.salerid = salerid;
    }

    public Long getSalesdeptid() {
        return salesdeptid;
    }

    public void setSalesdeptid(Long salesdeptid) {
        this.salesdeptid = salesdeptid;
    }

    public Date getSigndate() {
        return signdate;
    }

    public void setSigndate(Date signdate) {
        this.signdate = signdate;
    }

    public String getSignaddress() {
        return signaddress;
    }

    public void setSignaddress(String signaddress) {
        this.signaddress = signaddress == null ? null : signaddress.trim();
    }

    public Long getSignmanid() {
        return signmanid;
    }

    public void setSignmanid(Long signmanid) {
        this.signmanid = signmanid;
    }

    public Date getValidbegindate() {
        return validbegindate;
    }

    public void setValidbegindate(Date validbegindate) {
        this.validbegindate = validbegindate;
    }

    public Date getValidenddate() {
        return validenddate;
    }

    public void setValidenddate(Date validenddate) {
        this.validenddate = validenddate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public Long getInvtype() {
        return invtype;
    }

    public void setInvtype(Long invtype) {
        this.invtype = invtype;
    }

    public Long getSettletypeid() {
        return settletypeid;
    }

    public void setSettletypeid(Long settletypeid) {
        this.settletypeid = settletypeid;
    }

    public Long getDelivermethod() {
        return delivermethod;
    }

    public void setDelivermethod(Long delivermethod) {
        this.delivermethod = delivermethod;
    }

    public Long getTranmethod() {
        return tranmethod;
    }

    public void setTranmethod(Long tranmethod) {
        this.tranmethod = tranmethod;
    }

    public Long getTargetposid() {
        return targetposid;
    }

    public void setTargetposid(Long targetposid) {
        this.targetposid = targetposid;
    }

    public Long getUrgentflag() {
        return urgentflag;
    }

    public void setUrgentflag(Long urgentflag) {
        this.urgentflag = urgentflag;
    }

    public Long getTranpriority() {
        return tranpriority;
    }

    public void setTranpriority(Long tranpriority) {
        this.tranpriority = tranpriority;
    }

    public Date getTargetdate() {
        return targetdate;
    }

    public void setTargetdate(Date targetdate) {
        this.targetdate = targetdate;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Long getInputmanid() {
        return inputmanid;
    }

    public void setInputmanid(Long inputmanid) {
        this.inputmanid = inputmanid;
    }

    public Date getCredate() {
        return credate;
    }

    public void setCredate(Date credate) {
        this.credate = credate;
    }

    public Integer getDtlLines() {
        return dtlLines;
    }

    public void setDtlLines(Integer dtlLines) {
        this.dtlLines = dtlLines;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Long getEntryid() {
        return entryid;
    }

    public void setEntryid(Long entryid) {
        this.entryid = entryid;
    }

    public Long getFmid() {
        return fmid;
    }

    public void setFmid(Long fmid) {
        this.fmid = fmid;
    }

    public BigDecimal getExchange() {
        return exchange;
    }

    public void setExchange(BigDecimal exchange) {
        this.exchange = exchange;
    }

    public Long getUsestatus() {
        return usestatus;
    }

    public void setUsestatus(Long usestatus) {
        this.usestatus = usestatus;
    }

    public Long getCreditflag() {
        return creditflag;
    }

    public void setCreditflag(Long creditflag) {
        this.creditflag = creditflag;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public BigDecimal getRecmoney() {
        return recmoney;
    }

    public void setRecmoney(BigDecimal recmoney) {
        this.recmoney = recmoney;
    }

    public Long getCreditdaysflag() {
        return creditdaysflag;
    }

    public void setCreditdaysflag(Long creditdaysflag) {
        this.creditdaysflag = creditdaysflag;
    }

    public Long getCreditdays() {
        return creditdays;
    }

    public void setCreditdays(Long creditdays) {
        this.creditdays = creditdays;
    }

    public Date getRecdate() {
        return recdate;
    }

    public void setRecdate(Date recdate) {
        this.recdate = recdate;
    }

    public Long getLowpriceflag() {
        return lowpriceflag;
    }

    public void setLowpriceflag(Long lowpriceflag) {
        this.lowpriceflag = lowpriceflag;
    }

    public Long getApproveflag() {
        return approveflag;
    }

    public void setApproveflag(Long approveflag) {
        this.approveflag = approveflag;
    }

    public Long getApprovemanid() {
        return approvemanid;
    }

    public void setApprovemanid(Long approvemanid) {
        this.approvemanid = approvemanid;
    }

    public Date getApprovedate() {
        return approvedate;
    }

    public void setApprovedate(Date approvedate) {
        this.approvedate = approvedate;
    }

    public String getApprovememo() {
        return approvememo;
    }

    public void setApprovememo(String approvememo) {
        this.approvememo = approvememo == null ? null : approvememo.trim();
    }

    public Long getConfirmanid() {
        return confirmanid;
    }

    public void setConfirmanid(Long confirmanid) {
        this.confirmanid = confirmanid;
    }

    public Date getConfirmdate() {
        return confirmdate;
    }

    public void setConfirmdate(Date confirmdate) {
        this.confirmdate = confirmdate;
    }

    public Long getPrintcount() {
        return printcount;
    }

    public void setPrintcount(Long printcount) {
        this.printcount = printcount;
    }

    public Long getPrintmanid() {
        return printmanid;
    }

    public void setPrintmanid(Long printmanid) {
        this.printmanid = printmanid;
    }

    public Date getPrintdate() {
        return printdate;
    }

    public void setPrintdate(Date printdate) {
        this.printdate = printdate;
    }

    public Long getComefrom() {
        return comefrom;
    }

    public void setComefrom(Long comefrom) {
        this.comefrom = comefrom;
    }

    public Date getAssessdate() {
        return assessdate;
    }

    public void setAssessdate(Date assessdate) {
        this.assessdate = assessdate;
    }

    public Long getWfusestatus() {
        return wfusestatus;
    }

    public void setWfusestatus(Long wfusestatus) {
        this.wfusestatus = wfusestatus;
    }

    public Long getWfprocess() {
        return wfprocess;
    }

    public void setWfprocess(Long wfprocess) {
        this.wfprocess = wfprocess;
    }

    public String getWfmemo() {
        return wfmemo;
    }

    public void setWfmemo(String wfmemo) {
        this.wfmemo = wfmemo == null ? null : wfmemo.trim();
    }

    public Long getAgentid() {
        return agentid;
    }

    public void setAgentid(Long agentid) {
        this.agentid = agentid;
    }

    public Long getCnscommitflag() {
        return cnscommitflag;
    }

    public void setCnscommitflag(Long cnscommitflag) {
        this.cnscommitflag = cnscommitflag;
    }

    public Long getFinishflag() {
        return finishflag;
    }

    public void setFinishflag(Long finishflag) {
        this.finishflag = finishflag;
    }

    public Long getNowmsflag() {
        return nowmsflag;
    }

    public void setNowmsflag(Long nowmsflag) {
        this.nowmsflag = nowmsflag;
    }

    public Date getPlaninvdate() {
        return planinvdate;
    }

    public void setPlaninvdate(Date planinvdate) {
        this.planinvdate = planinvdate;
    }

    public Long getInvdemand() {
        return invdemand;
    }

    public void setInvdemand(Long invdemand) {
        this.invdemand = invdemand;
    }

    public Date getPredespdate() {
        return predespdate;
    }

    public void setPredespdate(Date predespdate) {
        this.predespdate = predespdate;
    }

    public String getContactman() {
        return contactman;
    }

    public void setContactman(String contactman) {
        this.contactman = contactman == null ? null : contactman.trim();
    }

    public Long getZxStsetid() {
        return zxStsetid;
    }

    public void setZxStsetid(Long zxStsetid) {
        this.zxStsetid = zxStsetid;
    }

    public String getZxIsb2bsend() {
        return zxIsb2bsend;
    }

    public void setZxIsb2bsend(String zxIsb2bsend) {
        this.zxIsb2bsend = zxIsb2bsend == null ? null : zxIsb2bsend.trim();
    }

    public String getZxOutersysOrderid() {
        return zxOutersysOrderid;
    }

    public void setZxOutersysOrderid(String zxOutersysOrderid) {
        this.zxOutersysOrderid = zxOutersysOrderid == null ? null : zxOutersysOrderid.trim();
    }

    public String getZxOutersysCredate() {
        return zxOutersysCredate;
    }

    public void setZxOutersysCredate(String zxOutersysCredate) {
        this.zxOutersysCredate = zxOutersysCredate == null ? null : zxOutersysCredate.trim();
    }

    public String getZxOutersysStorageaddress() {
        return zxOutersysStorageaddress;
    }

    public void setZxOutersysStorageaddress(String zxOutersysStorageaddress) {
        this.zxOutersysStorageaddress = zxOutersysStorageaddress == null ? null : zxOutersysStorageaddress.trim();
    }

    public String getZxOutersysStoragename() {
        return zxOutersysStoragename;
    }

    public void setZxOutersysStoragename(String zxOutersysStoragename) {
        this.zxOutersysStoragename = zxOutersysStoragename == null ? null : zxOutersysStoragename.trim();
    }

    public Long getReactflag() {
        return reactflag;
    }

    public void setReactflag(Long reactflag) {
        this.reactflag = reactflag;
    }

    public Long getZxOmsflag() {
        return zxOmsflag;
    }

    public void setZxOmsflag(Long zxOmsflag) {
        this.zxOmsflag = zxOmsflag;
    }

    public BigDecimal getCharges() {
        return charges;
    }

    public void setCharges(BigDecimal charges) {
        this.charges = charges;
    }
}