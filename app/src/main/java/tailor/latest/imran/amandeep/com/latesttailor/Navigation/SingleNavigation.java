package tailor.latest.imran.amandeep.com.latesttailor.Navigation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
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

import tailor.latest.imran.amandeep.com.latesttailor.R;

/**
 * Created by admin on 9/23/2016.
 */

public class SingleNavigation extends AppCompatActivity {

    private ImageView blrImage,userImage;
    private TextView userName,userEmail;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    Context context;
    Toolbar toolbar1;

    // set navigation view on an activity

    public void setNavigationViewForSingle(final int menuId,Toolbar toolbar,final Context context){
        toolbar1=toolbar;
        this.context=context;
        navigationView= (NavigationView) findViewById(R.id.navigation_view);
        View view=View.inflate(SingleNavigation.this,R.layout.header,null);

        blrImage= (ImageView) view.findViewById(R.id.imageBlr);
        userImage= (ImageView)view.findViewById(R.id.navUserImage);
        userName= (TextView) view.findViewById(R.id.navUserName);
        userEmail= (TextView) view.findViewById(R.id.navUserEmail);

        // write code for data base and get the value of user

        String name="User Name", email="UserEmail@gmail.com"
                ,path="https://www.google.co.in/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&ved=0ahUKEwipkeXYgKXPAhXHG5QKHZ8-BK4QjRwIBw&url=https%3A%2F%2Fwww.nasa.gov%2Fmission_pages%2Fspitzer%2Fimages%2Findex.html&psig=AFQjCNESkb_2tIGb8oPRY0vfFngjyEGC3Q&ust=1474703466256328";

        Picasso.with(SingleNavigation.this)
                .load(path)
                .placeholder(R.drawable.blur)
                .into(blrImage);

        Picasso.with(SingleNavigation.this)
                .load(path)
                .centerCrop()
                .resize(200,200)
                .placeholder(R.mipmap.ic_launcher)
                .into(userImage);


        userName.setText(name);
        userEmail.setText(email);


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
                        }
                        break;
                    case R.id.lifeStyle:
                        if (item.getItemId() != menuId) {
                            // start transaction
                        }
                        break;
                    case R.id.beauty:
                        if (item.getItemId() != menuId) {
                            // start transaction
                        }
                        break;
                    case R.id.notification:
                        if (item.getItemId() != menuId) {
                            // start transaction
                        }
                        break;
                    case R.id.offer_zone:
                        if (item.getItemId() != menuId) {
                            // start transaction
                        }
                        break;
                    case R.id.reffer_earn:
                        if (item.getItemId() != menuId) {
                            // start transaction
                        }
                        break;
                    case R.id.my_rewards:
                        if (item.getItemId() != menuId) {
                            // start transaction
                        }
                        break;
                    case R.id.my_cart:
                        if (item.getItemId() != menuId) {
                            // start transaction
                        }
                        break;
                    case R.id.my_order:
                        if (item.getItemId() != menuId) {
                            // start transaction
                        }
                        break;
                    case R.id.my_accounts:
                        if (item.getItemId() != menuId) {
                            // start transaction
                        }
                        break;
                    case R.id.customer_care:
                        if (item.getItemId() != menuId) {
                            // start transaction
                        }
                        break;
                    case R.id.legal:
                        if (item.getItemId() != menuId) {
                            // start transaction
                        }
                        break;
                    case R.id.terms:
                        if (item.getItemId() != menuId) {
                            // start transaction
                        }
                        break;
                    case R.id.logout:
                        if (item.getItemId() != menuId) {
                            // start transaction
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


}
