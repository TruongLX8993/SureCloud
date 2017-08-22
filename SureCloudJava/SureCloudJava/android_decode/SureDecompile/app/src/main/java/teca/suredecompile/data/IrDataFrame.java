package teca.suredecompile.data;

import java.util.List;

/**
 * Created by truonglxteca .
 */

public class IrDataFrame {


    private String codeSet;
    private String irFrequency;
    private List<String> irFrame;
    private int repeat;


    public IrDataFrame(String codeSet,String irCode,int repeat) throws Exception {
        this.codeSet=codeSet;
        this.irFrequency=IrFrameManipulator.getIrFrequency(irCode);
        this.irFrame=IrFrameManipulator.getIrCmd(irCode);
        this.repeat=repeat;
    }

    public List<String> getIrFrame() {
        return irFrame;
    }

    public String getCodeSet() {
        return codeSet;
    }

    public String getIrFrequency() {
        return irFrequency;
    }

}
