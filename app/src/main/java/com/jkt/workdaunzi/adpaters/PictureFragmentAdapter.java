package com.jkt.workdaunzi.adpaters;

import android.content.Context;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jkt.workdaunzi.R;
import com.jkt.workdaunzi.models.PictureModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 天哥哥 on 2016/11/2 0002.
 */

public class PictureFragmentAdapter extends RecyclerView.Adapter {
    public static final int Foor = 1;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<PictureModel.DataBean.DataBean1> mDataBean1List;

    public PictureFragmentAdapter(Context context, List<PictureModel.DataBean.DataBean1> listBeanList) {
        mContext = context;
        mDataBean1List = listBeanList;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == mDataBean1List.size()) {
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
        View inflate = mLayoutInflater.inflate(R.layout.item_picture, parent, false);
        return new DunZiViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position < mDataBean1List.size()) {
            DunZiViewHolder hotViewHolder = (DunZiViewHolder) holder;
            hotViewHolder.bindView(mDataBean1List.get(position));
        }
        if (position == mDataBean1List.size()) {
            FoorViewHolder foorViewHolder = (FoorViewHolder) holder;
            foorViewHolder.bindView();
        }
    }

    @Override
    public int getItemCount() {
        return mDataBean1List.size() + 1;
    }

    public class DunZiViewHolder extends RecyclerView.ViewHolder {
        private final SparseArrayCompat<View> mSparseArrayCompat;

        public DunZiViewHolder(View itemView) {
            super(itemView);
            mSparseArrayCompat = new SparseArrayCompat<>();
        }

        void bindView(PictureModel.DataBean.DataBean1 dataBean1) {
            TextView userNameView = (TextView) customFindViewByID(R.id.item_picture_name);
            TextView contentTextView = (TextView) customFindViewByID(R.id.item_picture_text);
            ImageView userIconView = (ImageView) customFindViewByID(R.id.item_picture_icon);
            ImageView pictureImageView = (ImageView) customFindViewByID(R.id.item_picture_image);
            if (userNameView != null && dataBean1 != null && dataBean1.getGroup() != null && dataBean1.getGroup().getUser() != null) {
                userNameView.setText(dataBean1.getGroup().getUser().getName());
            }
            if (contentTextView != null && dataBean1.getGroup() != null) {
                contentTextView.setText(dataBean1.getGroup().getText());
                if ("".equals(contentTextView.getText()) || contentTextView.getText() == null) {
                    contentTextView.setVisibility(View.GONE);
                }
            }
            if (userIconView != null && dataBean1.getGroup() != null && dataBean1.getGroup().getUser() != null && dataBean1.getGroup().getUser().getAvatar_url() != null && !"".equals(dataBean1.getGroup().getUser().getAvatar_url())) {
                Picasso.with(mContext).load(dataBean1.getGroup().getUser().getAvatar_url()).fit().into(userIconView);
            }
            if (pictureImageView != null && dataBean1.getGroup() != null && dataBean1.getGroup().getGifvideo() != null && dataBean1.getGroup().getGifvideo().getA480PVideo() != null && dataBean1.getGroup().getGifvideo().getA480PVideo().getUrl_list() != null && dataBean1.getGroup().getGifvideo().getA480PVideo().getUrl_list().get(0) != null && dataBean1.getGroup().getGifvideo().getA480PVideo().getUrl_list().get(0).getUrl() != null && !"".equals(dataBean1.getGroup().getGifvideo().getA480PVideo().getUrl_list().get(0).getUrl())) {
                Picasso.with(mContext).load(dataBean1.getGroup().getGifvideo().getA480PVideo().getUrl_list().get(0).getUrl()).into(pictureImageView);
            } else if (pictureImageView != null && dataBean1.getGroup() != null && dataBean1.getGroup().getLarge_image() != null && dataBean1.getGroup().getLarge_image().getUrl_list() != null && dataBean1.getGroup().getLarge_image().getUrl_list().get(0) != null && dataBean1.getGroup().getLarge_image().getUrl_list().get(0).getUrl() != null && !"".equals(dataBean1.getGroup().getLarge_image().getUrl_list().get(0).getUrl() != null)) {
                Picasso.with(mContext).load(dataBean1.getGroup().getLarge_image().getUrl_list().get(0).getUrl()).into(pictureImageView);
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

    }

    public class FoorViewHolder extends RecyclerView.ViewHolder {

        private final TextView mFinishTextView;
        private final TextView mTextView;
        private final ProgressBar mProgressBar;

        public FoorViewHolder(View itemView) {
            super(itemView);
            mFinishTextView = ((TextView) itemView.findViewById(R.id.item_more_finishTextView));
            mTextView = ((TextView) itemView.findViewById(R.id.item_more_textView));
            mProgressBar = ((ProgressBar) itemView.findViewById(R.id.item_more_progressBar));
        }

        private void bindView() {
            if (mDataBean1List.size() == 0) {
                itemView.setVisibility(View.GONE);
            } else {
                itemView.setVisibility(View.VISIBLE);
                mFinishTextView.setVisibility(View.GONE);
                mTextView.setVisibility(View.VISIBLE);
                mProgressBar.setVisibility(View.VISIBLE);
            }
        }
    }
}

