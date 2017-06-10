package tailor.latest.imran.amandeep.com.latesttailor.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tailor.latest.imran.amandeep.com.latesttailor.MainCode.MainActivity;
import tailor.latest.imran.amandeep.com.latesttailor.R;
import tailor.latest.imran.amandeep.com.latesttailor.Utils.CommonMessages;
import tailor.latest.imran.amandeep.com.latesttailor.Utils.Constants;


public class MyOrderHistory extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    String ACTIVITY_URL;
    String ACTIVITY_ADAPTER;
    String ACTIVITY_TAG_LINE;
    private  View view;
    private TextView tv;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public MyOrderHistory() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyOrderHistory.
     */
    // TODO: Rename and change types and number of parameters
    public static MyOrderHistory newInstance(String param1, String param2) {
        MyOrderHistory fragment = new MyOrderHistory();
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

        Bundle b=this.getArguments();
        if (b!=null){
            ACTIVITY_URL=b.getString(Constants.URL_BUNDLE_TAG,Constants.TAG_BUNDLE_DEFAULT_DATA);
            ACTIVITY_ADAPTER=b.getString(Constants.ADAPTER_BUNDLE_TAG,Constants.TAG_BUNDLE_DEFAULT_DATA);
            ACTIVITY_TAG_LINE=b.getString(Constants.TAG_LINE_BUNDLE,Constants.TAG_BUNDLE_DEFAULT_DATA);
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        view=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_my_order_history, container, false);

        tv= (TextView) view.findViewById(R.id.tv_myOrderHistory);

        CommonMessages.errorLog("TAGMOH",ACTIVITY_ADAPTER+" "+ACTIVITY_URL+" "+ACTIVITY_TAG_LINE);

        if (ACTIVITY_ADAPTER.equalsIgnoreCase("Switch")){
            ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            ((MainActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);

            final Toolbar toolbar= (Toolbar) ((MainActivity)getActivity()).findViewById(R.id.toolbar);

            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //((MainActivity)getActivity()).finish();
                    //((MainActivity)getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.content_main,new MyOrderHistory(), "MyOrderHistory");
                    Intent intent=new Intent(getActivity(),MainActivity.class);
                    intent.putExtra("Value","MyAccount");
                    startActivity(intent);
                   //  "My Account","Http://google.com/term/MyAccount","NotSwitch","MyAccount"
                  //   MyAccount account=new MyAccount();

                    //fragmentTransaction(account,"My Account","Http://google.com/term/MyAccount","NotSwitch","MyAccount");

                    //getActivity().overridePendingTransition(R.anim.long_zoom,R.anim.zoom_out);

                    /*((MainActivity)getActivity()).getSupportFragmentManager().popBackStack();
                    toolbar.getContentInsetStartWithNavigation();*/
                    //getActivity().getSupportFragmentManager().popBackStackImmediate();



                }
            });
           /* ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            ((MainActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);*/



        }

        if (ACTIVITY_TAG_LINE.equalsIgnoreCase("Heading One0")){
            // we have to set the adapter for each item according to the view and need
            // My Order
            CommonMessages.errorLog("TAGMOHINSIDE",ACTIVITY_ADAPTER+" "+ACTIVITY_URL+" "+ACTIVITY_TAG_LINE);
            tv.setText(ACTIVITY_URL+" "+ACTIVITY_TAG_LINE+""+ACTIVITY_ADAPTER);
        }else if (ACTIVITY_TAG_LINE.equalsIgnoreCase("Heading One1")){
            // My Returned Order
            CommonMessages.errorLog("TAGMOHINSIDE",ACTIVITY_ADAPTER+" "+ACTIVITY_URL+" "+ACTIVITY_TAG_LINE);
            tv.setText(ACTIVITY_URL+" "+ACTIVITY_TAG_LINE+""+ACTIVITY_ADAPTER);
        }else if (ACTIVITY_TAG_LINE.equalsIgnoreCase("Heading One2")){
            // My Exchanged Order
            CommonMessages.errorLog("TAGMOH",ACTIVITY_ADAPTER+" "+ACTIVITY_URL+" "+ACTIVITY_TAG_LINE);
            tv.setText(ACTIVITY_URL+" "+ACTIVITY_TAG_LINE+""+ACTIVITY_ADAPTER);
        }else if (ACTIVITY_TAG_LINE.equalsIgnoreCase("Heading One3")){
           // My Review
            CommonMessages.errorLog("TAGMOH",ACTIVITY_ADAPTER+" "+ACTIVITY_URL+" "+ACTIVITY_TAG_LINE);
            tv.setText(ACTIVITY_URL+" "+ACTIVITY_TAG_LINE+""+ACTIVITY_ADAPTER);
        }else if (ACTIVITY_TAG_LINE.equalsIgnoreCase("Heading One4")){

            // My Account Settings
           /* UserInformation userInformation=new UserInformation();
            fragmentTransaction(userInformation,"Information","StringUrlCollection","NoSwitch","INformationCollection");
            CommonMessages.errorLog("TAGMOH",ACTIVITY_ADAPTER+" "+ACTIVITY_URL+" "+ACTIVITY_TAG_LINE);*/

            tv.setText(ACTIVITY_URL+" "+ACTIVITY_TAG_LINE+""+ACTIVITY_ADAPTER);
        }else if (ACTIVITY_TAG_LINE.equalsIgnoreCase("Heading One5")){
            CommonMessages.errorLog("TAGMOH",ACTIVITY_ADAPTER+" "+ACTIVITY_URL+" "+ACTIVITY_TAG_LINE);
            tv.setText(ACTIVITY_URL+" "+ACTIVITY_TAG_LINE+""+ACTIVITY_ADAPTER);
        }else if (ACTIVITY_TAG_LINE.equalsIgnoreCase("Heading One6")){
            CommonMessages.errorLog("TAGMOH",ACTIVITY_ADAPTER+" "+ACTIVITY_URL+" "+ACTIVITY_TAG_LINE);
            tv.setText(ACTIVITY_URL+" "+ACTIVITY_TAG_LINE+""+ACTIVITY_ADAPTER);
        }else if (ACTIVITY_TAG_LINE.equalsIgnoreCase("Heading One7")){
            CommonMessages.errorLog("TAGMOH",ACTIVITY_ADAPTER+" "+ACTIVITY_URL+" "+ACTIVITY_TAG_LINE);
            tv.setText(ACTIVITY_URL+" "+ACTIVITY_TAG_LINE+""+ACTIVITY_ADAPTER);
        }



        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    protected void fragmentTransaction(Fragment fragmentObject,String tag,String collectionUrl,String adapter,String collection){

        mFragmentManager=((MainActivity)getActivity()).getSupportFragmentManager();
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

}



