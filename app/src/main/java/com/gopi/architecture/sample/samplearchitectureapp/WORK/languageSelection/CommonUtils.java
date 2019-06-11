package com.gopi.architecture.sample.samplearchitectureapp.WORK.languageSelection;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.bumptech.glide.load.HttpException;
import com.gopi.architecture.sample.samplearchitectureapp.MainApplication;

import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import okhttp3.Response;

public class CommonUtils {

    public static boolean isNullOrEmpty(String s) {
        return (s == null || s.trim().isEmpty());
    }

    public static boolean isNonEmpty(@Nullable CharSequence str) {
        return !isNullOrEmpty(str);
    }

    public static boolean isNonEmpty(@Nullable List list) {
        return !isNullOrEmpty(list);
    }

    public static boolean isNullOrEmpty(@Nullable CharSequence str) {
        return (str == null || str.length() == 0 || str.toString().trim().length() == 0);
    }

    public static boolean isNullOrEmpty(@Nullable List list) {
        return list == null || list.isEmpty();
    }

    public static boolean isNullOrEmpty(@Nullable Set set) {
        return set == null || set.isEmpty();
    }

    public static boolean isNullOrEmpty(@Nullable Map map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNullOrEmpty(String[] split) {
        return split == null || split.length == 0;
    }

    public static boolean equalsIgnoreCase(String first, String second) {
        if (isNullOrEmpty(first) || isNullOrEmpty(second)) {
            return false;
        }
        return first.equalsIgnoreCase(second);
    }

    public static String getNonNull(String input) {
        if (isNullOrEmpty(input)) {
            return "";
        }
        return input;
    }

    public static String ifNullReturn(String input, String defaultString) {
        if (isNullOrEmpty(input)) {
            return defaultString;
        }
        return input;
    }

    public static String ifNullReturnEmpty(String input) {
        return ifNullReturn(input, "");
    }

    public static String getIntentValue(Intent intent, String key, String defaultValue) {
        if (intent == null || intent.getExtras() == null) {
            return defaultValue;
        }
        Object object = intent.getExtras().get(key);
        if (object == null) {
            return defaultValue;
        }
        String result = String.valueOf(object);
        if (isNullOrEmpty(result)) {
            return defaultValue;
        }
        return result;
    }
    public static String getIntentValue(Intent intent, String key) {
        return getIntentValue(intent, key, "");
    }

    public static int getIntegerIntentValue(Intent intent, String key, int defaultValue) {
        String strValue = getIntentValue(intent, key);
        try {
            return Integer.parseInt(strValue);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static boolean getBooleanIntentValue(Intent intent, String key, boolean defaultValue) {
        if (intent == null || intent.getExtras() == null) {
            return defaultValue;
        }
        return intent.getBooleanExtra(key, defaultValue);
    }

    public static void putIntentExtras(Intent intent, Bundle bundle) {
        if(isNonNullAll(intent, bundle)) intent.putExtras(bundle);
    }

    public static Bundle getIntentExtras(Intent intent){
        if(isNonNull(intent) && isNonNull(intent.getExtras())){
            return intent.getExtras();
        }
        return new Bundle();
    }

    public static Parcelable getIntentParcellableExtras(Intent intent, String key) {
        if(isNull(intent)) return null;
        return intent.getParcelableExtra(key);
    }

    public static String getArgumentValue(Bundle bundle, String key) {
        if (bundle == null) {
            return "";
        }
        Object object = bundle.get(key);
        if (object == null) {
            return "";
        }
        String result = String.valueOf(object);
        if (isNullOrEmpty(result)) {
            return "";
        }
        return result;
    }

    public static Map<String, String> getNonEmptyIntentMap(Intent intent) {
        Map<String, String> map = new HashMap<>();
        if (intent == null || intent.getExtras() == null) {
            return map;
        }

        Bundle bundle = intent.getExtras();
        for (String key : bundle.keySet()) {
            Object valueObj = bundle.get(key);
            if (valueObj != null) {
                String value = valueObj.toString();
                if (!isNullOrEmpty(value)) {
                    map.put(key, value);
                }
            }
        }
        return map;
    }


    public static boolean isNonNull(Object obj) {
        return obj != null;
    }

    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static void setAllNull(Object... objects) {
        if (objects == null || objects.length == 0) {
            return;
        }
        for (int i = 0; i < objects.length; i++) {
            objects[i] = null;
        }
    }

    public static boolean isNonNullAll(Object... objects) {
        if (objects == null || objects.length == 0) {
            return false;
        }
        for (int i = 0; i < objects.length; i++) {
            if (isNull(objects[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNullAny(Object... objects) {
        return !isNonNullAll(objects);
    }

    public static boolean valueInList(String input, String... strings) {
        if (isNullOrEmpty(input) || strings == null || strings.length == 0) {
            return false;
        }
        for (int i = 0; i < strings.length; i++) {
            if (input.equals(strings[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean valueInList(int input, int... integers) {
        if (integers == null || integers.length == 0) {
            return false;
        }
        for (int i = 0; i < integers.length; i++) {
            if (input == (integers[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean valueInRange(int val, int startRange, int stopRange) { // both are inclusive
        return val >= startRange && val <= stopRange;
    }

    public static boolean isActivityAlive(Activity activity) {
        return !(isNull(activity) || activity.isFinishing());
    }

    public static boolean isRequiredNumberOfArguments(int requiredNoOfArguments, Object... objects) {
        return (objects != null && objects.length == requiredNoOfArguments);
    }

    public static boolean isValidIndex(List list, int index) {
        if(isNullOrEmpty(list)) return false;
        return index >= 0 && index < list.size();
    }

    public static boolean isValidIndex(Set set, int index) {
        if(isNullOrEmpty(set)) return false;
        return index >= 0 && index < set.size();
    }

    public static int getInt(boolean bool){
        return bool ? 1 : 0;
    }

    /*public static String toJson(Object object) {
        if (object == null) return "";
        try {
            return new Gson().toJson(object);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }*/

    public static <T> T getFirst(List<T> list) {
        if (isNullOrEmpty(list)) return null;
        return list.get(0);
    }

    public static MainApplication getApplicationContext() {
        return MainApplication.Companion.getAppContext();
    }

    public static String getString(@StringRes int resId) {
        return getApplicationContext().getString(resId);
    }

    public static void runInUIThread(Handler uiHandler , Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            if (uiHandler != null) uiHandler.post(runnable);
        }
    }

    public static void showToast(String message) {
        getApplicationContext().showToast(message);
    }

    public static void showToast(@StringRes int resId) {
        getApplicationContext().showToast(getString(resId));
    }

    public static boolean isFileExists(String filePath) {
        if(isNullOrEmpty(filePath)) return false;
        return new File(filePath).exists();
    }

    public static File getFile(String filePath) {
        try {
            return new File(filePath);
        } catch (Exception e) {
            return null;
        }
    }

    public static void ignoreObject(Object object) {  // This method is for using a object to avoid findbugs.
        if(object instanceof Double) {
            Log.v("IGNORE", "");
        }
    }

    public static void ignoreObjects(Object... objects) {
        if(objects == null || objects.length == 0) return;
        for (int i = 0; i < objects.length; i++) {
            ignoreObject(objects[i]);
        }
    }
    public static boolean equals(String first, String second) {
        if (isNullOrEmpty(first) || isNullOrEmpty(second)) {
            return false;
        }
        return first.equals(second);
    }

    public static String getFirstWord(String input){
        if(isNullOrEmpty(input)) return input;
        if(input.contains(" ")) {
            return input.substring(0, input.indexOf(" "));
        }
        return input;
    }



    public static void show(DialogFragment dialogFragment, FragmentManager fragmentManager, String tag){
        try {
            dialogFragment.show(fragmentManager,tag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}