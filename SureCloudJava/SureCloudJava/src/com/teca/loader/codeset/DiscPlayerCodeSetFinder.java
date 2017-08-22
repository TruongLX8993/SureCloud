package com.teca.loader.codeset;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by truonglx.
 */
public class DiscPlayerCodeSetFinder extends CodeSetFinder {


    public DiscPlayerCodeSetFinder(String brand) {
        super(AV_TEST_URL, brand, "Disc Player");
    }

    @Override
    protected String getMsg() throws JSONException {

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("type",getType());
        jsonObject.put("brand",getBrand());
        jsonObject.put("func1","PLAY");
        jsonObject.put("func2","POWER");
        jsonObject.put("func3","PAUSE");
        jsonObject.put("func4","MENU");
        jsonObject.put("func5","PƠWER OFF");
        jsonObject.put("func6","POWER ON");
        return jsonObject.toString();
    }
}
