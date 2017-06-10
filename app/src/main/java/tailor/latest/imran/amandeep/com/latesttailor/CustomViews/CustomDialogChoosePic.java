package tailor.latest.imran.amandeep.com.latesttailor.CustomViews;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import tailor.latest.imran.amandeep.com.latesttailor.R;


/**
 * Created by admin on 8/12/2016.
 * way to create your on dialog for choosing a pic from camera
 */
public class CustomDialogChoosePic  extends Dialog implements View.OnClickListener  {

    private static final String TAG = "CustomDialogChoosePic";
    Context context;
    private TextView txtChoosePic;
    private ImageView imgGallery;
    private CustomProgressDialog customProgressDialog;
    private final int GALLERY_ACTIVITY_CODE = 201;

    public CustomDialogChoosePic(Context context, int themeResId) {
        super(context, themeResId);
        this.context=context;
    }

    public CustomDialogChoosePic(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog_choose_pic);

        txtChoosePic = (TextView) findViewById(R.id.txt_choosefromgallery);
        imgGallery = (ImageView) findViewById(R.id.img_choosefromgallery);

        txtChoosePic.setOnClickListener(this);
        imgGallery.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {

        if(v==txtChoosePic || v==imgGallery)
        {
            Intent gallery_Intent = new Intent(context, GalleryUtil.class);
            ((Activity)context).startActivityForResult(gallery_Intent, GALLERY_ACTIVITY_CODE);
            dismiss();
        }

    }
}
