package com.teca.loader.ircode;


import com.teca.loader.ircode.IrCodeFinder;
import com.teca.loader.orm.IrCodeAc;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by truonglx.
 */

public class IrCodeAcFinder extends IrCodeFinder<IrCodeAc> {

    public IrCodeAcFinder(String codeSet) {
        super(AC_URL,codeSet);
    }


    @Override
    protected List<IrCodeAc> parse(String msg) throws JSONException {


        JSONObject jsonObject=new JSONObject(msg);
        JSONArray jsonArray=jsonObject.getJSONArray("accode");
        List<IrCodeAc> res=new ArrayList<IrCodeAc>();
        for (int i=0;i<jsonArray.length();i++)
            res.add(getElement(jsonArray.getJSONObject(i)));
        return res;
    }

    private IrCodeAc getElement(JSONObject object) throws JSONException {

        String codeSetName=object.getString("0");
        String functionName=object.getString("1");
        String stPower=object.getString("2");
        String stMode=object.getString("3");
        int stTem=object.getInt("4");
        String stFan=object.getString("5");
        String stSwing=object.getString("6");
        String irCode=object.getString("7");
        return new IrCodeAc(codeSetName,functionName,stPower,stMode,stTem,stFan,stSwing, irCode);
    }
}
