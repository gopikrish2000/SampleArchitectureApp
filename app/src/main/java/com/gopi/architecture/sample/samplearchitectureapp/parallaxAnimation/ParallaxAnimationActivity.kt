package com.gopi.architecture.sample.samplearchitectureapp.parallaxAnimation

import android.graphics.Point
import android.os.Bundle
import android.support.v4.widget.NestedScrollView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.gopi.architecture.sample.samplearchitectureapp.R
import com.gopi.architecture.sample.samplearchitectureapp.navigationdrawer.extensions.dpToPx
import kotlinx.android.synthetic.main.activity_parallax_transition_variant2.*

class ParallaxAnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parallax_transition_variant2)
        initAllView()
        initViews()
    }

    private fun initAllView() {

    }

    private fun initViews() {
        profileRv.layoutManager = LinearLayoutManager(this)
        val parallaxAnimationAdapter = ParallaxAnimationAdapter(mutableListOf(ParallaxItem("first"), ParallaxItem("second"), ParallaxItem("third"), ParallaxItem(), ParallaxItem(), ParallaxItem(), ParallaxItem(), ParallaxItem(), ParallaxItem(), ParallaxItem(), ParallaxItem(), ParallaxItem(), ParallaxItem(), ParallaxItem(), ParallaxItem(), ParallaxItem(), ParallaxItem(), ParallaxItem())) { item, position ->
        }
        profileRv.adapter = parallaxAnimationAdapter

        /* getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver . OnGlobalLayoutListener () {
             @Override
             public void onGlobalLayout() {

             }*/
        var point = Point()
        var previousPercent: Float = -1f
        var profileNameHeight = -1
        var imageParentHeight = -1
        var crossNameHeight = -1
        var titleNameHeaderPositionInCenter = -1f
        var titleNameHeaderExtremePosition = -1f
        rootView.viewTreeObserver.addOnGlobalLayoutListener {
            point.x = profileName.x.toInt()
            point.y = profileName.y.toInt()
            profileNameHeight = profileName.height
            imageParentHeight = profileImageSectionParent.height + profileImageSectionParent.y.toInt() + this.dpToPx(8f)
            crossNameHeight = profileNameHeight + imageParentHeight
            titleNameHeaderPositionInCenter = this.dpToPx(24f).toFloat() - (titleNameHeader.height.toFloat()/2)
            titleNameHeaderExtremePosition = dpToPx(48f).toFloat() - titleNameHeader.height
        }
//        ViewCompat.setNestedScrollingEnabled(profileRv, false)
        profileNestedScrollView.scrollTo(0, 0)
        profileNestedScrollView.setOnScrollChangeListener() { nestedScrollView: NestedScrollView?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int ->
            Log.i("GopiLog", "scrolled with scrollY = $scrollY  && oldScrollY = $oldScrollY  ########## $point   with height $profileNameHeight  ;;;; ${imageParentHeight}")
            if (scrollY in imageParentHeight..crossNameHeight) {
                val diff = crossNameHeight - scrollY
                var percent = (1 - (diff.toFloat().div(profileNameHeight)))
                percent = Math.round(percent * 100).toFloat()/100
                if(previousPercent != percent) {  //optimization only when current percent != previous update it.
                    titleNameHeader.text = percent.toString()
                    titleNameHeader.alpha = percent
                    titleNameHeader.y = titleNameHeaderExtremePosition - percent * ((titleNameHeaderExtremePosition - titleNameHeaderPositionInCenter))
                    previousPercent = percent
                }
            } else if (scrollY > crossNameHeight) {
//                titleNameHeader.text = "crossed"
                titleNameHeader.alpha = 1f
                previousPercent = 1f
                titleNameHeader.y = titleNameHeaderPositionInCenter
            } else {
//                titleNameHeader.text = "notstarted"
                titleNameHeader.alpha = 0f
                previousPercent = 0f
//                titleNameHeader.y = titleNameHeaderExtremePosition
            }
        }
    }

}
