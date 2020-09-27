package com.example.dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.dice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBind=DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        val viewModel = ViewModelProvider(this,ViewModelFactory()).get(MainViewModel::class.java)
        dataBind.viewModel = viewModel
        dataBind.lifecycleOwner =this

    }
}