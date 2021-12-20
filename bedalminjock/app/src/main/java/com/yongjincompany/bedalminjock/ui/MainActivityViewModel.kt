package com.yongjincompany.bedalminjock.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yongjincompany.bedalminjock.model.BannerItem
import com.yongjincompany.bedalminjock.model.GridItem

class MainActivityViewModel : ViewModel() {

    private val _bannerItemList: MutableLiveData<List<BannerItem>> = MutableLiveData()
    private val _currentPosition: MutableLiveData<Int> = MutableLiveData()
    private val _gridItemList: MutableLiveData<List<GridItem>> = MutableLiveData()

    val bannerItemList : LiveData<List<BannerItem>>
        get() = _bannerItemList

    val currentPosition: LiveData<Int>
        get() = _currentPosition

    val gridItemList: LiveData<List<GridItem>>
        get() = _gridItemList

    init{
        _currentPosition.value=0
    }


    fun setBannerItem(list: List<BannerItem>){
        _bannerItemList.value = list
    }

    fun setCurrentPosition(position: Int) {
        _currentPosition.value = position
    }

    fun setGridItems(list: List<GridItem>) {
        _gridItemList.value = list
    }

    fun getcurrentPosition() = currentPosition.value
}