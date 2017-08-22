package com.teca.store.orm;

/**
 * Created by truonglx.
 */
public class IrCode {

    private int id;

    private String codeSetName;

    private String functionName;

    private String ir1;

    private String ir2;

    private String irr3;

    private String ir4;


    public IrCode(int id, String codeSetName, String functionName, String ir1, String ir2, String irr3, String ir4) {
        this.id = id;
        this.codeSetName = codeSetName;
        this.functionName = functionName;
        this.ir1 = ir1;
        this.ir2 = ir2;
        this.irr3 = irr3;
        this.ir4 = ir4;
    }

    public IrCode(String codeSetName, String functionName, String ir1, String ir2, String irr3, String ir4) {
        this.codeSetName = codeSetName;
        this.functionName = functionName;
        this.ir1 = ir1;
        this.ir2 = ir2;
        this.irr3 = irr3;
        this.ir4 = ir4;
    }


    public int getId() {
        return id;
    }

    public String getCodeSetName() {
        return codeSetName;
    }

    public String getFunctionName() {
        return functionName;
    }


    public String getIr1() {
        return ir1;
    }

    public String getIr2() {
        return ir2;
    }

    public String getIr3() {
        return irr3;
    }

    public String getIr4() {
        return ir4;
    }

    public void setId(int id) {
        this.id = id;
    }
}
