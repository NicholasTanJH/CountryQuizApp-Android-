package com.example.quizappv3

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
//import android.util.Log
import androidx.core.content.ContextCompat
import kotlin.collections.ArrayList
import android.content.Intent as Intent

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {
    private var numQuestion: Int = 1
    private val questionList = Constant.getQuestions()
    private var question = questionList[numQuestion - 1]
    private var mSelectedOption: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null

    private var tv_displayOption1: TextView? = null
    private var tv_displayOption2: TextView? = null
    private var tv_displayOption3: TextView? = null
    private var tv_displayOption4: TextView? = null
    private var btk_submit: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        mUserName = intent.getStringExtra(Constant.USER_NAME) //putExtra() from MainActivity

        tv_displayOption1 = findViewById<TextView>(R.id.tv_option1)
        tv_displayOption2 = findViewById<TextView>(R.id.tv_option2)
        tv_displayOption3 = findViewById<TextView>(R.id.tv_option3)
        tv_displayOption4 = findViewById<TextView>(R.id.tv_option4)

//        Log.i("Question Size","${questionList.size }") // Logcat, need import log

        setQuestion()

        //textView become button,
        // add View.OnClickListener on top (need import)
        // implement member (click on Class QuizQuestionActivity), onClick fun come out
        tv_displayOption1?.setOnClickListener(this)
        tv_displayOption2?.setOnClickListener(this)
        tv_displayOption3?.setOnClickListener(this)
        tv_displayOption4?.setOnClickListener(this)
        //this also can
//        tv_displayOption1?.setOnClickListener{
//            selectOption(tv_displayOption1, 1)
//        }

        //summit button
        btk_submit = findViewById<Button>(R.id.btk_submit)
        btk_submit?.setOnClickListener(this)
    }

    private fun setQuestion() {
        if (numQuestion == questionList.size) {
            btk_submit?.text = "FINISH"
        } else {
            btk_submit?.text = "SUBMIT"
        }
        question = questionList[numQuestion - 1]
        displayQuestion()
        displayOptions()
        displayImage()
        updateProgressBar()
        defaultOptionView()
    }

    private fun displayOptions() {
        tv_displayOption1?.text = question.option1
        tv_displayOption2?.text = question.option2
        tv_displayOption3?.text = question.option3
        tv_displayOption4?.text = question.option4
    }

    private fun displayQuestion() {
        val tv_question = findViewById<TextView>(R.id.tv_question)
        tv_question.text = question.question
    }

    private fun displayImage() {
        val iv_image = findViewById<ImageView>(R.id.iv_image)
        iv_image.setImageResource(question.image)
    }

    private fun updateProgressBar() {
        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        val tv_progress = findViewById<TextView>(R.id.tv_progress)
        progressBar.progress = numQuestion
        tv_progress.text = "${numQuestion}/${progressBar.max}"
    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView?>()

        options.add(0, tv_displayOption1)
        options.add(1, tv_displayOption2)
        options.add(2, tv_displayOption3)
        options.add(3, tv_displayOption4)

        for (option in options) {
            option?.setTextColor(Color.parseColor("#7A8089"))
            option?.typeface = Typeface.DEFAULT_BOLD // "font"
            option?.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(v: View?) {
        defaultOptionView()
        when (v?.id) {
            R.id.tv_option1 -> {
                selectOption(tv_displayOption1, 1)
            }
            R.id.tv_option2 -> {
                selectOption(tv_displayOption2, 2)
            }
            R.id.tv_option3 -> {
                selectOption(tv_displayOption3, 3)
            }
            R.id.tv_option4 -> {
                selectOption(tv_displayOption4, 4)
            }
            R.id.btk_submit -> {
                if (mSelectedOption == 0) {
                    numQuestion++
                    when {
                        numQuestion <= questionList.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this,EndActivity::class.java)
                            intent.putExtra(Constant.USER_NAME, mUserName)
                            intent.putExtra(Constant.CORRECT_ANSWERS,mCorrectAnswers)
                            intent.putExtra(Constant.TOTAL_QUESTIONS,questionList.size)
                            startActivity(intent)
                            finish()//cant comeback when return button clicked
                        }
                    }
                } else {
                    if (question.correctOption != mSelectedOption) {
                        answerView(mSelectedOption, R.drawable.wrong_option_border_bg)
                    } else {
                        mCorrectAnswers++
                    }
                    answerView(question.correctOption, R.drawable.correct_option_border_bg)

                    if (mSelectedOption == questionList.size) {
                        btk_submit?.text = "FINISH"
                    } else {
                        btk_submit?.text = "GO TO NEXT QUESTION"
                    }
                }
                mSelectedOption = 0
            }
        }
    }

    private fun selectOption(tv: TextView?, selectedOptionNum: Int) {
        mSelectedOption = selectedOptionNum
        tv?.setTextColor(Color.parseColor("#FF000000"))
        tv?.setTypeface(tv.typeface, Typeface.BOLD)
//        tv?.typeface = Typeface.BOLD // not this
        tv?.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    private fun answerView(answer: Int, drawable: Int) {
        when (answer) {
            1 -> {
                tv_displayOption1?.background = ContextCompat.getDrawable(
                    this, drawable
                )
                tv_displayOption1?.setTextColor(Color.parseColor("#FFFFFFFF"))
            }
            2 -> {
                tv_displayOption2?.background = ContextCompat.getDrawable(
                    this, drawable
                )
                tv_displayOption2?.setTextColor(Color.parseColor("#FFFFFFFF"))
            }
            3 -> {
                tv_displayOption3?.background = ContextCompat.getDrawable(
                    this, drawable
                )
                tv_displayOption3?.setTextColor(Color.parseColor("#FFFFFFFF"))
            }
            4 -> {
                tv_displayOption4?.background = ContextCompat.getDrawable(
                    this, drawable
                )
                tv_displayOption4?.setTextColor(Color.parseColor("#FFFFFFFF"))
            }
        }
    }
}