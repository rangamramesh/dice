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

    fun getString(A: Array<String>, B: Array<String>, P: String): String {
        val index = ArrayList<Int>()
        var result: String = "No CONTACT"
        for (i in B.indices) {
            if (B[i].contains(P))
                index.add(i)
        }
        if (index.size != 0) {
            result = A[index[0]]
            for (i in 1 until index.size) {
                if (result.length > A[index[i]].length) {
                    result = A[index[i]]
                }
            }
        }
        return result
    }

    fun getString1(S: String): String {
        val data: String = S.trim().replace(" ", "").replace("-", "")
        if (data.length >= 2) {
            if (data.length == 3) {
                return data
            } else {
                var result = data.chunked(3).joinToString("-")
                if (result.substring(result.length - 3, result.lastIndex).contains("-")) {
                    result = result.removeRange(result.length - 3, result.lastIndex)
                    return result + "-" + S.substring(S.length - 2, S.lastIndex)
                } else {
                    return result
                }
            }
        } else {
           return data
        }
    }

    // Change one
}