package com.yongjincompany.bedalminjock.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yongjincompany.bedalminjock.model.BannerItem

class MainActivityViewModel : ViewModel() {
    private val _bannerItemList: MutableLiveData<List<BannerItem>> = MutableLiveData()

    val bannerItemList : LiveData<List<BannerItem>>
        get() = _bannerItemList


    fun setBannerItem(list: List<BannerItem>){
        _bannerItemList.value = list
    }
}