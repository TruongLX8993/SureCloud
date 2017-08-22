package com.teca.secure.encoder;

import com.teca.secure.Compression;
import com.teca.secure.Enigma;

import java.util.Base64;

/**
 * Created by truonglxteca .
 */

public class EncoderImpl implements Encoder  {



    public byte[] encode(byte[] in) throws Exception {
        byte[] bIn = Compression.compress(in);
        bIn=new Enigma().encode(bIn);
        return Base64.getEncoder().encode(bIn);


    }
}
