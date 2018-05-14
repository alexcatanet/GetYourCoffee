package com.example.android.getyourcoffee;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private TextView[] mDots;

    private Button mOrderButton;
    private Button mNextBtn;
    private Button mBackBtn;

    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSlideViewPager = findViewById(R.id.slideViewPager);
        mDotLayout = findViewById(R.id.dotsLayout);

        mOrderButton = findViewById(R.id.order_button);
        mNextBtn = findViewById(R.id.nextBtn);
        mBackBtn = findViewById(R.id.prevBtn);

        SliderAdapter sliderAdapter = new SliderAdapter(this);

        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);

        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage + 1);
            }
        });
        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage - 1);
            }
        });

        mOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent button = new Intent(MainActivity.this, OrderCoffee.class);
                startActivity(button);
            }
        });
    }

    public void addDotsIndicator(int position) {
        mDots = new TextView[4];
        mDotLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++) {

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(25);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            mDotLayout.addView(mDots[i]);
        }
        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            mCurrentPage = i;

            if (i == 0) {

                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(false);
                mOrderButton.setEnabled(false);
                mOrderButton.setVisibility(View.INVISIBLE);
                mBackBtn.setVisibility(View.INVISIBLE);

                mNextBtn.setText(R.string.next_button_java);
                mBackBtn.setText("");
                mOrderButton.setText("");

            } else if (i == mDots.length - 1) {

                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mOrderButton.setEnabled(true);
                mOrderButton.setVisibility(View.VISIBLE);
                mBackBtn.setVisibility(View.VISIBLE);

                mNextBtn.setText(R.string.finish_button_java);
                mBackBtn.setText(R.string.back_button_java);
                mOrderButton.setText(R.string.order_button_java);
            } else {

                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mOrderButton.setEnabled(false);
                mOrderButton.setVisibility(View.INVISIBLE);
                mBackBtn.setVisibility(View.VISIBLE);

                mNextBtn.setText(R.string.next_button_java);
                mBackBtn.setText(R.string.back_button_java);
                mOrderButton.setText("");
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {
        }
    };
}
