package com.sumit.stackcardview.transformer;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.sumit.stackcardview.utils.ScreenUtils;

public class VerticalStackTransformer extends VerticalBaseTransformer {

    private Context context;
    private int spaceBetweenFirAndSecWith = 10 * 2;
    private int spaceBetweenFirAndSecHeight = 10;

    public VerticalStackTransformer(Context context) {
        this.context = context;
    }

    public VerticalStackTransformer(Context context, int spaceBetweenFirAndSecWith, int spaceBetweenFirAndSecHeight) {
        this.context = context;
        this.spaceBetweenFirAndSecWith = spaceBetweenFirAndSecWith;
        this.spaceBetweenFirAndSecHeight = spaceBetweenFirAndSecHeight;
    }

    @Override
    protected void onTransform(View page, float position) {
        if (position <= 0.0f) {
            page.setAlpha(1.0f);
            Log.e("onTransform", "position <= 0.0f ==>" + position);
            page.setTranslationY(0f);
            page.setClickable(true);
        } else if (position <= 3.0f) {
            Log.e("onTransform", "position <= 3.0f ==>" + position);
            float scale = (float) (page.getWidth() - ScreenUtils.dp2px(context, spaceBetweenFirAndSecWith * position)) / (float) (page.getWidth());
            page.setAlpha(1.0f);
            page.setClickable(false);
            page.setPivotX(page.getWidth() / 2f);
            page.setPivotY(page.getHeight() / 2f);
            page.setScaleX(scale);
            page.setScaleY(scale);
            page.setTranslationY(-page.getHeight() * position + (page.getHeight() * 0.5f) * (1 - scale) + ScreenUtils.dp2px(context, spaceBetweenFirAndSecHeight) * position);
        }
    }
}

