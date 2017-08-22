package com.teca.secure.decoder;



import com.teca.secure.Compression;
import com.teca.secure.Enigma;

import java.io.IOException;
import java.util.Base64;

/**
 * Created by truonglxteca .
 */



public class DecoderFromDb implements Decoder {


    private byte[] decodeByBase64(byte[] in){

        return Base64.getDecoder().decode(in);
    }


    private byte[] decodeByEnigma(byte[] in) throws Exception {

        return new Enigma().decode(in);
    }


    private String decompress(byte[] in) throws IOException {

        return Compression.deCompress(in);
    }



    @Override
    public String decode(byte[] in) throws Exception {

        byte[] bIn=in;
        bIn=decodeByBase64(bIn);
        bIn=decodeByEnigma(bIn);
        return decompress(bIn);
    }






}
