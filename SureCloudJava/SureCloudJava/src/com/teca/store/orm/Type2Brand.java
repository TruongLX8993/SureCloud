package com.teca.store.orm;

/**
 * Created by truonglx.
 */
public class Type2Brand {

    private String typeName;

    private String brandName;

    private int id;

    public Type2Brand(String typeName, String brandName, int id) {
        this.typeName = typeName;
        this.brandName = brandName;
        this.id = id;
    }

    public Type2Brand(String typeName, String brandName) {
        this.typeName = typeName;
        this.brandName = brandName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getTypeName() {
        return typeName;
    }

}
