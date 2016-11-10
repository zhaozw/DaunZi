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

import com.bumptech.glide.Glide;
import com.jkt.workdaunzi.R;
import com.jkt.workdaunzi.models.DuanziModel;

import java.util.List;

/**
 * Created by 天哥哥 on 2016/11/2 0002.
 */

public class DuanziFragmentAdapter extends RecyclerView.Adapter {
    public static final int Foor = 1;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<DuanziModel.DataBean.DataBean1> mDataBean1List;

    public DuanziFragmentAdapter(Context context, List<DuanziModel.DataBean.DataBean1> listBeanList) {
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
        View inflate = mLayoutInflater.inflate(R.layout.item_duanzi, parent, false);
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

        void bindView(DuanziModel.DataBean.DataBean1 dataBean1) {
            TextView userNameView = (TextView) customFindViewByID(R.id.item_duanzi_text_name);
            TextView contentTextView = (TextView) customFindViewByID(R.id.item_duanzi_text_text);
            ImageView userIconView = (ImageView) customFindViewByID(R.id.item_duanzi_text_icon);
            TextView diggTextView = (TextView) customFindViewByID(R.id.item_duanzi_diggText);
            TextView buryTextView = (TextView) customFindViewByID(R.id.item_duanzi_buryText);
            TextView shareTextView = (TextView) customFindViewByID(R.id.item_duanzi_shareText);
            ImageView diggImageView = (ImageView) customFindViewByID(R.id.item_duanzi_diggImage);
            ImageView buryImageView = (ImageView) customFindViewByID(R.id.item_duanzi_buryImage);
            ImageView shareImageView = (ImageView) customFindViewByID(R.id.item_duanzi_shareImage);
            if (userNameView != null && dataBean1 != null && dataBean1.getGroup() != null && dataBean1.getGroup().getUser() != null) {
                userNameView.setText(dataBean1.getGroup().getUser().getName());
            }
            if (contentTextView != null && dataBean1.getGroup() != null) {
                contentTextView.setText(dataBean1.getGroup().getText());
            }
            if (diggTextView != null && dataBean1.getGroup() != null) {
                diggTextView.setText(String.valueOf(dataBean1.getGroup().getDigg_count()));
            }
            if (buryTextView != null && dataBean1.getGroup() != null) {
                buryTextView.setText(String.valueOf(dataBean1.getGroup().getBury_count()));
            }
            if (shareTextView != null && dataBean1.getGroup() != null) {
                shareTextView.setText(String.valueOf(dataBean1.getGroup().getShare_count()));
            }
            if (userIconView != null && dataBean1.getGroup() != null && dataBean1.getGroup().getUser() != null && dataBean1.getGroup().getUser().getAvatar_url() != null && !"".equals(dataBean1.getGroup().getUser().getAvatar_url())) {
                Glide.with(mContext).load(dataBean1.getGroup().getUser().getAvatar_url()).into(userIconView);
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
                mTextView.setVisibility(View.VISIBLE);
                mProgressBar.setVisibility(View.VISIBLE);
                mFinishTextView.setVisibility(View.GONE);
            }
        }
    }
}

