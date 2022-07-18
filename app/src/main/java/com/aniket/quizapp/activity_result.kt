package com.aniket.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class activity_result : AppCompatActivity() {
    var tv: TextView? = null
    var tv2: TextView? = null
    var tv3: TextView? = null
    var btnRestart: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        tv = findViewById(R.id.tvres) as TextView?
        tv2 = findViewById(R.id.tvres2) as TextView?
        tv3 = findViewById(R.id.tvres3) as TextView?
        btnRestart = findViewById(R.id.btnRestart) as Button?
        val sb = StringBuffer()
        sb.append("""Correct answers: ${activity_question.correct}""".trimIndent())
        val sb2 = StringBuffer()
        sb2.append("""Wrong Answers: ${activity_question.wrong}""".trimIndent())
        val sb3 = StringBuffer()
        sb3.append("""Final Score: ${activity_question.correct}""".trimIndent())
        tv!!.text = sb
        tv2!!.text = sb2
        tv3!!.text = sb3
        activity_question.correct = 0
        activity_question.wrong = 0
        activity_question.wrong = 0
        btnRestart!!.setOnClickListener {
            val `in` = Intent(applicationContext, MainActivity::class.java)
            startActivity(`in`)
        }
    }
}