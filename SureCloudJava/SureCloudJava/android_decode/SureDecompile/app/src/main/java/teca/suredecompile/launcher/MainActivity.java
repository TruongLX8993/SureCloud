package teca.suredecompile.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import teca.suredecompile.R;
import teca.suredecompile.data.decoder.Decoder;
import teca.suredecompile.data.decoder.DecoderFromDb;
import teca.suredecompile.data.transmitter.IrTransmitter;

/**
 * Created by truonglxteca .
 */

public class MainActivity extends Activity implements IrTransmitter.Listener {


    @Override
    public void onSuccess(IrTransmitter irTransmitter) {

    }

    private static final String IN_1 = "dnERdfCx7DY9ogaG74G52NVVyDdr155/bbJ+8YkF8hxsQ5zm5P7B+R8i/hygS1V2ffMwvX9DWu9f" +
            "F97/fi4hh2JrXojQl+IybZVDdRnkEMCVKy6jkrvrF56HVEV40bqP+G/wMYP3cS/PYfttNQ75";

    private static final String IN_391 = "dnERdfCx7DY9ogaG74G52NVVvCBXd3A9bce5UZ8ndjtaWFBvhKz3hoIUIWoAu0cRcWKZska2Scxe" +
            "EkoNdQlM5M2HbmWQdViELHOEHeUp+mrXmBrGdOn6aGZUkfs+o5csyZMqBZ4QbFsEkCo4zwyIdZmt" +
            "t07nswm7CIpsMJPuBTv+";

    private static final String IN_463 = "dnERdfCx7DY9ogaG74G52NVVvCBXD7A9rQsIl643wn3IImTION+FiCMSrhZwfWGOcmItIdCb4egk" +
            "Je98nPUWoDjcBTByja5DuXptXjTkPc4=";

    public void onSendClick(View view) {


        int id=view.getId();

        Decoder decoder = new DecoderFromDb();
        if (id==R.id.s1) {
            try {
                String irCode = decoder.decode(IN_1.getBytes());
                IrTransmitter.getIrTransmitter(this, this).onTrans(irCode);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (id==R.id.s391){

            try {
                String irCode = decoder.decode(IN_391.getBytes());
                IrTransmitter.getIrTransmitter(this, this).onTrans(irCode);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else{
            try {
                String irCode = decoder.decode(IN_463.getBytes());
                IrTransmitter.getIrTransmitter(this, this).onTrans(irCode);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);
    }

}



