package com.example.lifecycletraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() , TimerClass.onClicki{
    private lateinit var timerClass: TimerClass
    private lateinit var txtView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timerClass = TimerClass(this.lifecycle , this)
        txtView = findViewById(R.id.txt)

        if(savedInstanceState != null){
            txtView.text = savedInstanceState.getString("txtKey")
        }
    }

    override fun onClickedi(txt: String) {
        txtView.text = txt
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("txtKey",txtView.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        txtView.text = savedInstanceState.getString("txtKey")
    }
}