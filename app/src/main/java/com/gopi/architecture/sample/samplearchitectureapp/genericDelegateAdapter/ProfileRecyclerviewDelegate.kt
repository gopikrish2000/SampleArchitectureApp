/*
package com.gopi.architecture.sample.samplearchitectureapp.genericDelegateAdapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

object ProfileRecyclerviewDelegate {

    fun onCreateViewHolder(container: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            */
/*PROFILE_ITEMTYPE_REWARDS -> ProfileRewardsViewHolder.onCreateViewHolder(container)
            PROFILE_ITEMTYPE_HEADER -> ProfileHeaderViewHolder.onCreateViewHolder(container)
            ProfileItemType.PROFILE_ITEMTYPE_MESSAGE -> ProfileMessageViewHolder.onCreateViewHolder(container)
            ProfileItemType.PROFILE_ITEMTYPE_VERSIONNAME -> ProfileVersionNameViewHolder.onCreateViewHolder(container)
            else -> ProfileViewHolder.onCreateViewHolder(container)*//*

            else -> RecyclerView.ViewHolder(View())
        }
    }

    fun getItemViewType(item: GenericParentItem): Int {
        return when (item) {
            */
/*is ProfileSwipeItemRewards -> PROFILE_ITEMTYPE_REWARDS
            is ProfileSwipeItemHeader -> ProfileItemType.PROFILE_ITEMTYPE_HEADER
            is ProfileSwipeItemCounter -> ProfileItemType.PROFILE_ITEMTYPE_COUNTER
            is ProfileSwipeItemMessage -> ProfileItemType.PROFILE_ITEMTYPE_MESSAGE
            is ProfileVersionNameItem -> ProfileItemType.PROFILE_ITEMTYPE_VERSIONNAME
            else -> ProfileItemType.PROFILE_ITEMTYPE_DEFAULT*//*

            else -> 0
        }
    }

    fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, item: GenericParentItem, itemClickListener: (item: GenericParentItem) -> Unit) {

        when (viewHolder) {
            */
/*is ProfileRewardsViewHolder -> viewHolder.bindViewHolder(item, rewardsRepository)
            is ProfileHeaderViewHolder -> viewHolder.bindViewHolder(item)
            is ProfileMessageViewHolder -> viewHolder.bindViewHolder(item)
            is ProfileViewHolder -> viewHolder.bindViewHolder(item)
            is ProfileVersionNameViewHolder -> viewHolder.bindViewHolder(item)
        }*//*

//        HikeViewUtils.debounceClick(viewHolder.itemView){ itemClickListener(item)}
        }
    }
}

class GenericParentItem {

}

*/
