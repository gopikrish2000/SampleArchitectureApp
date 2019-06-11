package com.gopi.architecture.sample.samplearchitectureapp.WORK.languageSelection

import android.support.v7.app.AppCompatActivity

class StickerLanguageSelectionManager {

    fun startBottomSheet(context: AppCompatActivity?) {
        context ?: return
        val stickerLanguageSelectionBottomSheetFragment = StickerLanguageSelectionBottomSheetFragment()
        stickerLanguageSelectionBottomSheetFragment.show(context.supportFragmentManager, "stickerLanguageSelectionBottomSheetFragment")
    }

    fun getLanguageSelectionData(): MutableList<LanguageSelectionItem> {
        return mutableListOf<LanguageSelectionItem>(LanguageSelectionItem(1.toString(), "first", null, ItemState.GreyedOut), LanguageSelectionItem("2", "sec"), LanguageSelectionItem("3", "tthird"), LanguageSelectionItem("4", "four"), LanguageSelectionItem("5", "five"), LanguageSelectionItem("6", "six"), LanguageSelectionItem("7", "seveen"), LanguageSelectionItem("8", "eightt"))
    }
}