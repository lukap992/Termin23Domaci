package com.example.termin23domaci.async;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

public class MyAsync extends AsyncTask<Integer, Void, Integer> {

    Context context;
    private String string;

    public MyAsync(Context context, String string){
        this.context =context;
        this.string = string;
    }

    @Override
    protected Integer doInBackground(Integer... integers) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        Intent intent = new Intent("SYNC_DATA");
        intent.putExtra("RESULT_CODE", integer);
        intent.putExtra("COMMENT", string);
        context.sendBroadcast(intent);
    }
}
