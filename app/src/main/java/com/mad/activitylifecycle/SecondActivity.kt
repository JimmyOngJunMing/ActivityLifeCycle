package com.mad.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.mad.activitylifecycle.Models.QuestionModel

class SecondActivity : AppCompatActivity() {

    private lateinit var myModel : QuestionModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.i("Lifecycle", "onCreate")


        val btn : Button = findViewById(R.id.btnAdd)
        val tv : TextView = findViewById(R.id.tvQuestion)
        val tvName : TextView = findViewById(R.id.tvName)

        //myModel = QuestionModel()  //This will create new model

        //Get instance if had been created
        //myModel = ViewModelProvider (this).get(QuestionModel::class.java)
        myModel = QuestionModel.getInstant()

        tvName.text = myModel.name
        tv.text = myModel.getQuestion()
        /*
        tv .text = savedInstanceState?.getString("question")
        */

        btn.setOnClickListener(){
            tv.text = myModel.generateQuestion()
        }
    }

    override fun onStart() {
        super.onStart()

        Log.i("Lifecycle", "onStart")
    }

    override fun onResume() {
        super.onResume()


        Log.i("Lifecycle", "onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.i("Lifecycle", "onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.i("Lifecycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("Lifecycle", "onDestroy")
    }

//Save only one variable
    /*
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val tv : TextView = findViewById(R.id.tvQuestion)

        outState.putString("question", tv.text.toString())
    }
*/



}