package tailor.latest.imran.amandeep.com.latesttailor.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tailor.latest.imran.amandeep.com.latesttailor.Adapters.OfferRecyclerViewAdapter;
import tailor.latest.imran.amandeep.com.latesttailor.MainCode.MainActivity;
import tailor.latest.imran.amandeep.com.latesttailor.MyModelPattern.OfferDataModel;
import tailor.latest.imran.amandeep.com.latesttailor.R;
import tailor.latest.imran.amandeep.com.latesttailor.Utils.CommonMessages;
import tailor.latest.imran.amandeep.com.latesttailor.Utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = Home.class.getName();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    FragmentManager mFragmentManager;
    String getUrl,tagLine, adapter;
    TextView tv;
    private RecyclerView recyclerView;
    private OfferDataModel model;
    private List<OfferDataModel> modelList;
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
            "Marshmallow"
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
            "http://api.learn2crack.com/android/images/marshmallow.png"
    };


    public Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();

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

        Bundle b = this.getArguments();
        if (b != null) {
            getUrl = b.getString(Constants.URL_BUNDLE_TAG, Constants.TAG_BUNDLE_DEFAULT_DATA);
            adapter = b.getString(Constants.ADAPTER_BUNDLE_TAG, Constants.TAG_BUNDLE_DEFAULT_DATA);
            tagLine=b.getString(Constants.TAG_LINE_BUNDLE,Constants.TAG_BUNDLE_DEFAULT_DATA);


            CommonMessages.toastMessage(getContext(), getUrl + " " + adapter+" ");
            CommonMessages.errorLog(TAG+"Bundle", getUrl +" "+adapter+" "+tagLine);
        } else {
            adapter = "No Data1";
        }


        // here we get the data send from the adapter on the basis of data we hit the api with parameter and get the result according to that
        // like we have 40 to 60 % off on mans appraisal then we should send to parameters .


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        view = inflater.inflate(R.layout.fragment_home, container, false);
        // initialize all the view here

        tv = (TextView) view.findViewById(R.id.tv_home_offer_headLine);


        CommonMessages.errorLog(TAG, adapter);
        if (adapter.equalsIgnoreCase("Switch")) {

            ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            ((MainActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
            Toolbar toolbar = (Toolbar) ((MainActivity) getActivity()).findViewById(R.id.toolbar);
            tv.setText(getUrl);

            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CommonMessages.errorLog(TAG, "Worked");
                    mFragmentManager = getActivity().getSupportFragmentManager();
                    //

                    // mFragmentManager.popBackStack();
                    //((MainActivity)getActivity()).onBackPressed();

                    //((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);

                    // ((MainActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(false);
                    ((MainActivity) getActivity()).finish();
                    startActivity(new Intent(getActivity().getApplicationContext(), MainActivity.class));

                    getActivity().overridePendingTransition(R.anim.long_zoom, R.anim.zoom_out);

                }

            });
        }
            // here we need to write the code for recycler view
            inItViews();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    public void inItViews() {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_Homa);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager llm = new GridLayoutManager(getActivity().getApplicationContext(), 2);
        recyclerView.setLayoutManager(llm);
        ArrayList<OfferDataModel> modelList = prepareData();

        OfferRecyclerViewAdapter adapter = new OfferRecyclerViewAdapter(getActivity(), modelList);
        recyclerView.setAdapter(adapter);


    }


    private ArrayList<OfferDataModel> prepareData() {

        ArrayList<OfferDataModel> modelList = new ArrayList<>();
        for (int i = 0; i < android_version_names.length; i++) {

            OfferDataModel model = new OfferDataModel();
            model.setTitle(android_version_names[i]);
            model.setImage(android_image_urls[i]);

            modelList.add(model);
        }
        return modelList;
    }


}
