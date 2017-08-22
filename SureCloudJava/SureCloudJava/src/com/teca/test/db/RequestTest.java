package com.teca.test.db;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Base64;

/**
 * Created by truonglx.
 */
public class RequestTest {


    private static String getAuthorization(){

        return "Basic "+ Base64.getEncoder().encodeToString("LeoTolstoy:AWDJCNFHYTEqkwd2d2".getBytes());
    }

    private static void writeMessage(OutputStream os,String msg){

        try {

            os.write(msg.getBytes());
            os.flush();
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readMessage(InputStream is) throws IOException {

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuilder builder=new StringBuilder();
        while((line=bufferedReader.readLine())!=null){
            builder.append(line).append("\n");
        }
        bufferedReader.close();
        return builder.toString();
    }

    private static String createContent(){
//            JSONObject jsonObject=new JSONObject();
//            try {
//
////                jsonObject.put("codeSetName","Re_GLOBAL_430");
////                jsonObject.put("type","Air Conditioner");
////                jsonObject.put("brand","Daikin");
//                return jsonObject.toString();
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//            return null;
        return "";
    }


    private static  final String _URL="https://api.tekoiaiot.com/rest/ir/1/acpower";

    public static void main(String[] args) {

        HttpURLConnection con= null;
        try {
            con = (HttpURLConnection) new URL(_URL).openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type","application/json");
            con.setRequestProperty("Authorization",getAuthorization());
            con.setRequestProperty("Accept-Encoding","gzip");
            con.setUseCaches(false);
            String content=createContent();
            if(content.length()>0)
                writeMessage(con.getOutputStream(),createContent());
            String msg=readMessage(con.getInputStream());
            System.out.println(msg);
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
