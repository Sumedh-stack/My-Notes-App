package com.notes.alinfo.taken

import Adaptertransactions
import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.notes.alinfo.MainActivity
import com.notes.alinfo.R
import kotlinx.android.synthetic.main.activity_see_taken.*


class see_transactions : AppCompatActivity() {
    lateinit var DB: SQHelpertransaction
    lateinit var data: Cursor
    lateinit var items:ArrayList<subject2>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_taken)
        val go =findViewById<Button>(R.id.go_transactions)
        go.setOnClickListener{
            var intent = Intent(this@see_transactions, MainActivity::class.java)
            startActivity(intent)
        }
        items=ArrayList()
        DB= SQHelpertransaction(applicationContext)
        data=DB.data_getter
        showData()

        val adapter=Adaptertransactions(this@see_transactions,items)
        var  list=findViewById<ListView>(R.id.list_transactions)
        list.adapter=adapter
        plus_transaction_taken.setOnClickListener {
            startActivity(Intent(this@see_transactions,
                taken::class.java))
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
                subject2(
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