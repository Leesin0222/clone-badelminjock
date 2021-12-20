package com.yongjincompany.bedalminjock.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yongjincompany.bedalminjock.R
import kotlinx.android.synthetic.main.activity_event.*

class EventActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)
        iv_close.setOnClickListener {
            finish()
        }
    }
}