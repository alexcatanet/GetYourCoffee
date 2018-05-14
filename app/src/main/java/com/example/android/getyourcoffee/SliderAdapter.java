package com.example.android.getyourcoffee;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    private Context context;

    SliderAdapter(Context context) {
        this.context = context;
    }

    private int[] slide_images = {
            R.drawable.coffe_1,
            R.drawable.coffee_2,
            R.drawable.coffee_3,
            R.drawable.coffee_4
    };

    private String[] slide_headings = {
            "Welcome to Coffee Shop",
            "Discover New Restaurants",
            "Choose Your Product",
            "Delicious Delivered"

    };

    private String[] slide_descs = {
            "The delicacy of roses, smoothly combined \n with  a flavorous espresso and\n" +
                    "    the softness of  milk  for  an unforgettable \n love feeling.",
            "Discover world's top restaurants around you \n and be in the know.",
                    "Combining new technologies, reverent attitude" +
                            "  \n and love to what we do, today we can provide our guests with truly savoury coffee.",
            "Order online and our app baristas will deliver \n directly to your office. "
    };

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert layoutInflater != null;
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = view.findViewById(R.id.slide_image);
        TextView slideHeading = view.findViewById(R.id.slide_heading);
        TextView sliDescription = view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        sliDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;
    }

    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
