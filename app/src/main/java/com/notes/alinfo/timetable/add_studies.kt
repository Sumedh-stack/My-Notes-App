package com.notes.alinfo.timetable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.notes.alinfo.R

class add_studies : AppCompatActivity() {
lateinit  var DB :SQHelperstudies
    lateinit var monday_input : EditText
    lateinit var tuesday_input : EditText
    lateinit var wednesday_input:EditText
    lateinit var thursday_input : EditText
    lateinit var friday_input :EditText
    lateinit var saturday_input: EditText
    lateinit var sunday_input :EditText
    lateinit var add_btn :Button
    lateinit var monday:String
    lateinit var tuesday:String
    lateinit var wednesday:String
    lateinit var thursday:String
    lateinit var friday:String
    lateinit var saturday:String
    lateinit var sunday:String


        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_studies)
           DB = SQHelperstudies(applicationContext)
            monday_input = findViewById<EditText>(R.id.work_monday)
             tuesday_input = findViewById<EditText>(R.id.work_tuesday)
             wednesday_input = findViewById<EditText>(R.id.work_wednesday)
             thursday_input = findViewById<EditText>(R.id.work_thursday)
             friday_input = findViewById<EditText>(R.id.work_friday)
             saturday_input = findViewById<EditText>(R.id.work_saturday)
             sunday_input = findViewById<EditText>(R.id.work_sunday)
             add_btn = findViewById<Button>(R.id.add5)
            add_btn.setOnClickListener {
                monday = monday_input.text.toString().trim()
                 tuesday = tuesday_input.text.toString().trim()
                 wednesday = wednesday_input.text.toString().trim()
                 thursday = thursday_input.text.toString().trim()
                 friday = friday_input.text.toString().trim()
                 saturday = saturday_input.text.toString().trim()
                 sunday = sunday_input.text.toString().trim()
                if(monday==""&&tuesday==""&&wednesday==""&&thursday==""&&friday==""&&saturday==""&&sunday=="")
                    Toast.makeText(applicationContext, "Please write something", Toast.LENGTH_SHORT).show()
                else{
                DB.ADD_DATA2(monday,tuesday,wednesday,thursday,friday,saturday,sunday)
                Toast.makeText(this@add_studies, "the subject has been added", Toast.LENGTH_SHORT).show()
                Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(Intent(this@add_studies,
                    see_studies::class.java))
            }

            }
        }
    override fun onBackPressed() {
        super.onBackPressed()

             monday = monday_input.text.toString().trim()
             tuesday = tuesday_input.text.toString().trim()
             wednesday = wednesday_input.text.toString().trim()
             thursday = thursday_input.text.toString().trim()
             friday = friday_input.text.toString().trim()
             saturday = saturday_input.text.toString().trim()
             sunday = sunday_input.text.toString().trim()
            if(monday==""&&tuesday==""&&wednesday==""&&thursday==""&&friday==""&&saturday==""&&sunday=="")
                Toast.makeText(applicationContext, "Please write something", Toast.LENGTH_SHORT).show()
            else{
                DB.ADD_DATA2(monday,tuesday,wednesday,thursday,friday,saturday,sunday)
                Toast.makeText(this@add_studies, "the subject has been added", Toast.LENGTH_SHORT).show()
                Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(Intent(this@add_studies,
                    see_studies::class.java))
            }


    }
}