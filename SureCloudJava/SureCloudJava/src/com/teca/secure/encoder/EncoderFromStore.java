package com.teca.secure.encoder;


import com.teca.secure.Enigma;

/**
 * Created by truonglxteca .
 */

public class EncoderFromStore implements Encoder {

    @Override
    public byte[] encode(byte[] in) throws Exception {
        return new Enigma().decode(in);
    }
}
