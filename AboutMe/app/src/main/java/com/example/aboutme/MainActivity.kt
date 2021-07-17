package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val myName: MyName = MyName("Ziad Abdelnaby")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this , R.layout.activity_main)

        binding.myName = myName
        //binding = ActivityMainBinding.inflate(layoutInflater)
        //var view = binding.root
        //setContentView(view)

        binding.btnDone.setOnClickListener{
            addNickName()
        }

    }

    private fun addNickName(){
        binding.apply {
            //nicknameTxt.text = binding.nameEditTxt.text
            myName?.nickname = nameEditTxt.text.toString()
            nameEditTxt.visibility = View.GONE
            btnDone.visibility = View.GONE
            nicknameTxt.visibility = View.VISIBLE
            invalidateAll() // That Make sure that the updates is done
        }


        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.btnDone.windowToken , 0)
    }
}