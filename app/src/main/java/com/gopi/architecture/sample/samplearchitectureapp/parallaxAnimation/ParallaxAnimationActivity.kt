package com.gopi.architecture.sample.samplearchitectureapp.parallaxAnimation

import android.Manifest
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.widget.NestedScrollView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.facebook.drawee.generic.RoundingParams
import com.facebook.drawee.view.SimpleDraweeView
import com.gopi.architecture.sample.samplearchitectureapp.R
import com.gopi.architecture.sample.samplearchitectureapp.navigationdrawer.extensions.dpToPx
import kotlinx.android.synthetic.main.activity_parallax_transition_variant2.*

class ParallaxAnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parallax_transition_variant2)
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PERMISSION_GRANTED) {
            Toast.makeText(this,"Permission Not Present",Toast.LENGTH_LONG).show()
        }
        initAllView()
//        initViews()
        initOtherLogic()
        productionReadyCode()
    }

    private fun initOtherLogic() {
        val imageDrawee = findViewById<SimpleDraweeView>(R.id.profileIv)
//        profileIv.setImageURI(Uri.parse("http://lorempixel.com/300/300/sports/1"))
//        profileIv.setImageURI(Uri.parse("https://via.placeholder.com/150/0000FF/808080?Text=Digital.com"))
        imageDrawee.hierarchy.roundingParams = RoundingParams.asCircle()
        val imageUri = Uri.parse("https://i.imgur.com/tGbaZCY.jpg")
        imageDrawee.setImageURI(imageUri)

    }

    private fun initAllView() {
        app_bar.targetElevation = 0f
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            app_bar.elevation = 0f
        }
        profileRv.layoutManager = LinearLayoutManager(this)
        val parallaxAnimationAdapter = ParallaxAnimationAdapter(mutableListOf(ParallaxItem("first"), ParallaxItem("second"), ParallaxItem("third"), ParallaxItem(), ParallaxItem(), ParallaxItem(), ParallaxItem(), ParallaxItem(), ParallaxItem(), ParallaxItem(), ParallaxItem(), ParallaxItem(), ParallaxItem(), ParallaxItem(), ParallaxItem(), ParallaxItem(), ParallaxItem(), ParallaxItem())) { item, position ->
        }
        profileRv.adapter = parallaxAnimationAdapter
    }



    private fun productionReadyCode(){

        var previousMovedPercent: Float = -1f
        var profileNameHeight = -1
        val toolbarHeight = resources.getDimension(R.dimen.new_profile_toolbar_height)

        var animationStartScrollPosition = -1
        var animationEndScrollPosition = -1

        var titleNameHeaderPositionInCenter = -1f    // title view of header
        var titleNameHeaderBottomExtremePosition = -1f


        rootView.viewTreeObserver.addOnGlobalLayoutListener {
            profileNameHeight = profileName.height
            animationStartScrollPosition = profileImageSectionParent.height + profileImageSectionParent.y.toInt() + this.dpToPx(8f)
            animationEndScrollPosition = profileNameHeight + animationStartScrollPosition
            titleNameHeaderPositionInCenter = toolbarHeight/2 - (titleNameHeader.height.toFloat()/2)
            titleNameHeaderBottomExtremePosition = toolbarHeight - titleNameHeader.height
            profileNestedScrollView.scrollTo(0, 0)
        }

        profileNestedScrollView.setOnScrollChangeListener() { nestedScrollView: NestedScrollView?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int ->
            Log.i("GopiLog", "scrolled with scrollY = $scrollY  && oldScrollY = $oldScrollY  ##########   with height $profileNameHeight  ;;;; ${animationStartScrollPosition}")
            if (scrollY in animationStartScrollPosition..animationEndScrollPosition) {
                val diff = animationEndScrollPosition - scrollY
                var percent = (1 - (diff.toFloat().div(profileNameHeight)))
                percent = Math.round(percent * 100).toFloat()/100
                if(previousMovedPercent != percent) {  //optimization only when current percent != previous update it.
                    titleNameHeader.alpha = percent
                    titleNameHeader.y = titleNameHeaderBottomExtremePosition - percent * ((titleNameHeaderBottomExtremePosition - titleNameHeaderPositionInCenter))
                    previousMovedPercent = percent
                }
            } else if (scrollY > animationEndScrollPosition) {
                titleNameHeader.alpha = 1f
                previousMovedPercent = 1f
                titleNameHeader.y = titleNameHeaderPositionInCenter
            } else {
                titleNameHeader.alpha = 0f
                previousMovedPercent = 0f
            }
        }

    }




    /*private fun initViews() {

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
    }*/

}
