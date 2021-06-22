package com.droiddaemon.viewmodelpractice

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import java.util.TimerTask as TimerTask

class MainActivityViewModel : ViewModel() {

    val mHandler: Handler = Handler()
    private lateinit var mRunnable: Runnable
    var randomNumber = 0.0
    val toastMessage: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun generateRandom() {
        randomNumber = Math.random();

    }


    fun generateToast() {

        mRunnable = Runnable {
            generateRandom()
            toastMessage.value = "This is new Random Number ${randomNumber}"
            mHandler.postDelayed(mRunnable, 5000)
        }

        mHandler.postDelayed(mRunnable, 5000)

    }


    fun stopToasts() {
        mHandler.removeCallbacks(mRunnable)
    }
}