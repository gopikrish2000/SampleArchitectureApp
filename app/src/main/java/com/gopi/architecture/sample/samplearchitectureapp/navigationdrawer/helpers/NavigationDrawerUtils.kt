package com.gopi.architecture.sample.samplearchitectureapp.navigationdrawer.helpers

import android.view.Window
import android.view.WindowManager

object NavigationDrawerUtils {

    fun setStatusBarTranslucent(makeTranslucent: Boolean, window: Window) {
        if (makeTranslucent) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            //setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, false)
            //            window.statusBarColor = Color.TRANSPARENT
            /*getWindow().setFlags(
                   WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                   WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
           );*/
        } else {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//            window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        }
    }
}
