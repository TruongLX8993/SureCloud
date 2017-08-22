package com.teca.loader;

import com.teca.loader.orm.IrCode;
import org.json.JSONException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.List;

/**
 * Created by truonglx.
 */
public abstract class Finder {


    private String url;

    public Finder(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public abstract Object load() throws JSONException, IOException;

    protected HttpURLConnection openConnection() throws IOException {
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", getAuthorization());
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setRequestProperty("Accept-Encoding", "gzip");
        con.setUseCaches(false);
        return con;
    }

    protected String getAuthorization() {

        return "Basic " + Base64.getEncoder().encodeToString("LeoTolstoy:AWDJCNFHYTEqkwd2d2".getBytes());
    }

    protected void writeMessage(OutputStream os, String msg) {

        try {

            os.write(msg.getBytes());
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected String readMessage(InputStream is) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuilder builder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            builder.append(line).append("\n");
        }
        bufferedReader.close();
        return builder.toString();
    }

}
