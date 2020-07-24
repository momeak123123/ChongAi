package com.example.chongai.app.adapter;

import android.view.View;

import com.example.chongai.app.R;
import com.example.chongai.app.bean.CustomBean;
import com.example.chongai.app.holder.NetViewHolder;
import com.zhpan.bannerview.BaseBannerAdapter;
import com.zhpan.bannerview.BaseViewHolder;

class BannerAdapter extends BaseBannerAdapter<String, NetViewHolder> {

    @Override
    public NetViewHolder createViewHolder(View itemView, int viewType) {
        return new NetViewHolder(itemView);
    }

    @Override
    protected void onBind(NetViewHolder holder, String data, int position, int pageSize) {
        holder.bindData(data, position, pageSize);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.item_net;
    }
}
