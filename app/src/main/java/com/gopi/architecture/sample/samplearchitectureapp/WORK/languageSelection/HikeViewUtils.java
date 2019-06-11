package com.gopi.architecture.sample.samplearchitectureapp.WORK.languageSelection;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gopi.architecture.sample.samplearchitectureapp.MainApplication;

import java.util.List;

import static com.gopi.architecture.sample.samplearchitectureapp.WORK.languageSelection.CommonUtils.getApplicationContext;
import static com.gopi.architecture.sample.samplearchitectureapp.WORK.languageSelection.CommonUtils.isNonNull;
import static com.gopi.architecture.sample.samplearchitectureapp.WORK.languageSelection.CommonUtils.isNull;
import static com.gopi.architecture.sample.samplearchitectureapp.WORK.languageSelection.CommonUtils.isNullOrEmpty;

/**
 * Created by gopi on 08/11/17.
 */

public class HikeViewUtils {

    public static void setVisibility(View view, int visibility) {
        if (view != null && view.getVisibility() != visibility) {
            view.setVisibility(visibility);
        }
    }

    public static void setGone(View... views) {
        if (views == null) {
            return;
        }
        for (View view : views) {
            setVisibility(view, View.GONE);
        }
    }

    public static void setVisibleView(List<View> views) {
        if (views == null) {
            return;
        }
        for (View view : views) {
            setVisibility(view, View.VISIBLE);
        }
    }

    public static void setGone(List<View> views) {
        if (views == null) {
            return;
        }
        for (View view : views) {
            setVisibility(view, View.GONE);
        }
    }

    public static void setVisibleView(View... views) {
        if (views == null) {
            return;
        }
        for (View view : views) {
            setVisibility(view, View.VISIBLE);
        }
    }

    public static void setInVisible(View... views) {
        if(views == null){
            return;
        }
        for (View view : views) {
            setVisibility(view,View.INVISIBLE);
        }
    }

    public static void setEnabled(View... views) {
        if(views == null){
            return;
        }
        for (View view : views) {
            if (view != null) {
                view.setEnabled(true);
            }
        }
    }

    public static void setDisabled(View... views) {
        if(views == null){
            return;
        }
        for (View view : views) {
            if (view != null) {
                view.setEnabled(false);
            }
        }
    }

    public static void toggleViewsVisibility(View first, boolean isFirstVisible, View second) {
        if (isFirstVisible) {
            setVisibleView(first);
            setGone(second);
        } else {
            setVisibleView(second);
            setGone(first);
        }
    }

    public static void viewVisibilityWithBoolean(View view, boolean isVisible) {
        if (isVisible) {
            setVisibleView(view);
        } else {
            setGone(view);
        }
    }

    public static void viewEnabilityWithBoolean(View view, boolean isVisible) {
        if (isVisible) {
            setEnabled(view);
        } else {
            setDisabled(view);
        }
    }

    public static void debounceClick(View view, View.OnClickListener clickListener){
        if (isNonNull(view)) {
            view.setOnClickListener(DebouncedOnClickListener.wrap(clickListener));
        }
    }

    public static void debounceClick(View view, long threshold, View.OnClickListener clickListener) {
        if (isNonNull(view)) {
            view.setOnClickListener(DebouncedOnClickListener.wrap(threshold, clickListener));
        }
    }

    public static String getTagFromView(View view, int key) {
        if (isNull(view)) {
            return "";
        }
        Object tag = view.getTag(key);
        if(isNonNull(tag)){
            String tagStr = tag.toString();
            return tagStr;
        }
        return "";
    }


    public static void setScaleForViews(float scale, View... views) {
        if(isNull(views) || views.length == 0) return;
        for (View view: views) {
            view.setScaleX(scale);
            view.setScaleY(scale);
        }
    }

    public static boolean isViewVisible(View view) {
        if (isNull(view)) {
            return false;
        }
        return view.getVisibility() == View.VISIBLE;
    }

    public static int getColor(String colorString){
        return Color.parseColor(colorString);
    }

    public static int getColor(@ColorRes int colorResId){
        return ContextCompat.getColor(MainApplication.Companion.getAppContext(), colorResId);
    }

    public static void clearAnimation(List<View> views) {
        if(isNullOrEmpty(views)) return;
        for (View view : views) {
            clearAnimation(view);
        }
    }

    public static void clearAnimation(View... views) {
        if(isNull(views) || views.length == 0) return;
        for (View view : views) {
            if (isNonNull(view)) {
                view.clearAnimation();
            }
        }
    }

     public static void setClickListener(View.OnClickListener clickListener,View... views) {
        if(views == null){
            return;
        }
        for (View view : views) {
            if (view != null) {
                view.setOnClickListener(clickListener);
            }
        }
    }

     public static boolean isViewEnabled(View view) {
        if (isNull(view)) {
            return false;
        }
        return view.isEnabled();
    }

    /*public static void setGoneWithVisibilityTag(View view) {
        if(isNull(view) || (!isViewVisible(view))) return;
        boolean isViewCurrentlyVisible = isViewVisible(view);
        setGone(view);
        view.setTag(R.id.genericViewVisibilityTag, isViewCurrentlyVisible ? "visible" : "gone");
    }

    public static void setVisibleWithVisibilityTag(View view) {
        if(isNull(view)|| isViewVisible(view)) return;
        boolean isPreviouslyVisible = isViewPreviouslyVisibleWithTag(view);
        if(isPreviouslyVisible) setVisibleView(view);
        view.setTag(R.id.genericViewVisibilityTag, "");
    }*/

    /*public static void setToggleViewWithVisibilityTag(View view, boolean isShow) {
        if (isShow) {
            setVisibleWithVisibilityTag(view);
        }else {
            setGoneWithVisibilityTag(view);
        }
    }

    public static void setVisibleWithVisibilityTagList(List<View> views) {
        if (views == null) {
            return;
        }
        for (View view : views) {
            setVisibleWithVisibilityTag(view);
        }
    }*/

   /* public static void setGoneWithVisibilityTagList(List<View> views) {
        if (views == null) {
            return;
        }
        for (View view : views) {
            setGoneWithVisibilityTag(view);
        }
    }

    public static boolean isViewPreviouslyVisibleWithTag(View view) {
        return viewHasTagValue(view, R.id.genericViewVisibilityTag, "visible");
    }*/

    public static Drawable getDrawable(@DrawableRes int resId) {
        try {
            return ContextCompat.getDrawable(getApplicationContext(), resId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

     public static BitmapDrawable getBitmapDrawable(String resName) {
         try {
             final Drawable drawable = getDrawable(resName);
             if (drawable == null || !(drawable instanceof BitmapDrawable)) return null;
             return ((BitmapDrawable) drawable);
         } catch (Exception e){
             e.printStackTrace();
             return null;
         }
     }

    public static Drawable getDrawable(String resName) { // don't give filepath for this , its meant for resource Name instead of Id.
        try {
            final int drawableId = getApplicationContext().getResources().getIdentifier(resName, "drawable", getApplicationContext().getPackageName());
            return getDrawable(drawableId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void setTextWhenNotEmpty(TextView textView, String text){
        if (!isNullOrEmpty(text)) {
            textView.setText(text);
        }
    }


    public static void removeView(ViewGroup viewGroup, View view){
        try {
            viewGroup.removeView(view);
        } catch (Exception e) { // ignore if view is not in viewGroup ...
            e.printStackTrace();
        }
    }

    /*public static void setElevation(View view, int elevationInDP){
        if(view == null) return;
        ViewCompat.setElevation(view, view.getContext().dpToPx(elevationInDP));
    }*/
}