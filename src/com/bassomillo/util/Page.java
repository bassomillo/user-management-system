package com.bassomillo.util;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {
    private static final long serialVersionUID = 1691504018262076153L;
    private Integer total;
    private List<T> data;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Page(Integer total, List<T> data) {
        this.total = total;
        this.data = data;
    }

    public Page() {
    }

    @Override
    public String toString() {
        return "Page{" +
                "total=" + total +
                ", data=" + data +
                '}';
    }
}
