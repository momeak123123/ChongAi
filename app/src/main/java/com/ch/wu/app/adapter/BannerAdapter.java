package com.ch.wu.app.adapter;

import android.view.View;

import com.ch.wu.app.R;
import com.ch.wu.app.holder.NetViewHolder;
import com.zhpan.bannerview.BaseBannerAdapter;

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
