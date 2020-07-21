package com.sfc.entitypage;

import java.util.List;

/**
 * 此类封装了分页的数据
 * totalPageCount:	总页数
 * pageSize:		每页的大小
 * totalCount:		所有有页面的总数据数量
 * currPageNo:		当前页码
 * newsList:		每一页的数据集合
 * @param <T>
 */
public class Page<T> {
    //总页数
    private int totalPageCount = 0;
    //每页的大小
    private int pageSize = 5;
    //所有有页面的总数据数量
    private int totalCount;
    //当前页码
    private int currPageNo = 1;
    //每一页的数据集合
    private List<T> aList;

    /**
     * 获取页数
     * @return
     */
    public int getTotalPageCount() {
        return totalPageCount;
    }

    /**
     * 设置页数
     * @param totalPageCount
     */
    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    /**
     * 获取单页面数据数量
     * @return
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置页面大小，前提必须大于0
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        if(pageSize > 0)
            this.pageSize = pageSize;
    }

    /**
     * 获取总页面大小
     * @return
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     *
     * @param totalCount
     */
    public void setTotalCount(int totalCount) {
        if(totalCount > 0) {
            this.totalCount = totalCount;
            //计算总页
            totalPageCount = this.totalCount % pageSize == 0 ? (this.totalCount/pageSize) : (this.totalCount/pageSize)+1;
        }
    }

    /**
     *
     * @return
     */
    public int getCurrPageNo() {
        if(currPageNo == 0)
            return 0;
        return currPageNo;
    }

    /**
     *
     * @param currPageNo
     */
    public void setCurrPageNo(int currPageNo) {
        if(currPageNo > 0)
            this.currPageNo = currPageNo;
    }

    /**
     *  分页后每页集合
     * @return
     */
    public List<T> getAList() {
        return aList;
    }

    /**
     *
     * @param newsList
     */
    public void setAList(List<T> newsList) {
        this.aList = newsList;
    }
}
