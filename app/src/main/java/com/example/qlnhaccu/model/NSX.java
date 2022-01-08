package com.example.qlnhaccu.model;

import java.io.Serializable;

public class NSX implements Serializable {
    public int idNSX;
    public String tenNSX;

    public NSX() {
    }

    public NSX(String tenNSX) {
        this.tenNSX = tenNSX;
    }

    public NSX(int idNSX, String tenNSX) {
        this.idNSX = idNSX;
        this.tenNSX = tenNSX;
    }

    public int getIdNSX() {
        return idNSX;
    }

    public void setIdNSX(int idNSX) {
        this.idNSX = idNSX;
    }

    public String getTenNSX() {
        return tenNSX;
    }

    public void setTenNSX(String tenNSX) {
        this.tenNSX = tenNSX;
    }
}


