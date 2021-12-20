package com.yongjincompany.bedalminjock.ui.a_home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yongjincompany.bedalminjock.MainActivity
import com.yongjincompany.bedalminjock.R
import com.yongjincompany.bedalminjock.model.BannerItem
import kotlinx.android.synthetic.main.item_layout_banner.view.*

class ViewPagerAdapter(private val interaction: Interaction) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val ITEM_COUNT = 5
    }

    private var bannerItemList: List<BannerItem>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BannerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout_banner, parent, false),
            interaction
        )
    }

    override fun getItemCount(): Int {
        return ITEM_COUNT
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        bannerItemList?.let { bannerItemList ->
            (holder as BannerViewHolder).bind(bannerItemList[position])
        }
    }

    //functions
    fun submitList(list : List<BannerItem>?) {
        bannerItemList = list
        notifyDataSetChanged()
    }


    //ViewHolder
    class BannerViewHolder
    constructor(itemView : View, private val interaction: Interaction) : RecyclerView.ViewHolder(itemView) {
        fun bind(bannerItem: BannerItem) {
            itemView.setOnClickListener {
                //MainActivity에서 동작을 수행할 수 있도록 만든다.
                interaction.onBannerItemClicked(bannerItem)
            }
            itemView.iv_banner_image.setImageResource(bannerItem.image)
        }

    }
}

