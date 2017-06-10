package tailor.latest.imran.amandeep.com.latesttailor.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import tailor.latest.imran.amandeep.com.latesttailor.Fragments.MyOrderHistory;
import tailor.latest.imran.amandeep.com.latesttailor.Fragments.UserInformation;
import tailor.latest.imran.amandeep.com.latesttailor.MainCode.MainActivity;
import tailor.latest.imran.amandeep.com.latesttailor.MyModelPattern.TwoTextViewValueModel;
import tailor.latest.imran.amandeep.com.latesttailor.R;
import tailor.latest.imran.amandeep.com.latesttailor.Utils.CommonMessages;
import tailor.latest.imran.amandeep.com.latesttailor.Utils.Constants;

/**
 * Created by admin on 10/3/2016.
 */

public class RecyclerAdaptrForTwoTextView extends RecyclerView.Adapter<RecyclerAdaptrForTwoTextView.MyViewHolder> {
   private Context context;
    private int res;
    private ArrayList<TwoTextViewValueModel> modelList;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    public RecyclerAdaptrForTwoTextView(Context context, int res, ArrayList<TwoTextViewValueModel> modelList) {
        this.context=context;
        this.res=res;
        this.modelList=modelList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(res,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.tvHeading.setText(modelList.get(position).getHeadingOne());
        holder.tvBottomHeading.setText(modelList.get(position).getHeadingTwo());

        holder.tvBottomHeading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // we meed to add url in our pojo class
                String text=modelList.get(position).getHeadingOne();
               // CommonMessages.errorLog("Tag",text);

                if (text.equalsIgnoreCase("Heading One0")){
                    // Order History
                    MyOrderHistory myOrderHistory=new MyOrderHistory();
                    fragmentTransaction(myOrderHistory,text,text+"URL","Switch","Heading One0");

                }else if (text.equalsIgnoreCase("Heading One1")){
                    // My Payments
                    // My Cancelled Order
                    MyOrderHistory myOrderHistory=new MyOrderHistory();
                    fragmentTransaction(myOrderHistory,text,text+"URL","Switch","Heading One1");
                    CommonMessages.errorLog("Tag",text);
                }else if (text.equalsIgnoreCase("Heading One1")){
                    // My Reviews
                    // Exchanged Order
                    MyOrderHistory myOrderHistory=new MyOrderHistory();
                    fragmentTransaction(myOrderHistory,text,text+"URL","Switch","Heading One2");
                    CommonMessages.errorLog("Tag",text);
                }else if (text.equalsIgnoreCase("Heading One2")){
                    // My Address
                    // Returned Order
                    MyOrderHistory myOrderHistory=new MyOrderHistory();
                    fragmentTransaction(myOrderHistory,text,text+"URL","Switch","Heading One3");
                    CommonMessages.errorLog("Tag",text);
                }else if (text.equalsIgnoreCase("Heading One3")){
                    // My Review
                    MyOrderHistory myOrderHistory=new MyOrderHistory();
                    fragmentTransaction(myOrderHistory,text,text+"URL","Switch","Heading One4");
                    CommonMessages.errorLog("Tag",text);
                }else if (text.equalsIgnoreCase("Heading One4")){
                    // My Address
                    //MyOrderHistory myOrderHistory=new MyOrderHistory();
                    UserInformation information=new UserInformation();
                    fragmentTransaction(information,text,text+"URL","Switch","Heading One5");
                    CommonMessages.errorLog("Tag",text);
                }else if (text.equalsIgnoreCase("Heading One5")){
                    // My Account Settings
                    MyOrderHistory myOrderHistory=new MyOrderHistory();
                    fragmentTransaction(myOrderHistory,text,text+"URL","Switch","Heading One6");
                    CommonMessages.errorLog("Tag",text);
                }else if (text.equalsIgnoreCase("Heading One6")){
                    // My Reviews
                    MyOrderHistory myOrderHistory=new MyOrderHistory();
                    fragmentTransaction(myOrderHistory,text,text+"URL","Switch","Heading One7");
                    CommonMessages.errorLog("Tag",text);
                }else if (text.equalsIgnoreCase("Heading One7")){
                    // My Reviews
                    MyOrderHistory myOrderHistory=new MyOrderHistory();
                    fragmentTransaction(myOrderHistory,text,text+"URL","UnSwitch",text+"Collection");
                    CommonMessages.errorLog("Tag",text+"Logout");


                }

               // fragmentTransaction();
            }
        });

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvHeading,tvBottomHeading;
        View v;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvHeading= (TextView) itemView.findViewById(R.id.tv_myAccount_heading);
            tvBottomHeading= (TextView) itemView.findViewById(R.id.tv_myAccount_bottomText);
            v=itemView.findViewById(R.id.view_myAccount);
        }
    }

    protected void fragmentTransaction(Fragment fragmentObject, String tag, String collectionUrl, String adapter, String collection){

        mFragmentManager=((MainActivity)context).getSupportFragmentManager();
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
