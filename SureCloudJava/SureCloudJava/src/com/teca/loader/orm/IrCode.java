package com.teca.loader.orm;

/**
 * Created by truonglx.
 */
public class IrCode {

    private String codeSet;

    private String functionName;

    private String irCodes[];

    public IrCode(String codeSet, String functionName, String... irCodes) {
        this.codeSet = codeSet;
        this.functionName = functionName;
        this.irCodes = irCodes;
    }

    public String getFunctionName() {
        return functionName;
    }

    public String getCodeSet() {
        return codeSet;
    }

    public String[] getIrCodes() {
        return irCodes;
    }

    public String decodeIrCode(String encryption){
        return null;
    }


}
