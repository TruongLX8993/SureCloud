package com.teca.store.orm;

/**
 * Created by truonglx.
 */
public class IrCodeAc {

    private int id;

    private String codeSetName;

    private String functionName;

    private String power;

    private String mode;

    private int temp;

    private String fan;

    private String swing;

    private String ir;

    public IrCodeAc(String codeSetName, String functionName, String power, String mode, int temp,String fan, String swing, String ir) {
        this.codeSetName = codeSetName;
        this.functionName = functionName;
        this.power = power;
        this.mode = mode;
        this.temp = temp;
        this.swing = swing;
        this.ir = ir;
        this.fan=fan;
    }

    public IrCodeAc(String codeSetName, String functionName, String power, String mode, int temp,String fan, String swing, int id, String ir) {
        this.codeSetName = codeSetName;
        this.functionName = functionName;
        this.power = power;
        this.mode = mode;
        this.temp = temp;
        this.fan=fan;
        this.swing = swing;
        this.id = id;
        this.ir = ir;

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

    public String getPower() {
        return power;
    }

    public String getMode() {
        return mode;
    }

    public int getTemp() {
        return temp;
    }

    public String getSwing() {
        return swing;
    }

    public String getIr() {
        return ir;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFan() {
        return fan;
    }


}
