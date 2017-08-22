package com.teca.loader.codeset;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by truonglx.
 */
public class ProjectorCodeSetFinder extends CodeSetFinder {

    public ProjectorCodeSetFinder(String brand) {
        super(AV_TEST_URL, brand, "Projector");
    }

    @Override
    protected String getMsg() throws JSONException {

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("type",getType());
        jsonObject.put("brand",getBrand());
        jsonObject.put("func1","VOLUME UP");
        jsonObject.put("func2","POWER");
        jsonObject.put("func3","VOLUME DOWN");
        jsonObject.put("func4","MENU");
        jsonObject.put("func5","POWER OFF");
        jsonObject.put("func6","POWER ON");
        return jsonObject.toString();
    }
}
