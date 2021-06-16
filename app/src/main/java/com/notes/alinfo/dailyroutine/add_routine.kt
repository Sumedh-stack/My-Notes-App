package com.notes.alinfo.dailyroutine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.notes.alinfo.R

class add_routine : AppCompatActivity() {
    lateinit var DB:SQHelperroutine
    lateinit var time1:EditText
    lateinit var time2:EditText
    lateinit var time3:EditText
    lateinit var time4:EditText
    lateinit var time5:EditText
    lateinit var time6:EditText
    lateinit var time7:EditText
    lateinit var time8:EditText
    lateinit var time9:EditText
    lateinit var time10:EditText
    lateinit var time11:EditText
    lateinit var time12:EditText
    lateinit var time13:EditText
    lateinit var time14:EditText
    lateinit var time15:EditText
    lateinit var time16:EditText
    lateinit var time17:EditText
    lateinit var work1:EditText
    lateinit var work2:EditText
    lateinit var work3:EditText
    lateinit var work4:EditText
    lateinit var work5:EditText
    lateinit var work6:EditText
    lateinit var work7:EditText
    lateinit var work8:EditText
    lateinit var work9:EditText
    lateinit var work10:EditText
    lateinit var work11:EditText
    lateinit var work12:EditText
    lateinit var work13:EditText
    lateinit var work14:EditText
    lateinit var work15:EditText
    lateinit var work16:EditText
    lateinit var work17:EditText
    lateinit var dayy:EditText
    lateinit var datee:EditText

    lateinit var time1a :String
    lateinit var time2a  :String
    lateinit var time3a :String
    lateinit var time4a :String
    lateinit var time5a  :String
    lateinit var time6a :String
    lateinit var time7a :String
    lateinit var time8a  :String
    lateinit var time9a  :String
    lateinit var time10a  :String
    lateinit var time11a  :String
    lateinit var time12a :String
    lateinit var time13a :String
    lateinit var time14a :String
    lateinit var time15a  :String
    lateinit var time16a  :String
    lateinit var time17a  :String
    lateinit var work1a  :String
    lateinit var work2a :String
    lateinit var work3a :String
    lateinit var work4a  :String
    lateinit var work5a  :String
    lateinit var work6a :String
    lateinit var work7a :String
    lateinit var work8a :String
    lateinit var work9a :String
    lateinit var work10a  :String
    lateinit var work11a :String
    lateinit var work12a  :String
    lateinit var work13a :String
    lateinit var work14a:String
    lateinit var work15a  :String
    lateinit var work16a  :String
    lateinit var work17a :String
    lateinit var day11a :String
    lateinit var date11a :String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_routine)
        DB = SQHelperroutine(applicationContext)
        time1 = findViewById<EditText>(R.id.Time1)
        time2 = findViewById<EditText>(R.id.Time2)
        time3 = findViewById<EditText>(R.id.Time3)
        time4 = findViewById<EditText>(R.id.Time4)
        time5 = findViewById<EditText>(R.id.Time5)
        time6 = findViewById<EditText>(R.id.Time6)
        time7 = findViewById<EditText>(R.id.Time7)
        time8 = findViewById<EditText>(R.id.Time8)
        time9 = findViewById<EditText>(R.id.Time9)
        time10 =findViewById<EditText>(R.id.Time10)
        time11 = findViewById<EditText>(R.id.Time11)
        time12 = findViewById<EditText>(R.id.Time12)
        time13 = findViewById<EditText>(R.id.Time13)
        time14 = findViewById<EditText>(R.id.Time14)
        time15 = findViewById<EditText>(R.id.Time15)
        time16 = findViewById<EditText>(R.id.Time16)
        time17 = findViewById<EditText>(R.id.Time17)
        work1 = findViewById<EditText>(R.id.work1)
        work2 = findViewById<EditText>(R.id.work2)
        work3= findViewById<EditText>(R.id.work3)
        work4 = findViewById<EditText>(R.id.work4)
        work5= findViewById<EditText>(R.id.work5)
        work6 = findViewById<EditText>(R.id.work6)
        work7 = findViewById<EditText>(R.id.work7)
        work8= findViewById<EditText>(R.id.work8)
        work9 =findViewById<EditText>(R.id.work9)
        work10 = findViewById<EditText>(R.id.work10)
        work11= findViewById<EditText>(R.id.work11)
        work12 = findViewById<EditText>(R.id.work12)
        work13 = findViewById<EditText>(R.id.work13)
        work14= findViewById<EditText>(R.id.work14)
        work15 = findViewById<EditText>(R.id.work15)
        work16= findViewById<EditText>(R.id.work16)
        work17 = findViewById<EditText>(R.id.work17)
        dayy=findViewById(R.id.day)
        datee=findViewById(R.id.date)
        val add_btn3 = findViewById<Button>(R.id.add_btn3)
        add_btn3.setOnClickListener {
            time1a = time1.text.toString().trim()
            time2a = time2.text.toString().trim()
            time3a= time3.text.toString().trim()
            time4a= time4.text.toString().trim()
            time5a = time5.text.toString().trim()
            time6a= time6.text.toString().trim()
            time7a= time7.text.toString().trim()
            time8a = time8.text.toString().trim()
            time9a = time9.text.toString().trim()
            time10a = time10.text.toString().trim()
            time11a = time11.text.toString().trim()
            time12a= time12.text.toString().trim()
            time13a= time13.text.toString().trim()
            time14a = time14.text.toString().trim()
            time15a = time15.text.toString().trim()
            time16a = time16.text.toString().trim()
            time17a = time17.text.toString().trim()
            work1a =  work1.text.toString().trim()
            work2a =work2.text.toString().trim()
            work3a= work3.text.toString().trim()
            work4a = work4.text.toString().trim()
            work5a =work5.text.toString().trim()
            work6a =work6.text.toString().trim()
            work7a= work7.text.toString().trim()
            work8a= work8.text.toString().trim()
            work9a =work9.text.toString().trim()
            work10a = work10.text.toString().trim()
            work11a= work11.text.toString().trim()
            work12a =work12.text.toString().trim()
            work13a= work13.text.toString().trim()
            work14a= work14.text.toString().trim()
            work15a =work15.text.toString().trim()
            work16a = work16.text.toString().trim()
            work17a= work17.text.toString().trim()
            day11a=dayy.text.toString().trim()
            date11a=datee.text.toString().trim()
            if(work1a==""&&work2a==""&&work3a==""&&work4a==""&&work5a==""&&work6a==""&&work7a==""&&work8a==""&&work9a==""&&work10a==""&&work11a==""&&work12a==""&&work13a==""&&work14a==""&&work15a==""&&work16a==""&&work17a=="")
                Toast.makeText(this@add_routine, "Please write something", Toast.LENGTH_SHORT).show()
            else{
                DB.ADD_DATA(time1a,time2a,time3a,time4a, time5a, time6a,time7a,time8a, time9a,time10a,time11a,time12a,time13a, time14a,time15a,time16a,time17a, work1a,work2a,work3a,work4a,work5a,work6a,work7a,work8a,work9a,work10a,work11a,work12a,work13a,work14a,work15a,work16a,work17a,day11a,date11a)
                Toast.makeText(this@add_routine, "the subject has been added", Toast.LENGTH_SHORT).show()
                val intent= Intent(this@add_routine, see_routine::class.java)
                startActivity(intent)
            }



        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
        time1a = time1.text.toString().trim()
        time2a = time2.text.toString().trim()
        time3a= time3.text.toString().trim()
        time4a= time4.text.toString().trim()
        time5a = time5.text.toString().trim()
        time6a= time6.text.toString().trim()
        time7a= time7.text.toString().trim()
        time8a = time8.text.toString().trim()
        time9a = time9.text.toString().trim()
        time10a = time10.text.toString().trim()
        time11a = time11.text.toString().trim()
        time12a= time12.text.toString().trim()
        time13a= time13.text.toString().trim()
        time14a = time14.text.toString().trim()
        time15a = time15.text.toString().trim()
        time16a = time16.text.toString().trim()
        time17a = time17.text.toString().trim()
        work1a =  work1.text.toString().trim()
        work2a =work2.text.toString().trim()
        work3a= work3.text.toString().trim()
        work4a = work4.text.toString().trim()
        work5a =work5.text.toString().trim()
        work6a =work6.text.toString().trim()
        work7a= work7.text.toString().trim()
        work8a= work8.text.toString().trim()
        work9a =work9.text.toString().trim()
        work10a = work10.text.toString().trim()
        work11a= work11.text.toString().trim()
        work12a =work12.text.toString().trim()
        work13a= work13.text.toString().trim()
        work14a= work14.text.toString().trim()
        work15a =work15.text.toString().trim()
        work16a = work16.text.toString().trim()
        work17a= work17.text.toString().trim()
        day11a=dayy.text.toString().trim()
        date11a=datee.text.toString().trim()
        if(work1a==""&&work2a==""&&work3a==""&&work4a==""&&work5a==""&&work6a==""&&work7a==""&&work8a==""&&work9a==""&&work10a==""&&work11a==""&&work12a==""&&work13a==""&&work14a==""&&work15a==""&&work16a==""&&work17a=="")
            startActivity(Intent(this@add_routine, see_routine::class.java))
        else{
            DB.ADD_DATA(time1a,time2a,time3a,time4a, time5a, time6a,time7a,time8a, time9a,time10a,time11a,time12a,time13a, time14a,time15a,time16a,time17a, work1a,work2a,work3a,work4a,work5a,work6a,work7a,work8a,work9a,work10a,work11a,work12a,work13a,work14a,work15a,work16a,work17a,day11a,date11a)
            Toast.makeText(this@add_routine, "the subject has been added", Toast.LENGTH_SHORT).show()
            val intent= Intent(this@add_routine, see_routine::class.java)
            startActivity(intent)
        }

    }
}
