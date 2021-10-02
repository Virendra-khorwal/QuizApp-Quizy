package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        tv_name.text = intent.getStringExtra(Constants.USER_NAME)
        val mCorrectAns = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        val mTotalQuestion = intent.getIntExtra(Constants.TOTALQUESTIONS,0)

        tv_score.text = "You got $mCorrectAns out of $mTotalQuestion"

        btn_finish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }


    }
}