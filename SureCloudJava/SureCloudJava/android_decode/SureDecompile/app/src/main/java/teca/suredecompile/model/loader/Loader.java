package teca.suredecompile.model.loader;

import android.os.AsyncTask;

/**
 * Created by truonglxteca .
 */

abstract class Loader extends AsyncTask<Void,Void,Object>{


    interface Listener{

        public void onSuccess(Object result);

        public void onError(Object exception);
    }

    private Listener listener;



    protected abstract Object run();

    @Override
    protected Object doInBackground(Void... params) {
        return run();
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        if (listener==null)
            return ;
        if (o instanceof Exception)
            listener.onError(o);
        else
            listener.onSuccess(o);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}
