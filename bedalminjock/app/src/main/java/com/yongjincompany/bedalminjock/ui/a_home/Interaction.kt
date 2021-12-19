package com.yongjincompany.bedalminjock.ui.a_home

import com.yongjincompany.bedalminjock.model.BannerItem

interface Interaction {
    //해당 인터페이스로 이미지 배너를 클릭시 동작이 되게...
    fun onBannerItemClicked(bannerItem: BannerItem)
}