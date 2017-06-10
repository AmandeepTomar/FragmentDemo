package tailor.latest.imran.amandeep.com.latesttailor.MainCode;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import tailor.latest.imran.amandeep.com.latesttailor.R;
import tailor.latest.imran.amandeep.com.latesttailor.Utils.CommonMessages;

public class SplashScreen extends AppCompatActivity {
    private static final String TAG = SplashScreen.class.getName();

    private ImageView splashLogoImage, buttonBack,btnFacebook,btnGoogle;
    private TextView tapToEnter, tapToRegister, tapToLogin, tvForgotPassword;
    private Button buttonForgot, buttonContinue, buttonRegister;
    private EditText etUserName, etPassword, etEnterMailId;

    int backint = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


//******************************************* Initializing All Views *****************************************************

        splashLogoImage = (ImageView) findViewById(R.id.splash_forgotpassword);
        buttonBack = (ImageView) findViewById(R.id.iv_forgotPasswordBack);
        tapToEnter = (TextView) findViewById(R.id.taptoenter);
        tapToLogin = (TextView) findViewById(R.id.tv_login_now);
        tapToRegister = (TextView) findViewById(R.id.tv_registerNow);
        tvForgotPassword = (TextView) findViewById(R.id.textforget);
        buttonForgot = (Button) findViewById(R.id.buttonForgot);
        buttonContinue = (Button) findViewById(R.id.btnloginnow);
        buttonRegister = (Button) findViewById(R.id.btn_register_now);
        etUserName = (EditText) findViewById(R.id.useridinput);
        etPassword = (EditText) findViewById(R.id.passwordinput);
        btnFacebook= (ImageView) findViewById(R.id.iv_facebookButton);
        btnGoogle= (ImageView) findViewById(R.id.iv_gmailButton);


        //**************************** Button Listener***************************************************

        MyButtonClickListener listener=new MyButtonClickListener();
        btnFacebook.setOnClickListener(listener);
        btnGoogle.setOnClickListener(listener);
        buttonContinue.setOnClickListener(listener);
        buttonRegister.setOnClickListener(listener);
        tapToEnter.setOnClickListener(listener);
        buttonBack.setOnClickListener(listener);
        tapToRegister.setOnClickListener(listener);
        tapToLogin.setOnClickListener(listener);


        // ******************************************** Checking DataBase **********************************
      //  if database have some value or count is not equal to 0 then we switch the acticity to MainActivity




    }

    // ************************************** Handling On Back Pressed Of activity *******************************************

    @Override
    public void onBackPressed() {

        switch (backint){
            case 0:
                Animation fromtopreverse = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.reverse_top);
                ((LinearLayout) findViewById(R.id.layout_above_password)).startAnimation(fromtopreverse);

                Animation frombottomreverse = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.reverse_bottom);
                ((LinearLayout) findViewById(R.id.layout_bottom_password)).startAnimation(frombottomreverse);

                fromtopreverse.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        ((LinearLayout) findViewById(R.id.layout_above_password)).setVisibility(View.GONE);
                        ((LinearLayout) findViewById(R.id.layout_bottom_password)).setVisibility(View.GONE);
                        //MainActivity.super.onBackPressed();

                        ((LinearLayout) findViewById(R.id.layout_above_password_login)).setVisibility(View.VISIBLE);
                        ((LinearLayout) findViewById(R.id.layout_bottom_password_login)).setVisibility(View.VISIBLE);

                        Animation fromtopreverse = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.top);
                        ((LinearLayout) findViewById(R.id.layout_above_password_login)).startAnimation(fromtopreverse);

                        Animation frombottomreverse = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.bottom_in);
                        ((LinearLayout) findViewById(R.id.layout_bottom_password_login)).startAnimation(frombottomreverse);

                        backint = -1;
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                break;
            case 1:
               /* Animation fromtopreverse1 = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.reverse_top);
                ((LinearLayout) findViewById(R.id.registration_layout_above)).startAnimation(fromtopreverse1);

                Animation frombottomreverse1 = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.reverse_bottom);
                ((LinearLayout) findViewById(R.id.registration_layout_Bottom)).startAnimation(frombottomreverse1);*/

                Animation reverseTop=AnimationUtils.loadAnimation(SplashScreen.this,R.anim.reverse_top);
                ((LinearLayout)findViewById(R.id.registration_layout_above)).startAnimation(reverseTop);

                Animation fromBottom=AnimationUtils.loadAnimation(SplashScreen.this,R.anim.reverse_bottom);
                ((LinearLayout)findViewById(R.id.registration_layout_Bottom)).startAnimation(fromBottom);

                reverseTop.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                       ((LinearLayout)findViewById(R.id.registration_layout_above)).setVisibility(View.GONE);
                        ((LinearLayout)findViewById(R.id.registration_layout_Bottom)).setVisibility(View.GONE);

                        ((LinearLayout)findViewById(R.id.layout_above_password_login)).setVisibility(View.VISIBLE);
                        ((LinearLayout)findViewById(R.id.layout_bottom_password_login)).setVisibility(View.VISIBLE);

                        Animation fromTop=AnimationUtils.loadAnimation(SplashScreen.this,R.anim.top);
                        ((LinearLayout)findViewById(R.id.layout_above_password_login)).setAnimation(fromTop);

                        Animation fromBottom=AnimationUtils.loadAnimation(SplashScreen.this,R.anim.bottom_in);
                        ((LinearLayout)findViewById(R.id.layout_bottom_password_login)).setAnimation(fromBottom);
                        backint=-1;

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                break;
            default:
                super.onBackPressed();
                break;
        }

    }



    // ****************************************** Login AsymcTask************************************

    protected class LoginAsyncTask extends AsyncTask<Void,String,Void>{

        @Override
        protected Void doInBackground(Void... params) {
            return null;
        }
    }


    //*************************************** Registration AsyncTask **************************************************

    protected  class RegistrationAsyncTask extends  AsyncTask<Void,String,Void>{

        @Override
        protected Void doInBackground(Void... params) {
            return null;
        }
    }
    //***************************** Class For Handling Click Events ***************************************************


    private class MyButtonClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            int id=v.getId();
            switch (id){
                case R.id.btnloginnow:
                    Intent intent=new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.long_zoom,R.anim.zoom_out);
                    break;
                case R.id.btn_register_now:
                    CommonMessages.toastMessage(getApplicationContext(),"Register Button");
                    break;
                case R.id.iv_facebookButton:
                    CommonMessages.toastMessage(getApplicationContext(),"FaceBook Button");
                    break;
                case R.id.iv_gmailButton:
                    CommonMessages.toastMessage(getApplicationContext(),"Google Button");
                    break;
                case R.id.textforget:
            //********************************** Animation for text forgot password *******************************************

                    tvForgotPassword.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Animation fromtopreverse = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.reverse_top);
                            ((LinearLayout)findViewById(R.id.layout_above_password_login)).startAnimation(fromtopreverse);

                            Animation frombottomreverse = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.reverse_bottom);
                            ((LinearLayout)findViewById(R.id.layout_bottom_password_login)).startAnimation(frombottomreverse);

                            fromtopreverse.setAnimationListener(new Animation.AnimationListener() {
                                @Override
                                public void onAnimationStart(Animation animation) {
                                }

                                @Override
                                public void onAnimationEnd(Animation animation) {
                                    CommonMessages.errorLog(TAG,"S");
                                    ((LinearLayout)findViewById(R.id.layout_above_password_login)).setVisibility(View.GONE);
                                    ((LinearLayout)findViewById(R.id.layout_bottom_password_login)).setVisibility(View.GONE);

                                    //MainActivity.super.onBackPressed(); these line will be called

                                    ((LinearLayout)findViewById(R.id.layout_above_password)).setVisibility(View.VISIBLE);
                                    ((LinearLayout)findViewById(R.id.layout_bottom_password)).setVisibility(View.VISIBLE);

                                    Animation fromtopreverse = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.top);
                                    ((LinearLayout)findViewById(R.id.layout_above_password)).startAnimation(fromtopreverse);

                                    Animation frombottomreverse = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.bottom_in);
                                    ((LinearLayout)findViewById(R.id.layout_bottom_password)).startAnimation(frombottomreverse);

                                    backint = 0;

                                }

                                @Override
                                public void onAnimationRepeat(Animation animation) {

                                }
                            });

                        }
                    });
                    break;
                case R.id.taptoenter:

// **************************** this animation used for simplifying the image *****************************

                    final Animation simplify = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.scaling);
                    tapToEnter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            splashLogoImage.startAnimation(simplify);
                        }
                    });

                    simplify.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            tapToEnter.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Log.e(TAG, "OnAnimationEnd");

                            findViewById(R.id.layout_above_password_login).setVisibility(View.VISIBLE);
                            findViewById(R.id.layout_bottom_password_login).setVisibility(View.VISIBLE);

                            Animation fromTop = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.top);
                            Animation fromBottom = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.bottom_in);

                            findViewById(R.id.layout_above_password_login).setAnimation(fromTop);

                            findViewById(R.id.layout_bottom_password_login).setAnimation(fromBottom);


                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    break;
                case R.id.tv_registerNow:
                    //*******************************************  Animation For Registration Page *********************************************

                    tapToRegister.setOnClickListener(new View.OnClickListener() {
                        Animation fromTopToReverse = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.reverse_top);
                        Animation fromBottomReverse = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.reverse_bottom);

                        @Override
                        public void onClick(View v) {
                            Toast.makeText(SplashScreen.this, "Test", Toast.LENGTH_SHORT).show();


                            findViewById(R.id.layout_above_password_login).startAnimation(fromTopToReverse);
                            findViewById(R.id.layout_bottom_password_login).startAnimation(fromBottomReverse);

                            fromTopToReverse.setAnimationListener(new Animation.AnimationListener() {
                                @Override
                                public void onAnimationStart(Animation animation) {

                                }

                                @Override
                                public void onAnimationEnd(Animation animation) {

                                    findViewById(R.id.layout_above_password_login).setVisibility(View.GONE);
                                    findViewById(R.id.layout_bottom_password_login).setVisibility(View.GONE);


                                    findViewById(R.id.registration_layout_above).setVisibility(View.VISIBLE);
                                    findViewById(R.id.registration_layout_Bottom).setVisibility(View.VISIBLE);

                                    Animation fromBottom = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.pop_enter);
                                    Animation fromBottomT = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.pop_exit);

                                    findViewById(R.id.registration_layout_Bottom).setAnimation(fromBottomT);
                                    findViewById(R.id.registration_layout_above).setAnimation(fromBottom);

                                    backint=1;
                                }

                                @Override
                                public void onAnimationRepeat(Animation animation) {

                                }
                            });
                        }
                    });
                    break;
                case R.id.iv_forgotPasswordBack:

                    //**************************** Set Animation For Back Button ********************************************************

                    buttonBack.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Animation fromtopreverse = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.reverse_top);
                            ((LinearLayout)findViewById(R.id.layout_above_password)).startAnimation(fromtopreverse);

                            Animation frombottomreverse = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.reverse_bottom);
                            ((LinearLayout)findViewById(R.id.layout_bottom_password)).startAnimation(frombottomreverse);

                            fromtopreverse.setAnimationListener(new Animation.AnimationListener() {
                                @Override
                                public void onAnimationStart(Animation animation) {
                                }

                                @Override
                                public void onAnimationEnd(Animation animation) {
                                    ((LinearLayout)findViewById(R.id.layout_above_password)).setVisibility(View.GONE);
                                    ((LinearLayout)findViewById(R.id.layout_bottom_password)).setVisibility(View.GONE);
                                    //MainActivity.super.onBackPressed();

                                    ((LinearLayout)findViewById(R.id.layout_above_password_login)).setVisibility(View.VISIBLE);
                                    ((LinearLayout)findViewById(R.id.layout_bottom_password_login)).setVisibility(View.VISIBLE);

                                    Animation fromtopreverse = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.top);
                                    ((LinearLayout)findViewById(R.id.layout_above_password_login)).startAnimation(fromtopreverse);

                                    Animation frombottomreverse = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.bottom_in);
                                    ((LinearLayout)findViewById(R.id.layout_bottom_password_login)).startAnimation(frombottomreverse);

                                    backint = -1;
                                }

                                @Override
                                public void onAnimationRepeat(Animation animation) {

                                }
                            });
                        }
                    });


                    break;
                default:
                    break;

            }
        }
    }
}
