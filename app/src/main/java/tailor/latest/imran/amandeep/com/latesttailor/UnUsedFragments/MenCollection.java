package tailor.latest.imran.amandeep.com.latesttailor.UnUsedFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tailor.latest.imran.amandeep.com.latesttailor.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenCollection#newInstance} factory method to
 * create an instance of this fragment.
 */

// All New Fragments Are not in use

public class MenCollection extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG=MenCollection.class.getName();
    private View view;
    String url;
    String tagLine;
    private TextView tv,tv1;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public MenCollection() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenCollection.
     */
    // TODO: Rename and change types and number of parameters
    public static MenCollection newInstance(String param1, String param2) {
        MenCollection fragment = new MenCollection();
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

        Bundle b=getArguments();
        if (b!=null) {

            url = b.getString("URL");

            tagLine = b.getString("TagLine");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_men_collection, container, false);

        // initialize the view
        tv= (TextView) view.findViewById(R.id.textView);
        tv1= (TextView) view.findViewById(R.id.textView1);

        tv.setText(url);
        tv1.setText(tagLine);



        return view;
    }

}
