package com.jaison.healthandglowproductlisting.ui.view;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jaison.healthandglowproductlisting.R;
import com.jaison.healthandglowproductlisting.model.Response.SkuItemData;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Jaison on 17/09/16.
 */
public class ProductListAdapter extends RecyclerView.Adapter<ProductListViewHolder> {

    List<SkuItemData> data;
    Context context;

    @Override
    public ProductListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        return new ProductListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_product, parent, false));
    }

    @Override
    public void onBindViewHolder(final ProductListViewHolder holder, int position) {
        SkuItemData itemData = data.get(position);

        Glide.with(context)
                .load(itemData.getSkuImageUrls().get(0))
                .placeholder(R.drawable.placeholder_product)
                .into(holder.productImage);

        String[] strArray = itemData.getSkuName().split(" ");
        String itemName = "";
        for (String s : strArray) {
            String cap = s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
            itemName = itemName.concat(cap + " ");
        }
        holder.productName.setText(itemName);

        holder.discountedPrice.setText("Rs ".concat(itemData.getSkuOfferPrice()));
        holder.originalPrice.setText("Rs ".concat(itemData.getSkuPrice()));
        holder.originalPrice.setPaintFlags(holder.originalPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        if (itemData.getSkuAverageRating() != null) {
            holder.productRatingLayout.setVisibility(View.VISIBLE);
            holder.productRating.setText(itemData.getSkuAverageRating());
            holder.ratingStar.setColorFilter(ContextCompat.getColor(context,R.color.colorAccent), PorterDuff.Mode.SRC_IN);
        } else {
            holder.productRatingLayout.setVisibility(View.GONE);
        }

        holder.leftVerticalLine.setVisibility(View.VISIBLE);
        holder.rightVerticalLine.setVisibility(View.VISIBLE);
        holder.bottomVerticalLine.setVisibility(View.VISIBLE);

        if (position % 2 == 0) {
            holder.leftVerticalLine.setVisibility(View.INVISIBLE);
        } else {
            holder.rightVerticalLine.setVisibility(View.INVISIBLE);
        }

        //WishList icon
        holder.wishlistImageView.setColorFilter(ContextCompat.getColor(context,R.color.red1), PorterDuff.Mode.SRC_IN);
        holder.wishlistImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Change to a filled color
                holder.wishlistImageView.setColorFilter(ContextCompat.getColor(context,R.color.red1), PorterDuff.Mode.SRC_IN);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (data == null)
            return 0;
        return data.size();
    }

    public void setData(List<SkuItemData> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void addData(List<SkuItemData> moreData) {
        int insertStart = this.data.size();
        this.data.addAll(moreData);
        notifyItemRangeInserted(insertStart, moreData.size());
    }
}
