package com.fxt.exchange;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

public class SliderAdapter extends BaseAdapter {

    private Context context;
    private List<String> imageUrls;

    public SliderAdapter(Context context, List<String> imageUrls) {
        this.context = context;
        this.imageUrls = imageUrls;
    }

    @Override
    public int getCount() {
        return imageUrls != null ? imageUrls.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return imageUrls != null ? imageUrls.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }

        Glide.with(context)
                .load(imageUrls.get(position))
                .into(imageView);

        return imageView;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
        notifyDataSetChanged();
    }
}
