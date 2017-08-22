package com.teca.loader.ircode;

import com.teca.loader.orm.IrCode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by truonglx.
 */
public class IrCodeAvFinder extends IrCodeFinder<IrCode> {


    public IrCodeAvFinder(String codeSetName) {
        super(AV_URL,codeSetName);
    }

    @Override
    protected List<IrCode> parse(String response) throws JSONException {
        List<IrCode> res=new ArrayList<IrCode>();
        JSONObject jsonObject=new JSONObject(response);
        JSONArray jsonArray=jsonObject.getJSONArray("functions");
        for (int i=0;i<jsonArray.length();i++)
            res.add(getElement(jsonArray.getJSONObject(i)));
        return res;
    }

    private IrCode getElement(JSONObject element) throws JSONException {

        String codeSetName;
        String function;
        String[] irs=new String[4];

        codeSetName=element.getString("0");
        function=element.getString("1");

        irs[0]=element.getString("3");
        irs[1]=element.getString("4");
        irs[2]=element.getString("5");
        irs[3]=element.getString("6");

        return new IrCode(codeSetName,function,irs);
    }
}
