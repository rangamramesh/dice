package com.example.dice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.dice.databinding.ActivityMainBinding
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCenter.start(
            application, "eb5d8e2a-bb4e-43ce-bbf7-a42486207ab5",
            Analytics::class.java, Crashes::class.java
        )
        val dataBind = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )
        val viewModel = ViewModelProvider(this, ViewModelFactory()).get(MainViewModel::class.java)
        dataBind.viewModel = viewModel
        dataBind.lifecycleOwner = this

    }
}