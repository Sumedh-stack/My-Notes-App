package com.notes.alinfo.timetable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.notes.alinfo.R

class Show_timetable : AppCompatActivity() {
    lateinit var items:ArrayList<Subject4>
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_timetable)

        var a=intent.getStringExtra("a")
        var b=intent.getStringExtra("b")
        var c=intent.getStringExtra("c")
        var d=intent.getStringExtra("d")
        var e=intent.getStringExtra("e")
        var f=intent.getStringExtra("f")
        var g=intent.getStringExtra("g")





        items=ArrayList()
        items.add(Subject4(a, b, c, d, e, f, g))

        val adapter=
            Adapter(this@Show_timetable, items)
        var  list=findViewById<ListView>(R.id.list_ver)
        list.adapter=adapter

    }
}