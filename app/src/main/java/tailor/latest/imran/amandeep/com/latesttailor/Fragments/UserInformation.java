package tailor.latest.imran.amandeep.com.latesttailor.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tailor.latest.imran.amandeep.com.latesttailor.R;
import tailor.latest.imran.amandeep.com.latesttailor.Utils.CommonMessages;
import tailor.latest.imran.amandeep.com.latesttailor.Utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 *
 * create an instance of this fragment.
 */
public class UserInformation extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    String ACTIVITY_URL;
    String ACTIVITY_ADAPTER;
    String ACTIVITY_TAG_LINE;

    private View view;
    private CollapsingToolbarLayout collapsingToolbar;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public UserInformation() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserInformation.
     */
    // TODO: Rename and change types and number of parameters
    public static UserInformation newInstance(String param1, String param2) {
        UserInformation fragment = new UserInformation();
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
        ACTIVITY_URL=b.getString(Constants.URL_BUNDLE_TAG,Constants.TAG_BUNDLE_DEFAULT_DATA);
        ACTIVITY_ADAPTER=b.getString(Constants.ADAPTER_BUNDLE_TAG,Constants.TAG_BUNDLE_DEFAULT_DATA);
        ACTIVITY_TAG_LINE=b.getString(Constants.TAG_LINE_BUNDLE,Constants.TAG_BUNDLE_DEFAULT_DATA);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_user_information, container, false);
        collapsingToolbar=(CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);

        CommonMessages.errorLog("TAGUSERINFO",ACTIVITY_ADAPTER+" "+ACTIVITY_TAG_LINE+" "+ACTIVITY_URL);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
           }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

}
