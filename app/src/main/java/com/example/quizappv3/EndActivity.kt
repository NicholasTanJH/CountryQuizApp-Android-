package com.example.quizappv3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class EndActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val userName = intent.getStringExtra(Constant.USER_NAME)
        val tv_name = findViewById<TextView>(R.id.tv_name)
        tv_name.text = userName

        //if something goes wrong, will be 0
        val correctQuestions = intent.getIntExtra(Constant.CORRECT_ANSWERS,0)
        val totalQuestion = intent.getIntExtra(Constant.TOTAL_QUESTIONS,0)
        val tv_score = findViewById<TextView>(R.id.tv_score)
        tv_score.text = "$correctQuestions/$totalQuestion"

        val btk_finish = findViewById<TextView>(R.id.btk_finish)
        btk_finish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}