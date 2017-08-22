package teca.suredecompile.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import teca.suredecompile.data.decoder.Decoder;
import teca.suredecompile.data.decoder.DecoderFromDb;
import teca.suredecompile.data.encoder.Encoder;
import teca.suredecompile.data.encoder.EncoderImpl;

/**
 * Created by truonglxteca .
 */

public class TestDaoActivity extends Activity {



    private byte[] encode(String in) throws Exception {
        Encoder encoder=new EncoderImpl();
        return encoder.encode(in.getBytes());
    }


    private String decode(byte[] in) throws Exception {
        Decoder decoder=new DecoderFromDb();
        return decoder.decode(in);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.d("packagename",getApplicationContext().getPackageName());
//        Decoder decoder=new DecoderFromDb();
//
//
//        String irqIn="dnERdfCx7DY9ogaG74G52NVVvCBXd3A9bce5UZ8ndjtaWFBvhKz3hoIUIWoAu0cRcWKZska2Scxe" +
//                "EkoNdQlM5M2HbmWQdViELHOEHeUp+mrXmBrGdOn6aGZUkfs+o5csyZMqBZ4QbFsEkCo4zwyIdZmt" +
//                "t07nswm7CIpsMJPuBTv+";
//        try {
//            String decodeResult=decoder.decode(irqIn);
//            String rep=IrFrameManipulator.replicateIrFrameData(decodeResult,2);
//            IrDataFrame irDataFrame=new IrDataFrame("Re_GLOBAL_463",rep,1);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        Intent intent=new Intent(this,TestService.class);
//        startService(intent);


        StringBuilder builder=new StringBuilder();
        for (int i=0;i<150;i++)
            builder.append(i);

        String in=builder.toString();
        try {
            String out;

//            Log.d("truong_in",in);
//            Log.d("truong_de",new String(encode(in)));
//
//
            String sCode="dnERdfCx7DY9ogaG74G52NVVvCBXd3A9bce5UZ8ndjtaWFBvhKz3hoIUIWoAu0cRcWKZska2Scxe" +
                    "EkoNdQlM5M2HbmWQdViELLtSIJIWLpUyP2hpkfFc0RGXR/gpWlgynhToPMdlDUNUCgqyvMihdgh/" +
                    "8kzeyG2etwnYx+WjP3S7EiZXlsOU";

            out=decode(sCode.getBytes());

//            byte[] bIn=new byte[]{
//                    0x76,0x71,0x11,0x75, (byte) 0xf0, (byte) 0xb1, (byte) 0xec,0x36,0x3d, (byte) 0xa2,0x06, (byte) 0x86, (byte) 0xef, (byte) 0x81, (byte) 0xb9,
//                    (byte) 0xd8,
//                    (byte) 0xd5,0x55, (byte) 0xbc,0x20,0x57,0x0f, (byte) 0xb0,0x3d, (byte) 0xad,0x0b,0x08, (byte) 0x97, (byte) 0xae,0x37, (byte) 0xc2, (byte) 0x7d,
//                    (byte) 0xc8,0x22,0x64, (byte) 0xc8,0x38, (byte) 0xdf, (byte) 0x85, (byte) 0x88,0x23,0x12, (byte) 0xae,0x16,0x70,0x7d,0x61,0x0e,
//                    (byte) 0x83, (byte) 0xd2, (byte) 0x9f,0x76,0x2d, (byte) 0xec,0x5a, (byte) 0xcc, (byte) 0xa7,0x1a, (byte) 0xfa,0x78,0x56, (byte) 0xa2,0x68, (byte) 0xae,
//                    (byte) 0xe8, (byte) 0xbc, (byte) 0xd3, (byte) 0xd1,0x6a, (byte) 0xe2, (byte) 0xa5, (byte) 0xda,0x1e, (byte) 0xe9, (byte) 0xcf,0x23, (byte) 0xb7,0x57, (byte) 0xfe,0x38,
//            };
//
//            Encoder encoder=new EncoderFromStore();
//            byte[] encodeResult=encoder.encode(bIn);
//            Log.d("Encode", Converter.bytesToHex(encodeResult,true));
//
//
//            Decoder decoder=new DecoderForCreation();
//            out=decoder.decode(bIn);
//            Log.d("truong_ou",hex2dec(out));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
