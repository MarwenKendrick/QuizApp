package com.marwendevs.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName: TextView = findViewById(R.id.tv_Name)
        val tvScore: TextView = findViewById(R.id.tv_Score)
        val btnFinish : Button = findViewById(R.id.btn_Finish)

        tvName.text = intent.getStringExtra(Constant.USER_NAME)


        val correctAnswers = intent.getIntExtra(Constant.CORRECT_ANSWER,0)
        val totalQuestion = intent.getIntExtra(Constant.TOTAL_QUESTIONS,0)
        tvScore.text = "Your Score is $correctAnswers Out of $totalQuestion"

        btnFinish.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}