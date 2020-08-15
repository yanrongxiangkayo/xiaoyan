package com.kayo.io;

import java.io.Serializable;
import java.util.List;

/**
 * 分页实体
 */
public class PageResult implements Serializable {
    /**
     * 总页数
     */
    private long pages;
    /**
     * 分页数据
     */
    private List<?> rows;

    public PageResult() {
    }

    public PageResult(long pages, List<?> rows) {
        this.pages = pages;
        this.rows = rows;
    }

    /**
     * setter and getter method
     */
    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
