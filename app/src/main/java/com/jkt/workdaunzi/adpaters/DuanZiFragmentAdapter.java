package com.jkt.workdaunzi.adpaters;

import android.content.Context;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jkt.workdaunzi.R;
import com.jkt.workdaunzi.models.DuanziModel;
import com.jkt.workdaunzi.tool.CustomToast;

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

    public class DunZiViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final SparseArrayCompat<View> mSparseArrayCompat;
        private ImageView mDiggImageView;
        private ImageView mBuryImageView;
        private ImageView mShareImageView;
        private DuanziModel.DataBean.DataBean1 mDataBean1;
        private TextView mBuryTextView;
        private TextView mDiggTextView;
        private TextView mShareTextView;
        private LinearLayout mDiggLayout;
        private LinearLayout mBuryLayout;
        private LinearLayout mShareLayout;
        private TextView mUserNameView;
        private TextView mContentTextView;
        private ImageView mUserIconView;

        public DunZiViewHolder(View itemView) {
            super(itemView);
            mSparseArrayCompat = new SparseArrayCompat<>();
        }

        void bindView(DuanziModel.DataBean.DataBean1 dataBean1) {
            mDataBean1 = dataBean1;
            initFindView();
            initData(dataBean1);
            initImageState(dataBean1);
            setListeners();
        }

        private void initFindView() {
            mUserNameView = (TextView) customFindViewByID(R.id.item_duanzi_text_name);
            mContentTextView = (TextView) customFindViewByID(R.id.item_duanzi_text_text);
            mUserIconView = (ImageView) customFindViewByID(R.id.item_duanzi_text_icon);
            mDiggTextView = (TextView) customFindViewByID(R.id.item_duanzi_diggText);
            mBuryTextView = (TextView) customFindViewByID(R.id.item_duanzi_buryText);
            mShareTextView = (TextView) customFindViewByID(R.id.item_duanzi_shareText);
            mDiggImageView = (ImageView) customFindViewByID(R.id.item_duanzi_diggImage);
            mBuryImageView = (ImageView) customFindViewByID(R.id.item_duanzi_buryImage);
            mShareImageView = (ImageView) customFindViewByID(R.id.item_duanzi_shareImage);
            mDiggLayout = (LinearLayout) customFindViewByID(R.id.item_duanzi_diggLayout);
            mBuryLayout = (LinearLayout) customFindViewByID(R.id.item_duanzi_buryLayout);
            mShareLayout = (LinearLayout) customFindViewByID(R.id.item_duanzi_shareLayout);
        }

        private void initImageState(DuanziModel.DataBean.DataBean1 dataBean1) {
            if (!dataBean1.isChoose()) {
                mDiggImageView.setImageResource(R.drawable.ic_digg_normal);
                mBuryImageView.setImageResource(R.drawable.ic_bury_normal);
                mShareImageView.setImageResource(R.drawable.ic_more_action_normal);
                return;
            }
            if (dataBean1.isChooseShare()) {
                mShareTextView.setText(mDataBean1.getGroup().getShare_count() + 1 + "");
                mShareImageView.setImageResource(R.drawable.ic_more_action_pressed);
            }
            if (dataBean1.isChooseDigg()) {
                mDiggTextView.setText(mDataBean1.getGroup().getDigg_count() + 1 + "");
                mDiggImageView.setImageResource(R.drawable.ic_digg_pressed);
                return;
            }
            if (dataBean1.isChooseBury()) {
                mBuryTextView.setText(mDataBean1.getGroup().getBury_count() + 1 + "");
                mBuryImageView.setImageResource(R.drawable.ic_bury_pressed);
            }

        }

        private void setListeners() {
            mDiggLayout.setOnClickListener(this);
            mBuryLayout.setOnClickListener(this);
            mShareLayout.setOnClickListener(this);
        }

        private void initData(DuanziModel.DataBean.DataBean1 dataBean1) {
            try {
                mUserNameView.setText(dataBean1.getGroup().getUser().getName());
                mContentTextView.setText(dataBean1.getGroup().getText());
                mDiggTextView.setText(String.valueOf(dataBean1.getGroup().getDigg_count()));
                mBuryTextView.setText(String.valueOf(dataBean1.getGroup().getBury_count()));
                mShareTextView.setText(String.valueOf(dataBean1.getGroup().getShare_count()));
                Glide.with(mContext).load(dataBean1.getGroup().getUser().getAvatar_url()).into(mUserIconView);
            } catch (Exception e) {

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
            switch (v.getId()) {
                case R.id.item_duanzi_diggLayout:
                    if (mDataBean1.isChooseBury() || mDataBean1.isChooseDigg()) {
                        CustomToast.getToast(mContext, "你已经选择过啦~").show();
                        return;
                    }
                    mDataBean1.setChoose(true);
                    mDataBean1.setChooseDigg(true);
                    mDiggTextView.setText(mDataBean1.getGroup().getDigg_count() + 1 + "");
                    mDiggImageView.setImageResource(R.drawable.ic_digg_pressed);
                    break;
                case R.id.item_duanzi_buryLayout:
                    if (mDataBean1.isChooseBury() || mDataBean1.isChooseDigg()) {
                        CustomToast.getToast(mContext, "你已经选择过啦~").show();
                        return;
                    }
                    mDataBean1.setChooseBury(true);
                    mDataBean1.setChoose(true);
                    mBuryTextView.setText(mDataBean1.getGroup().getBury_count() + 1 + "");
                    mBuryImageView.setImageResource(R.drawable.ic_bury_pressed);
                    break;
                case R.id.item_duanzi_shareLayout:
                    mShareImageView.setImageResource(R.drawable.ic_more_action_pressed);
                    mShareTextView.setText(mDataBean1.getGroup().getShare_count() + 1 + "");
                    mDataBean1.setChooseShare(true);
                    mDataBean1.setChoose(true);

                    break;

            }
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

