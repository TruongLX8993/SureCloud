package com.teca.secure;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by truonglxteca .
 */

public class Compression {





    public static String deCompress(byte[] in) throws IOException {
        final int BUFFER_SIZE = 32;
        GZIPInputStream gzipInputStream=new GZIPInputStream(new ByteArrayInputStream(in),BUFFER_SIZE);
        StringBuilder builder=new StringBuilder();
        byte[] buffer=new byte[BUFFER_SIZE];
        int length;


        while((length=gzipInputStream.read(buffer))!=-1)
            builder.append(new String(buffer, 0, length));
        gzipInputStream.close();
        return builder.toString();
    }

    public static byte[] compress(byte[] in) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream(in.length);
        GZIPOutputStream gos = new GZIPOutputStream(os);
        gos.write(in);
        gos.close();
        byte[] compressed = os.toByteArray();
        os.close();
        return compressed;
    }




}
