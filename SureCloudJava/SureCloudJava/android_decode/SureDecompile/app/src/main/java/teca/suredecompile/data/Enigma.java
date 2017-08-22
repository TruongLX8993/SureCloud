package teca.suredecompile.data;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by truonglxteca .
 */

public class Enigma {

    private static byte[] iv = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
    private Cipher cipher = null;
    private IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
    private String key = "aPhKT7@b0&mc^18<";
    private SecretKeySpec keySpec = null;

    public Enigma() {
        initCipher();
        this.keySpec = new SecretKeySpec(this.key.getBytes(), "AES");
    }

    public Enigma(String paramString) {

        initCipher();
        if ((paramString != null) && (paramString.length() == 16))
            this.key = paramString;
        this.keySpec = new SecretKeySpec(this.key.getBytes(), "AES");
    }

    private void initCipher() {

        try {
            this.cipher = Cipher.getInstance("AES/CFB/NoPadding");
        }
        catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    public byte[] decode(byte[] paramArrayOfByte) throws Exception {


        if (this.cipher == null) {
            return null;
        }
        this.cipher.init(Cipher.DECRYPT_MODE, this.keySpec, this.ivParameterSpec);
        return this.cipher.doFinal(paramArrayOfByte);
    }

    public byte[] encode(byte[] in) throws Exception {


        if (this.cipher == null) {
            return null;
        }
        this.cipher.init(Cipher.ENCRYPT_MODE, this.keySpec, this.ivParameterSpec);
        return  this.cipher.doFinal(in);
    }


}
