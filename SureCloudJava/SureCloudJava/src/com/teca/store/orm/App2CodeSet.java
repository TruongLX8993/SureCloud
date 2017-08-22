package com.teca.store.orm;

/**
 * Created by truonglx.
 */
public class App2CodeSet {

    private int id;

    private int type2BrandId;

    private String codeSetName;


    public App2CodeSet(int id, int type2BrandId, String codeSetName) {
        this.id = id;
        this.codeSetName = codeSetName;
        this.type2BrandId=type2BrandId;
    }

    public App2CodeSet(String codeSetName, int type2BrandId) {
        this.codeSetName = codeSetName;
        this.type2BrandId = type2BrandId;
    }

    public int getId() {
        return id;
    }

    public int getType2BrandId() {
        return type2BrandId;
    }

    public String getCodeSetName() {
        return codeSetName;
    }


    public void setId(int id) {
        this.id = id;
    }
}
