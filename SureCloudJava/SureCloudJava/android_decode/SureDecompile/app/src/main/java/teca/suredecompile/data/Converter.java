package teca.suredecompile.data;

/**
 * Created by truonglxteca .
 */

public class Converter {

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bytes,boolean space) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        if (!space)
            return new String(hexChars);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < hexChars.length; i++) {
            if (i % 2 == 0 && i != 0)
                builder.append(" ");
            builder.append(hexChars[i]);
        }
        return builder.toString();
    }
}
