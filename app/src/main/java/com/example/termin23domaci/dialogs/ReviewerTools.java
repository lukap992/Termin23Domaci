package com.example.termin23domaci.dialogs;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ReviewerTools {

    public static int TYPE_WIFI = 1;
    public static int TYPE_MOBILE = 2;
    public  static int TYPE_NOT_CONNECTED = 0;

    public static int getConnectivityStatus(Context context){
        ConnectivityManager cm =  (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if(null != activeNetwork){
            if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI);
                return TYPE_WIFI;
        }
        if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE){
                return TYPE_MOBILE;
        }

        return TYPE_NOT_CONNECTED;

    }
    public static String getConnectionType(Integer type){
        switch (type){
            case 1:
                return "WIFI";
            case 2:
                return "MOBILE internet";
            default:
                return "";
        }
    }

    public static int calculateTimeTillNextSync(int minutes) {
        return 1000 * 60 * minutes;
    }

}
