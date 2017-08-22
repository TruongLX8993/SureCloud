package teca.suredecompile.data.encoder;

import android.util.Base64;

import teca.suredecompile.data.Compression;
import teca.suredecompile.data.Enigma;

/**
 * Created by truonglxteca .
 */

public class EncoderImpl implements Encoder  {



    public byte[] encode(byte[] in) throws Exception {
        byte[] bIn = Compression.compress(in);
        bIn=new Enigma().encode(bIn);
        return Base64.encode(bIn,0);


    }
}
