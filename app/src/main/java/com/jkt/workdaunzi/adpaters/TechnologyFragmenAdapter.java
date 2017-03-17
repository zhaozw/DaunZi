package com.jkt.workdaunzi.adpaters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jkt.workdaunzi.DocActivity;
import com.jkt.workdaunzi.R;
import com.jkt.workdaunzi.SlideActivity;
import com.jkt.workdaunzi.Topic2Activity;
import com.jkt.workdaunzi.models.TechnologyModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 天哥哥 on 2016/10/25 0025.
 */

public class TechnologyFragmenAdapter extends RecyclerView.Adapter {
    public List<TechnologyModel.ItemBean> mItemBeanList;
    public Context mContext;
    public static final int TOPIC2 = 1;
    public static final int DOC = 2;
    public static final int SLIDE = 3;
    public LayoutInflater mLayoutInflater;

    public TechnologyFragmenAdapter(List<TechnologyModel.ItemBean> itemBeanList, Context context) {
        mItemBeanList = itemBeanList;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        String type = mItemBeanList.get(position).getType();
        if (type == null) {
            return -1;
        }
        switch (type) {
            case "doc":
                return DOC;
            case "slide":
                return SLIDE;
            case "topic2":
                return TOPIC2;
        }
        return -1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case DOC:
                View docInflate = LayoutInflater.from(mContext).inflate(R.layout.item_doc, parent, false);
                return new DocViewHolder(docInflate);
            case SLIDE:
                View slideInflate = LayoutInflater.from(mContext).inflate(R.layout.item_slide, parent, false);
                return new SlideViewHolder(slideInflate);
            case TOPIC2:
                View topic2Inflate = LayoutInflater.from(mContext).inflate(R.layout.item_topic2, parent, false);
                return new Topic2ViewHolder(topic2Inflate);
        }
        View docInflate = LayoutInflater.from(mContext).inflate(R.layout.item_doc, parent, false);
        return new DocViewHolder(docInflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof DocViewHolder) {
            DocViewHolder docViewHolder = (DocViewHolder) holder;
            docViewHolder.bindView(mItemBeanList.get(position));
        } else if (holder instanceof SlideViewHolder) {
            SlideViewHolder slideViewHolder = (SlideViewHolder) holder;
            slideViewHolder.bindView(mItemBeanList.get(position));
        } else if (holder instanceof Topic2ViewHolder) {
            Topic2ViewHolder topic2ViewHolder = (Topic2ViewHolder) holder;
            topic2ViewHolder.bindView(mItemBeanList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mItemBeanList.size();
    }

    public class DocViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private SparseArrayCompat<View> mSparseArrayCompat;
        private String mDocumentId;

        public DocViewHolder(View itemView) {
            super(itemView);
            mSparseArrayCompat = new SparseArrayCompat<>();
            itemView.setOnClickListener(this);
        }

        public void bindView(TechnologyModel.ItemBean itemBean) {
            mDocumentId = itemBean.getDocumentId();
            ImageView imageView = (ImageView) customFindView(R.id.item_doc_image);
            String path = itemBean.getThumbnail();
            if (imageView != null && path != null && !"".equals(path)) {
                Picasso.with(mContext).load(path).fit().into(imageView);
            }
            TextView titleView = (TextView) customFindView(R.id.item_doc_title);
            if (titleView != null) {
                titleView.setText(itemBean.getTitle());
            }
            TextView timeView = (TextView) customFindView(R.id.item_doc_time);
            if (timeView != null) {
                String updateTime = itemBean.getUpdateTime();
                if (updateTime != null && updateTime.length() >= 9) {

                    String substring = updateTime.substring(updateTime.length() - 9);
                    timeView.setText(substring);
                }
            }
            TextView commentView = (TextView) customFindView(R.id.item_doc_comment);
            if (commentView != null) {
                commentView.setText(itemBean.getCommentsall());
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
            if (mDocumentId != null && !"".equals(mDocumentId)) {
                Intent intent = new Intent(mContext, DocActivity.class);
                intent.putExtra("aid", mDocumentId);
                mContext.startActivity(intent);
            }
        }
    }

    public class SlideViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private SparseArrayCompat<View> mSparseArrayCompat;
        private String mDocumentId;

        public SlideViewHolder(View itemView) {
            super(itemView);
            mSparseArrayCompat = new SparseArrayCompat<>();
            itemView.setOnClickListener(this);
        }

        public void bindView(TechnologyModel.ItemBean itemBean) {
            mDocumentId = itemBean.getDocumentId();
            List<String> images = itemBean.getStyle().getImages();
            if (images != null) {
                int size = images.size();
                ImageView imageView = (ImageView) customFindView(R.id.item_slide_image);
                String path = images.get(0);
                if (size >= 1) {

                    if (imageView != null && path != null && !"".equals(path)) {
                        Picasso.with(mContext).load(path)
                                .fit().into(imageView);
                    }
                }
                ImageView imageView1 = (ImageView) customFindView(R.id.item_slide_image1);
                if (size >= 2) {
                    String path1 = images.get(1);
                    if (imageView1 != null && path1 != null && !"".equals(path1)) {
                        Picasso.with(mContext).load(path1)
                                .fit().into(imageView1);
                    }
                }
                ImageView imageView2 = (ImageView) customFindView(R.id.item_slide_image2);
                if (size >= 3) {
                    String path2 = images.get(2);
                    if (imageView2 != null && path2 != null && !"".equals(path2)) {
                        Picasso.with(mContext).load(path2)
                                .fit().into(imageView2);
                    }
                }
            }
            TextView titleView = (TextView) customFindView(R.id.item_slide_title);
            if (titleView != null) {
                titleView.setText(itemBean.getTitle());
            }
            TextView timeView = (TextView) customFindView(R.id.item_slide_time);
            if (timeView != null) {
                String updateTime = itemBean.getUpdateTime();
                String substring = updateTime.substring(updateTime.length() - 9);
                timeView.setText(substring);
            }
            TextView commentView = (TextView) customFindView(R.id.item_slide_comment);
            if (commentView != null) {
                commentView.setText(itemBean.getCommentsall());
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
            if (mDocumentId != null && !"".equals(mDocumentId)) {
                Intent intent = new Intent(mContext, SlideActivity.class);
                intent.putExtra("aid", mDocumentId);
                mContext.startActivity(intent);
            }
        }
    }

    public class Topic2ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private SparseArrayCompat<View> mSparseArrayCompat;
        private String mId;

        public Topic2ViewHolder(View itemView) {
            super(itemView);
            mSparseArrayCompat = new SparseArrayCompat<>();
            itemView.setOnClickListener(this);
        }

        public void bindView(TechnologyModel.ItemBean itemBean) {
            mId = itemBean.getId();
            ImageView imageView = (ImageView) customFindView(R.id.item_topic2_image);
            String path = itemBean.getThumbnail();
            if (imageView != null && path != null && !"".equals(path)) {
                Picasso.with(mContext).load(path)
                        .fit().into(imageView);
            }
            TextView titleView = (TextView) customFindView(R.id.item_topic2_title);
            if (titleView != null) {
                titleView.setText(itemBean.getTitle());
            }
            TextView timeView = (TextView) customFindView(R.id.item_topic2_detail_time);
            if (timeView != null) {
                timeView.setTextColor(Color.RED);
                timeView.setText("专题");
            }
            TextView commentView = (TextView) customFindView(R.id.item_topic2_comment);
            if (commentView != null) {
                commentView.setText(itemBean.getCommentsall());
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
            if (mId != null && !"".equals(mId)) {
                Intent intent = new Intent(mContext, Topic2Activity.class);
                intent.putExtra("id", mId);
                mContext.startActivity(intent);
            }
        }
    }
}
