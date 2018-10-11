package com.gopi.architecture.sample.samplearchitectureapp.nestedViewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class DisableableViewPager extends ViewPager {
  private boolean disable = false;
    public boolean isForceInterceptTouchEvent = false;
  public DisableableViewPager(Context context) {
      super(context);
  }
  public DisableableViewPager(Context context, AttributeSet attrs){
      super(context,attrs);
  }
  @Override
  public boolean onInterceptTouchEvent(MotionEvent event) {
      boolean bool = disable ? false : super.onInterceptTouchEvent(event);
      if(isForceInterceptTouchEvent) return true;
      return bool;
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
      boolean bool = disable ? false : super.onTouchEvent(event);

      if (isForceInterceptTouchEvent && (event.getActionMasked() == MotionEvent.ACTION_UP || event.getActionMasked() == MotionEvent.ACTION_CANCEL)) {
          isForceInterceptTouchEvent = false;
      }
      return bool;
  }

  public void disableScroll(){
      //When disable = true not work the scroll and when disble = false work the scroll
      this.disable = true;
  }

  public void enableScroll(){
      //When disable = true not work the scroll and when disble = false work the scroll
      this.disable = false;
  }
}