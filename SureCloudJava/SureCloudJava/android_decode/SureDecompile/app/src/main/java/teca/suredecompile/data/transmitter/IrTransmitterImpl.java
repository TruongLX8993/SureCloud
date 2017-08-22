package teca.suredecompile.data.transmitter;

import android.content.Context;
import android.hardware.ConsumerIrManager;
import android.os.AsyncTask;

/**
 * Created by truonglxteca .
 */

class IrTransmitterImpl extends IrTransmitter{




    IrTransmitterImpl(Listener listener, Context context) {
        super(listener, context);
    }

    @Override
    public void onTrans(String irCode) {
        new Runner().execute(irCode);
    }


    private class Runner extends AsyncTask<String,Void,Void>{

        @Override
        protected Void doInBackground(String... params) {

            IrInfo irInfo=new IrInfo(params[0]);
            ConsumerIrManager consumerIrManager=getConsumerIrManager();
            consumerIrManager.transmit(irInfo.getFrequency(),irInfo.getDurationPattern());
            return null;
        }
    }


}
