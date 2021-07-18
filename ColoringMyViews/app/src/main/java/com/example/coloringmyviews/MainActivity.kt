package com.example.coloringmyviews

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.coloringmyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setListeners()
    }

    private fun setListeners() {
        //val clickableViews: List<View> = listOf(box_one_text, box_two_text, box_three_text, box_four_text, box_five_text)

        //for (item in clickableViews) {
        //    item.setOnClickListener { makeColored(it) }
        //}

        binding.apply {
            boxOneText.setOnClickListener {
                makeColored(it)
            }
            boxTwoText.setOnClickListener {
                makeColored(it)
            }
            boxThreeText.setOnClickListener {
                makeColored(it)
            }
            boxFourText.setOnClickListener {
                makeColored(it)
            }
            boxFiveText.setOnClickListener {
                makeColored(it)
            }
            constr.setOnClickListener {
                makeColored(it)
            }
            redButton.setOnClickListener {
                makeColored(it)
            }
            greenButton.setOnClickListener {
                makeColored(it)
            }
            yellowButton.setOnClickListener {
                makeColored(it)
            }
        }
    }

    private fun makeColored(view: View) {
        when (view.id) {

            // Boxes using Color class colors for background
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            R.id.red_button -> binding.boxThreeText.setBackgroundResource(R.color.red)
            R.id.yellow_button -> binding.boxFourText.setBackgroundResource(R.color.yellow)
            R.id.green_button -> binding.boxFiveText.setBackgroundResource(R.color.green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}