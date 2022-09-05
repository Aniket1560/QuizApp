package com.aniket.quizapp
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startbutton = findViewById(R.id.button) as Button?
        val nametext = findViewById(R.id.editName) as EditText?
        startbutton!!.setOnClickListener {
            val name = nametext!!.text.toString()
            val intent = Intent(applicationContext, activity_question::class.java)
            intent.putExtra("My Name", name)
            startActivity(intent)
        }
    }
}