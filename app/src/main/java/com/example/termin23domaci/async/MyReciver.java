package com.example.termin23domaci.async;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.termin23domaci.R;
import com.example.termin23domaci.dialogs.ReviewerTools;

public class MyReciver extends BroadcastReceiver {

    private static int notificationID = 1;

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("SYNC_DATA")){
            String string = intent.getExtras().getString("COMMENT");
            int resultCode = intent.getExtras().getInt("RESULT_CODE");

            prepareNotification(resultCode, context, string);
        }

    }

    private void prepareNotification(int resultCode, Context context, String string) {
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context);

        Bitmap bm = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_directions_walk_black_24dp);
        Log.i("MY_ANDROID_APP", "NOtif");

        if(resultCode == ReviewerTools.TYPE_NOT_CONNECTED){
            mBuilder.setSmallIcon(R.drawable.ic_favorite_black_24dp);
            mBuilder.setContentTitle(string);
            mBuilder.setContentText(string);

        }else if (resultCode == ReviewerTools.TYPE_MOBILE){
            mBuilder.setSmallIcon(R.drawable.ic_fitness_center_black_24dp);
            mBuilder.setContentTitle(string);
            mBuilder.setContentText(string);

        }else{
            mBuilder.setSmallIcon(R.drawable.ic_flight_black_24dp);
            mBuilder.setContentTitle(string);
            mBuilder.setContentText(string);
        }
        mBuilder.setLargeIcon(bm);

        mNotificationManager.notify(notificationID, mBuilder.build());
    }
}
