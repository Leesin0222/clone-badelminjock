package com.yongjincompany.bedalminjock.repository.b_eatwhat

import com.yongjincompany.bedalminjock.model.WhatToEat
import com.yongjincompany.bedalminjock.model.data.fakeWhatToEatList

object EatWhatRepositoryImpl {
    override suspend fun getWhatToEatItems() : List<WhatToEat> {
        return fakeWhatToEatList
    }
}