package com.example.kotlinconstraintlayoutdesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    var languages = arrayOf("IND", "UK", "AUS", "CHA", "USA")
    var images = arrayOf(R.drawable.india, R.drawable.uk, R.drawable.malesiya, R.drawable.maxico, R.drawable.uk)
    lateinit var img: ImageView
    lateinit var convert_from_spinner: Spinner
    lateinit var button_Statistics: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        convert_from_spinner = findViewById(R.id.spinner)
        img = findViewById(R.id.imageView2)
        button_Statistics = findViewById(R.id.buttonStatistics)

        convert_from_spinner.adapter = ArrayAdapter<String>(this, R.layout.spinner_right_aligned, languages)
        convert_from_spinner.onItemSelectedListener = this
        button_Statistics.setOnClickListener {
            val intent = Intent(this@MainActivity,StatisticsActivity::class.java);
            startActivity(intent);
        }

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        img.setImageResource(images.get(convert_from_spinner.selectedItemPosition))
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}