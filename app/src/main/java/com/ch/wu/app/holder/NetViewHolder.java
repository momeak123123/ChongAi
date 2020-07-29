package com.ch.wu.app.holder;

import android.view.View;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.ch.wu.app.R;
import com.ch.wu.app.view.CornerImageView;
import com.zhpan.bannerview.BaseViewHolder;
import com.zhpan.bannerview.utils.BannerUtils;

public class NetViewHolder extends BaseViewHolder<String> {

    public NetViewHolder(@NonNull View itemView) {
        super(itemView);
        CornerImageView imageView = findView(R.id.banner_image);
        imageView.setRoundCorner(BannerUtils.dp2px(0));
    }

    @Override
    public void bindData(String data, int position, int pageSize) {
        CornerImageView imageView = findView(R.id.banner_image);
        Glide.with(imageView).load(data).placeholder(R.drawable.banner).into(imageView);


    }
}
