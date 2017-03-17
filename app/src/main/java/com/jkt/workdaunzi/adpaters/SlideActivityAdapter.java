package com.jkt.workdaunzi.adpaters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jkt.workdaunzi.R;
import com.jkt.workdaunzi.SlideActivity;
import com.jkt.workdaunzi.models.SlideModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 天哥哥 on 2016/10/29 0029.
 */

public class SlideActivityAdapter extends PagerAdapter implements View.OnClickListener {
    private int mPages;
    private Context mContext;
    private List<SlideModel.BodyBean.SlidesBean> mSlidesBeanList;
    private SparseArrayCompat<View> mSparseArrayCompat;
    private LayoutInflater mLayoutInflater;

    private List<SlideModel.BodyBean.RecommendBean> mRecommendBeanList;

    public SlideActivityAdapter(Context context, SlideModel slideModel) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        getList(slideModel);
        getPages(slideModel);
        mSparseArrayCompat = new SparseArrayCompat<>();
        mLayoutInflater = LayoutInflater.from(context);
    }


    private void getPages(SlideModel slideModel) {
        if (slideModel != null && slideModel.getBody() != null && slideModel.getBody().getSlides() != null) {
            mPages = slideModel.getBody().getSlides().size();
        }
    }

    private void getList(SlideModel slideModel) {
        if (slideModel != null && slideModel.getBody() != null && slideModel.getBody().getSlides() != null) {
            mSlidesBeanList = slideModel.getBody().getSlides();
        }
        if (slideModel != null && slideModel.getBody() != null && slideModel.getBody().getRecommend() != null) {
            mRecommendBeanList = slideModel.getBody().getRecommend();
        }
    }


    @Override
    public int getCount() {
        return mSlidesBeanList.size() + 1;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View ret = null;
        if (position == mSlidesBeanList.size()) {
            ret = mSparseArrayCompat.get(position);
            if (ret == null) {
                ret = mLayoutInflater.inflate(R.layout.item_slide_recommend, container, false);
                mSparseArrayCompat.put(position, ret);
            }
            RecommendViewHolder recommendViewHolder = (RecommendViewHolder) ret.getTag();
            if (recommendViewHolder == null) {
                recommendViewHolder = new RecommendViewHolder(ret);
                ret.setTag(recommendViewHolder);
            }
            initRecommendData(recommendViewHolder,container,ret);
            return ret;
        }
        ret = mSparseArrayCompat.get(position);
        if (ret == null) {
            ret = mLayoutInflater.inflate(R.layout.item_slide_detail, container, false);
            mSparseArrayCompat.put(position, ret);
        }
        DetailViewHolder detailViewHolder = (DetailViewHolder) ret.getTag();
        if (detailViewHolder == null) {
            detailViewHolder = new DetailViewHolder(ret);
            ret.setTag(detailViewHolder);
        }
        initDetailData(container, position, ret, detailViewHolder);
        return ret;
    }

    private void initRecommendData(RecommendViewHolder recommendViewHolder,ViewGroup container,View view) {
        if (mRecommendBeanList.size() >= 6) {
            recommendViewHolder.mBigTitle.setText("精彩推荐");
            recommendViewHolder.mTitle.setText(mRecommendBeanList.get(0).getTitle());
            recommendViewHolder.mTitle1.setText(mRecommendBeanList.get(1).getTitle());
            recommendViewHolder.mTitle2.setText(mRecommendBeanList.get(2).getTitle());
            recommendViewHolder.mTitle3.setText(mRecommendBeanList.get(3).getTitle());
            recommendViewHolder.mTitle4.setText(mRecommendBeanList.get(4).getTitle());
            recommendViewHolder.mTitle5.setText(mRecommendBeanList.get(5).getTitle());
            Picasso.with(mContext).load(mRecommendBeanList.get(0).getThumbnail()).into(recommendViewHolder.mImageView);
            Picasso.with(mContext).load(mRecommendBeanList.get(1).getThumbnail()).into(recommendViewHolder.mImageView1);
            Picasso.with(mContext).load(mRecommendBeanList.get(2).getThumbnail()).into(recommendViewHolder.mImageView2);
            Picasso.with(mContext).load(mRecommendBeanList.get(3).getThumbnail()).into(recommendViewHolder.mImageView3);
            Picasso.with(mContext).load(mRecommendBeanList.get(4).getThumbnail()).into(recommendViewHolder.mImageView4);
            Picasso.with(mContext).load(mRecommendBeanList.get(5).getThumbnail()).into(recommendViewHolder.mImageView5);
            recommendViewHolder.mImageView.setOnClickListener(this);
            recommendViewHolder.mImageView1.setOnClickListener(this);
            recommendViewHolder.mImageView2.setOnClickListener(this);
            recommendViewHolder.mImageView3.setOnClickListener(this);
            recommendViewHolder.mImageView4.setOnClickListener(this);
            recommendViewHolder.mImageView5.setOnClickListener(this);
            recommendViewHolder.mImageView.setTag(mRecommendBeanList.get(0).getId());
            recommendViewHolder.mImageView1.setTag(mRecommendBeanList.get(1).getId());
            recommendViewHolder.mImageView2.setTag(mRecommendBeanList.get(2).getId());
            recommendViewHolder.mImageView3.setTag(mRecommendBeanList.get(3).getId());
            recommendViewHolder.mImageView4.setTag(mRecommendBeanList.get(4).getId());
            recommendViewHolder.mImageView5.setTag(mRecommendBeanList.get(5).getId());
            container.addView(view);
        }
    }

    private void initDetailData(ViewGroup container, int position, View ret, DetailViewHolder detailViewHolder) {
        SlideModel.BodyBean.SlidesBean slidesBean = mSlidesBeanList.get(position);
        Picasso.with(mContext).load(slidesBean.getImage())
                .placeholder(R.drawable.place1)
                .config(Bitmap.Config.RGB_565)
                .into(detailViewHolder.mImageView);
        detailViewHolder.mPages.setText((position + 1) + "/" + mPages);
        if (position == 0) {
            detailViewHolder.mContent.setText(slidesBean.getTitle() + "\n" + slidesBean.getDescription());
        } else {
            detailViewHolder.mContent.setText(slidesBean.getDescription());
        }
        container.addView(ret);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(((View) object));
    }

    @Override
    public void onClick(View v) {
        if (v.getTag()!=null&&v.getTag() instanceof String) {
            String id = (String) v.getTag();
            Intent intent = new Intent(mContext, SlideActivity.class);
            intent.putExtra("aid",id);
            mContext.startActivity(intent);
        }
    }

    public class DetailViewHolder {
        private final ImageView mImageView;
        private final TextView mPages;
        private final TextView mContent;

        public DetailViewHolder(View view) {
            mImageView = ((ImageView) view.findViewById(R.id.item_slide_detail_imageView));
            mPages = ((TextView) view.findViewById(R.id.item_slide_detail_pages));
            mContent = ((TextView) view.findViewById(R.id.item_slide_detail_content));
        }
    }

    public class RecommendViewHolder {
        private final ImageView mImageView;
        private final ImageView mImageView1;
        private final ImageView mImageView2;
        private final ImageView mImageView3;
        private final ImageView mImageView4;
        private final ImageView mImageView5;
        private final TextView mBigTitle;
        private final TextView mTitle;
        private final TextView mTitle1;
        private final TextView mTitle2;
        private final TextView mTitle3;
        private final TextView mTitle4;
        private final TextView mTitle5;

        public RecommendViewHolder(View view) {
            mImageView = ((ImageView) view.findViewById(R.id.item_slide_recommend_image));
            mImageView1 = ((ImageView) view.findViewById(R.id.item_slide_recommend_image1));
            mImageView2 = ((ImageView) view.findViewById(R.id.item_slide_recommend_image2));
            mImageView3 = ((ImageView) view.findViewById(R.id.item_slide_recommend_image3));
            mImageView4 = ((ImageView) view.findViewById(R.id.item_slide_recommend_image4));
            mImageView5 = ((ImageView) view.findViewById(R.id.item_slide_recommend_image5));
            mBigTitle = ((TextView) view.findViewById(R.id.item_slide_recommend_bigTitle));
            mTitle = ((TextView) view.findViewById(R.id.item_slide_recommend_title));
            mTitle1 = ((TextView) view.findViewById(R.id.item_slide_recommend_title1));
            mTitle2 = ((TextView) view.findViewById(R.id.item_slide_recommend_title2));
            mTitle3 = ((TextView) view.findViewById(R.id.item_slide_recommend_title3));
            mTitle4 = ((TextView) view.findViewById(R.id.item_slide_recommend_title4));
            mTitle5 = ((TextView) view.findViewById(R.id.item_slide_recommend_title5));
        }
    }

}
