package teca.suredecompile.data.decoder;

import android.util.Base64;
import java.io.IOException;
import teca.suredecompile.data.Compression;
import teca.suredecompile.data.Enigma;

/**
 * Created by truonglxteca .
 */



public class DecoderFromDb implements Decoder {


    private byte[] decodeByBase64(byte[] in){

        return Base64.decode(in,0);
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
