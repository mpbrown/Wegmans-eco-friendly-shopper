package io.github.anthonymj.foodpointtech;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import java.util.concurrent.FutureTask;

public class MilkTask extends AsyncTask<Void, Void, Void> {

    @Override
    protected Void doInBackground(Void... voids) {
        DatabaseHelper dbH = new DatabaseHelper();
        return null;
    }


}
