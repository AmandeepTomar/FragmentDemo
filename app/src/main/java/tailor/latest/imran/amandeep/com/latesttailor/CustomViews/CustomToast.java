package tailor.latest.imran.amandeep.com.latesttailor.CustomViews;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import tailor.latest.imran.amandeep.com.latesttailor.R;


/**
 * Created by Manna on 11/2/2015.
 */
public  class CustomToast extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_custom_toast);

        }

        public static void showToast(Context context,String text,int gravity) {
            //Creating the LayoutInflater instance
            TextView tvToast;

            LayoutInflater li;
            //Getting the View object as defined in the activity_custom_toast.xml file
            li = LayoutInflater.from(context);
            //ViewGroup viewGroup=(ViewGroup) findViewById(R.id.custom_toast_layout);
            View layout = li.inflate(R.layout.activity_custom_toast, null);
            Toast toast = new Toast(context);
            toast.setDuration(Toast.LENGTH_SHORT);
            tvToast=(TextView)layout.findViewById(R.id.ToastTextView);
            tvToast.setText(text);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, gravity);
            toast.setView(layout);//setting the view of custom toast layout
            toast.show();
        }

    public static void showToastLong(Context context,String text,int gravity) {
        //Creating the LayoutInflater instance
        TextView tvToast;
        LayoutInflater li;
        //Getting the View object as defined in the activity_custom_toast.xml file
        li = LayoutInflater.from(context);
        //ViewGroup viewGroup=(ViewGroup) findViewById(R.id.custom_toast_layout);
        View layout = li.inflate(R.layout.activity_custom_toast, null);
        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_LONG);
        tvToast=(TextView)layout.findViewById(R.id.ToastTextView);
        tvToast.setText(text);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, gravity);
        toast.setView(layout);//setting the view of custom toast layout
        toast.show();
    }

    }


