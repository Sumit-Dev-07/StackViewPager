package com.sumit.stackviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.sumit.stackcardview.OrientedViewPager;
import com.sumit.stackcardview.transformer.VerticalStackTransformer;
import com.sumit.stackviewpager.adapters.ContentFragmentAdapter;
import com.sumit.stackviewpager.fragments.CardFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private OrientedViewPager mOrientedViewPager;
    private ContentFragmentAdapter mContentFragmentAdapter;
    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOrientedViewPager = (OrientedViewPager) findViewById(R.id.view_pager);


        for (int i = 0; i < 10; i++) {
            mFragments.add(CardFragment.newInstance(i + 1));
        }

        mContentFragmentAdapter = new
                ContentFragmentAdapter(getSupportFragmentManager(), mFragments);

        mOrientedViewPager.setOrientation(OrientedViewPager.Orientation.VERTICAL);

        mOrientedViewPager.setOffscreenPageLimit(3);

        mOrientedViewPager.setPageTransformer(true, new VerticalStackTransformer(getApplicationContext()));
        mOrientedViewPager.setAdapter(mContentFragmentAdapter);
    }
}