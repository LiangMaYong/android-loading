package com.liangmayong.loading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by LiangMaYong on 2016/9/10.
 */
public class LoadingFragment extends DialogFragment {

    public LoadingFragment() {
    }

    private LinearLayout rootLayout = null;
    private TextView labelView = null;
    private LoadingProgressWheel progressWheel = null;
    private String label = "loading";

    /**
     * labelView
     *
     * @return loading
     */
    public TextView getLabelView() {
        return labelView;
    }

    /**
     * label
     *
     * @return label
     */
    public String getLabel() {
        return label;
    }

    /**
     * setLabel
     *
     * @param label label
     */
    public void setLabel(String label) {
        this.label = label;
        if (labelView != null) {
            labelView.setText(label);
            if ("".equals(label) || label == null) {
                labelView.setVisibility(View.GONE);
            } else {
                labelView.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        getDialog().setCanceledOnTouchOutside(false);
        window.getDecorView().setBackgroundColor(0x00ffffff);
        WindowManager.LayoutParams windowParams = window.getAttributes();
        windowParams.dimAmount = 0.0f;
        window.setAttributes(windowParams);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Context context = inflater.getContext();
        rootLayout = new LinearLayout(context);

        rootLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        rootLayout.setMinimumWidth(dip2px(context, 80));
        rootLayout.setMinimumHeight(dip2px(context, 80));
        rootLayout.setGravity(Gravity.CENTER);
        rootLayout.setOrientation(LinearLayout.VERTICAL);
        rootLayout.setPadding(dip2px(context, 20), dip2px(context, 10), dip2px(context, 20), dip2px(context, 10));
        rootLayout.setBackgroundDrawable(new RoundDrawable(20, 0x99333333));

        progressWheel = new LoadingProgressWheel(context);
        progressWheel.setBarColor(0xddffffff);
        progressWheel.setRimColor(0x05eeeeee);
        progressWheel.setRimWidth(5);
        progressWheel.setBarWidth(5);
        int width = dip2px(context, 30);
        progressWheel.setCircleRadius(width);
        progressWheel.setPadding(0, dip2px(context, 10), 0, dip2px(context, 10));
        if (!progressWheel.isSpinning()) {
            progressWheel.spin();
        }
        rootLayout.addView(progressWheel);

        labelView = new TextView(getContext());
        labelView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        labelView.setSingleLine();
        labelView.setGravity(Gravity.CENTER);
        labelView.setTextSize(15);
        labelView.setTextColor(0xffffffff);
        labelView.setText(label);
        if ("".equals(label) || label == null) {
            labelView.setVisibility(View.GONE);
        } else {
            labelView.setVisibility(View.VISIBLE);
        }
        rootLayout.addView(labelView);

        return rootLayout;
    }

    private int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * RoundDrawable
     */
    private static class RoundDrawable extends ColorDrawable {

        private int round;

        public RoundDrawable(int round, int color) {
            super(color);
            this.round = round;
        }

        @Override
        public void draw(Canvas canvas) {
            super.draw(new RoundCanvas(canvas, round));
        }

        private class RoundCanvas extends Canvas {

            private int round;
            private Canvas canvas;

            public RoundCanvas(Canvas canvas, int round) {
                this.round = round;
                this.canvas = canvas;
            }

            @Override
            public void drawRect(Rect r, Paint paint) {
                RectF rectF = new RectF(r);
                canvas.drawRoundRect(rectF, round, round, paint);
            }
        }
    }
}
