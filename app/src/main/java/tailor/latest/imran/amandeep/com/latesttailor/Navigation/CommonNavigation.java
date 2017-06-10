package tailor.latest.imran.amandeep.com.latesttailor.Navigation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import tailor.latest.imran.amandeep.com.latesttailor.Activities.OfferZone;
import tailor.latest.imran.amandeep.com.latesttailor.Fragments.Beauty;
import tailor.latest.imran.amandeep.com.latesttailor.Fragments.CustomerCare;
import tailor.latest.imran.amandeep.com.latesttailor.Fragments.Home;
import tailor.latest.imran.amandeep.com.latesttailor.Fragments.Legal;
import tailor.latest.imran.amandeep.com.latesttailor.Fragments.LifeStyle;
import tailor.latest.imran.amandeep.com.latesttailor.Fragments.MyAccount;
import tailor.latest.imran.amandeep.com.latesttailor.Fragments.MyCart;
import tailor.latest.imran.amandeep.com.latesttailor.Fragments.MyOrderHistory;
import tailor.latest.imran.amandeep.com.latesttailor.Fragments.MyRewards;
import tailor.latest.imran.amandeep.com.latesttailor.Fragments.Notification;
import tailor.latest.imran.amandeep.com.latesttailor.Fragments.RefferAndEarn;
import tailor.latest.imran.amandeep.com.latesttailor.Fragments.TermAndCondition;
import tailor.latest.imran.amandeep.com.latesttailor.MainCode.SplashScreen;
import tailor.latest.imran.amandeep.com.latesttailor.R;
import tailor.latest.imran.amandeep.com.latesttailor.Utils.CommonMessages;
import tailor.latest.imran.amandeep.com.latesttailor.Utils.Constants;

/**
 * Created by admin on 9/22/2016.
 */

public class CommonNavigation extends AppCompatActivity {

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar1;
    private TextView textView1, textView2;
    private ImageView imgBlr, imgUser;
    Context context;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    Home home;

    //******************* Navigation Drawer****************************************************
    public void setNavigationDrawerForAll(Toolbar toolbar, final Context context) {
        toolbar1 = toolbar;
        this.context = context;

        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        View view = View.inflate(CommonNavigation.this, R.layout.header, null);

        imgUser = (ImageView) view.findViewById(R.id.navUserImage);
        imgBlr = (ImageView) view.findViewById(R.id.imageBlr);
        textView1 = (TextView) view.findViewById(R.id.navUserName);
        textView2 = (TextView) findViewById(R.id.navUserEmail);

        navigationView.addHeaderView(view);
        this.context = context;

        mFragmentManager=getSupportFragmentManager();



// need to werite code for data base and get value of image and other data from data base
        String path = "https://www.google.co.in/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&ved=0ahUKEwipkeXYgKXPAhXHG5QKHZ8-BK4QjRwIBw&url=https%3A%2F%2Fwww.nasa.gov%2Fmission_pages%2Fspitzer%2Fimages%2Findex.html&psig=AFQjCNESkb_2tIGb8oPRY0vfFngjyEGC3Q&ust=1474703466256328";
        Picasso.with(CommonNavigation.this)
                .load(path)
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .resize(200, 200)
                .into(imgUser);

        Picasso.with(CommonNavigation.this)
                .load(path)
                .placeholder(R.drawable.blur)
                .into(imgBlr);

        textView1.setText("Name Of User");


        //  textView2.setText("name@gmail.com");
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //Checking if the item is in checked state or not, if not make it in checked state
                //if (menuItem.isChecked())
                //  menuItem.setChecked(false);
                //else menuItem.setChecked(true);
                //Closing drawer on item click
                drawerLayout.closeDrawers();
                //Check to see which item was being clicked and perform appropriate action

                switch (item.getItemId()) {

                    case R.id.home:
                  //      if (item.getItemId() != menuId) {
                            Toast.makeText(context, "Home", Toast.LENGTH_SHORT).show();
                            // start transaction
                           // ft=mFragmentManager.beginTransaction()
                          //   ft.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                         // ft.setCustomAnimations(R.anim.enter_from_left, R.anim.exiy_to_tight);
                        //ft.setCustomAnimations(R.anim.side_in_left,R.anim.slide_out_right);
                        //  ft.setCustomAnimations(R.anim.long_zoom,R.anim.zoom_out);

                          /*   ft.replace(R.id.content_main,home,"Home");
                            ft.addToBackStack("Home");
                            ft.commit();*/
                        home = new Home();
                        fragmentTransaction(home,"Home","Http://google.com/term/home","NotSwitch","home");
                       // fragmentTransaction(home,"Home");

                     //   }
                        break;
                    case R.id.lifeStyle:
                       // if (item.getItemId() != menuId) {
                           CommonMessages.toastMessage(getApplicationContext(),"Life Style");
                            // start transaction

                       // mFragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                        //ft.setCustomAnimations(R.anim.enter_from_left, R.anim.exiy_to_tight);
                        //  ft.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                        //  ft.setCustomAnimations(R.anim.exit_to_left, R.anim.exiy_to_tight);
                            LifeStyle lifeStyle=new LifeStyle();
                           /* ft.replace(R.id.content_main,lifeStyle,"Life Style");
                            ft.addToBackStack("Life Style");
                            ft.commit();*/
                        home = new Home();
                        fragmentTransaction(home,"LIfe Style","Http://google.com/term/Life Style","NotSwitch","Life Style");
                       // fragmentTransaction(lifeStyle,"LifeStyle");
                        overridePendingTransition(R.anim.long_zoom,R.anim.zoom_out);
                     //   }
                   break;
                    case R.id.beauty:
                     //   if (item.getItemId() != menuId) {
                            // start transaction
                        CommonMessages.toastMessage(getApplicationContext(),"Beauty");

                        // start transaction
                       // mFragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                        Beauty beauty=new Beauty();
                       // ft.replace(R.id.content_main,beauty,"Beauty");
                       // ft.addToBackStack("Beauty");
                        //ft.commit();
                        home = new Home();
                        fragmentTransaction(home,"Beauty","Http://google.com/term/Beauty","NotSwitch","Beauty");
                       // fragmentTransaction(beauty,"Beauty");
                        overridePendingTransition(R.anim.long_zoom,R.anim.zoom_out);
                       // }
                        break;
                    case R.id.notification:
                        //if (item.getItemId() != menuId) {
                            // start transaction
                        CommonMessages.toastMessage(getApplicationContext(),"Notification");

                       // mFragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                        Notification notification=new Notification();
                       // ft.replace(R.id.content_main,notification,"Notification");
                       // ft.addToBackStack("Notification");
                       // ft.commit();
                        home = new Home();
                        fragmentTransaction(home,"Notification","Http://google.com/term/Notification","NotSwitch","Notification");
                        //fragmentTransaction(notification,"Notification");
                        overridePendingTransition(R.anim.long_zoom,R.anim.zoom_out);


                      //  }
                        break;
                    case R.id.offer_zone:
                       // if (item.getItemId() != menuId) {
                            // start transaction
                       CommonMessages.toastMessage(getApplicationContext(),"Offer Zone");
                        Intent intent=new Intent(getApplicationContext(), OfferZone.class);
                        startActivity(intent);
                      //  finish();
                        overridePendingTransition(R.anim.long_zoom, R.anim.zoom_out);
                     //   }
                        break;
                    case R.id.reffer_earn:
                      //  if (item.getItemId() != menuId) {
                            // start transaction
                        CommonMessages.toastMessage(getApplicationContext(),"Refer & Earn");

                       // mFragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                        RefferAndEarn refferAndEarn=new RefferAndEarn();
                        //ft.replace(R.id.content_main,refferAndEarn,"Refer & Earn");
                       // ft.addToBackStack("Refer & Earn");
                        //ft.commit();
                        home = new Home();
                        fragmentTransaction(home,"Reffer And Earn","Http://google.com/term/Refer and earn","NotSwitch","Refer and earn");
                        //fragmentTransaction(refferAndEarn,"Reffer And Earn");
                        overridePendingTransition(R.anim.long_zoom,R.anim.zoom_out);
                     //   }
                        break;
                    case R.id.my_rewards:
                    //    if (item.getItemId() != menuId) {
                            // start transaction
                        CommonMessages.toastMessage(getApplicationContext(),"Rewards");
                        MyRewards myRewards=new MyRewards();

                       // mFragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                        //ft.replace(R.id.content_main,myRewards,"My Rewards");
                        //ft.addToBackStack("My Rewards");
                        //ft.commit();
                        home = new Home();
                        fragmentTransaction(home,"My Rewards","Http://google.com/term/LMyRewards","NotSwitch","MyRewards");
                       // fragmentTransaction(myRewards,"My Rewards");
                        overridePendingTransition(R.anim.long_zoom,R.anim.zoom_out);
                      //  }
                        break;
                    case R.id.my_cart:
                      //  if (item.getItemId() != menuId) {
                            // start transaction
                        CommonMessages.toastMessage(getApplicationContext(),"My Cart");
                        MyCart myCart=new MyCart();

                       // mFragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                       // ft.replace(R.id.content_main,myCart,"My Cart");
                        //ft.addToBackStack("My Cart");
                        //ft.commit();
                        home = new Home();
                        fragmentTransaction(home,"My Cart","Http://google.com/term/Legal","NotSwitch","MyCart");
                        //fragmentTransaction(myCart,"My Cart");
                        overridePendingTransition(R.anim.long_zoom,R.anim.zoom_out);
                       // }
                        break;
                    case R.id.my_order:
                     //   if (item.getItemId() != menuId) {
                            // start transaction
                        CommonMessages.toastMessage(getApplicationContext(),"My Order");
                        MyOrderHistory myOrderHistory=new MyOrderHistory();

                       // mFragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                        //ft.replace(R.id.content_main,myOrderHistory,"My Order");
                        //ft.addToBackStack("My Order");
                        //ft.commit();
                        home = new Home();
                        fragmentTransaction(home,"My Order","Http://google.com/term/My Order","NotSwitch","My Order");
                        //fragmentTransaction(myOrderHistory,"My Order");
                        overridePendingTransition(R.anim.long_zoom,R.anim.zoom_out);
                      //  }
                        break;
                    case R.id.my_accounts:
                       // if (item.getItemId() != menuId) {
                            // start transaction
                        CommonMessages.toastMessage(getApplicationContext(),"My Accounts");
                        MyAccount myAccount=new MyAccount();
                       //  mFragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                        //ft.replace(R.id.content_main,myAccount,"My Accounts");
                        //ft.addToBackStack("My Accounts");
                       // ft.commit();

                        fragmentTransaction(myAccount,"My Account","Http://google.com/term/MyAccount","NotSwitch","MyAccount");
                        //fragmentTransaction(myAccount,"My Account");
                        overridePendingTransition(R.anim.long_zoom,R.anim.zoom_out);
                       // }
                        break;
                    case R.id.customer_care:
                // if (item.getItemId() != menuId) {
                // start transaction
                        CommonMessages.toastMessage(getApplicationContext(),"Customer Care");
                        CustomerCare customerCare=new CustomerCare();

                      //  mFragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                       // ft.replace(R.id.content_main,customerCare,"Customer Care");
                        //ft.addToBackStack("Customer Care");
                        //ft.commit();
                        home = new Home();
                        fragmentTransaction(home,"Customer Care","Http://google.com/term/Customer Care","NotSwitch","Customer Care");
                       // fragmentTransaction(customerCare,"Customer Care");
                        overridePendingTransition(R.anim.long_zoom,R.anim.zoom_out);
                // }
                        break;
                    case R.id.legal:
                // if (item.getItemId() != menuId) {
                // start transaction
                        CommonMessages.toastMessage(getApplicationContext(),"Legal");
                        Legal legal=new Legal();

                      //  mFragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                        //ft.replace(R.id.content_main,legal,"Legal");
                        //ft.addToBackStack("Legal");
                        //ft.commit();
                        home = new Home();
                        fragmentTransaction(home,"Legal","Http://google.com/term/Legal","NotSwitch","Legal");
                      //  fragmentTransaction(legal,"Legal");
                        overridePendingTransition(R.anim.long_zoom,R.anim.zoom_out);
                // }
                        break;
                    case R.id.terms:
                // if (item.getItemId() != menuId) {
                // start transaction
                        CommonMessages.toastMessage(getApplicationContext(),"Terms");
                        TermAndCondition termAndCondition=new TermAndCondition();

                       // mFragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                        //ft.replace(R.id.content_main,termAndCondition,"Terms");
                        //ft.addToBackStack("Terms");
                        //ft.commit();
                        home = new Home();
                        fragmentTransaction(home,"Term Condition","Http://google.com/term/Condition","NotSwitch","Term Condition");

                        overridePendingTransition(R.anim.long_zoom,R.anim.zoom_out);
                // }
                        break;
                    case R.id.logout:
                // if (item.getItemId() != menuId) {
                // start transaction
                        CommonMessages.toastMessage(getApplicationContext(),"Log-out");
                        /*MyCart myCart=new MyCart();
                        ft=mFragmentManager.beginTransaction();
                        ft.replace(R.id.content_main,myCart,"My Cart");
                        ft.addToBackStack("My Cart");
                        ft.commit();*/
                        Intent intent1=new Intent(getApplicationContext(), SplashScreen.class);
                        intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent1);
                        overridePendingTransition(R.anim.long_zoom,R.anim.zoom_out);
                // }
                        break;
                    default:
                        break;

                }
                return false;
            }
        });

        // initialize drawer layout
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawerClosed, R.string.drawerOpen) {
            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
                drawerView.bringToFront();
                drawerLayout.requestLayout();
            }


            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
               // Toast.makeText(context, "Slide", Toast.LENGTH_SHORT).show();
            }

        };
        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();


    }
    public void setNavigationViewForSingle(final int menuId,Toolbar toolbar,final Context context){
        toolbar1=toolbar;
        this.context=context;
        navigationView= (NavigationView) findViewById(R.id.navigation_view);
        View view=View.inflate(CommonNavigation.this,R.layout.header,null);

        imgUser = (ImageView) view.findViewById(R.id.navUserImage);
        imgBlr = (ImageView) view.findViewById(R.id.imageBlr);
        textView1 = (TextView) view.findViewById(R.id.navUserName);
        textView2 = (TextView) findViewById(R.id.navUserEmail);

        // write code for data base and get the value of user

        String name="User Name", email="UserEmail@gmail.com"
                ,path="https://www.google.co.in/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&ved=0ahUKEwipkeXYgKXPAhXHG5QKHZ8-BK4QjRwIBw&url=https%3A%2F%2Fwww.nasa.gov%2Fmission_pages%2Fspitzer%2Fimages%2Findex.html&psig=AFQjCNESkb_2tIGb8oPRY0vfFngjyEGC3Q&ust=1474703466256328";

        Picasso.with(CommonNavigation.this)
                .load(path)
                .placeholder(R.drawable.blur)
                .into(imgBlr);

        Picasso.with(CommonNavigation.this)
                .load(path)
                .centerCrop()
                .resize(200,200)
                .placeholder(R.mipmap.ic_launcher)
                .into(imgUser);


        textView1.setText(name);
        textView2.setText(email);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//Checking if the item is in checked state or not, if not make it in checked state
                //if (menuItem.isChecked())
                //  menuItem.setChecked(false);
                //else menuItem.setChecked(true);
                //Closing drawer on item click
                drawerLayout.closeDrawers();
                //Check to see which item was being clicked and perform appropriate action
                switch (item.getItemId()) {

                    case R.id.home:
                        if (item.getItemId() != menuId) {
                            // start transaction
                            /*CommonMessages.toastMessage(getApplicationContext(),"Life Style");
                            // start transaction
                            ft=mFragmentManager.beginTransaction();
                            LifeStyle lifeStyle=new LifeStyle();
                            ft.replace(R.id.content_main,lifeStyle,"Life Style");
                            ft.addToBackStack("Life Style");
                            ft.commit();
                            overridePendingTransition(R.anim.long_zoom,R.anim.zoom_out);*/
                        }
                        break;
                    case R.id.lifeStyle:
                        if (item.getItemId() != menuId) {
                            // start transaction
                            CommonMessages.toastMessage(getApplicationContext(),"Life Style");
                            // start transaction

                          //  mFragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                            LifeStyle lifeStyle=new LifeStyle();
                            //ft.replace(R.id.content_main,lifeStyle,"Life Style");
                           // ft.addToBackStack("Life Style");
                           // ft.commit();
                            home = new Home();
                            fragmentTransaction(home,"LIfe Style","Http://google.com/term/Life Style","NotSwitch","Life Style");
                           // overridePendingTransition(R.anim.long_zoom,R.anim.zoom_out);
                        }
                        break;
                    case R.id.beauty:
                        if (item.getItemId() != menuId) {
                            // start transaction
                            CommonMessages.toastMessage(getApplicationContext(),"Beauty");

                            // start transaction
                            /*ft=mFragmentManager.beginTransaction();
                            ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                            Beauty beauty=new Beauty();
                            ft.replace(R.id.content_main,beauty,"Beauty");
                            ft.addToBackStack("Beauty");
                            ft.commit();
*/

                           // mFragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                            Beauty beauty=new Beauty();
                            // ft.replace(R.id.content_main,beauty,"Beauty");
                            // ft.addToBackStack("Beauty");
                            //ft.commit();
                            home = new Home();
                            fragmentTransaction(home,"Beauty","Http://google.com/term/Beauty","NotSwitch","Beauty");
                        }
                        break;
                    case R.id.notification:
                        if (item.getItemId() != menuId) {
                            // start transaction
                            CommonMessages.toastMessage(getApplicationContext(),"Notification");
                            /*ft=mFragmentManager.beginTransaction();
                            ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                            Notification notification=new Notification();
                            ft.replace(R.id.content_main,notification,"Notification");
                            ft.addToBackStack("Notification");
                            ft.commit();*/

                           // mFragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                            Notification notification=new Notification();
                            // ft.replace(R.id.content_main,notification,"Notification");
                            // ft.addToBackStack("Notification");
                            // ft.commit();
                            home = new Home();
                            fragmentTransaction(home,"Notification","Http://google.com/term/Notification","NotSwitch","Notification");

                        }
                        break;
                    case R.id.offer_zone:
                        if (item.getItemId() != menuId) {
                            // start transaction
                            CommonMessages.toastMessage(getApplicationContext(),"Offer Zone");
                            Intent intent=new Intent(getApplicationContext(), OfferZone.class);
                            startActivity(intent);
                           // finish();
                            overridePendingTransition(R.anim.long_zoom, R.anim.zoom_out);
                        }
                        break;
                    case R.id.reffer_earn:
                        if (item.getItemId() != menuId) {
                            // start transaction
                            CommonMessages.toastMessage(getApplicationContext(),"Refer & Earn");
                         /*   ft=mFragmentManager.beginTransaction();
                            ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                            RefferAndEarn refferAndEarn=new RefferAndEarn();
                            ft.replace(R.id.content_main,refferAndEarn,"Refer & Earn");
                            ft.addToBackStack("Refer & Earn");
                            ft.commit();
                            overridePendingTransition(R.anim.long_zoom,R.anim.zoom_out);*/
                           // mFragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                            RefferAndEarn refferAndEarn=new RefferAndEarn();
                            //ft.replace(R.id.content_main,refferAndEarn,"Refer & Earn");
                            // ft.addToBackStack("Refer & Earn");
                            //ft.commit();
                            home = new Home();
                            fragmentTransaction(home,"Reffer And Earn","Http://google.com/term/Refer and earn","NotSwitch","Refer and earn");
                        }
                        break;
                    case R.id.my_rewards:
                        if (item.getItemId() != menuId) {
                            // start transaction
                            CommonMessages.toastMessage(getApplicationContext(),"Rewards");
                            MyRewards myRewards=new MyRewards();
                           /* ft=mFragmentManager.beginTransaction();
                            ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                            ft.replace(R.id.content_main,myRewards,"My Rewards");
                            ft.addToBackStack("My Rewards");
                            ft.commit();*/
                           // mFragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                            //ft.replace(R.id.content_main,myRewards,"My Rewards");
                            //ft.addToBackStack("My Rewards");
                            //ft.commit();
                            home = new Home();

                            fragmentTransaction(home,"My Rewards","Http://google.com/term/LMyRewards","NotSwitch","MyRewards");


                        }
                        break;
                    case R.id.my_cart:
                        if (item.getItemId() != menuId) {
                            // start transaction
                            CommonMessages.toastMessage(getApplicationContext(),"My Cart");
                            MyCart myCart=new MyCart();
                           /* ft=mFragmentManager.beginTransaction();
                            ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                            ft.replace(R.id.content_main,myCart,"My Cart");
                            ft.addToBackStack("My Cart");
                            ft.commit();
*/
                           // mFragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                            // ft.replace(R.id.content_main,myCart,"My Cart");
                            //ft.addToBackStack("My Cart");
                            //ft.commit();
                            home = new Home();
                            fragmentTransaction(home,"My Cart","Http://google.com/term/Legal","NotSwitch","MyCart");
                            overridePendingTransition(R.anim.long_zoom,R.anim.zoom_out);
                        }
                        break;
                    case R.id.my_order:
                        if (item.getItemId() != menuId) {
                            // start transaction
                            CommonMessages.toastMessage(getApplicationContext(),"My Order");
                            MyOrderHistory myOrderHistory=new MyOrderHistory();
                            /*ft=mFragmentManager.beginTransaction();
                            ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                            ft.replace(R.id.content_main,myOrderHistory,"My Order");
                            ft.addToBackStack("My Order");
                            ft.commit();*/


                           // mFragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                            //ft.replace(R.id.content_main,myOrderHistory,"My Order");
                            //ft.addToBackStack("My Order");
                            //ft.commit();
                            home = new Home();
                            fragmentTransaction(home,"My Order","Http://google.com/term/My Order","NotSwitch","My Order");
                            overridePendingTransition(R.anim.long_zoom,R.anim.zoom_out);

                        }
                        break;
                    case R.id.my_accounts:
                        if (item.getItemId() != menuId) {
                            // start transaction

                            CommonMessages.toastMessage(getApplicationContext(),"My Accounts");
                            MyAccount myAccount=new MyAccount();
                           /* ft=mFragmentManager.beginTransaction();
                            ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                            ft.replace(R.id.content_main,myAccount,"My Accounts");
                            ft.addToBackStack("My Accounts");
                            ft.commit();*/
                            //mFragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                            ///ft.replace(R.id.content_main,myAccount,"My Accounts");
                            //ft.addToBackStack("My Accounts");
                            // ft.commit();
                            home = new Home();
                            fragmentTransaction(home,"My Account","Http://google.com/term/MyAccount","NotSwitch","MyAccount");
                            overridePendingTransition(R.anim.long_zoom,R.anim.zoom_out);

                        }
                        break;
                    case R.id.customer_care:
                        if (item.getItemId() != menuId) {
                            // start transaction
                            CommonMessages.toastMessage(getApplicationContext(),"Customer Care");
                            CustomerCare customerCare=new CustomerCare();
                          /*  ft=mFragmentManager.beginTransaction();
                            ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                            ft.replace(R.id.content_main,customerCare,"Customer Care");
                            ft.addToBackStack("Customer Care");
                            ft.commit();*/
                           // mFragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                            // ft.replace(R.id.content_main,customerCare,"Customer Care");
                            //ft.addToBackStack("Customer Care");
                            //ft.commit();
                            home = new Home();
                            fragmentTransaction(home,"Customer Care","Http://google.com/term/Customer Care","NotSwitch","Customer Care");
                            overridePendingTransition(R.anim.long_zoom,R.anim.zoom_out);

                        }
                        break;
                    case R.id.legal:
                        if (item.getItemId() != menuId) {
                            // start transaction
                            CommonMessages.toastMessage(getApplicationContext(),"Legal");
                            Legal legal=new Legal();
                            //mFragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                            //ft.replace(R.id.content_main,legal,"Legal");
                            //ft.addToBackStack("Legal");
                            //ft.commit();
                            home = new Home();
                            fragmentTransaction(home,"Legal","Http://google.com/term/Legal","NotSwitch","Legal");
                            overridePendingTransition(R.anim.long_zoom,R.anim.zoom_out);


                        }
                        break;
                    case R.id.terms:
                        if (item.getItemId() != menuId) {
                            // start transaction
                            CommonMessages.toastMessage(getApplicationContext(),"Terms");
                            TermAndCondition termAndCondition=new TermAndCondition();
                           /* ft=mFragmentManager.beginTransaction();
                            ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                            ft.replace(R.id.content_main,termAndCondition,"Terms");
                            ft.addToBackStack("Terms");
                            ft.commit();*/

                           // mFragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                            //ft.replace(R.id.content_main,termAndCondition,"Terms");
                            //ft.addToBackStack("Terms");
                            //ft.commit();
                            home = new Home();
                            fragmentTransaction(home,"Term Condition","Http://google.com/term/Condition","NotSwitch","Term Condition");
                            overridePendingTransition(R.anim.long_zoom,R.anim.zoom_out);

                        }
                        break;
                    case R.id.logout:
                        if (item.getItemId() != menuId) {
                            // start transaction
                            CommonMessages.toastMessage(getApplicationContext(),"Log-out");
                        /*MyCart myCart=new MyCart();
                        ft=mFragmentManager.beginTransaction();
                        ft.replace(R.id.content_main,myCart,"My Cart");
                        ft.addToBackStack("My Cart");
                        ft.commit();*/
                            Intent intent1=new Intent(getApplicationContext(), SplashScreen.class);
                            intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent1);
                            overridePendingTransition(R.anim.long_zoom,R.anim.zoom_out);
                            overridePendingTransition(R.anim.long_zoom,R.anim.zoom_out);
                        }
                        break;
                    default:
                        break;

                }
                return false;
            }
        });

        drawerLayout= (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.drawerClosed,R.string.drawerOpen){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                drawerView.bringToFront();
                drawerLayout.requestLayout();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                Toast.makeText(context, "Workrd", Toast.LENGTH_SHORT).show();
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }
    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(Gravity.LEFT)){
            drawerLayout.closeDrawer(Gravity.LEFT);
        }else{
            super.onBackPressed();
        }
    }

    protected void fragmentTransaction(Fragment fragmentObject,String tag,String collectionUrl,String adapter,String collection){

        mFragmentManager=getSupportFragmentManager();
        mFragmentTransaction=mFragmentManager.beginTransaction();
        Bundle b=new Bundle();
        b.putString(Constants.URL_BUNDLE_TAG,collectionUrl);
        b.putString(Constants.ADAPTER_BUNDLE_TAG,adapter);
        b.putString(Constants.TAG_LINE_BUNDLE,collection);

        fragmentObject.setArguments(b);
        mFragmentTransaction.replace(R.id.content_main,fragmentObject,tag);
        mFragmentTransaction.addToBackStack(tag);
        mFragmentTransaction.commit();


    }


    protected void fragmentTransactionAdd(Fragment fragmentObject,String tag){

        //mFragmentManager=getActivity().getSupportFragmentManager();
        mFragmentTransaction=mFragmentManager.beginTransaction();
        mFragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
        mFragmentTransaction.add(R.id.content_main,fragmentObject,tag);
        mFragmentTransaction.addToBackStack(tag);
        mFragmentTransaction.commit();


    }


    protected void fragmentTransaction(Fragment fragmentObject, String tag){

        //  mFragmentManager=getActivity().getSupportFragmentManager();
        mFragmentTransaction=mFragmentManager.beginTransaction();
        mFragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
       /* Bundle b=new Bundle();
        b.putString("URL",collectionUrl);
        b.putString("TagLine",collection);
        fragmentObject.setArguments(b);*/
        mFragmentTransaction.replace(R.id.content_main,fragmentObject,tag);
        mFragmentTransaction.addToBackStack(tag);
        mFragmentTransaction.commit();


    }
}


