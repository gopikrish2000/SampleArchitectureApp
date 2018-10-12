package com.gopi.architecture.sample.samplearchitectureapp.navigationdrawer.defs;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.SOURCE)
@StringDef({NavigationItemType.NAV_ITEMTYPE_DEFAULT, NavigationItemType.NAV_ITEMTYPE_COUNTER})
public @interface NavigationItemType {
    String NAV_ITEMTYPE_DEFAULT = "DEFAULT";
    String NAV_ITEMTYPE_COUNTER = "COUNTER";
}
