package com.jkt.workdaunzi.adpaters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jkt.workdaunzi.R;
import com.jkt.workdaunzi.models.PictureModel;

import java.util.List;

/**
 * Created by 天哥哥 on 2016/11/2 0002.
 */

public class PictureFragmentAdapter extends RecyclerView.Adapter {
    public static final int Foor = 1;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<PictureModel.DataBean.DataBean1> mDataBean1List;
    private ImageView mImageView;
    private Bitmap mBitmap;

    public PictureFragmentAdapter(Context context, List<PictureModel.DataBean.DataBean1> listBeanList) {
        mContext = context;
        mDataBean1List = listBeanList;
        mLayoutInflater = LayoutInflater.from(context);
        mImageView = new ImageView(context);

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
        View inflate = mLayoutInflater.inflate(R.layout.item_picture, parent, false);
        return new PictureViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position < mDataBean1List.size()) {
            PictureViewHolder hotViewHolder = (PictureViewHolder) holder;
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

    public class PictureViewHolder extends RecyclerView.ViewHolder {
        private final SparseArrayCompat<View> mSparseArrayCompat;

        public PictureViewHolder(View itemView) {
            super(itemView);
            mSparseArrayCompat = new SparseArrayCompat<>();
        }

        void bindView(final PictureModel.DataBean.DataBean1 dataBean1) {
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
            if (pictureImageView != null && dataBean1.getGroup() != null && dataBean1.getGroup().getGifvideo() != null && dataBean1.getGroup().getGifvideo().getA480PVideo() != null && dataBean1.getGroup().getGifvideo().getA480PVideo().getUrl_list() != null && dataBean1.getGroup().getGifvideo().getA480PVideo().getUrl_list().get(0) != null && dataBean1.getGroup().getGifvideo().getA480PVideo().getUrl_list().get(0).getUrl() != null && !"".equals(dataBean1.getGroup().getGifvideo().getA480PVideo().getUrl_list().get(0).getUrl())) {
                if (pictureImageView != null && dataBean1.getGroup() != null && dataBean1.getGroup().getLarge_image() != null && dataBean1.getGroup().getLarge_image().getUrl_list() != null && dataBean1.getGroup().getLarge_image().getUrl_list().get(0) != null && dataBean1.getGroup().getLarge_image().getUrl_list().get(0).getUrl() != null && !"".equals(dataBean1.getGroup().getLarge_image().getUrl_list().get(0).getUrl() != null)) {
                    int width = dataBean1.getGroup().getLarge_image().getWidth();
                    int height = dataBean1.getGroup().getLarge_image().getHeight();
                    Bitmap scaledBitmap = Bitmap.createScaledBitmap(mBitmap, width, height, false);
                    mImageView.setImageBitmap(scaledBitmap);
                    Drawable drawable = mImageView.getDrawable();
//                        if (gifImageView != null) {
//                            gifImageView.setVisibility(View.VISIBLE);
//                        }
//                        Glide.with(mContext)
//                                .load(dataBean1.getGroup().getLarge_image().getUrl_list().get(0).getUrl())
//                                .asGif()
//                                .placeholder(drawable)
//                                .diskCacheStrategy(DiskCacheStrategy.RESULT)
//                                .into(new Target<GifDrawable>() {
//                                    @Override
//                                    public void onLoadStarted(Drawable placeholder) {
////                                        Glide.with(mContext)
////                                                .load(dataBean1.getGroup().getMiddle_image().getUrl_list().get(0).getUrl())
////                                                .asBitmap()
////                                                .placeholder(placeholder)
////                                                .into(pictureImageView);
//
//                                    }
//
//                                    @Override
//                                    public void onLoadFailed(Exception e, Drawable errorDrawable) {
////                                        if (gifImageView != null) {
//                                            gifImageView.setVisibility(View.INVISIBLE);
////                                        }
//                                    }
//
//                                    @Override
//                                    public void onResourceReady(GifDrawable resource, GlideAnimation<? super GifDrawable> glideAnimation) {
////                                        if (gifImageView != null) {
//                                            gifImageView.setVisibility(View.INVISIBLE);
////                                        }
//                                        pictureImageView.setImageDrawable(resource);
//
//                                    }
//
//                                    @Override
//                                    public void onLoadCleared(Drawable placeholder) {
//
//                                    }
//
//                                    @Override
//                                    public void getSize(SizeReadyCallback cb) {
//
//                                    }
//
//                                    @Override
//                                    public void setRequest(Request request) {
//
//                                    }
//
//                                    @Override
//                                    public Request getRequest() {
//                                        return null;
//                                    }
//
//                                    @Override
//                                    public void onStart() {
//
//                                    }
//
//                                    @Override
//                                    public void onStop() {
//
//                                    }
//
//                                    @Override
//                                    public void onDestroy() {
//
//                                    }
//                                });
                    Glide.with(mContext)
                            .load(dataBean1.getGroup().getLarge_image().getUrl_list().get(0).getUrl())
                            .asGif()
                            .placeholder(drawable)
                            .diskCacheStrategy(DiskCacheStrategy.RESULT)
                            .into(pictureImageView);
                    return;
                }
            } else if (pictureImageView != null && dataBean1.getGroup() != null && dataBean1.getGroup().getMiddle_image() != null && dataBean1.getGroup().getMiddle_image().getUrl_list() != null && dataBean1.getGroup().getMiddle_image().getUrl_list().get(0) != null && dataBean1.getGroup().getMiddle_image().getUrl_list().get(0).getUrl() != null && !"".equals(dataBean1.getGroup().getMiddle_image().getUrl_list().get(0).getUrl() != null)) {
                int width = dataBean1.getGroup().getMiddle_image().getWidth();
                int height = dataBean1.getGroup().getMiddle_image().getHeight();
                Bitmap scaledBitmap = Bitmap.createScaledBitmap(mBitmap, width, height, false);
//                if (gifImageView != null) {
//                    gifImageView.setVisibility(View.GONE);
//                }
                mImageView.setImageBitmap(scaledBitmap);
                Drawable drawable = mImageView.getDrawable();
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

