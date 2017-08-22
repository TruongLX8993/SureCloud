package com.teca.loader.orm;

/**
 * Created by truonglx.
 */
public class IrCodeAc extends IrCode {


    private String power;

    private String mode;

    private int temp;

    private String swing;

    private String fan;




    public IrCodeAc(String codeSet, String functionName, String power, String mode, int
            temp,String fan, String swing, String... irCodes) {
        super(codeSet, functionName, irCodes);

        this.power = power;
        this.mode = mode;
        this.temp = temp;
        this.swing = swing;
        this.fan=fan;
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

    public String getFan() {
        return fan;
    }

    public String getSwing() {
        return swing;
    }
}
