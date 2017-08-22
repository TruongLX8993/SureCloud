package com.teca.loader.codeset;

import com.teca.loader.orm.IrCode;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.*;
import java.util.List;

/**
 * Created by truonglx.
 */
public  class AcCodeSetFinder extends CodeSetFinder {



    public AcCodeSetFinder(String brand) {
        super(AC_TEST_URL,brand,"Air Conditioner");
    }





    public List<String> load() throws IOException, JSONException {
        HttpURLConnection con = openConnection();
        String msg = getMsg();
        writeMessage(con.getOutputStream(), msg);
        String response = readMessage(con.getInputStream());
        con.disconnect();
        return parse(response);
    }




    @Override
    protected String getMsg() throws JSONException {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("type",getType());
        jsonObject.put("brand",getBrand());
        return jsonObject.toString();
    }





}
