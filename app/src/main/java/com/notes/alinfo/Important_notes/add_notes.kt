package com.notes.alinfo.Important_notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.notes.alinfo.R

class add_notes : AppCompatActivity() {
lateinit  var DB:SQHelpernotes
    lateinit var title_input:EditText
    lateinit var desc_input:EditText
    lateinit var title_text :String
    lateinit var desc_text :String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_dates)
        DB = SQHelpernotes(applicationContext)
       title_input = findViewById<EditText>(R.id.title_edit_date)
        desc_input = findViewById<EditText>(R.id.desc_edit_date)
        val add_btn = findViewById<Button>(R.id.add_btn)
        add_btn.setOnClickListener {
             title_text = title_input.text.toString().trim()
             desc_text = desc_input.text.toString().trim()
            when{

                TextUtils.isEmpty(desc_text)->Toast.makeText(applicationContext,"Description is Required",Toast.LENGTH_SHORT).show()
                else->{
                    DB.ADD_DATA2(title_text, desc_text)
                    Toast.makeText(this@add_notes, "the subject has been added", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@add_notes, see_notes::class.java))
                    title_input.setText("")
                    desc_input.setText("")
                }
            }


        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
         title_text = title_input.text.toString().trim()
         desc_text = desc_input.text.toString().trim()
        when{

            TextUtils.isEmpty(desc_text)->  startActivity(Intent(this@add_notes, see_notes::class.java))
            else->{
                DB.ADD_DATA2(title_text, desc_text)
                Toast.makeText(this@add_notes, "the subject has been added", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@add_notes, see_notes::class.java))
                title_input.setText("")
                desc_input.setText("")
            }
        }

    }
}