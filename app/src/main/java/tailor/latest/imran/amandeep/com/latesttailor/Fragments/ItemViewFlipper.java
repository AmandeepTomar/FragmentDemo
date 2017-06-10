package tailor.latest.imran.amandeep.com.latesttailor.Fragments;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import tailor.latest.imran.amandeep.com.latesttailor.R;
import tailor.latest.imran.amandeep.com.latesttailor.Utils.CommonMessages;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ItemViewFlipper#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ItemViewFlipper extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = ItemViewFlipper.class.getName();
    View view;
    LinearLayout dotslinearLayout;
    int dotsCount;// no of dots
    ImageView[] dots;
    private PagerAdapter mPagerAdapter;
    ArrayList<String> imageslist;
    String position,imageUrl,title;


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

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public ItemViewFlipper() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ItemViewFlipper.
     */
    // TODO: Rename and change types and number of parameters
    public static ItemViewFlipper newInstance(String param1, String param2) {
        ItemViewFlipper fragment = new ItemViewFlipper();
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
        if (b!=null){
            position=b.getString("Position");
            title=b.getString("ItemName");
            imageUrl=b.getString("Image");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_item_view_flipper, container, false);
        imageslist = new ArrayList<String>();

        dotslinearLayout = (LinearLayout)view.findViewById(R.id.dotsll);

        // it is working with commented adapter code we try it in traditional way
     /*   viewPager.setAdapter(new CustomPagerAdapter(getActivity().getApplicationContext()));*/

        CommonMessages.errorLog(TAG+"First",position+" "+title+"  "+imageUrl);

        inItViews();


        return view;
    }


    //******************************************  Custom Pager Adapter ******************************************

   /* private class CustomPagerAdapter extends PagerAdapter {
        private Context mContext;


        public CustomPagerAdapter(Context context) {
            mContext = context;
        }


        @Override
        public Object instantiateItem(ViewGroup collection, int position) {
            CustomPagerEnum customPagerEnum = CustomPagerEnum.values()[position];
            LayoutInflater inflater = LayoutInflater.from(mContext);
            ViewGroup layout = (ViewGroup) inflater.inflate(customPagerEnum.getLayoutResId(), collection, false);
            collection.addView(layout);
            return layout;
        }

        @Override
        public void destroyItem(ViewGroup collection, int position, Object view) {
            collection.removeView((View) view);
        }

        @Override
        public int getCount() {
            return CustomPagerEnum.values().length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            CustomPagerEnum customPagerEnum = CustomPagerEnum.values()[position];
            return mContext.getString(customPagerEnum.getTitleResId());
        }
    }*/

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            ScreenSlidePageFragment screenSlidePageFragment = new ScreenSlidePageFragment();
            Bundle bundledata = new Bundle();
            bundledata.putString("urls",imageslist.get(position));
            screenSlidePageFragment.setArguments(bundledata);

            return screenSlidePageFragment;
        }

        @Override
        public int getCount() {
            return imageslist.size();
        }
    }

    private void setUiPageViewController()
    {
        dots = new ImageView[dotsCount];

        for(int i=0; i<dotsCount; i++)
        {
            dots[i] = new ImageView(getActivity());
            if(Build.VERSION.SDK_INT<=21)
                dots[i].setImageDrawable(getResources().getDrawable(R.drawable.smallcircle));
            else
                dots[i].setImageDrawable(getResources().getDrawable(R.drawable.smallcircle,null));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(4, 0, 4, 0);

            dotslinearLayout.addView(dots[i], params);
        }

        if(Build.VERSION.SDK_INT<=21)
            dots[0].setImageDrawable(getResources().getDrawable(R.drawable.bigcircle));
        else
            dots[0].setImageDrawable(getResources().getDrawable(R.drawable.bigcircle,null));
    }


    private ArrayList<String> prepareData(){
        ArrayList<String> modelList=new ArrayList<>();
        for (int i = 0; i <android_version_names.length ; i++) {
          /*  CustomPagerEnumImage model=new CustomPagerEnumImage();
            model.setImage(android_image_urls[i]);
            model.setTitle(android_version_names[i]);*/
            modelList.add(android_image_urls[i]);
            dotsCount=modelList.size();

        }
        return modelList;
    }

    protected void inItViews(){
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
       /* ArrayList<CustomPagerEnumImage> modelList=prepareData();*/
       // viewPager.setAdapter(new CustomPagerAdapterImage(getActivity().getApplicationContext(),modelList));
       for (int i=0;i<android_image_urls.length;i++) {
           imageslist.add(android_image_urls[i]);
           CommonMessages.errorLog(TAG+"Image",imageslist.toString());
       }
        dotsCount=imageslist.size();
        CommonMessages.errorLog(TAG+"DOTCOUNT",dotsCount+"");

        mPagerAdapter = new ScreenSlidePagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(mPagerAdapter);

        setUiPageViewController();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dotsCount; i++) {
                    if (Build.VERSION.SDK_INT <= 21)
                        dots[i].setImageDrawable(getResources().getDrawable(R.drawable.smallcircle));
                    else
                        dots[i].setImageDrawable(getResources().getDrawable(R.drawable.smallcircle, null));
                }
                if (Build.VERSION.SDK_INT <= 21)
                    dots[position].setImageDrawable(getResources().getDrawable(R.drawable.bigcircle));
                else
                    dots[position].setImageDrawable(getResources().getDrawable(R.drawable.bigcircle, null));
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // 1 = Dragging
                // 2 = Settling
                // 3 = Idle
            }
        });
    }
}

