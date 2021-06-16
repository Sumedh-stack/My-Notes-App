package com.notes.alinfo.given

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.notes.alinfo.R

class given : AppCompatActivity() {
    lateinit var addtr: Button

    lateinit var DB: SQHelpergiven
    lateinit var amount:EditText
    lateinit var name:EditText
    lateinit var time:EditText
    lateinit var amount_text :String
    lateinit var name_text :String
    lateinit var time_text:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_given)
        DB = SQHelpergiven(applicationContext)
        amount = findViewById(R.id.amount2)
         name = findViewById(R.id.name_person2)
         time = findViewById(R.id.time2)

        addtr = findViewById(R.id.add_trans2)

        addtr.setOnClickListener {
             amount_text = amount.text.toString().trim()
             name_text =  name.text.toString().trim()
             time_text =  time.text.toString().trim()
            //val return_text =  return_time.text.toString().trim()
            when {
                TextUtils.isEmpty(amount_text) -> Toast.makeText(
                    applicationContext,
                    "Amount is Required",
                    Toast.LENGTH_SHORT
                ).show()
                TextUtils.isEmpty(name_text) -> Toast.makeText(
                    applicationContext,
                    "name of person is Required",
                    Toast.LENGTH_SHORT
                ).show()
                TextUtils.isEmpty(time_text) -> Toast.makeText(
                    applicationContext,
                    "Date/time of amount given is Required",
                    Toast.LENGTH_SHORT
                ).show()
                else->{
                    DB.ADD_DATA("GIVEN",amount_text, name_text, time_text)
                    Toast.makeText(this@given, "the subject has been added", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@given, see_given::class.java))
                }
            }


        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
         amount_text = amount.text.toString().trim()
         name_text =  name.text.toString().trim()
         time_text =  time.text.toString().trim()

        when {
            TextUtils.isEmpty(amount_text) ->  startActivity(Intent(this@given, see_given::class.java))
            TextUtils.isEmpty(name_text) ->  startActivity(Intent(this@given, see_given::class.java))
            TextUtils.isEmpty(time_text) ->  startActivity(Intent(this@given, see_given::class.java))

            else->{
                DB.ADD_DATA("GIVEN",amount_text, name_text, time_text)
                Toast.makeText(this@given, "the subject has been added", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@given, see_given::class.java))
            }
        }
    }
}
