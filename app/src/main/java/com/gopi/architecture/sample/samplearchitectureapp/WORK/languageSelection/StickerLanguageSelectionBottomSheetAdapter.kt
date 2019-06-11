package com.gopi.architecture.sample.samplearchitectureapp.WORK.languageSelection

import android.content.Context
import android.support.design.card.MaterialCardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.gopi.architecture.sample.samplearchitectureapp.R
import com.gopi.architecture.sample.samplearchitectureapp.navigationdrawer.extensions.inflate
import com.gopi.architecture.sample.samplearchitectureapp.navigationdrawer.extensions.setGone
import com.gopi.architecture.sample.samplearchitectureapp.navigationdrawer.extensions.setVisible

class StickerLanguageSelectionBottomSheetAdapter(private val context: Context, private val datalist: MutableList<LanguageSelectionItem>, val itemClickListener: (LanguageSelectionItem, Int) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(container: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return LanguageSelectionViewHolder(container.inflate(R.layout.language_sel_bottomsheet_item))
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val item = datalist[position];
        if (viewHolder is LanguageSelectionViewHolder) {
            viewHolder.onBindViewHolder(item)
            if (item.state != ItemState.GreyedOut) {
                HikeViewUtils.debounceClick(viewHolder.itemView, 40) { itemClickListener(item, position) }
            }
        }
    }

    override fun getItemCount(): Int = datalist.size
}

sealed class ItemState() {
    object Selected : ItemState()
    object GreyedOut : ItemState()
    object NotSelected : ItemState()

    fun toggle(): ItemState {
        return if (this == Selected) NotSelected else Selected
    }
}

class LanguageSelectionItem(var id: String, var title: String, val iconDrawable: Int? = null, var state: ItemState = ItemState.NotSelected)

class LanguageSelectionViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    //    private val itemContainer: ConstraintLayout
    private val imgParent: MaterialCardView
    private val languageIv: ImageView
    private val title: TextView
    private val tick: ImageView

    init {
//        itemContainer = view.findViewById<View>(R.id.item_container) as ConstraintLayout
        imgParent = view.findViewById<View>(R.id.imgParent) as MaterialCardView
        languageIv = view.findViewById<View>(R.id.languageIv) as ImageView
        title = view.findViewById<View>(R.id.title) as TextView
        tick = view.findViewById<View>(R.id.tick) as ImageView
    }

    fun onBindViewHolder(item: LanguageSelectionItem) {
        val context = itemView.context
//        val utils = HikeMessengerApp.getApplicationComponent().utils
//        languageIv.drawable
        title.text = item.title
        when (item.state) {
            ItemState.Selected -> {
                imgParent.run { strokeWidth = 2; strokeColor = HikeViewUtils.getColor(R.color.blue_action_bar) }
                tick.setVisible(true).setImageDrawable(HikeViewUtils.getDrawable(R.drawable.blue_circular_tick))
//                title.setTextColor(currentTheme.colorPallete.mainColor)
            }
            ItemState.GreyedOut -> {
                imgParent.strokeWidth = 0
                tick.setVisible().setImageDrawable(HikeViewUtils.getDrawable(R.drawable.blue_circular_tick))
//                title.setTextColor(currentTheme.colorPallete.secondaryColor)
            }
            ItemState.NotSelected -> {
                imgParent.strokeWidth = 0
                tick.setGone(true)
//                title.setTextColor(currentTheme.colorPallete.secondaryColor)
            }
        }
    }
}