package com.mad.activitylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.mad.activitylifecycle.Models.QuestionModel

class MainActivity : AppCompatActivity() {

    private lateinit var myModel : QuestionModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn : Button = findViewById(R.id.btnNext)

        //This mean using current view and model
        //myModel = ViewModelProvider (this).get(QuestionModel::class.java)

        //This share same variables (Different Activity) in same Model
        myModel = QuestionModel.getInstant()

        btn.setOnClickListener(){
            var intent : Intent = Intent(this, SecondActivity::class.java )

            //Save input name
            myModel.name = findViewById<TextView>(R.id.tfName).text.toString()

            startActivity(intent)
        }


    }
}