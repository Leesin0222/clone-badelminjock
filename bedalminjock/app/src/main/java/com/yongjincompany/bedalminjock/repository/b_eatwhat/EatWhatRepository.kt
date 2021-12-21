package com.yongjincompany.bedalminjock.repository.b_eatwhat

import com.yongjincompany.bedalminjock.model.WhatToEat

interface EatWhatRepository {
    suspend fun getWhatToEatItems() : List<WhatToEat>
}