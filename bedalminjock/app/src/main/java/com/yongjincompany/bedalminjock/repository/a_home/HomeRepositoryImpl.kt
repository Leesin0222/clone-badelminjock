package com.yongjincompany.bedalminjock.repository.a_home

import com.yongjincompany.bedalminjock.model.BannerItem
import com.yongjincompany.bedalminjock.model.GridItem
import com.yongjincompany.bedalminjock.model.data.fakeBannerItemList
import com.yongjincompany.bedalminjock.model.data.fakeGridItemList

//싱글(벙글)톤
object HomeRepositoryImpl : HomeRepository {
    
    override suspend fun getBannerItems(): List<BannerItem> {
        return fakeBannerItemList
    }

    override suspend fun getGridItems() : List<GridItem> {
        return fakeGridItemList
    }
}