package com.example.demo.model;

import javax.persistence.Transient;

/**
 * Created by Joana on 18/2/1.
 */
public class BaseEtity {
    @Transient
    private Integer page = 1;

    @Transient
    private Integer rows = 10;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
