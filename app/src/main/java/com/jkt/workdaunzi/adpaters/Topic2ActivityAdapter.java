package com.jkt.workdaunzi.adpaters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jkt.workdaunzi.DocActivity;
import com.jkt.workdaunzi.R;
import com.jkt.workdaunzi.SlideActivity;
import com.jkt.workdaunzi.models.Topic2Model;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 天哥哥 on 2016/10/30 0030.
 */

public class Topic2ActivityAdapter extends RecyclerView.Adapter {
    private List<Topic2Model.BodyBean.SubjectsBean.PodItemsBean> mPodItemsBeanList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public Topic2ActivityAdapter(List<Topic2Model.BodyBean.SubjectsBean.PodItemsBean> podItemsBeanList, Context context) {
        mPodItemsBeanList = podItemsBeanList;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = mLayoutInflater.inflate(R.layout.item_topic2_detail, parent, false);
        return new Topic2ACViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Topic2ACViewHolder viewHolder = (Topic2ACViewHolder) holder;
        viewHolder.bindView(mPodItemsBeanList.get(position));
    }

    @Override
    public int getItemCount() {
        return mPodItemsBeanList.size();
    }

    public class Topic2ACViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private SparseArrayCompat<View> mSparseArrayCompat;
        public String mUrl;
        public String mType;

        public Topic2ACViewHolder(View itemView) {
            super(itemView);
            mSparseArrayCompat = new SparseArrayCompat<>();
            itemView.setOnClickListener(this);
        }

        public void bindView(Topic2Model.BodyBean.SubjectsBean.PodItemsBean podItemsBean) {
            if (podItemsBean.getLinks() != null && podItemsBean.getLinks().get(0) != null) {
                mUrl = podItemsBean.getLinks().get(0).getUrl();
                mType = podItemsBean.getLinks().get(0).getType();
            }

            ImageView imageView = (ImageView) customFindView(R.id.item_topic2_detail_image);
            if (imageView != null && podItemsBean.getThumbnail() != null && !"".equals(podItemsBean.getThumbnail())) {
                Picasso.with(mContext).load(podItemsBean.getThumbnail()).fit().into(imageView);
            }
            TextView titleView = (TextView) customFindView(R.id.item_topic2_detail_title);
            if (titleView != null) {
                titleView.setText(podItemsBean.getTitle());
            }
            TextView commentView = (TextView) customFindView(R.id.item_topic2_detail_comment);
            if (commentView != null) {
                commentView.setText(String.valueOf(podItemsBean.getCommentCount()));
            }
        }

        public View customFindView(int resourceID) {
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
            if (mUrl != null && !"".equals(mUrl)) {
                int indexOf = mUrl.indexOf('=');
                String substring = mUrl.substring(indexOf + 1);
                Log.i("aa", substring);
                if ("doc".equals(mType)) {
                    Intent intent = new Intent(mContext, DocActivity.class);
                    intent.putExtra("aid", substring);
                    mContext.startActivity(intent);
                } else if ("slide".equals(mType)) {
                    Intent intent = new Intent(mContext, SlideActivity.class);
                    intent.putExtra("aid", substring);
                    mContext.startActivity(intent);
                }
            }
        }
    }
}
