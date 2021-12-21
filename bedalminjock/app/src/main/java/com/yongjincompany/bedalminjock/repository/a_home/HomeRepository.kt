package com.yongjincompany.bedalminjock.repository.a_home

import com.yongjincompany.bedalminjock.model.BannerItem
import com.yongjincompany.bedalminjock.model.GridItem

interface HomeRepository {
    suspend fun getBannerItems() : List<BannerItem>
    suspend fun getGridItems() : List<GridItem>
}