package com.gopi.architecture.sample.samplearchitectureapp.WORK.languageSelection

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
//import android.support.design.widget.BottomSheetBehavior
//import android.support.design.widget.BottomSheetDialogFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import android.support.design.widget.CoordinatorLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.gopi.architecture.sample.samplearchitectureapp.R
import com.gopi.architecture.sample.samplearchitectureapp.navigationdrawer.extensions.dpToPx

@SuppressLint("ValidFragment")
class StickerLanguageSelectionBottomSheetFragment() : BottomSheetDialogFragment() {


    private var mBottomSheetBehavior: BottomSheetBehavior<View>? = null
    private lateinit var adapter: StickerLanguageSelectionBottomSheetAdapter



    fun onCreateDialog(dialog: Dialog, style: Int) {
//        super.setupDialog(dialog, style)

        val contentView = View.inflate(context, R.layout.language_selection_bottom_sheet_dialog, null)
        dialog.setContentView(contentView)
        dialog.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        (contentView.getParent() as View).setBackgroundColor(HikeViewUtils.getColor(android.R.color.transparent))
        val parentLayout = contentView.findViewById<View>(R.id.bottomsheet_layout_parent)
        /*if (currentTheme.isNightTheme) {
            HikeMessengerApp.getApplicationComponent().utils.setBackground(parentLayout, HikeMessengerApp.getInstance().themeResources.drawableResources.getDrawable(R.drawable.over_flow_rounded, currentTheme.colorPallete.backgroundColor))
        }*/

        val headerText = parentLayout.findViewById<TextView>(R.id.header_text)
//        headerText?.setTextColor(currentTheme.colorPallete.mainColor)


        val recyclerView = contentView.findViewById(R.id.recyclerview) as RecyclerView
        val context = recyclerView.getContext()
        val linearLayoutManager = object : GridLayoutManager(context, 2) {
            override fun canScrollVertically(): Boolean {
                return true
            }
        }
        val dataList: MutableList<LanguageSelectionItem> = StickerLanguageSelectionManager().getLanguageSelectionData()

        adapter = StickerLanguageSelectionBottomSheetAdapter(context, dataList) { item: LanguageSelectionItem, position: Int ->
            item.state = item.state.toggle()
            adapter.notifyItemChanged(position)
        }
        recyclerView.setLayoutManager(linearLayoutManager)
        recyclerView.setAdapter(adapter)

        val layoutParams = (contentView.parent as View).layoutParams as CoordinatorLayout.LayoutParams
        val behavior = layoutParams.behavior
        mBottomSheetBehavior = behavior as BottomSheetBehavior<View>
        if (behavior != null) {
            behavior.setBottomSheetCallback(mBottomSheetBehaviorCallback)
            mBottomSheetBehavior!!.peekHeight = context.dpToPx(((((dataList.size + 2) / 2) * 56) + 36).toFloat())
        }
    }

    private val mBottomSheetBehaviorCallback = object : BottomSheetBehavior.BottomSheetCallback() {
        override fun onSlide(bottomSheet: View, slideOffset: Float) {
        }

        override fun onStateChanged(bottomSheet: View, newState: Int) {
            if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                dismiss()
            }
        }
    }


}