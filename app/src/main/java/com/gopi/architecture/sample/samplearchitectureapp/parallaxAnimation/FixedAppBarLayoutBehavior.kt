package com.gopi.architecture.sample.samplearchitectureapp.parallaxAnimation

import android.content.Context
import android.support.design.widget.AppBarLayout
import android.util.AttributeSet

class FixedAppBarLayoutBehavior(context: Context, attrs: AttributeSet) : AppBarLayout.Behavior(context, attrs) {
  init {
    setDragCallback(object : DragCallback() {
      override fun canDrag(appBarLayout: AppBarLayout): Boolean = false
    })
  }
}