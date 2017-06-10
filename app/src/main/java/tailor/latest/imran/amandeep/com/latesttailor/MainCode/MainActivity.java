package tailor.latest.imran.amandeep.com.latesttailor.MainCode;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import tailor.latest.imran.amandeep.com.latesttailor.Adapters.DiscountRecyclerAdapter;
import tailor.latest.imran.amandeep.com.latesttailor.Fragments.MainActivityFragment;
import tailor.latest.imran.amandeep.com.latesttailor.Fragments.MyAccount;
import tailor.latest.imran.amandeep.com.latesttailor.MyModelPattern.DiscountModel;
import tailor.latest.imran.amandeep.com.latesttailor.Navigation.CommonNavigation;
import tailor.latest.imran.amandeep.com.latesttailor.R;
import tailor.latest.imran.amandeep.com.latesttailor.Utils.CommonMessages;
import tailor.latest.imran.amandeep.com.latesttailor.Utils.Constants;

public class MainActivity extends CommonNavigation implements View.OnClickListener {
    private static final String TAG=MainActivity.class.getName();
    List<DiscountModel> modelList;
    private RecyclerView recyclerView;
    private DiscountRecyclerAdapter adapter;
    DiscountModel model;
    ArrayList<String> ccone,cctwo;
    LinearLayout searchContainer;
    EditText toolbarSearchView;
    ImageView searchClearButton;
    private CardView cardViewMen,cardViewWoman,cardViewKids,cardViewLifeStyle,cardViewBeauty,cardViewSpecial;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    int fitCount=0;
    Intent intent;




    @Override
    protected void onStart() {
        super.onStart();
        CommonMessages.errorLog(TAG,"OnStart");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CommonMessages.errorLog(TAG, "OnCreate");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        super.setNavigationDrawerForAll(toolbar, MainActivity.this);
        intent = getIntent();

        //     super.setNavigationDrawerForAll(R.id.home,toolbar,MainActivity.this);
        // if you used this method then first you need to view on activity view it will not perform
        // any kind of click on home page so we used a constructor without menu parameter
        // we want to put some view on activity also i,.e npt come under the home section

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        String frag = intent.getStringExtra("Value");
        if (frag != null && frag.equalsIgnoreCase("MyAccount")) {
            MyAccount account = new MyAccount();
            CommonMessages.errorLog(TAG + "INTENT", frag);
            fragmentTransaction(account, "My Account", "Http://google.com/term/MyAccount", "NotSwitch", "MyAccount");
        } else {


  /*      // Setup search container view
        searchContainer = new LinearLayout(this);
        Toolbar.LayoutParams containerParams = new Toolbar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        containerParams.gravity = Gravity.CENTER_VERTICAL;
        searchContainer.setLayoutParams(containerParams);

        // Setup search view
        toolbarSearchView = new EditText(this);
        // Set width / height / gravity
        int[] textSizeAttr = new int[]{android.R.attr.actionBarSize};
        int indexOfAttrTextSize = 0;
        TypedArray a = obtainStyledAttributes(new TypedValue().data, textSizeAttr);
        int actionBarHeight = a.getDimensionPixelSize(indexOfAttrTextSize, -1);
        a.recycle();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, actionBarHeight);
        params.gravity = Gravity.CENTER_VERTICAL;
        params.weight = 1;
        toolbarSearchView.setLayoutParams(params);

        // Setup display
        toolbarSearchView.setBackgroundColor(Color.TRANSPARENT);
        toolbarSearchView.setPadding(2, 0, 0, 0);
        toolbarSearchView.setTextColor(Color.WHITE);
        toolbarSearchView.setGravity(Gravity.CENTER_VERTICAL);
        toolbarSearchView.setSingleLine(true);
        toolbarSearchView.setImeActionLabel("Search", EditorInfo.IME_ACTION_UNSPECIFIED);
        toolbarSearchView.setHint("Search");
        toolbarSearchView.setHintTextColor(Color.parseColor("#b3ffffff"));
        try {
            // Set cursor colour to white
            // http://stackoverflow.com/a/26544231/1692770
            // https://github.com/android/platform_frameworks_base/blob/kitkat-release/core/java/android/widget/TextView.java#L562-564
            Field f = TextView.class.getDeclaredField("mCursorDrawableRes");
            f.setAccessible(true);
            f.set(toolbarSearchView, R.drawable.ic_keyboard_backspace_black_24dp);
        } catch (Exception ignored) {
        }

// Search text changed listener
        toolbarSearchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Fragment mainFragment = getFragmentManager().findFragmentById(R.id.container);
                if (mainFragment != null && mainFragment instanceof MainListFragment) {
                    ((MainListFragment) mainFragment).search(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() <= 0) {
                    toolbarSearchView.setHintTextColor(Color.parseColor("#b3ffffff"));
                }
            }
        });
        ((LinearLayout) searchContainer).addView(toolbarSearchView);

        // Setup the clear button
        searchClearButton = new ImageView(this);
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, r.getDisplayMetrics());
        LinearLayout.LayoutParams clearParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        clearParams.gravity = Gravity.CENTER;
        searchClearButton.setLayoutParams(clearParams);
        searchClearButton.setImageResource(R.drawable.ic_keyboard_backspace_black_24dp); // TODO: Get this image from here: https://github.com/google/material-design-icons
        searchClearButton.setPadding(px, 0, px, 0);
        searchClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toolbarSearchView.setText("");
            }
        });
        ((LinearLayout) searchContainer).addView(searchClearButton);

        // Add search view to toolbar and hide it
        searchContainer.setVisibility(View.GONE);
        toolbar.addView(searchContainer);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // toolbarHomeButtonAnimating is a boolean that is initialized as false. It's used to stop the user pressing the home button while it is animating and breaking things.
                if (!toolbarHomeButtonAnimating) {
                    // Here you'll want to check if you have a search query set, if you don't then hide the search box.
                    // My main fragment handles this stuff, so I call its methods.
                    FragmentManager fragmentManager = getFragmentManager();
                    final Fragment fragment = fragmentManager.findFragmentById(R.id.container);
                    if (fragment != null && fragment instanceof MainListFragment) {
                        if (((MainListFragment) fragment).hasSearchQuery() || searchContainer.getVisibility() == View.VISIBLE) {
                            displaySearchView(false);
                            return;
                        }
                    }
                }

                if (mDrawerLayout.isDrawerOpen(findViewById(R.id.navigation_drawer)))
                    mDrawerLayout.closeDrawer(findViewById(R.id.navigation_drawer));
                else
                    mDrawerLayout.openDrawer(findViewById(R.id.navigation_drawer));
            }
        });
*/


            // color array for subject assessment list
            ccone = new ArrayList<String>();
            ccone.add("#ff9933");
            ccone.add("#0099cc");
            ccone.add("#00cc66");
            ccone.add("#737373");
            ccone.add("#cc6699");

            // darkcolor array list for subject assessment list

            cctwo = new ArrayList<String>();
            cctwo.add("#e67300");
            cctwo.add("#0086b3");
            cctwo.add("#00b359");
            cctwo.add("#666666");
            cctwo.add("#bf4080");

            // initialize all the views
    /*    cardViewMen= (CardView) findViewById(R.id.cardView_main_men);
        cardViewWoman= (CardView) findViewById(R.id.cardView_main_woman);
        cardViewKids= (CardView) findViewById(R.id.cardView_main_kids);
        cardViewBeauty= (CardView) findViewById(R.id.cardView_main_beauty);
        cardViewLifeStyle= (CardView) findViewById(R.id.cardView_main_lifeStyle);
        cardViewSpecial= (CardView) findViewById(R.id.cardView_main_special);

        mFragmentManager=getSupportFragmentManager();
*/
//************************************** Apply On CLick Listener *****************************************
      /*  cardViewMen.setOnClickListener(this);
        cardViewWoman.setOnClickListener(this);
        cardViewBeauty.setOnClickListener(this);
        cardViewKids.setOnClickListener(this);
        cardViewLifeStyle.setOnClickListener(this);
        cardViewSpecial.setOnClickListener(this);*/


            //********************************************* Calling initialize Methods ***********************************
            //  initializeRecyclerView();


            mFragmentManager = getSupportFragmentManager();
            fragmentTransaction(new MainActivityFragment(), "MAIN");

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void initializeRecyclerView(){
        recyclerView= (RecyclerView) findViewById(R.id.recyclerView_discount);
        recyclerView.hasFixedSize();

        RecyclerView.LayoutManager llm=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(llm);

        modelList=new ArrayList<>();
        String imagesArray[]={"https://www.google.co.in/search?q=images&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwjpm8iCnK_PAhUGTI8KHTqRBPIQsAQIJA&biw=1366&bih=662#imgrc=AWlSOvbusqcWGM%3A"
        ,"http://www.nasa.gov/sites/default/files/styles/image_card_4x3_ratio/public/thumbnails/image/av_oa6_l2.jpg?itok=aJqW6Vob",
        "https://www.google.co.in/search?q=images&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwjpm8iCnK_PAhUGTI8KHTqRBPIQsAQIJA&biw=1366&bih=662#imgdii=AWlSOvbusqcWGM%3A%3BAWlSOvbusqcWGM%3A%3BNLq7kQNH_GhxBM%3A&imgrc=AWlSOvbusqcWGM%3A",
        "http://www.nasa.gov/sites/default/files/styles/image_card_4x3_ratio/public/thumbnails/image/av_oa6_l2.jpg?itok=aJqW6Vob",
        "https://www.google.co.in/search?q=images&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwjpm8iCnK_PAhUGTI8KHTqRBPIQsAQIJA&biw=1366&bih=662#imgdii=AWlSOvbusqcWGM%3A%3BAWlSOvbusqcWGM%3A%3BtMEvFuUbkTbu-M%3A&imgrc=AWlSOvbusqcWGM%3A",
        "http://www.nasa.gov/sites/default/files/styles/image_card_4x3_ratio/public/thumbnails/image/av_oa6_l2.jpg?itok=aJqW6Vob"
        ,"https://www.google.co.in/search?q=images&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwjpm8iCnK_PAhUGTI8KHTqRBPIQsAQIJA&biw=1366&bih=662#imgdii=AWlSOvbusqcWGM%3A%3BAWlSOvbusqcWGM%3A%3BGqxZ1KSFsB5W4M%3A&imgrc=AWlSOvbusqcWGM%3A",
        "https://www.google.co.in/search?q=images&tbm=isch&tbo=u&source=univ&sa=X&ved=0ahUKEwjpm8iCnK_PAhUGTI8KHTqRBPIQsAQIJA&biw=1366&bih=662#q=images&tbm=isch&tbs=rimg%3ACQFpUjr27rKnIjg04_1qywrFr_1DS6u5EDR_1xoenJ2bF5upqS0wS8W5RuRNu1OQXXAtBjRGqxZ1KSFsB4cWfKpKsDQYioSCTTj-rLCsWv8EdX0m1deVX97KhIJNLq7kQNH_1GgRaqTNkVVVW30qEgl6cnZsXm6mpBHMQduhPMTJBCoSCbTBLxblG5E2EVfkB0WJdhxkKhIJ7U5BdcC0GNERSUWo2ju7IhsqEgkarFnUpIWwHhGNr0Q685eICCoSCRxZ8qkqwNBiEVfkB0WJdhxk&imgrc=qVwl1DAtQoL_JM%3A"
        };

        for (int i=0;i<imagesArray.length;i++){
            Constants.colorcodeloop=Constants.colorcodeloop+1;
            if (ccone.size()!=Constants.colorcodeloop) {
                String url = imagesArray[i];
                model = new DiscountModel();

                model.setImage(url);
                CommonMessages.errorLog(TAG, url);
                CommonMessages.errorLog(TAG, i + "");
                CommonMessages.errorLog(TAG+"IFG", i + ""+cctwo.get(Constants.colorcodeloop)+" "+ccone.get(Constants.colorcodeloop));

                model.setTest_color(ccone.get(Constants.colorcodeloop));
                model.setTest_color_bottom(cctwo.get(Constants.colorcodeloop));

                model.setTagLine("Value Of tag" + i);

                modelList.add(model);
            }else {
                Constants.colorcodeloop = -1;
                Constants.colorcodeloop = Constants.colorcodeloop + 1;
                String url = imagesArray[i];
                model = new DiscountModel();

                model.setImage(url);

                model.setTest_color(ccone.get(Constants.colorcodeloop));
                model.setTest_color_bottom(cctwo.get(Constants.colorcodeloop));

                CommonMessages.errorLog(TAG, url);
                CommonMessages.errorLog(TAG+"PPPPPP", i + ""+cctwo.get(Constants.colorcodeloop)+" "+ccone.get(Constants.colorcodeloop));

                model.setTagLine("Value Of tag" + i);

                modelList.add(model);
            }
        }


        adapter=new DiscountRecyclerAdapter(MainActivity.this,modelList);

        recyclerView.setAdapter(adapter);


    }
//********************************** Perform OnClick Events Here ****************************************************************
    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
     /*       case R.id.cardView_main_men:
                CommonMessages.toastMessage(getApplicationContext(),"Tst");
           MenCollection men;
                ((LinearLayout)findViewById(R.id.rootLinearLayout)).removeAllViews();
                men = new MenCollection();

                fragmentTransaction(men,"MEN");
               // finish();
              //  fragmentTransactionAdd(men,"MEN");

                break;
            case R.id.cardView_main_woman:
                CommonMessages.toastMessage(getApplicationContext(),"Tst");
                fragmentTransaction(new WomanCollection(),"WOMAN");
                break;
            case R.id.cardView_main_kids:
                CommonMessages.toastMessage(getApplicationContext(),"Tst");
                fragmentTransaction(new KidsCollection(),"KIDS");
                break;
            case R.id.cardView_main_lifeStyle:
                CommonMessages.toastMessage(getApplicationContext(),"Tst");
                fragmentTransaction(new LifeStyle(),"LifeStyle");
                break;
            case R.id.cardView_main_beauty:
                CommonMessages.toastMessage(getApplicationContext(),"Tst");
                fragmentTransaction(new Beauty(),"Beauty");
                break;
            case R.id.cardView_main_special:
                CommonMessages.toastMessage(getApplicationContext(),"Tst");
                fragmentTransaction(new SpecialCollection(),"Special");
                break;
            default:
                break;*/



        }





    }
//*************************************************** Maintain OnBackPressed ************************************************
    @Override
    public void onBackPressed() {

        if (fitCount==1){

        }
        super.onBackPressed();

    }

    //***************************** Method for Fragment Transaction *************************************

    protected void fragmentTransaction(Fragment fragmentObject,String tag,String collectionUrl,String adapter,String collection){

        mFragmentManager=getSupportFragmentManager();
        mFragmentTransaction=mFragmentManager.beginTransaction();
        Bundle b=new Bundle();
        b.putString("URL",collectionUrl);
        b.putString("Adapter",adapter);
        b.putString("TagLine",collection);

        fragmentObject.setArguments(b);
        mFragmentTransaction.replace(R.id.content_main,fragmentObject,tag);
        mFragmentTransaction.addToBackStack(tag);
        mFragmentTransaction.commit();


    }

    protected void fragmentTransactionAdd(Fragment fragmentObject,String tag){

        mFragmentManager=getSupportFragmentManager();
        mFragmentTransaction=mFragmentManager.beginTransaction();
        mFragmentTransaction.add(R.id.content_main,fragmentObject,tag);
        mFragmentTransaction.addToBackStack(tag);
        mFragmentTransaction.commit();


    }

}
