package com.notes.alinfo.given

import Adaptergiven
import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

import com.notes.alinfo.MainActivity
import com.notes.alinfo.R
import kotlinx.android.synthetic.main.activity_see_given.*

class see_given : AppCompatActivity() {
    lateinit var DB: SQHelpergiven
    lateinit var data: Cursor
    lateinit var items:ArrayList<Subject22>

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_given)

















        val go =findViewById<Button>(R.id.go_given)
        go.setOnClickListener{
            var intent = Intent(this@see_given, MainActivity::class.java)
            startActivity(intent)

        }
        items=ArrayList()
        DB= SQHelpergiven(applicationContext)
        data=DB.data_getter
        showData()

        val adapter=Adaptergiven(this@see_given,items)
        var  list=findViewById<ListView>(R.id.list_given)
        list.adapter=adapter
        plus_transaction_given.setOnClickListener {
            startActivity(Intent(this@see_given,
                given::class.java))
        }
    }
    fun showData()
    {
        if(data.count==0)
        {
            Toast.makeText(applicationContext,"There is no item", Toast.LENGTH_SHORT).show()

        }

        while(data.moveToNext()){
            items.add(
                Subject22(
                    data.getString(0),
                    data.getString(1),
                    data.getString(2),
                    data.getString(3),
                    data.getString(4)
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