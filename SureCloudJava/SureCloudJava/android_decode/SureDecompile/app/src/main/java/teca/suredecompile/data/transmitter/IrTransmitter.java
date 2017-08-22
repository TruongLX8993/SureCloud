package teca.suredecompile.data.transmitter;


import android.content.Context;
import android.hardware.ConsumerIrManager;


/**
 * Created by truonglxteca .
 */

public abstract class IrTransmitter {


    private Listener listener;

    private Context context;


    public abstract void onTrans(String  irCoder);


    protected IrTransmitter(Listener listener, Context context) {
        this.listener = listener;
        this.context = context;
    }

    protected Listener getListener() {
        return listener;
    }



    public static IrTransmitter getIrTransmitter(Listener listener,Context context){
        return new IrTransmitterImpl(listener,context);
    }


    public  final ConsumerIrManager getConsumerIrManager(){

        return (ConsumerIrManager)context.getSystemService(Context.CONSUMER_IR_SERVICE);
    }


    public interface Listener{

        public void onSuccess(IrTransmitter irTransmitter);
    }


}
