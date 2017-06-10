package tailor.latest.imran.amandeep.com.latesttailor.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import tailor.latest.imran.amandeep.com.latesttailor.Fragments.Home;
import tailor.latest.imran.amandeep.com.latesttailor.MainCode.MainActivity;
import tailor.latest.imran.amandeep.com.latesttailor.MyModelPattern.DiscountModel;
import tailor.latest.imran.amandeep.com.latesttailor.R;
import tailor.latest.imran.amandeep.com.latesttailor.Utils.CommonMessages;

/**
 * Created by admin on 9/27/2016.
 */

public class DiscountRecyclerAdapter extends RecyclerView.Adapter<DiscountRecyclerAdapter.MyViewHolder>  {
    Context context;
    List<DiscountModel> modelList;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    public DiscountRecyclerAdapter(Context context,List<DiscountModel> modelList) {
        this.context=context;
        this.modelList=modelList;
        Log.e("MSG______",modelList.get(0).getTagLine()+" "+modelList.get(0).getTest_color());
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.discount_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

       // image should contain a array list
       String url=modelList.get(position).getImage();

        Glide.with(context)
                .load(modelList.get(position).getImage())
                .thumbnail(.1f)
                .animate(R.anim.pop_enter)
                .into(holder.iv);

       /* Picasso.with(context).load(modelList.get(position).getImage())
                .placeholder(R.drawable.ic_facebook)
                .into(holder.iv);*/
        CommonMessages.errorLog("Value",modelList.get(position).getImage());

        CommonMessages.errorLog("Color",modelList.get(position).getTest_color_bottom()+" "+modelList.get(position).getTest_color());

        //****************************************** Set Color on Layout according to the Version*****************************
        /*
        if(Build.VERSION.SDK_INT<=21 && Build.VERSION.SDK_INT<16) {
            holder.linearLayoutMain.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.rectangle_border_bottom,null));
            holder.linearLayoutBottom.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.rectangle_border_bottom,null));
            ((GradientDrawable)holder.linearLayoutMain.getBackground()).setColor(Color.parseColor(modelList.get(position).getTest_color()));
            ((GradientDrawable)holder.linearLayoutBottom.getBackground()).setColor(Color.parseColor(modelList.get(position).getTest_color_bottom()));*/
         if(Build.VERSION.SDK_INT<=21 && Build.VERSION.SDK_INT>16){
            holder.linearLayoutMain.setBackground(context.getResources().getDrawable(R.drawable.rectangle_border));
            holder.linearLayoutBottom.setBackground(context.getResources().getDrawable(R.drawable.rectangle_border_bottom));
            ((GradientDrawable)holder.linearLayoutMain.getBackground()).setColor(Color.parseColor(modelList.get(position).getTest_color()));
            ((GradientDrawable)holder.linearLayoutBottom.getBackground()).setColor(Color.parseColor(modelList.get(position).getTest_color_bottom()));
        }else if (Build.VERSION.SDK_INT>=21 && Build.VERSION.SDK_INT<16) {
            holder.linearLayoutMain.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.rectangle_border, null));
            holder.linearLayoutBottom.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.rectangle_border_bottom, null));
            ((GradientDrawable) holder.linearLayoutMain.getBackground()).setColor(Color.parseColor(modelList.get(position).getTest_color()));
            ((GradientDrawable) holder.linearLayoutBottom.getBackground()).setColor(Color.parseColor(modelList.get(position).getTest_color_bottom()));
        }else if ( Build.VERSION.SDK_INT>19){
            holder.linearLayoutMain.setBackgroundResource(R.drawable.rectangle_border);
            holder.linearLayoutBottom.setBackgroundResource(R.drawable.rectangle_border_bottom);
            ((GradientDrawable)holder.linearLayoutMain.getBackground()).setColor(Color.parseColor(modelList.get(position).getTest_color()));
            ((GradientDrawable)holder.linearLayoutBottom.getBackground()).setColor(Color.parseColor(modelList.get(position).getTest_color_bottom()));
        }
        holder.tv.setText(modelList.get(position).getTagLine());

        CommonMessages.errorLog("Value1",modelList.get(position).getTagLine());

        //************************** Code for animation ********************************************************
        Animation fromzoomin = AnimationUtils.loadAnimation(context, R.anim.zoom_in);
        holder.iv.startAnimation(fromzoomin);

        Animation fromzoominright = AnimationUtils.loadAnimation(context, R.anim.zoom_in_right);
        holder.linearLayoutBottom.startAnimation(fromzoominright);


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonMessages.toastMessage(context,position+"");

                Home home=new Home();
                fragmentTransaction(home,"Home","URL REQUIRED","Switch");

            }
        });

    }



    @Override
    public int getItemCount() {
        return modelList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tv;
        LinearLayout linearLayoutMain,linearLayoutBottom;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv= (ImageView) itemView.findViewById(R.id.iv_discount_item);
            tv= (TextView) itemView.findViewById(R.id.tv_discount_item);
            linearLayoutMain= (LinearLayout) itemView.findViewById(R.id.linearlayoutmain);
            linearLayoutBottom= (LinearLayout) itemView.findViewById(R.id.linearLayoutBottom);
            cardView= (CardView) itemView.findViewById(R.id.cardViewDiscount);



        }
    }


    protected void fragmentTransaction(Fragment fragmentObject, String tag, String collectionUrl, String adapter){

        mFragmentManager=((MainActivity)context).getSupportFragmentManager();
        mFragmentTransaction=mFragmentManager.beginTransaction();
        Bundle b=new Bundle();
        b.putString("URL",collectionUrl);
        b.putString("Adapter",adapter);
        fragmentObject.setArguments(b);
        mFragmentTransaction.replace(R.id.content_main,fragmentObject,tag);
        mFragmentTransaction.addToBackStack(tag);
        mFragmentTransaction.commit();


    }
}
