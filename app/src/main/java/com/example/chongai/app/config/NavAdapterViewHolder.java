package com.example.chongai.app.config;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.chongai.app.R;
import com.example.chongai.app.bean.Nav;
import com.zaaach.transformerslayout.holder.Holder;

import java.util.List;


public class NavAdapterViewHolder extends Holder<Nav> {
    private ImageView icon;
    private TextView text;

   public NavAdapterViewHolder( View itemView) {
        super(itemView);
    }

    @Override
    protected void initView(View itemView) {
        icon = itemView.findViewById(R.id.iv_menu_icon);
        text = itemView.findViewById(R.id.tv_menu_text);
    }

    @Override
    public void onBind(Context context, List<Nav> list, Nav data, int position) {
        text.setText(data.getText());
        Glide.with(context)
                .asBitmap()
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.default_place_holder)
                .load(data.getUrl())
                .into(icon);
    }

}