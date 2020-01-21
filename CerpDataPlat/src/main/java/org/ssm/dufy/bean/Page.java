package org.ssm.dufy.bean;

import java.util.List;

public class Page<T> {
    private List<T> datas;
    private int pageno;
    private int totalpageno;
    private int totalsize;

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public int getPageno() {
        return pageno;
    }

    public void setPageno(int pageno) {
        this.pageno = pageno;
    }

    public int getTotalpageno() {
        return totalpageno;
    }

    public void setTotalpageno(int totalpageno) {
        this.totalpageno = totalpageno;
    }

    public int getTotalsize() {
        return totalsize;
    }

    public void setTotalsize(int totalsize) {
        this.totalsize = totalsize;
    }
}
