package com.jkt.workdaunzi.adpaters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jkt.workdaunzi.R;
import com.jkt.workdaunzi.ZhiBoActivity;
import com.jkt.workdaunzi.models.LiveModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 天哥哥 on 2016/11/2 0002.
 */

public class LiveFragmentAdapter extends RecyclerView.Adapter {
    public static final int Foor = 1;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<LiveModel.DataBean.ListBean> mListBeanList;
    private int mAllPage;
    private int mCurrentPage;

    public int getAllPage() {
        return mAllPage;
    }

    public void setAllPage(int allPage) {
        mAllPage = allPage;
    }

    public int getCurrentPage() {
        return mCurrentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.mCurrentPage = currentPage;
    }

    public LiveFragmentAdapter(Context context, List<LiveModel.DataBean.ListBean> listBeanList) {
        mContext = context;
        mListBeanList = listBeanList;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == mListBeanList.size()) {
            return Foor;
        }
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == Foor) {
            View inflate = mLayoutInflater.inflate(R.layout.item_more, parent, false);
            return new FoorViewHolder(inflate);
        }
        View inflate = mLayoutInflater.inflate(R.layout.item_live, parent, false);
        return new HotViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position < mListBeanList.size()) {
            HotViewHolder hotViewHolder = (HotViewHolder) holder;
            hotViewHolder.bindView(mListBeanList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mListBeanList.size() + 1;
    }

    public class HotViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final SparseArrayCompat<View> mSparseArrayCompat;
        private String mFlv;

        public HotViewHolder(View itemView) {
            super(itemView);
            mSparseArrayCompat = new SparseArrayCompat<>();
            itemView.setOnClickListener(this);
        }

        void bindView(LiveModel.DataBean.ListBean listBean) {
            mFlv = listBean.getFlv();
            TextView userNameView = (TextView) customFindViewByID(R.id.item_hot_userName);
            TextView addressView = (TextView) customFindViewByID(R.id.item_hot_address);
            TextView viewsView = (TextView) customFindViewByID(R.id.item_hot_views);
            ImageView userIconView = (ImageView) customFindViewByID(R.id.item_hot_userIcon);
            ImageView imageView = (ImageView) customFindViewByID(R.id.item_hot_image);
            if (userNameView != null) {
                userNameView.setText(listBean.getMyname());
            }
            if (addressView != null) {
                addressView.setText(listBean.getGps());
            }
            if (viewsView != null) {
                viewsView.setText(String.valueOf(listBean.getAllnum()) + "在观看");
            }
            if (userIconView != null && listBean.getSmallpic() != null && !"".equals(listBean.getSmallpic())) {
                Picasso.with(mContext).load(listBean.getSmallpic()).fit().into(userIconView);
            }
            if (imageView != null && listBean.getBigpic() != null && !"".equals(listBean.getBigpic())) {
                Picasso.with(mContext).load(listBean.getBigpic()).fit().into(imageView);
            }

        }

        public View customFindViewByID(int resourceID) {
            View ret = null;
            ret = mSparseArrayCompat.get(resourceID);
            if (ret == null) {
                ret = itemView.findViewById(resourceID);
                mSparseArrayCompat.put(resourceID, ret);
            }
            return ret;
        }

        @Override
        public void onClick(View v) {
            if (mFlv != null) {
                Intent intent = new Intent(mContext, ZhiBoActivity.class);
                intent.putExtra("Flv", mFlv);
                mContext.startActivity(intent);
            }
        }
    }

    public class FoorViewHolder extends RecyclerView.ViewHolder {

        public FoorViewHolder(View itemView) {
            super(itemView);
            if (mListBeanList.size() == 0 || mAllPage==mCurrentPage) {
                itemView.setVisibility(View.GONE);
            } else {
                itemView.setVisibility(View.VISIBLE);
            }
        }
    }
}

