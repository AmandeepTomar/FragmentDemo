package tailor.latest.imran.amandeep.com.latesttailor.Utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by admin on 9/24/2016.
 */

public class CommonMessages {
    public static void toastMessage(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void errorLog(String tag,String message){
        Log.e(tag,message);
    }
    public static void warningLog(String tag,String message){
        Log.w(tag,message);
    }
    public static void debugLog(String tag,String message){
        Log.d(tag,message);
    }
    public static void informationLog(String tag,String message){
        Log.i(tag, message);
    }
}
