package com.teca.secure.decoder;


import com.teca.secure.Compression;
import com.teca.secure.Enigma;

/**
 * Created by truonglxteca .
 */

public class DecoderForCreation implements Decoder {
    @Override
    public String decode(byte[] in) throws Exception {

        Enigma enigma=new Enigma();
        return Compression.deCompress(enigma.decode(in));

    }
}
