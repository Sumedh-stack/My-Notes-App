package com.notes.alinfo.taken

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.notes.alinfo.R
import com.notes.alinfo.given.see_given

class taken : AppCompatActivity() {
lateinit var addtr:Button
    lateinit var DB:SQHelpertransaction
    lateinit var amount:EditText
    lateinit var name:EditText
    lateinit var time:EditText
    lateinit var amount_text:String
    lateinit var name_text :String
    lateinit var time_text:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taken)

        DB = SQHelpertransaction(applicationContext)
        amount = findViewById<EditText>(R.id.amount)
         name = findViewById<EditText>(R.id.name_person)
        time = findViewById<EditText>(R.id.time)

        addtr=findViewById(R.id.add_trans)


        addtr.setOnClickListener {
            val amount_text =  amount.text.toString().trim()
            val name_text =name.text.toString().trim()
            val time_text =  time.text.toString().trim()
           // val return_text =  return_time.text.toString().trim()
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
                    "Date/time of amount taken is Required",
                    Toast.LENGTH_SHORT
                ).show()
                else->{
                    DB.ADD_DATA("TAKEN",amount_text, name_text,time_text)
                    Toast.makeText(this@taken, "the subject has been added", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@taken,
                        see_transactions::class.java))

                }
            }

        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

         amount_text =  amount.text.toString().trim()
             name_text =name.text.toString().trim()
             time_text =  time.text.toString().trim()

            when {
                TextUtils.isEmpty(amount_text) ->  startActivity(Intent(this@taken, see_given::class.java))
                TextUtils.isEmpty(name_text) ->  startActivity(Intent(this@taken, see_given::class.java))
                TextUtils.isEmpty(time_text) ->  startActivity(Intent(this@taken, see_given::class.java))
                else->{
                    DB.ADD_DATA("TAKEN",amount_text, name_text,time_text)
                    Toast.makeText(this@taken, "the subject has been added", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@taken,
                        see_transactions::class.java))

                }
            }


    }
}
