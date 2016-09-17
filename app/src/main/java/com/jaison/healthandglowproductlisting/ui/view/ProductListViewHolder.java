package com.jaison.healthandglowproductlisting.ui.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jaison.healthandglowproductlisting.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Jaison on 17/09/16.
 */
public class ProductListViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.productImage)
    ImageView productImage;
    @Bind(R.id.productName)
    TextView productName;
    @Bind(R.id.discountedPrice)
    TextView discountedPrice;
    @Bind(R.id.originalPrice)
    TextView originalPrice;
    @Bind(R.id.ratingStar)
    ImageView ratingStar;
    @Bind(R.id.productRating)
    TextView productRating;
    @Bind(R.id.productRatingLayout)
    LinearLayout productRatingLayout;
    @Bind(R.id.productPriceLayout)
    LinearLayout productPriceLayout;
    @Bind(R.id.productDetailsLayout)
    LinearLayout productDetailsLayout;
    @Bind(R.id.offerTextView)
    TextView offerTextView;
    @Bind(R.id.wishlistImageView)
    ImageView wishlistImageView;
    @Bind(R.id.bannerLayout)
    LinearLayout bannerLayout;
    @Bind(R.id.leftVerticalLine)
    LinearLayout leftVerticalLine;
    @Bind(R.id.rightVerticalLine)
    LinearLayout rightVerticalLine;
    @Bind(R.id.bottomHorizontalLine)
    FrameLayout bottomVerticalLine;

    public ProductListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
