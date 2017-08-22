package teca.suredecompile.data.decoder;

import teca.suredecompile.data.Compression;
import teca.suredecompile.data.Enigma;

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
