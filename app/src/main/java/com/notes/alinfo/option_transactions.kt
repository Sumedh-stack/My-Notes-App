package com.notes.alinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.notes.alinfo.given.see_given
import com.notes.alinfo.taken.see_transactions

class option_transactions : AppCompatActivity() {
    lateinit var add_data: Button
    lateinit var saved_data: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option_transactions)

        add_data=findViewById(R.id.add_data4)
        saved_data=findViewById(R.id.saved_data4)
        add_data.setOnClickListener {
            startActivity(Intent(this@option_transactions,see_given::class.java))


        }
        saved_data.setOnClickListener {

            startActivity(Intent(this@option_transactions,
              see_transactions::class.java))
        }

    }
}
