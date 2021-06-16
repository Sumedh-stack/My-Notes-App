package com.notes.alinfo.dailyroutine

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

import com.notes.alinfo.*
import kotlinx.android.synthetic.main.activity_see_routine.*

class see_routine : AppCompatActivity() {
    lateinit var DB: SQHelperroutine
    lateinit var data: Cursor
    lateinit var items:ArrayList<Subject_routine>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_routine)





        val go =findViewById<Button>(R.id.go_password)
        go.setOnClickListener{
            var intent = Intent(this@see_routine, MainActivity::class.java)
            startActivity(intent)

        }
        items=ArrayList()
        DB= SQHelperroutine(applicationContext)
        data=DB.data_getter
        showData()

        val adapter= Adapter_routine(this@see_routine, items)
        var  list=findViewById<ListView>(R.id.list_password)
        list.adapter=adapter
        plus.setOnClickListener {
            startActivity(Intent(this@see_routine,
                add_routine::class.java))
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
                Subject_routine(
                    data.getString(0),
                    data.getString(1),
                    data.getString(2),
                    data.getString(3),
                    data.getString(4),
                    data.getString(5),
                    data.getString(6),
                    data.getString(7),
                    data.getString(8),
                    data.getString(9),
                    data.getString(10),
                    data.getString(11),
                    data.getString(12),
                    data.getString(13),
                    data.getString(14),
                    data.getString(15),
                    data.getString(16),
                    data.getString(17),
                    data.getString(18),
                    data.getString(19),
                    data.getString(20),
                    data.getString(21),
                    data.getString(22),
                    data.getString(23),
                    data.getString(24),
                    data.getString(25),
                    data.getString(26),
                    data.getString(27),
                    data.getString(28),
                    data.getString(29),
                    data.getString(30),
                    data.getString(31),
                    data.getString(32),
                    data.getString(33),
                    data.getString(34),
                    data.getString(35),
                    data.getString(36)

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