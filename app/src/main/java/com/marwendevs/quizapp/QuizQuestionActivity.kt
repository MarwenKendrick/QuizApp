package com.marwendevs.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener
{
    private var mCurrentPosition: Int = 1
    private var mQuestionList:ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0

    private var mUserName : String? = null
    private var mCorrectAnswers : Int = 0

    private var progressBar : ProgressBar? = null
    private var imgQuiz : ImageView? = null
    private var tvQuestion : TextView? = null
    private var tvProgressCount : TextView? = null
    private var tvAns1 : TextView? = null
    private var tvAns2 : TextView? = null
    private var tvAns3 : TextView? = null
    private var tvAns4 : TextView? = null

    private var btnSubmit : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUserName = intent.getStringExtra(Constant.USER_NAME)

        progressBar = findViewById(R.id.pb_Progress)
        tvProgressCount = findViewById(R.id.tv_quesCount)
        imgQuiz = findViewById(R.id.img_Question)
        tvQuestion = findViewById(R.id.tv_Question)
        tvAns1 = findViewById(R.id.tv_Option_One)
        tvAns2 = findViewById(R.id.tv_Option_Two)
        tvAns3 = findViewById(R.id.tv_Option_Three)
        tvAns4 =findViewById(R.id.tv_Option_Four)

        btnSubmit = findViewById(R.id.btn_Submit)

        tvAns1?.setOnClickListener(this)
        tvAns2?.setOnClickListener(this)
        tvAns3?.setOnClickListener(this)
        tvAns4?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)
        mQuestionList = Constant.getQuestion()

        setQuestion()
        optionView()

    }

    private fun setQuestion() {
        optionView()
        var question: Question = mQuestionList!![mCurrentPosition - 1]
        imgQuiz?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgressCount?.text = "$mCurrentPosition / ${progressBar?.max}"
        tvQuestion?.text = question.question
        tvAns1?.text = question.optionOne
        tvAns2?.text = question.optionTwo
        tvAns3?.text = question.optionThree
        tvAns4?.text = question.optionFour

        if(mCurrentPosition == mQuestionList!!.size){
            btnSubmit?.text = "Finish"
        } else{
            btnSubmit?.text = "Submit"
        }

    }

    private fun optionView(){
        val option = ArrayList<TextView>()
        tvAns1?.let {
            option.add(0,it)
        }
        tvAns2?.let {
            option.add(1,it)
        }
        tvAns3?.let {
            option.add(2,it)
        }
        tvAns4?.let {
            option.add(3,it)
        }
        for (option in option){
            option.setTextColor(Color.parseColor("#212529"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_shape)
        }
    }


    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        optionView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#32322C"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_border_shape)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_Option_One -> {
                tvAns1?.let {
                    selectedOptionView(it,1)
                }
            }
            R.id.tv_Option_Two -> {
                tvAns2?.let {
                    selectedOptionView(it,2)
                }
            }
            R.id.tv_Option_Three -> {
                tvAns3?.let {
                    selectedOptionView(it,3)
                }
            }
            R.id.tv_Option_Four -> {
                tvAns4?.let {
                    selectedOptionView(it,4)
                }
            }

            R.id.btn_Submit ->{
               if (mSelectedOptionPosition == 0){
                   mCurrentPosition++

                   when{
                       mCurrentPosition <= mQuestionList!!.size ->{
                           setQuestion()
                       }else -> {
                       val intent = Intent(this,ResultActivity::class.java)
                       intent.putExtra(Constant.USER_NAME,mUserName)
                       intent.putExtra(Constant.CORRECT_ANSWER,mCorrectAnswers)
                       intent.putExtra(Constant.TOTAL_QUESTIONS, mQuestionList?.size)
                       startActivity(intent)
                       finish()

                       }
                   }
               }else {
                   val questions = mQuestionList?.get(mCurrentPosition - 1)
                   if(questions!!.correctAnswer != mSelectedOptionPosition){
                       answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_shape)
                   } else{
                       mCorrectAnswers++
                   }
                   answerView(questions.correctAnswer, R.drawable.correct_option_border_shape)
                   if (mCurrentPosition == mQuestionList!!.size){
                       btnSubmit?.text = "FINISH"
                   }else{
                       btnSubmit?.text = "GO TO NEXT QUESTION"
                   }

                   mSelectedOptionPosition = 0
               }
            }
        }
    }

    private fun answerView(answer:Int,drawableView: Int){

        when(answer){
            1 -> {
               tvAns1?.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                tvAns2?.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                tvAns3?.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                tvAns4?.background = ContextCompat.getDrawable(this, drawableView)
            }
        }

    }
}