package tailor.latest.imran.amandeep.com.latesttailor.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import tailor.latest.imran.amandeep.com.latesttailor.Adapters.RecyclerAdaptrForTwoTextView;
import tailor.latest.imran.amandeep.com.latesttailor.MyModelPattern.TwoTextViewValueModel;
import tailor.latest.imran.amandeep.com.latesttailor.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyAccount#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyAccount extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private  View view;
    private RecyclerView mRecyclerView;
    private ArrayList<TwoTextViewValueModel> modelList;



    public MyAccount() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyAccount.
     */
    // TODO: Rename and change types and number of parameters
    public static MyAccount newInstance(String param1, String param2) {
        MyAccount fragment = new MyAccount();
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
        view=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_my_account, container, false);

        mRecyclerView= (RecyclerView) view.findViewById(R.id.recyclerView_MyAccount);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager llm=new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(llm);

        ArrayList<TwoTextViewValueModel> valueList=preparedData();

        RecyclerAdaptrForTwoTextView adapter=new RecyclerAdaptrForTwoTextView(getActivity(),R.layout.my_account_card_view,valueList);
        mRecyclerView.setAdapter(adapter);







        return view;
    }

    protected ArrayList<TwoTextViewValueModel> preparedData(){

        modelList=new ArrayList<>();

        for (int i = 0; i <8 ; i++) {
            TwoTextViewValueModel model=new TwoTextViewValueModel();
            model.setHeadingOne("Heading One"+i);
            model.setHeadingTwo("Heading Two"+i);
            modelList.add(model);

        }
        return modelList;


    }




}
