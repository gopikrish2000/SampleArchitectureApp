package com.gopi.architecture.sample.samplearchitectureapp.WORK.languageSelection;

import android.os.SystemClock;
import android.view.View;

public abstract class DebouncedOnClickListener implements View.OnClickListener {

    private long threshold;
    private long lastClickMillis;
    
    /**
     * Implement this in your subclass instead of onClick
     * @param v The view that was clicked
     */
    public abstract void onDebouncedClick(View v);

    public DebouncedOnClickListener() {
        threshold = 400l;
    }

    /**
     * @param threshold The minimum allowed time between clicks - any click sooner than this after a previous click will be rejected
     */
    public DebouncedOnClickListener(long threshold) {
        this.threshold = threshold;
    }

    @Override
    public void onClick(View clickedView) {
        long currentTimestamp = SystemClock.uptimeMillis();

        if ((currentTimestamp - lastClickMillis > threshold)) {
            onDebouncedClick(clickedView);
            lastClickMillis = currentTimestamp;
        }
    }

    public static View.OnClickListener wrap(final View.OnClickListener onClickListener) {
        return new DebouncedOnClickListener() {
            @Override
            public void onDebouncedClick(View v) {
                onClickListener.onClick(v);
            }
        };
    }

    public static View.OnClickListener wrap(final long threshold, final View.OnClickListener onClickListener) {
        return new DebouncedOnClickListener(threshold) {
            @Override
            public void onDebouncedClick(View v) {
                onClickListener.onClick(v);
            }
        };
    }
}