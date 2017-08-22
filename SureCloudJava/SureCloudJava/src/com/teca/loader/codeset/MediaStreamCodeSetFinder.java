package com.teca.loader.codeset;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by truonglx.
 */
public class MediaStreamCodeSetFinder extends CodeSetFinder {


    public MediaStreamCodeSetFinder(String brand) {
        super(AV_TEST_URL, brand, "Media Streamer");
    }

    @Override
    protected String getMsg() throws JSONException {

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("brand",getBrand());
        jsonObject.put("type",getType());
        jsonObject.put("func1","DOWN");
        jsonObject.put("func2","POWER");
        jsonObject.put("func3","UP");
        jsonObject.put("func4","MENU");
        jsonObject.put("func5","POWER OFF");
        jsonObject.put("func6","POWER ON");

        return jsonObject.toString();
    }
}
