package com.gopi.architecture.sample.samplearchitectureapp.navigationdrawer.repository

import android.support.annotation.*
import com.gopi.architecture.sample.samplearchitectureapp.R
import com.gopi.architecture.sample.samplearchitectureapp.navigationdrawer.defs.NavigationItemType


object NavigationDrawerRepository {

    private var mNavigationItemList: MutableList<NavigationItem>

    init {
        mNavigationItemList = mutableListOf(
                NavigationItem(R.id.nav_id_posts, R.drawable.ic_action_achievement, R.string.nav_bar_posts, NavigationItemType.NAV_ITEMTYPE_DEFAULT),
                NavigationItem(R.id.nav_id_myfriends, R.drawable.group, R.string.nav_bar_posts, NavigationItemType.NAV_ITEMTYPE_DEFAULT),
                NavigationItemCounter(R.id.nav_id_notifications, R.drawable.ic_action_achievement, R.string.nav_bar_posts, 0, NavigationItemType.NAV_ITEMTYPE_COUNTER),
                NavigationItem(R.id.nav_id_privacy, R.drawable.ic_action_achievement, R.string.nav_bar_posts, NavigationItemType.NAV_ITEMTYPE_DEFAULT),
                NavigationItem(R.id.nav_id_settings, R.drawable.ic_action_achievement, R.string.nav_bar_posts, NavigationItemType.NAV_ITEMTYPE_DEFAULT)
        )
    }

    fun getNavigationItemData(): MutableList<NavigationItem> {
        return mNavigationItemList
    }

    fun updateNotificationCounter(updatedNotificationCounter: Int) {
        mNavigationItemList.filter { it.id == R.id.nav_id_notifications }.map { it -> it as NavigationItemCounter }.map { it.counter = updatedNotificationCounter }
    }
}

open class NavigationItem(@IdRes val id: Int, @DrawableRes val iconDrawable: Int, @StringRes val title: Int, @NavigationItemType val itemType: String)
class NavigationItemCounter(@IdRes id: Int, @DrawableRes iconDrawable: Int, @StringRes title: Int, var counter: Int, @NavigationItemType itemType: String) : NavigationItem(id, iconDrawable, title, itemType)
