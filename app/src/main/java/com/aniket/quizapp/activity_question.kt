package com.aniket.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class activity_question : AppCompatActivity() {
    var tv: TextView? = null
    var submitbutton: Button? = null
    var quitbutton: Button? = null
    var radio_g: RadioGroup? = null
    var rb1: RadioButton? = null
    var rb2: RadioButton? = null
    var rb3: RadioButton? = null
    var rb4: RadioButton? = null
    var questions = arrayOf(
        "C programs are converted into machine language with the help of",
        "C was primarily devoloped as",
        "From what location are the 1st computer instruction available on boot up?",
        "Which of these keywords is used to define interfaces in Java?",
        "Which of these access specifiers can be used for an interface?",
        "Which of the following is correct way of importing an entire package ‘pkg’?",
        "With respect to a network interface card, the term 10/100 refers to",
        "Which of the following package stores all the standard java classes?",
        "Capacitance is measured in units of",
        "Which provides the fastest data access time?"
    )
    var answers = arrayOf("A compiler","System programming language",
        "ROM BIOS",
        "interface",
        "public",
        "import pkg.*",
        "megabits per second",
        "java",
        "farads",
        "RAM")
    var opt = arrayOf(
        "An editor",
        "A compiler",
        "An os",
        "None of these",
        "System programming language",
        "General purpose language",
        "Data processing language",
        "None of these",
        "ROM BIOS",
        "CPU",
        "boot.ini",
        "CONFIG.SYS",
        "Interface",
        "interface",
        "intf",
        "Intf",
        "public",
        "protected",
        "private",
        "All of the mentioned",
        "Import pkg.",
        "import pkg.*",
        "Import pkg.*",
        "import pkg.",
        "protocol speed",
        "fiber speed",
        "megabits per second",
        "minimum and maximum server speed",
        "lang",
        "java",
        "util",
        "java.packages",
        "volts",
        "amps",
        "farads","neutrinos",
        "Hard disk",
        "SSD",
        "ROM",
        "RAM"
    )
    var flag = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        val score = findViewById(R.id.textView4) as TextView?
        val textView = findViewById(R.id.DispName) as TextView?
        val intent = intent
        val name = intent.getStringExtra("My Name")

        if (name != null) {
            if (name.trim { it <= ' ' } == "")
                textView!!.text = "Hello User"
            else
                textView!!.text = "Hello $name"
        }
        submitbutton = findViewById(R.id.button3) as Button?
        quitbutton = findViewById(R.id.buttonquit) as Button?
        tv = findViewById(R.id.tvque) as TextView?
        radio_g = findViewById(R.id.answersgrp) as RadioGroup?
        rb1 = findViewById(R.id.radioButton) as RadioButton?
        rb2 = findViewById(R.id.radioButton2) as RadioButton?
        rb3 = findViewById(R.id.radioButton3) as RadioButton?
        rb4 = findViewById(R.id.radioButton4) as RadioButton?
        tv!!.text = questions[flag]
        rb1!!.text = opt[0]
        rb2!!.text = opt[1]
        rb3!!.text = opt[2]
        rb4!!.text = opt[3]
        submitbutton!!.setOnClickListener(View.OnClickListener { //int color = mBackgroundColor.getColor();
            //mLayout.setBackgroundColor(color);
            if (radio_g!!.checkedRadioButtonId == -1) {
                Toast.makeText(applicationContext, "Please select one choice", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }
            val uans = findViewById(radio_g!!.checkedRadioButtonId) as RadioButton?
            val ansText = uans!!.text.toString()
// Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
            if (ansText == answers[flag]) {
                correct++
                Toast.makeText(applicationContext, "Correct", Toast.LENGTH_SHORT).show()} else {
                wrong++
                Toast.makeText(applicationContext, "Wrong", Toast.LENGTH_SHORT).show()
            }
            flag++
            if (score != null) score.text = "" + correct
            if (flag < questions.size) {
                tv!!.text = questions[flag]
                rb1!!.text = opt[flag * 4]
                rb2!!.text = opt[flag * 4 + 1]
                rb3!!.text = opt[flag * 4 + 2]
                rb4!!.text = opt[flag * 4 + 3]
            } else {
                marks = correct
                val `in` = Intent(applicationContext, activity_result::class.java)
                startActivity(`in`)
            }
            radio_g!!.clearCheck()
        })
        quitbutton!!.setOnClickListener {
            val intent = Intent(applicationContext, activity_result::class.java)
            startActivity(intent)
        }
    }
    companion object {
        var marks = 0
        @JvmField
        var correct = 0
        @JvmField
        var wrong = 0
    }
}