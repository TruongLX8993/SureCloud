package com.teca.loader.ircode;

import com.teca.loader.Finder;
import com.teca.loader.orm.IrCode;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

/**
 * Created by truonglx.
 */
public abstract class IrCodeFinder<T extends IrCode> extends Finder {




    private String codeSetName;

    public static final String AC_URL="https://api.tekoiaiot.com/rest/ir/1/acall";

    public static final String AV_URL="https://api.tekoiaiot.com/rest/ir/1/avall";

    public IrCodeFinder(String url,String codeSetName) {
        super(url);
        this.codeSetName=codeSetName;
    }


    public void setCodeSetName(String codeSetName) {
        this.codeSetName = codeSetName;
    }

    public List<T> load() throws JSONException, IOException {

        HttpURLConnection con=openConnection();
        writeMessage(con.getOutputStream(),createContent());
        String res=readMessage(con.getInputStream());
        con.disconnect();
        return parse(res);
    }



    public boolean isCodeAc(){
        return getUrl().equals(AC_URL);
    }

    public boolean isCodeAv(){
        return getUrl().equals(AV_URL);
    }


    private String createContent() throws JSONException {

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("codeset",codeSetName);
        return jsonObject.toString();
    }


    protected abstract List<T> parse(String res) throws JSONException;
}
