package com.yongjincompany.bedalminjock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenResumed
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.yongjincompany.bedalminjock.model.BannerItem
import com.yongjincompany.bedalminjock.model.data.fakeBannerItemList
import com.yongjincompany.bedalminjock.model.data.fakeGridItemList
import com.yongjincompany.bedalminjock.ui.EventActivity
import com.yongjincompany.bedalminjock.ui.MainActivityViewModel
import com.yongjincompany.bedalminjock.ui.a_home.GridRecyclerViewAdapter
import com.yongjincompany.bedalminjock.ui.a_home.Interaction
import com.yongjincompany.bedalminjock.ui.a_home.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), View.OnClickListener,Interaction {

    private lateinit var gridRecyclerViewAdapter: GridRecyclerViewAdapter
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var viewModel: MainActivityViewModel
    private var isRunning = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.setBannerItem(fakeBannerItemList)
        viewModel.setGridItems(fakeGridItemList)

        iv_hamburger.setOnClickListener(this)
        initViewPager2()
        subscribeObservers()
        autoScrollViewPager()
    }

    private fun initViewPager2() {
        viewPager2.apply {
            viewPagerAdapter = ViewPagerAdapter(this@MainActivity)
            adapter = viewPagerAdapter
            registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)

                    isRunning = true
                    tv_page_number.text = "${position+1}"

                    viewModel.setCurrentPosition(position)
                }
            })
        }
        gridRecyclerView.apply {
            gridRecyclerViewAdapter = GridRecyclerViewAdapter()
            layoutManager = GridLayoutManager(this@MainActivity,4)

            adapter = gridRecyclerViewAdapter
        }
    }

    private fun subscribeObservers() {
        viewModel.bannerItemList.observe(this, Observer { bannerItemList ->
            viewPagerAdapter.submitList(bannerItemList)

        })
        viewModel.currentPosition.observe(this, Observer { currentPosition ->
            viewPager2.currentItem = currentPosition
        })
        viewModel.gridItemList.observe(this, Observer { currentPosition ->
            viewPager2.currentItem = currentPosition
        })
    }

    private fun autoScrollViewPager() {
        lifecycleScope.launch {
            whenResumed {
                while (isRunning) {
                    delay(3000)
                    viewModel.getcurrentPosition()?.let {
                        viewModel.setCurrentPosition((it.plus(1)) % 5)
                    }
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        isRunning = false
    }

    override fun onResume() {
        super.onResume()
        isRunning = true
    }

     override fun onBannerItemClicked(bannerItem: BannerItem) {
        startActivity(Intent(this@MainActivity, EventActivity::class.java))
    }

    override fun onClick(p0: View?) {
        p0?.let {
            when(it.id){
              R.id.iv_hamburger -> {

              }

            }
        }
    }
}