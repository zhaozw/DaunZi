package com.jkt.workdaunzi.adpaters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.jkt.workdaunzi.R;
import com.jkt.workdaunzi.models.VideoModel;
import com.jkt.workdaunzi.tool.CustomToast;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 天哥哥 on 2016/11/2 0002.
 */

public class VideoFragmentAdapter extends RecyclerView.Adapter {
    public static final int Foor = 1;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<VideoModel.DataBean.DataBean1> mDataBean1List;
    private ImageView mOutImageView;
    private Bitmap mBitmap;
    private int mPlayPosition;
    private VideoViewHolder mVideoViewHolder;

    public VideoViewHolder getVideoViewHolder() {
        return mVideoViewHolder;
    }


    public VideoFragmentAdapter(Context context, List<VideoModel.DataBean.DataBean1> listBeanList) {
        mContext = context;
        mDataBean1List = listBeanList;
        mLayoutInflater = LayoutInflater.from(context);
        mOutImageView = new ImageView(context);
        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.place);
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
        View inflate = mLayoutInflater.inflate(R.layout.item_video, parent, false);
        return new VideoViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position < mDataBean1List.size()) {
            VideoViewHolder hotViewHolder = (VideoViewHolder) holder;
            hotViewHolder.bindView(mDataBean1List.get(position), position);
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

    public class VideoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {
        private VideoModel.DataBean.DataBean1 mDataBean1;
        private final SparseArrayCompat<View> mSparseArrayCompat;
        private VideoView mVideoView;
        private ImageView mPictureImageView;
        private ImageView mIndicatorImageView;
        private ProgressBar mProgressBar;
        private MediaController mMediaController;
        private TextView mUserNameView;
        private TextView mContentTextView;
        private TextView mDiggTextView;
        private TextView mBuryTextView;
        private TextView mShareTextView;
        private ImageView mDiggImageView;
        private ImageView mBuryImageView;
        private ImageView mShareImageView;
        private LinearLayout mDiggLayout;
        private LinearLayout mBuryLayout;
        private LinearLayout mShareLayout;
        private ImageView mUserIconView;

        public VideoViewHolder(View itemView) {
            super(itemView);
            mSparseArrayCompat = new SparseArrayCompat<>();
            mMediaController = new MediaController(mContext);
        }

        void bindView(VideoModel.DataBean.DataBean1 dataBean1, int position) {
            mDataBean1 = dataBean1;
            initFindView();
            initData(dataBean1);
            initImageState(dataBean1);
            setListeners();

        }

        private void initImageState(VideoModel.DataBean.DataBean1 dataBean1) {
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


        private void initData(VideoModel.DataBean.DataBean1 dataBean1) {
            if (mUserNameView != null && dataBean1 != null && dataBean1.getGroup() != null && dataBean1.getGroup().getUser() != null) {
                mUserNameView.setText(dataBean1.getGroup().getUser().getName());
            }
            if (mContentTextView != null && dataBean1.getGroup() != null) {
                mContentTextView.setText(dataBean1.getGroup().getText());
                if ("".equals(mContentTextView.getText()) || mContentTextView.getText() == null) {
                    mContentTextView.setVisibility(View.GONE);
                }
            }
            if (mUserIconView != null && dataBean1.getGroup() != null && dataBean1.getGroup().getUser() != null && dataBean1.getGroup().getUser().getAvatar_url() != null && !"".equals(dataBean1.getGroup().getUser().getAvatar_url())) {
                Glide.with(mContext).load(dataBean1.getGroup().getUser().getAvatar_url())
                        .into(mUserIconView);
            }
            if (mDiggTextView != null && dataBean1.getGroup() != null) {
                mDiggTextView.setText(String.valueOf(dataBean1.getGroup().getDigg_count()));
            }
            if (mBuryTextView != null && dataBean1.getGroup() != null) {
                mBuryTextView.setText(String.valueOf(dataBean1.getGroup().getBury_count()));
            }
            if (mShareTextView != null && dataBean1.getGroup() != null) {
                mShareTextView.setText(String.valueOf(dataBean1.getGroup().getShare_count()));
            }
            if (mPictureImageView != null && dataBean1.getGroup().getA480p_video() != null && dataBean1.getGroup() != null && dataBean1.getGroup().getMiddlecover() != null && dataBean1.getGroup().getMiddlecover().getUrl_list() != null && dataBean1.getGroup().getMiddlecover().getUrl_list().get(0) != null && dataBean1.getGroup().getMiddlecover().getUrl_list().get(0).getUrl() != null && !"".equals(dataBean1.getGroup().getMiddlecover().getUrl_list().get(0).getUrl() != null)) {
                mPictureImageView.setOnClickListener(this);
                int width = dataBean1.getGroup().getA480p_video().getWidth();
                int height = dataBean1.getGroup().getA480p_video().getHeight();
                Bitmap scaledBitmap = Bitmap.createScaledBitmap(mBitmap, width, height, false);
                mOutImageView.setImageBitmap(scaledBitmap);
                Drawable drawable = mOutImageView.getDrawable();
                Picasso.with(mContext).load(dataBean1.getGroup().getMiddlecover().getUrl_list().get(0).getUrl())
                        .placeholder(drawable)
                        .into(mPictureImageView);
                mPictureImageView.setTag(dataBean1.getGroup().getA480p_video().getUrl_list().get(0).getUrl());

            }
        }

        private void initFindView() {
            mUserNameView = (TextView) itemView.findViewById(R.id.item_video_name);
            mContentTextView = (TextView) customFindViewByID(R.id.item_video_text);
            mDiggTextView = (TextView) customFindViewByID(R.id.item_video_diggText);
            mBuryTextView = (TextView) customFindViewByID(R.id.item_video_buryText);
            mShareTextView = (TextView) customFindViewByID(R.id.item_video_shareText);
            mDiggImageView = (ImageView) customFindViewByID(R.id.item_video_diggImage);
            mBuryImageView = (ImageView) customFindViewByID(R.id.item_video_buryImage);
            mShareImageView = (ImageView) customFindViewByID(R.id.item_video_shareImage);
            mDiggLayout = (LinearLayout) customFindViewByID(R.id.item_video_diggLayout);
            mBuryLayout = (LinearLayout) customFindViewByID(R.id.item_video_buryLayout);
            mShareLayout = (LinearLayout) customFindViewByID(R.id.item_video_shareLayout);
            mVideoView = (VideoView) customFindViewByID(R.id.item_video_video);
            mUserIconView = (ImageView) customFindViewByID(R.id.item_video_icon);
            mPictureImageView = (ImageView) customFindViewByID(R.id.item_video_image);
            mIndicatorImageView = (ImageView) customFindViewByID(R.id.item_video_indicator);
            mProgressBar = (ProgressBar) customFindViewByID(R.id.item_video_progressBar);
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
                case R.id.item_video_diggLayout:
                    if (mDataBean1.isChooseBury() || mDataBean1.isChooseDigg()) {
                        CustomToast.getToast(mContext, "你已经选择过啦~").show();
                        return;
                    }
                    mDataBean1.setChoose(true);
                    mDataBean1.setChooseDigg(true);
                    mDiggTextView.setText(mDataBean1.getGroup().getDigg_count() + 1 + "");
                    mDiggImageView.setImageResource(R.drawable.ic_digg_pressed);
                    break;
                case R.id.item_video_buryLayout:
                    if (mDataBean1.isChooseBury() || mDataBean1.isChooseDigg()) {
                        CustomToast.getToast(mContext, "你已经选择过啦~").show();
                        return;
                    }
                    mDataBean1.setChooseBury(true);
                    mDataBean1.setChoose(true);
                    mBuryTextView.setText(mDataBean1.getGroup().getBury_count() + 1 + "");
                    mBuryImageView.setImageResource(R.drawable.ic_bury_pressed);
                    break;
                case R.id.item_video_shareLayout:
                    mShareImageView.setImageResource(R.drawable.ic_more_action_pressed);
                    mShareTextView.setText(mDataBean1.getGroup().getShare_count() + 1 + "");
                    mDataBean1.setChooseShare(true);
                    mDataBean1.setChoose(true);

                    break;
                case R.id.item_video_image:
                    if (v.getTag() != null && v.getTag() instanceof String) {
                        mVideoViewHolder = this;
                        String tag = (String) v.getTag();
                        mIndicatorImageView.setVisibility(View.INVISIBLE);
                        mProgressBar.setVisibility(View.VISIBLE);
                        mVideoView.setMediaController(mMediaController);
                        mVideoView.setVisibility(View.VISIBLE);
                        mVideoView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, mPictureImageView.getHeight()));
                        mVideoView.setVideoPath(tag);
                        mVideoView.setOnCompletionListener(this);
                        mVideoView.setOnErrorListener(this);
                        mVideoView.setOnPreparedListener(this);
                        mVideoView.start();
                    }
                    break;
            }
        }

        @Override
        public void onPrepared(MediaPlayer mp) {
            mProgressBar.setVisibility(View.INVISIBLE);
            mPictureImageView.setVisibility(View.INVISIBLE);
            mVideoView.setVisibility(View.VISIBLE);
        }

        @Override
        public boolean onError(MediaPlayer mp, int what, int extra) {
            mPictureImageView.setVisibility(View.VISIBLE);
            mIndicatorImageView.setVisibility(View.VISIBLE);
            mProgressBar.setVisibility(View.INVISIBLE);
            mVideoView.setVisibility(View.INVISIBLE);
            mVideoView.stopPlayback();
            return false;
        }

        @Override
        public void onCompletion(MediaPlayer mp) {
            videoReset();
        }

        public void videoReset() {
            mPictureImageView.setVisibility(View.VISIBLE);
            mIndicatorImageView.setVisibility(View.VISIBLE);
            mProgressBar.setVisibility(View.INVISIBLE);
            mVideoView.setVisibility(View.INVISIBLE);
            mVideoView.stopPlayback();
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

