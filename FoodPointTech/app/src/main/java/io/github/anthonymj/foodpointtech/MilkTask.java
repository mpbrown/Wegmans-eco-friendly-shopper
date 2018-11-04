package io.github.anthonymj.foodpointtech;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

public class MilkTask extends AsyncTask<Void, Void, Void> {
    private Context context;
//    private Activity activity;

    public MilkTask(Context context){
        this.context =  context;
//        this.activity = activity;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        DatabaseHelper dbH = new DatabaseHelper();
        String s = dbH.getDebugText();
        int respcode = dbH.get_myresponsecode();
        String rscStr = Integer.toString(respcode);
        String mytext = "nope";
        if (s.isEmpty()){
            mytext = "yesss";
        }
        Log.i("Task", s);
//        activity.runOnUiThread(new Runnable() {
//
//            public void run() {
//
//                Toast.makeText(context, "Example for Toast", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//        Looper.prepare();
//        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
        return null;
    }


}
