package com.example.quizappv3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        var btk_start = findViewById<Button>(R.id.btk_start)
        var et_name = findViewById<androidx.appcompat.widget.AppCompatEditText>(R.id.et_name)

        btk_start.setOnClickListener{
            if(et_name.text.toString().isEmpty()){
                Toast.makeText(this,"Please enter your name", Toast.LENGTH_LONG).show()
            }else{
                //go to other activity
                val intent = Intent(this, QuizQuestionActivity::class.java)
                intent.putExtra(Constant.USER_NAME,et_name.text.toString()) // transfer info
                //use Constant bc x type new name, use same val
                startActivity(intent)
                finish() //close current activity
            }
        }
    }
}