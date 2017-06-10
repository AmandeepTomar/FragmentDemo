package tailor.latest.imran.amandeep.com.latesttailor.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by admin on 9/24/2016.
 */

public class ConnectionDetector {
    public static int TYPE_WIFI = 1;
    public static int TYPE_MOBILE = 2;
    public static int TYPE_NOT_CONNECTED = 0;

    public static int connectionStatus(Context context){
        ConnectivityManager cm= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork=cm.getActiveNetworkInfo();
        if (activeNetwork!=null){
            if (activeNetwork.getType()==ConnectivityManager.TYPE_MOBILE)
                return TYPE_MOBILE;
            if (activeNetwork.getType()==ConnectivityManager.TYPE_WIFI)
                return TYPE_WIFI;
        }
        return TYPE_NOT_CONNECTED;
    }


    public static String connectionStatusString(Context context){
        ConnectivityManager cm= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo actNetworkInfo=cm.getActiveNetworkInfo();
        if (actNetworkInfo!=null){
            if (actNetworkInfo.getType()==ConnectivityManager.TYPE_MOBILE)
                return "MOBILE_NETWORK";
            if (actNetworkInfo.getType()==ConnectivityManager.TYPE_WIFI)
                return "WIFI_NETWORK";
        }
        return "NO_NETWORK";
    }
}
