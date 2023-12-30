package com.example.quizappv3

import kotlin.collections.ArrayList

//this is a file, not class
object Constant {
    const val USER_NAME: String = "user_name"
    const val CORRECT_ANSWERS: String = "correct_answer"
    const val TOTAL_QUESTIONS: String = "total_question"


    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val ques1 = Question(
            1,
            "Which country is this flag belongs to?",
            R.drawable.ic_argentina_flag,
            "Argentina",
            "Belgium",
            "New Zealand",
            "Italy",
            1)
        questionList.add(ques1)

        val ques2 = Question(
            2,
            "Which country is this flag belongs to?",
            R.drawable.ic_belgium_flag,
            "Argentina",
            "Belgium",
            "New Zealand",
            "Italy",
            2)
        questionList.add(ques2)

        val ques3 = Question(
            3,
            "Which country is this flag belongs to?",
            R.drawable.ic_new_zealand_flag,
            "Argentina",
            "Belgium",
            "New Zealand",
            "Italy",
            3)
        questionList.add(ques3)

        val ques4 = Question(
            4,
            "Which country is this flag belongs to?",
            R.drawable.ic_italy_flag,
            "Argentina",
            "Belgium",
            "New Zealand",
            "Italy",
            4)
        questionList.add(ques4)

        val ques5 = Question(
            5,
            "Which country is this flag belongs to?",
            R.drawable.ic_poland_flag,
            "United Kingdom",
            "Belgium",
            "Poland",
            "Italy",
            3)
        questionList.add(ques5)

        val ques6 = Question(
            6,
            "Which country is this flag belongs to?",
            R.drawable.ic_cuba_flag,
            "Argentina",
            "Singapore",
            "South Africa",
            "Cuba",
            4)
        questionList.add(ques6)

        val ques7 = Question(
            7,
            "Which country is this flag belongs to?",
            R.drawable.ic_canada_flag,
            "Canada",
            "Belgium",
            "New Zealand",
            "Italy",
            1)
        questionList.add(ques7)

        val ques8 = Question(
            8,
            "Which country is this flag belongs to?",
            R.drawable.ic_iceland_flag,
            "Argentina",
            "Iceland",
            "New Zealand",
            "Italy",
            2)
        questionList.add(ques8)

        val ques9 = Question(
            9,
            "Which country is this flag belongs to?",
            R.drawable.ic_russia_flag,
            "Argentina",
            "Russia",
            "New Zealand",
            "Italy",
            2)
        questionList.add(ques9)

        val ques10 = Question(
            10,
            "Which country is this flag belongs to?",
            R.drawable.ic_denmark_flag,
            "Argentina",
            "Belgium",
            "Denmark",
            "Italy",
            3)
        questionList.add(ques10)

        return questionList
    }
}