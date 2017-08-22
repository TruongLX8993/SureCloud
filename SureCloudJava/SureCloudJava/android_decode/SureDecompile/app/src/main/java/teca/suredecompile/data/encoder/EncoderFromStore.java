package teca.suredecompile.data.encoder;

import teca.suredecompile.data.Enigma;

/**
 * Created by truonglxteca .
 */

public class EncoderFromStore implements Encoder {

    @Override
    public byte[] encode(byte[] in) throws Exception {

        return new Enigma().decode(in);
    }
}
