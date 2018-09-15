package com.wcfvol.onlinejudge.pojo;

/**
 * @author wangchunfei
 */
public class PageInfo {
    private int pageNum = 1;
    private int pageSize = 20;

    private int total;

    public PageInfo() {

    }
    public PageInfo(int pageNum,int pageSize) {
        if (pageNum<=0) {
            return;
        } else if(pageSize<=0) {
            return;
        } else {
            this.pageNum = pageNum;
            this.pageSize = pageSize;
        }
    }
    public PageInfo(int pageNum,int pageSize,int total) {
        if (pageNum<=0) {
            return;
        } else if(pageSize<=0) {
            return;
        } else {
            this.pageNum = pageNum;
            this.pageSize = pageSize;
            this.total = total;
        }
    }
}
