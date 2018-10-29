package com.gopi.architecture.sample.samplearchitectureapp.advancedkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.gopi.architecture.sample.samplearchitectureapp.R

class KotlinViewReferenceActivity : AppCompatActivity() {
    val firstName: TextView by bindView(R.id.ref_first_tv)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_view_reference)
//        val secondName = bindView<TextView>(R.id.ref_second_tv)
        firstName.text = "SETTING IN RUNTIME..."
        (findViewById(R.id.ref_second_tv) as TextView).text = "SETTING SECOND TV TEXT"
//        secondName.text = "SETTING IN RUNTIME..."
        val intentVal = intent?.extras?.getString("abc", "empty")
        Toast.makeText(this,"intentValue is $intentVal", Toast.LENGTH_SHORT).show()
    }
}
