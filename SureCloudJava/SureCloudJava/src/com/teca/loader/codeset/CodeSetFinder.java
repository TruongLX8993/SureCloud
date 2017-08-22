package com.teca.loader.codeset;

import com.teca.loader.Finder;
import com.teca.loader.orm.IrCode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by truonglx.
 */
public abstract class CodeSetFinder  extends Finder {


    public static final String AC_TEST_URL = "https://api.tekoiaiot.com/rest/ir/1/actest";

    public static final String AV_TEST_URL="https://api.tekoiaiot.com/rest/ir/1/avtest";
    private String brand;

    private String type;

    public CodeSetFinder(String url,String brand,String type) {
        super(url);
        this.brand=brand;
        this.type=type;
    }


    protected abstract String getMsg() throws JSONException;


    public List<String> parse(String msg) throws JSONException {

        List<String> res=new ArrayList<String>();
        JSONObject jsonObject=new JSONObject(msg);
        JSONArray jsonArray=jsonObject.getJSONArray("ircodes");
        for (int i=0;i<jsonArray.length();i++) {

            String tem=jsonArray.getJSONObject(i).getString("0");
            if (!res.contains(tem))
                res.add(tem);
        }

        return res;
    }

    @Override
    public List<String> load() throws JSONException, IOException {


        HttpURLConnection con = openConnection();
        String msg = getMsg();
        writeMessage(con.getOutputStream(), msg);
        String response = readMessage(con.getInputStream());
        con.disconnect();
        return parse(response);
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }
}
