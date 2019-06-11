package com.gopi.architecture.sample.samplearchitectureapp.navigationdrawer.extensions

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.BounceInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.Interpolator
import android.widget.TextView
import android.widget.Toast
import com.gopi.architecture.sample.samplearchitectureapp.BuildConfig
import java.io.Serializable

/**
 * Created by Gopi on 17/10/18.
 */

fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

val DEFAULT_ANIMATION_PROPERTIES_OBJECT = ViewAnimationProperties()
class ViewAnimationProperties(var durationMills:Long = 300, var startDelayMillis:Long = 0, var animateInterpolator: Interpolator = BounceInterpolator())

fun <T : View> T.setGone(doAnimation: Boolean = false, animationPropertiesObject: ViewAnimationProperties? = null): T {
    if (this.visibility == View.GONE) return this
    if (!doAnimation) {
        this.visibility = View.GONE
        return this
    }
    var animationProperties = animationPropertiesObject
    if (animationProperties == null) animationProperties = DEFAULT_ANIMATION_PROPERTIES_OBJECT

    fun animationBlock() {
        animate().scaleX(0f).scaleX(0f).setInterpolator(animationProperties.animateInterpolator).setDuration(animationProperties.durationMills)
                .withEndAction { this.visibility = View.GONE; scaleX = 1f;scaleY = 1f }.start()
    }
    if (animationProperties.startDelayMillis > 0) Handler(Looper.getMainLooper()).postDelayed({ animationBlock() }, animationProperties.startDelayMillis)
    else animationBlock()
    return this
}

fun <T : View> T.setVisible(doAnimation: Boolean = false, animationPropertiesObject: ViewAnimationProperties? = null): T {
    if (this.visibility == View.VISIBLE) return this
    if (!doAnimation) {
        this.visibility = View.VISIBLE
        return this
    }

    var animationProperties = animationPropertiesObject
    if (animationProperties == null) animationProperties = DEFAULT_ANIMATION_PROPERTIES_OBJECT

    fun animationBlock() {
        scaleX = 0f; scaleY = 0f
        animate().scaleX(1f).scaleX(1f).setInterpolator(animationProperties.animateInterpolator).setDuration(animationProperties.durationMills).withEndAction { this.visibility = View.VISIBLE }.start()
    }
    if (animationProperties.startDelayMillis > 0) Handler(Looper.getMainLooper()).postDelayed({ animationBlock() }, animationProperties.startDelayMillis)
    else animationBlock()
    return this
}

fun View.setInVisible() {
    this.visibility = View.INVISIBLE
}

fun Bundle.putBundleInfo(key: String?, bundle: Bundle?): Bundle {  // wrapper method which returns the bundle instead of default void.
    this.putBundle(key, bundle)
    return this
}

fun Bundle.putStringInfo(key: String?, value: String?):Bundle{
    putString(key,value);
    return this
}

fun Bundle?.getNonNullBundle(key: String?): Bundle {  // wrapper method which returns the bundle instead of default void.
    return this?.getBundle(key) ?: Bundle.EMPTY
}

fun TextView.setTextColorInt(colorRes: Int){  // use colorRes as R.color.<colorResource>
    this.setTextColor(ContextCompat.getColor(context, colorRes))
}

fun TextView.setTextColorString(hashColorCode: String){  // use hashColorCode as #ffffff
    this.setTextColor(Color.parseColor(hashColorCode))
}

fun Context?.dpToPx(dp: Float): Int {
    return this?.run { dp * resources.displayMetrics.density }?.toInt() ?: 0
}

fun Context?.showToast(msg:String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

inline fun <reified T> AppCompatActivity?.startActivityWithData(vararg pairs: Pair<String, Any?>) {
    this ?: return
    this.baseContext.startActivityWithData<T>(*pairs)
}

inline fun <reified T> Fragment?.startActivityWithData(vararg pairs: Pair<String, Any?>) {
    this ?: return
    this.activity.startActivityWithData<T>(*pairs)
}

inline fun <reified T> Context?.startActivityWithData(vararg pairs: Pair<String, Any?>) {
    this ?: return
    val intent = Intent(this, T::class.java)
    fillTheIntent(intent, pairs)
    this.startActivity(intent)
}

fun fillTheIntent(intent: Intent, pairs: Array<out Pair<String, Any?>>) {
    pairs.forEach {
        val value = it.second
        when (value) {
            null -> intent.putExtra(it.first, null as Serializable?)
            is Int -> intent.putExtra(it.first, value)
            is Long -> intent.putExtra(it.first, value)
            is CharSequence -> intent.putExtra(it.first, value)
            is String -> intent.putExtra(it.first, value)
            is Float -> intent.putExtra(it.first, value)
            is Double -> intent.putExtra(it.first, value)
            is Char -> intent.putExtra(it.first, value)
            is Short -> intent.putExtra(it.first, value)
            is Boolean -> intent.putExtra(it.first, value)
            is Serializable -> intent.putExtra(it.first, value)
            is Bundle -> intent.putExtra(it.first, value)
            is Parcelable -> intent.putExtra(it.first, value)
            is Array<*> -> when {
                value.isArrayOf<CharSequence>() -> intent.putExtra(it.first, value)
                value.isArrayOf<String>() -> intent.putExtra(it.first, value)
                value.isArrayOf<Parcelable>() -> intent.putExtra(it.first, value)
            }
            is IntArray -> intent.putExtra(it.first, value)
            is LongArray -> intent.putExtra(it.first, value)
            is FloatArray -> intent.putExtra(it.first, value)
            is DoubleArray -> intent.putExtra(it.first, value)
            is CharArray -> intent.putExtra(it.first, value)
            is ShortArray -> intent.putExtra(it.first, value)
            is BooleanArray -> intent.putExtra(it.first, value)
            else -> {   // ignore
            }
        }
    }
}

fun Any.logInfo(message: String, explicitTag: String? = null, throwable: Throwable? = null, isOnlyForDebug: Boolean = true) = logWithMode("info", message,explicitTag, throwable = throwable , isOnlyForDebug = isOnlyForDebug)

fun Any.logDebug(message: String, explicitTag: String? = null, throwable: Throwable? = null, isOnlyForDebug: Boolean = true) = logWithMode("debug", message,explicitTag, throwable = throwable , isOnlyForDebug = isOnlyForDebug)

fun Any.logVerbose(message: String, explicitTag: String? = null, throwable: Throwable? = null, isOnlyForDebug: Boolean = true) = logWithMode("verbose", message,explicitTag, throwable = throwable , isOnlyForDebug = isOnlyForDebug)

fun Any.logWarn(message: String, explicitTag: String? = null, throwable: Throwable? = null, isOnlyForDebug: Boolean = true) = logWithMode("warn", message,explicitTag, throwable = throwable , isOnlyForDebug = isOnlyForDebug)

fun Any.logException(message: String, explicitTag: String? = null, throwable: Throwable? = null, isOnlyForDebug: Boolean = true) = logWithMode("exception", message,explicitTag, throwable = throwable , isOnlyForDebug = isOnlyForDebug)

private fun Any.logWithMode(type: String, message: String, explicitTag: String? = null, throwable: Throwable? = null, isOnlyForDebug: Boolean = true) {
    val tag = explicitTag ?: CLASS_TAG
    val toExecute = if (isOnlyForDebug.not()) true else BuildConfig.DEBUG
    if (toExecute.not()) return
    when (type) {
        "info" -> Log.i(tag, message)
        "debug" -> Log.d(tag, message)
        "verbose" -> Log.v(tag, message)
        "warn" -> Log.w(tag, message, throwable)
        "exception" -> Log.e(tag, message, throwable)
        else -> { /*ignore */ }
    }
}


val Any.CLASS_TAG: String             // No need to create explict TAG variable , use CLASS_TAG
        get() = this.javaClass.simpleName
