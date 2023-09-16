package com.example.DataStructureAndAlgorithms.linear.hashtable;

public class Entry {

    private Integer k;
    private String V;

    public Entry(Integer k, String v) {
        this.k = k;
        V = v;
    }

    public Integer getK() {
        return k;
    }

    public void setK(Integer k) {
        this.k = k;
    }

    public String getV() {
        return V;
    }

    public void setV(String v) {
        V = v;
    }
}
