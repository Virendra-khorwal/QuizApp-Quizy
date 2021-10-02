package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.TintableCompoundDrawablesView
import kotlinx.android.synthetic.main.activity_quiz_question.*


class QuizQuestionActivity : AppCompatActivity() , View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionlist:ArrayList<Questions>? = null
    private var mSelectedOptionPosition:Int =0
    private var correctAns:Int = 0
    private var mUserName:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestionlist = Constants.getQuestions()

        setQuestion()

        tv_optionOne.setOnClickListener(this)
        tv_optionTwo.setOnClickListener(this)
        tv_optionThree.setOnClickListener(this)
        tv_optionFour.setOnClickListener(this)
        tv_btn_submit.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_optionOne -> {
                selectedOptionView(tv_optionOne,1)
            }

            R.id.tv_optionTwo -> {
                selectedOptionView(tv_optionTwo,2)
            }

            R.id.tv_optionThree -> {
                selectedOptionView(tv_optionThree,3)
            }

            R.id.tv_optionFour -> {
                selectedOptionView(tv_optionFour,4)
            }

            R.id.tv_btn_submit -> {

                if(mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when{
                            mCurrentPosition <= mQuestionlist!!.size ->{
                                setQuestion()
                            }else ->{
                                val intent = Intent(this,ResultActivity::class.java)
                                intent.putExtra(Constants.USER_NAME, mUserName)
                                intent.putExtra(Constants.CORRECT_ANSWERS, correctAns)
                                intent.putExtra(Constants.TOTALQUESTIONS, mQuestionlist!!.size)
                                startActivity(intent)
                            }
                    }
                }else{
                    val question = mQuestionlist?.get(mCurrentPosition-1)
                    if (question!!.correctOption != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        correctAns++
                    }
                    answerView(question.correctOption, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionlist!!.size){
                        tv_btn_submit.text = "FINISH"
                    }else{
                        tv_btn_submit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer:Int, drawablesView: Int){
        when(answer){
            1 -> {
                tv_optionOne.background = ContextCompat.getDrawable(this, drawablesView)
            }

            2 -> {
                tv_optionTwo.background = ContextCompat.getDrawable(this, drawablesView)
            }

            3 -> {
                tv_optionThree.background = ContextCompat.getDrawable(this, drawablesView)
            }

            4 -> {
                tv_optionFour.background = ContextCompat.getDrawable(this, drawablesView)
            }
        }
    }

    private fun setQuestion(){
        val question: Questions = mQuestionlist!![mCurrentPosition - 1]

        defaultOptionView()

        if (mCurrentPosition == mQuestionlist!!.size){
            tv_btn_submit.text = "FINISH"
        }else{
            tv_btn_submit.text = "SUBMIT"
        }

        progress_bar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/"+ progress_bar.max

        tv_question.text = question.question
        iv_image.setImageResource(question.image)
        tv_optionOne.text = question.optionOne
        tv_optionTwo.text = question.optionTwo
        tv_optionThree.text = question.optionThree
        tv_optionFour.text = question.optionFour
    }

    private fun selectedOptionView(tv: TextView , selectedOptionNum: Int){
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        options.add(0,tv_optionOne)
        options.add(1,tv_optionTwo)
        options.add(2,tv_optionThree)
        options.add(3,tv_optionFour)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }


}