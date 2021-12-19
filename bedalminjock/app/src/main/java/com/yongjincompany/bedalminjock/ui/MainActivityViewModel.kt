package com.yongjincompany.bedalminjock.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yongjincompany.bedalminjock.model.BannerItem

class MainActivityViewModel : ViewModel() {
    private val _bannerItemList: MutableLiveData<List<BannerItem>> = MutableLiveData()
    private val _currentPosition: MutableLiveData<Int> = MutableLiveData()

    val bannerItemList : LiveData<List<BannerItem>>
        get() = _bannerItemList

    val currentPosition: LiveData<Int>
        get() = _currentPosition

    init{
        _currentPosition.value=0
    }


    fun setBannerItem(list: List<BannerItem>){
        _bannerItemList.value = list
    }

    fun setCurrentPosition(position: Int) {
        _currentPosition.value = position
    }

    fun getcurrentPosition() = currentPosition.value
}