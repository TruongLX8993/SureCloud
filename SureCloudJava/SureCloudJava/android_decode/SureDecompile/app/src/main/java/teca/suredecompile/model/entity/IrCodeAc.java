package teca.suredecompile.model.entity;

/**
 * Created by truonglxteca .
 */

public class IrCodeAc {


    private String id;

    private String codesetName;

    private String functionName;

    private String stPower;

    private String stMode;

    private String stTemp;

    private String stSwing;

    private String irCode;

    public IrCodeAc(String codesetName, String functionName, String stPower, String stMode, String stTemp, String stSwing, String irCode) {
        this.codesetName = codesetName;
        this.functionName = functionName;
        this.stPower = stPower;
        this.stMode = stMode;
        this.stTemp = stTemp;
        this.stSwing = stSwing;
        this.irCode = irCode;
    }

    public IrCodeAc(String id, String codesetName, String functionName, String stPower, String stMode, String stTemp, String stSwing, String irCode) {
        this.id = id;
        this.codesetName = codesetName;
        this.functionName = functionName;
        this.stPower = stPower;
        this.stMode = stMode;
        this.stTemp = stTemp;
        this.stSwing = stSwing;
        this.irCode = irCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodesetName() {
        return codesetName;
    }

    public void setCodesetName(String codesetName) {
        this.codesetName = codesetName;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getStPower() {
        return stPower;
    }

    public void setStPower(String stPower) {
        this.stPower = stPower;
    }

    public String getStMode() {
        return stMode;
    }

    public void setStMode(String stMode) {
        this.stMode = stMode;
    }

    public String getStTemp() {
        return stTemp;
    }

    public void setStTemp(String stTemp) {
        this.stTemp = stTemp;
    }

    public String getStSwing() {
        return stSwing;
    }

    public void setStSwing(String stSwing) {
        this.stSwing = stSwing;
    }
}
