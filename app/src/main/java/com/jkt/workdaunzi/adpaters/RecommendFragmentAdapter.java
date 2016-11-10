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
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jkt.workdaunzi.R;
import com.jkt.workdaunzi.models.RecommendModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 天哥哥 on 2016/11/2 0002.
 */

public class RecommendFragmentAdapter extends RecyclerView.Adapter {
    public static final int Foor = 1;
    public static final int VIDEO = 2;
    public static final int PICTURE = 3;

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<RecommendModel.DataBean.DataBean1> mDataBean1List;
    private ImageView mOutImageView;
    private Bitmap mBitmap;
    private VideoViewHolder mVideoViewHolder;

    public VideoViewHolder getVideoViewHolder() {
        return mVideoViewHolder;
    }

    public RecommendFragmentAdapter(Context context, List<RecommendModel.DataBean.DataBean1> listBeanList) {
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
        if (mDataBean1List.get(position) != null && mDataBean1List.get(position).getGroup() != null && mDataBean1List.get(position).getGroup().getA480p_video() != null && mDataBean1List.get(position).getGroup().getA480p_video().getUri() != null) {
            return VIDEO;
        }
        return PICTURE;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == Foor) {
            View inflate = mLayoutInflater.inflate(R.layout.item_more, parent, false);
            return new FoorViewHolder(inflate);
        }
        if (viewType == VIDEO) {
            View inflate = mLayoutInflater.inflate(R.layout.item_video, parent, false);
            return new VideoViewHolder(inflate);
        }
        View inflate = mLayoutInflater.inflate(R.layout.item_picture, parent, false);
        return new PictureViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position < mDataBean1List.size() && holder instanceof VideoViewHolder) {
            VideoViewHolder hotViewHolder = (VideoViewHolder) holder;
            hotViewHolder.bindView(mDataBean1List.get(position));
            return;
        }
        if (position < mDataBean1List.size() && holder instanceof PictureViewHolder) {
            PictureViewHolder pictureViewHolder = (PictureViewHolder) holder;
            pictureViewHolder.bindView(mDataBean1List.get(position));
            return;
        }
        if (position == mDataBean1List.size()) {
            FoorViewHolder foorViewHolder = (FoorViewHolder) holder;
            foorViewHolder.bindView();
            return;
        }
    }

    @Override
    public int getItemCount() {
        return mDataBean1List.size() + 1;
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {
        private final SparseArrayCompat<View> mSparseArrayCompat;
        private VideoView mVideoView;
        private ImageView mPictureImageView;
        private ImageView mIndicatorImageView;
        private ProgressBar mProgressBar;
        private MediaController mMediaController;

        public VideoViewHolder(View itemView) {
            super(itemView);
            mMediaController = new MediaController(mContext);
            mSparseArrayCompat = new SparseArrayCompat<>();
        }

        void bindView(RecommendModel.DataBean.DataBean1 dataBean1) {
            TextView userNameView = (TextView) customFindViewByID(R.id.item_video_name);
            TextView contentTextView = (TextView) customFindViewByID(R.id.item_video_text);
            TextView diggTextView = (TextView) customFindViewByID(R.id.item_video_diggText);
            TextView buryTextView = (TextView) customFindViewByID(R.id.item_video_buryText);
            TextView shareTextView = (TextView) customFindViewByID(R.id.item_video_shareText);
            ImageView diggImageView = (ImageView) customFindViewByID(R.id.item_video_diggImage);
            ImageView buryImageView = (ImageView) customFindViewByID(R.id.item_video_buryImage);
            ImageView shareImageView = (ImageView) customFindViewByID(R.id.item_video_shareImage);
            mVideoView = (VideoView) customFindViewByID(R.id.item_video_video);
            ImageView userIconView = (ImageView) customFindViewByID(R.id.item_video_icon);
            mPictureImageView = (ImageView) customFindViewByID(R.id.item_video_image);
            mIndicatorImageView = (ImageView) customFindViewByID(R.id.item_video_indicator);
            mProgressBar = (ProgressBar) customFindViewByID(R.id.item_video_progressBar);
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
                Glide.with(mContext).load(dataBean1.getGroup().getUser().getAvatar_url())
                        .into(userIconView);
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
            if (mPictureImageView != null && dataBean1.getGroup().getA480p_video() != null && dataBean1.getGroup() != null && dataBean1.getGroup().getMiddleCover() != null && dataBean1.getGroup().getMiddleCover().getUrl_list() != null && dataBean1.getGroup().getMiddleCover().getUrl_list().get(0) != null && dataBean1.getGroup().getMiddleCover().getUrl_list().get(0).getUrl() != null && !"".equals(dataBean1.getGroup().getMiddleCover().getUrl_list().get(0).getUrl() != null)) {
                mPictureImageView.setOnClickListener(this);
                int width = dataBean1.getGroup().getA480p_video().getWidth();
                int height = dataBean1.getGroup().getA480p_video().getHeight();
                Bitmap scaledBitmap = Bitmap.createScaledBitmap(mBitmap, width, height, false);
                mOutImageView.setImageBitmap(scaledBitmap);
                Drawable drawable = mOutImageView.getDrawable();
                Picasso.with(mContext).load(dataBean1.getGroup().getMiddleCover().getUrl_list().get(0).getUrl())
                        .placeholder(drawable)
                        .into(mPictureImageView);
                mPictureImageView.setTag(dataBean1.getGroup().getMp4_url());
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
            if (v.getTag() != null && v.getTag() instanceof String) {
                mVideoViewHolder = this;
                String tag = (String) v.getTag();
                mIndicatorImageView.setVisibility(View.INVISIBLE);
                mProgressBar.setVisibility(View.VISIBLE);
                mVideoView.setVisibility(View.VISIBLE);
                mVideoView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, mPictureImageView.getHeight()));
                mVideoView.setMediaController(mMediaController);
                mVideoView.setVideoPath(tag);
                mVideoView.setOnCompletionListener(this);
                mVideoView.setOnErrorListener(this);
                mVideoView.setOnPreparedListener(this);
                mVideoView.start();
            }
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
        public void onPrepared(MediaPlayer mp) {
            mProgressBar.setVisibility(View.INVISIBLE);
            mPictureImageView.setVisibility(View.INVISIBLE);
            mVideoView.setVisibility(View.VISIBLE);
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

    public class PictureViewHolder extends RecyclerView.ViewHolder {
        private final SparseArrayCompat<View> mSparseArrayCompat;

        public PictureViewHolder(View itemView) {
            super(itemView);
            mSparseArrayCompat = new SparseArrayCompat<>();
        }

        void bindView(RecommendModel.DataBean.DataBean1 dataBean1) {
            TextView userNameView = (TextView) customFindViewByID(R.id.item_picture_name);
            TextView contentTextView = (TextView) customFindViewByID(R.id.item_picture_text);
            ImageView userIconView = (ImageView) customFindViewByID(R.id.item_picture_icon);
            TextView diggTextView = (TextView) customFindViewByID(R.id.item_picture_diggText);
            TextView buryTextView = (TextView) customFindViewByID(R.id.item_picture_buryText);
            TextView shareTextView = (TextView) customFindViewByID(R.id.item_picture_shareText);
            ImageView diggImageView = (ImageView) customFindViewByID(R.id.item_picture_diggImage);
            ImageView buryImageView = (ImageView) customFindViewByID(R.id.item_picture_buryImage);
            ImageView shareImageView = (ImageView) customFindViewByID(R.id.item_picture_shareImage);
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
                Glide.with(mContext).load(dataBean1.getGroup().getUser().getAvatar_url())
                        .into(userIconView);
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
            if (pictureImageView != null && dataBean1.getGroup() != null && dataBean1.getGroup().getGifvideo() != null && dataBean1.getGroup().getGifvideo().getB480p_video() != null && dataBean1.getGroup().getGifvideo().getB480p_video().getUrl_list() != null && dataBean1.getGroup().getGifvideo().getB480p_video().getUrl_list().get(0) != null && dataBean1.getGroup().getGifvideo().getB480p_video().getUrl_list().get(0).getUrl() != null && !"".equals(dataBean1.getGroup().getGifvideo().getB480p_video().getUrl_list().get(0).getUrl())) {
                if (pictureImageView != null && dataBean1.getGroup() != null && dataBean1.getGroup().getLargeImage() != null && dataBean1.getGroup().getLargeImage().getUrl_list() != null && dataBean1.getGroup().getLargeImage().getUrl_list().get(0) != null && dataBean1.getGroup().getLargeImage().getUrl_list().get(0).getUrl() != null && !"".equals(dataBean1.getGroup().getLargeImage().getUrl_list().get(0).getUrl() != null)) {
                    if (pictureImageView != null && dataBean1.getGroup() != null && dataBean1.getGroup().getMiddle_image() != null && dataBean1.getGroup().getMiddle_image().getUrl_list() != null && dataBean1.getGroup().getMiddle_image().getUrl_list().get(0) != null && dataBean1.getGroup().getMiddle_image().getUrl_list().get(0).getUrl() != null && !"".equals(dataBean1.getGroup().getMiddle_image().getUrl_list().get(0).getUrl() != null)) {
                        int width = dataBean1.getGroup().getLargeImage().getWidth();
                        int height = dataBean1.getGroup().getLargeImage().getHeight();
                        Bitmap scaledBitmap = Bitmap.createScaledBitmap(mBitmap, width, height, false);
                        mOutImageView.setImageBitmap(scaledBitmap);
                        Drawable drawable = mOutImageView.getDrawable();
                        Glide.with(mContext)
                                .load(dataBean1.getGroup().getLargeImage().getUrl_list().get(0).getUrl())
                                .asGif()
                                .placeholder(drawable)
                                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                                .into(pictureImageView);
                        return;
                    }
                }
            } else if (pictureImageView != null && dataBean1.getGroup() != null && dataBean1.getGroup().getMiddle_image() != null && dataBean1.getGroup().getMiddle_image().getUrl_list() != null && dataBean1.getGroup().getMiddle_image().getUrl_list().get(0) != null && dataBean1.getGroup().getMiddle_image().getUrl_list().get(0).getUrl() != null && !"".equals(dataBean1.getGroup().getMiddle_image().getUrl_list().get(0).getUrl() != null)) {
                int width = dataBean1.getGroup().getMiddle_image().getWidth();
                int height = dataBean1.getGroup().getMiddle_image().getHeight();
                Bitmap scaledBitmap = Bitmap.createScaledBitmap(mBitmap, width, height, false);
                mOutImageView.setImageBitmap(scaledBitmap);
                Drawable drawable = mOutImageView.getDrawable();
                Glide.with(mContext)
                        .load(dataBean1.getGroup().getMiddle_image().getUrl_list().get(0).getUrl())
                        .placeholder(drawable)
                        .diskCacheStrategy(DiskCacheStrategy.RESULT)
                        .into(pictureImageView);
                return;
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
}

