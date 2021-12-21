package com.yongjincompany.bedalminjock.ui.b_eatwhat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yongjincompany.bedalminjock.model.WhatToEat
import com.yongjincompany.bedalminjock.repository.b_eatwhat.EatWhatRepositoryImpl
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EatWhatViewModel : ViewModel() {
    private val _eatWhatToEatList: MutableLiveData<List<WhatToEat>> = MutableLiveData()
    val eatWhatToEatList : LiveData<List<WhatToEat>>
        get() = _eatWhatToEatList

    fun getFakeWhatToEatList() {
        viewModelScope.launch {
            //지금은 fakedata라 다른 스레드로 해야하지만 실제는 네트워크이므로 네트워크는 IO르므로 사용함
            withContext(IO) {
                _eatWhatToEatList.postValue(EatWhatRepositoryImpl.getWhatToEatItems())
            }
        }
    }
}