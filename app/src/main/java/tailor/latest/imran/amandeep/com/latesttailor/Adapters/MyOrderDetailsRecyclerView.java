package tailor.latest.imran.amandeep.com.latesttailor.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import tailor.latest.imran.amandeep.com.latesttailor.R;

/**
 * Created by admin on 10/4/2016.
 */

public class MyOrderDetailsRecyclerView extends RecyclerView.Adapter<MyOrderDetailsRecyclerView.MyViewHolder> {
   private Context context;
    private View view;
    int res;

    public MyOrderDetailsRecyclerView(Context context,int res) {
        this.context=context;
        this.res=res;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvItemOrderDate,tvItemName,tvItemStatus,tvItemWriteReview,tvItemEditYourReview;
        RatingBar ratingBar;
        ImageView ivItemImage;
        RelativeLayout layoutReview;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvItemOrderDate= (TextView) itemView.findViewById(R.id.tv_cardView_MOH_OrderDate);
            tvItemName= (TextView) itemView.findViewById(R.id.tv_cardView_MOH_ItemName);
            tvItemStatus= (TextView) itemView.findViewById(R.id.tv_cardView_MOH_ItemStatus);
            tvItemWriteReview= (TextView) itemView.findViewById(R.id.tv_cardView_MOH_ReviewfIXED);
            tvItemEditYourReview= (TextView) itemView.findViewById(R.id.tv_cardView_MOH_editReview);
            ratingBar= (RatingBar) itemView.findViewById(R.id.ratingBar_cardView_MOH_RatingBar);
            ivItemImage= (ImageView) itemView.findViewById(R.id.iv_cardView_MOH_ItemPic);
            layoutReview= (RelativeLayout) itemView.findViewById(R.id.cardView_MOH_relativeViewForReview);

        }
    }
}
