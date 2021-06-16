package com.notes.alinfo.Important_notes

import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.notes.alinfo.MainActivity
import com.notes.alinfo.R
import com.notes.alinfo.Subject
import kotlinx.android.synthetic.main.activity_see_dates.*
import kotlin.collections.ArrayList


class see_notes : AppCompatActivity() {
    lateinit var DB: SQHelpernotes
    lateinit var data: Cursor
    lateinit var items:ArrayList<Subject>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_dates)








        val go =findViewById<Button>(R.id.go2)
        go.setOnClickListener{
            var intent = Intent(this@see_notes, MainActivity::class.java)
            startActivity(intent)

        }
        items=ArrayList()
        DB= SQHelpernotes(applicationContext)
        data=DB.data_getter2
        showData()

        val adapter= Adapternotes(this@see_notes, items)
        var  list=findViewById<ListView>(R.id.list_dates)
        list.adapter=adapter
        plus_dates.setOnClickListener {
            startActivity(Intent(this@see_notes,
                add_notes::class.java))
        }

//        val touchListener = MultiTouchListener(this)
//        plus_dates.setOnTouchListener(touchListener)
    }
    fun showData()
    {
        if(data.count==0)
        {
            Toast.makeText(applicationContext,"There is no item", Toast.LENGTH_SHORT).show()

        }

        while(data.moveToNext()){

            items.add(
                Subject(
                    data.getString(0),
                    data.getString(1),
                    data.getString(2)
                )
            )

        }





    }
    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this,MainActivity::class.java))
    }
    override fun onStart() {
        super.onStart()
        showData()
    }

}

