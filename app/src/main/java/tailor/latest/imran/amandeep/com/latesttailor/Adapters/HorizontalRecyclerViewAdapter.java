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
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import tailor.latest.imran.amandeep.com.latesttailor.Fragments.Home;
import tailor.latest.imran.amandeep.com.latesttailor.MainCode.MainActivity;
import tailor.latest.imran.amandeep.com.latesttailor.MyModelPattern.OfferDataModel;
import tailor.latest.imran.amandeep.com.latesttailor.R;
import tailor.latest.imran.amandeep.com.latesttailor.Utils.CommonMessages;

/**
 * Created by admin on 9/30/2016.
 */

public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.MyViewHolder> {
    private Context context;
    ArrayList<ArrayList<OfferDataModel>> modelList;
    View view;
    int i=0;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    public HorizontalRecyclerViewAdapter(Context context, ArrayList<ArrayList<OfferDataModel>> modelList) {
        this.context=context;
        this.modelList=modelList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view= LayoutInflater.from(context).inflate(R.layout.view_horizontal,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        ArrayList<OfferDataModel> model = modelList.get(position);
        int size=model.size();
        CommonMessages.errorLog("HZTAG", size+"-&&&--");

        for(i=0;i<size;i++)
        {
            CommonMessages.errorLog("HZTAG",model.get(i).getImage()+"%%%%%");

            Picasso.with(context).load(model.get(i).getImage()).placeholder(R.drawable.ic_facebook).into(holder.imgarray[i]);
            holder.txtarray[i].setText(model.get(i).getTitle());
           final String value=model.get(i).getTitle();
            CommonMessages.errorLog("Value",value+"()()(((()()(");
            holder.imgarray[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CommonMessages.toastMessage(context,""+value);
                    Home home=new Home();

                    fragmentTransaction(home,value,value+"URL","Switch",value+"Collection");



                }
            });
        }



      /*  Picasso.with(context).load(model.get(0).getImage()).placeholder(R.drawable.ic_gallery).into(holder.iv);
        Picasso.with(context).load(model.get(1).getImage()).placeholder(R.drawable.ic_gallery).into(holder.iv1);
        Picasso.with(context).load(model.get(2).getImage()).placeholder(R.drawable.ic_gallery).into(holder.iv2);

        holder.tv.setText(model.get(0).getTitle());
        holder.tv1.setText(model.get(1).getTitle());
        holder.tv2.setText(model.get(2).getTitle());

        CommonMessages.errorLog("HZTAG", model.get(0).getTitle() + " " + " " + model.get(1).getTitle() + " " + " " + model.get(2).getTitle());
        CommonMessages.errorLog("IMAGETAG", model.get(0).getImage() + " " + model.get(1).getImage() + " " + model.get(2).getImage());*/
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
       ImageView[] imgarray;
        TextView[] txtarray;
        public MyViewHolder(View itemView) {
            super(itemView);
            ImageView iv,iv1,iv2;
            TextView tv,tv1,tv2;
            CommonMessages.errorLog("HZTAG", modelList.size() +"-------------");

            iv= (ImageView) itemView.findViewById(R.id.iv_main_cardViewItem1);
            iv1= (ImageView) itemView.findViewById(R.id.iv_main_cardViewItem11);
            iv2= (ImageView) itemView.findViewById(R.id.iv_main_cardViewItem111);

            tv= (TextView) itemView.findViewById(R.id.tv_main_cardViewItem2);
            tv1= (TextView) itemView.findViewById(R.id.tv_main_cardViewItem21);
            tv2= (TextView) itemView.findViewById(R.id.tv_main_cardViewItem211);
            imgarray=new ImageView[]{iv,iv1,iv2};
            txtarray=new TextView[]{tv,tv1,tv2};

        }
    }


    protected void fragmentTransaction(Fragment fragmentObject, String tag, String collectionUrl, String adapter, String collection){

        mFragmentManager=((MainActivity)context).getSupportFragmentManager();
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




}
