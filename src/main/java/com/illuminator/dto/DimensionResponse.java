package com.illuminator.dto;

import java.io.Serializable;

public class DimensionResponse {

    private String name;
    private Serializable id;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Serializable getId() {
        return id;
    }

    public void setId(Serializable id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Dimension={" + "id=" + id + ", name=" + name + ", url=" + url +'}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
