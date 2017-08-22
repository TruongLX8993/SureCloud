package com.teca.cache;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;

/**
 * Created by truonglx.
 */
public class Cache {

    private static final String PATH="cache.txt";


    private boolean flagInit;

    private static Cache instance;

    public static Cache getCache(){

        if (instance==null)
            try {
                instance=new Cache();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        return instance;
    }
    private Cache() throws IOException, JSONException {
        if (!isExitsCache())
            createCache();
        else
            loadCacheFile();
    }

    public void setFlagInit(boolean flagInit){
        this.flagInit=flagInit;
        try {
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCache() throws IOException {
        File file=new File(PATH);
        if (file.exists())
            file.delete();
        file.createNewFile();
        save();
    }

    private boolean isExitsCache(){
        return new File(PATH).exists();
    }

    private void loadCacheFile() throws IOException, JSONException {


        String cacheData=readCacheFile();
        parse(cacheData);
    }


    private String readCacheFile() throws IOException {

        FileReader fileReader=new FileReader(PATH);
        StringBuilder sBuilder=new StringBuilder();
        char[] buffer=new char[10];
        int counter;
        while((counter = fileReader.read(buffer,0,10))>0){
            sBuilder.append(buffer,0,counter);
        }
        return sBuilder.toString();
    }
    private void save() throws IOException {

        String data=toString();
        FileWriter fileWriter=new FileWriter(new File(PATH));
        fileWriter.write(data,0,data.length());
        fileWriter.flush();
        fileWriter.close();
    }




    private void parse(String cacheData) throws JSONException {
        JSONObject jsonObject = new JSONObject(cacheData);
        flagInit = jsonObject.getBoolean("FlagInit");
    }

    @Override
    public String toString() {
        JSONObject jsonObject=new JSONObject();
        try {
            jsonObject.put("FlagInit",flagInit);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
