package tailor.latest.imran.amandeep.com.latesttailor.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import tailor.latest.imran.amandeep.com.latesttailor.Fragments.ItemViewFlipper;
import tailor.latest.imran.amandeep.com.latesttailor.MainCode.MainActivity;
import tailor.latest.imran.amandeep.com.latesttailor.MyModelPattern.OfferDataModel;
import tailor.latest.imran.amandeep.com.latesttailor.R;

/**
 * Created by admin on 9/28/2016.
 */

public class OfferRecyclerViewAdapter extends RecyclerView.Adapter<OfferRecyclerViewAdapter.MyViewHolder> {

    Context context;
    ArrayList<OfferDataModel> modelList;

    public OfferRecyclerViewAdapter(Context context,ArrayList<OfferDataModel> modelList) {
        this.context = context;
        this.modelList=modelList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.offer_item_visible,parent,false);
        return new MyViewHolder(view);
    }

   /* @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

        @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }*/

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // here you need to set view

        holder.tv.setText(modelList.get(position).getTitle());

        Glide.with(context)
                .load(modelList.get(position).getImage())
                .thumbnail(0.1f)
                .animate(R.anim.long_zoom)
                .into(holder.iv);

        holder.cardViwe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Worked", Toast.LENGTH_SHORT).show();
              //  ((MainActivity)context).getSupportFragmentManager().beginTransaction()
                     //   .replace(new ItemViewFlipper(),"Flipper").addToBackStack(null).commit();

                // we need to here the item, image and position
                FragmentManager manager=((MainActivity)context).getSupportFragmentManager();
                FragmentTransaction ft=manager.beginTransaction();
                ItemViewFlipper obj=new ItemViewFlipper();
                Bundle b=new Bundle();
                b.putString("Position",position+"");
                b.putString("ItemName",modelList.get(position).getTitle());
                b.putString("Image",modelList.get(position).getImage());
                obj.setArguments(b);
                ft.replace(R.id.content_main,obj, "Fliper");
                ft.commit();
            }
        });
        /*Picasso.with(context)
                .load(modelList.get(position).getImage())
                .placeholder(R.drawable.ic_gallery)
                .centerCrop()
                .resize(200,200)
                .into(holder.iv);*/
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView iv,iv1;
        TextView tv,tv1;
        CardView cardViwe;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv= (ImageView) itemView.findViewById(R.id.iv_offerItem_visible_item1);
           // iv1= (ImageView) itemView.findViewById(R.id.iv_offerItem_visible_item2);
            tv= (TextView) itemView.findViewById(R.id.tv_offerItem_visible_item1);
           // tv1= (TextView) itemView.findViewById(R.id.tv_offerItem_visible_item2);
            cardViwe= (CardView) itemView.findViewById(R.id.cardView_offer_item_visible);
        }
    }

    // if we want to inflate two view at a time in recycler view

    class MyViewHolder1 extends RecyclerView.ViewHolder{
        ImageView iv,iv1;
        TextView tv,tv1;

        public MyViewHolder1(View itemView) {
            super(itemView);
            iv= (ImageView) itemView.findViewById(R.id.iv_offerItem_visible_item1);
            // iv1= (ImageView) itemView.findViewById(R.id.iv_offerItem_visible_item2);
            tv= (TextView) itemView.findViewById(R.id.tv_offerItem_visible_item1);
            // tv1= (TextView) itemView.findViewById(R.id.tv_offerItem_visible_item2);

        }
    }
}
