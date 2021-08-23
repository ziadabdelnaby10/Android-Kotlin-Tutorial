package com.example.lifecycletraining

import android.os.Handler
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class TimerClass(lifecycle: Lifecycle , o : onClicki) : LifecycleObserver{
    var secondsCount = 0
    private var handler = Handler()
    private lateinit var runnable: Runnable
    private var onclicki : onClicki

    init {
        lifecycle.addObserver(this)
        onclicki = o
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun startTimer(){
        runnable = Runnable {
            secondsCount++
            Log.i("TimerActivity" , "Time is at : $secondsCount")
            onclicki.onClickedi("Time is at : $secondsCount")
            handler.postDelayed(runnable, 1000)
        }
        handler.postDelayed(runnable, 1000)
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stopTimer(){
        handler.removeCallbacks(runnable)
    }

    interface onClicki{
        fun onClickedi(txt : String)
    }
}