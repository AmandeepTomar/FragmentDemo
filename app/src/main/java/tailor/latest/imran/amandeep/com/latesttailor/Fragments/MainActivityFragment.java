package tailor.latest.imran.amandeep.com.latesttailor.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import tailor.latest.imran.amandeep.com.latesttailor.Adapters.DiscountRecyclerAdapter;
import tailor.latest.imran.amandeep.com.latesttailor.Adapters.HorizontalRecyclerViewAdapter;
import tailor.latest.imran.amandeep.com.latesttailor.MyModelPattern.DiscountModel;
import tailor.latest.imran.amandeep.com.latesttailor.MyModelPattern.OfferDataModel;
import tailor.latest.imran.amandeep.com.latesttailor.R;
import tailor.latest.imran.amandeep.com.latesttailor.UnUsedFragments.MenCollection;
import tailor.latest.imran.amandeep.com.latesttailor.Utils.CommonMessages;
import tailor.latest.imran.amandeep.com.latesttailor.Utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainActivityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String TAG=MainActivityFragment.class.getName();
    List<DiscountModel> modelList;
    private RecyclerView recyclerView,recyclerViewHorizontal;
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
    View view;


    private final String android_version_names[] = {
            "Donut",
            "Eclair",
            "Froyo",
            "Gingerbread",
            "Honeycomb",
            "Ice Cream Sandwich",
            "Jelly Bean",
            "KitKat",
            "Lollipop",
            "Marshmallow",
            "Lollipop",
            "Jelly Bean",
            "Froyo"

    };

    private final String android_image_urls[] = {
            "http://api.learn2crack.com/android/images/donut.png",
            "http://api.learn2crack.com/android/images/eclair.png",
            "http://api.learn2crack.com/android/images/froyo.png",
            "http://api.learn2crack.com/android/images/ginger.png",
            "http://api.learn2crack.com/android/images/honey.png",
            "http://api.learn2crack.com/android/images/icecream.png",
            "http://api.learn2crack.com/android/images/jellybean.png",
            "http://api.learn2crack.com/android/images/kitkat.png",
            "http://api.learn2crack.com/android/images/lollipop.png",
            "http://api.learn2crack.com/android/images/marshmallow.png",
            "http://api.learn2crack.com/android/images/lollipop.png",
            "http://api.learn2crack.com/android/images/eclair.png",
            "http://api.learn2crack.com/android/images/ginger.png",

    };


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public MainActivityFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainActivityFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainActivityFragment newInstance(String param1, String param2) {
        MainActivityFragment fragment = new MainActivityFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_main_activity, container, false);

        // initialize all the views
        /*cardViewMen= (CardView) view.findViewById(R.id.cardView_main_men);
        cardViewWoman= (CardView) view.findViewById(R.id.cardView_main_woman);
        cardViewKids= (CardView) view.findViewById(R.id.cardView_main_kids);
        cardViewBeauty= (CardView) view.findViewById(R.id.cardView_main_beauty);
        cardViewLifeStyle= (CardView) view.findViewById(R.id.cardView_main_lifeStyle);
        cardViewSpecial= (CardView) view.findViewById(R.id.cardView_main_special);*/

        mFragmentManager=getActivity().getSupportFragmentManager();

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




//************************************** Apply On CLick Listener *****************************************
       /* cardViewMen.setOnClickListener(this);
        cardViewWoman.setOnClickListener(this);
        cardViewBeauty.setOnClickListener(this);
        cardViewKids.setOnClickListener(this);
        cardViewLifeStyle.setOnClickListener(this);
        cardViewSpecial.setOnClickListener(this);*/


        //********************************************* Calling initialize Methods ***********************************
        initializeRecyclerView();
        // horizontal recycler view
        initializeHorizontalView();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);




    }
    //********************************** Perform OnClick Events Here ****************************************************************
    // All new fragments are not in use like
       /* 1. MenCollection
        2. WomanCollection
        3. KidsCollection
        4. SpecialCollection*/

    @Override
    public void onClick(View v) {
        int id = v.getId();
        MenCollection men;
        Home home;
        switch (id) {
        /*    case R.id.cardView_main_men:
                CommonMessages.toastMessage(getActivity().getApplicationContext(), "Tst");

                //  ((LinearLayout)findViewById(R.id.rootLinearLayout)).removeAllViews();
             //   men = new MenCollection();
                home=new Home();

                fragmentTransaction(home, "MEN","Http://Www.googlr.com","Switch","Men Collection");
                // finish();
                //  fragmentTransactionAdd(men,"MEN");

                break;
            case R.id.cardView_main_woman:
                CommonMessages.toastMessage(getActivity().getApplicationContext(), "Tst");
                home=new Home();

                fragmentTransaction(home, "WOMAN","Http://Www.googlr.com/woman","Switch","WoMen Collection");
               // fragmentTransaction(new WomanCollection(), "WOMAN");
                break;
            case R.id.cardView_main_kids:
                CommonMessages.toastMessage(getActivity().getApplicationContext(), "Tst");
               // fragmentTransaction(new KidsCollection(), "KIDS");
                home=new Home();

                fragmentTransaction(home, "KIDS","Http://Www.googlr.com/KIDS","Switch","Kids Collection");
                break;
            case R.id.cardView_main_lifeStyle:
                CommonMessages.toastMessage(getActivity().getApplicationContext(), "Tst");
               // fragmentTransaction(new LifeStyle(), "LifeStyle");
                home=new Home();

                fragmentTransaction(home, "Life Style","Http://Www.google.com/LIfeStyle","Switch","Life Style Collection");
                break;
            case R.id.cardView_main_beauty:
                CommonMessages.toastMessage(getActivity().getApplicationContext(), "Tst");
              //  fragmentTransaction(new Beauty(), "Beauty");
                home=new Home();

                fragmentTransaction(home, "Beauty","Http://Www.google.com/beauty","Switch","Beauty Collection");
                break;
            case R.id.cardView_main_special:
                CommonMessages.toastMessage(getActivity().getApplicationContext(), "Tst");
               // fragmentTransaction(new SpecialCollection(), "Special");
                home=new Home();

                fragmentTransaction(home, "Special","Http://Www.google.com/Special","Switch","Special Collection");
                break;
            default:
                break;*/
        }
    }


    public void initializeRecyclerView(){
        recyclerView= (RecyclerView) view.findViewById(R.id.recyclerView_discount);
        recyclerView.hasFixedSize();

        RecyclerView.LayoutManager llm=new LinearLayoutManager(getActivity().getApplicationContext());
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
             //   CommonMessages.errorLog(TAG+"PPPPPP", i + ""+cctwo.get(Constants.colorcodeloop)+" "+ccone.get(Constants.colorcodeloop));

                model.setTagLine("Value Of tag" + i);

                modelList.add(model);
            }
        }


        adapter=new DiscountRecyclerAdapter(getActivity(),modelList);

        recyclerView.setAdapter(adapter);


    }


    //********************************************** initialize horizontal recycler view ************************************************

        public void  initializeHorizontalView(){
            recyclerViewHorizontal= (RecyclerView) view.findViewById(R.id.horizontal_recyclerView);
            recyclerViewHorizontal.setHasFixedSize(false);
            LinearLayoutManager llmHorizontal=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
            recyclerViewHorizontal.setLayoutManager(llmHorizontal);

            ArrayList<ArrayList<OfferDataModel>> modelList=prepared();

            CommonMessages.errorLog("MODELLIST",modelList.size()+" ");

            // set Adapter Here

           // OfferRecyclerViewAdapter adapter=new OfferRecyclerViewAdapter(getActivity(),modelList);
            HorizontalRecyclerViewAdapter adapter=new HorizontalRecyclerViewAdapter(getActivity(),modelList);
            recyclerViewHorizontal.setAdapter(adapter);



        }


    //***************************** Method for Fragment Transaction *************************************

    protected void fragmentTransaction(Fragment fragmentObject,String tag,String collectionUrl,String adapter,String collection){

      //  mFragmentManager=getActivity().getSupportFragmentManager();
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
        mFragmentTransaction.add(R.id.content_main,fragmentObject,tag);
        mFragmentTransaction.addToBackStack(tag);
        mFragmentTransaction.commit();


    }

    protected ArrayList<ArrayList<OfferDataModel>> prepared(){

        ArrayList<ArrayList<OfferDataModel>> modelList=new ArrayList<>();

        int rem=android_image_urls.length%3;

     int count=0;
        for(int i=0;i<android_image_urls.length;i=i+3){
            count++;
            ArrayList<OfferDataModel> mlist=new ArrayList<>();
            OfferDataModel model=new OfferDataModel();
            model.setImage(android_image_urls[i]);
            model.setTitle(android_version_names[i]);
            mlist.add(model);
           // CommonMessages.errorLog("HZTAG", "1111111");

            if(i+1<android_image_urls.length) {
                OfferDataModel model2 = new OfferDataModel();
                model2.setImage(android_image_urls[i + 1]);
                model2.setTitle(android_version_names[i + 1]);
                mlist.add(model2);
               // CommonMessages.errorLog("HZTAG", "2222222");

            }
            if(i+2<android_image_urls.length) {

                OfferDataModel model3 = new OfferDataModel();
                model3.setImage(android_image_urls[i + 2]);
                model3.setTitle(android_version_names[i + 2]);
                mlist.add(model3);
                CommonMessages.errorLog("HZTAG", "33333333");

            }
         //   CommonMessages.errorLog("HZTAG",count+"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

            modelList.add(mlist);

        }
        //CommonMessages.errorLog("HZTAG", modelList.size()+"###----" +count);

        return modelList;
    }
}
