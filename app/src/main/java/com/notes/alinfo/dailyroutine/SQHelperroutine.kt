package com.notes.alinfo.dailyroutine



import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class SQHelperroutine(context:Context):SQLiteOpenHelper(context,
    DB_name,null,1)
{


    companion object{
        val DB_name="subjected.db "
        val TB_name="Subjected "
        val id="ID"
        val time1 ="S_a"
        val time2="S_b"
        val time3 ="S_c"
        val time4="S_d"
        val time5 ="S_e"
        val time6="S_f"
        val time7 ="S_g"
        val time8="S_h"
        val time9="S_i"
        val time10="S_j"
        val time11 ="S_k"
        val time12="S_l"
        val time13 ="S_m"
        val time14="S_n"
        val time15="S_o"
        val time16="S_p"
        val time17 ="S_q"
        val work1="S_r"
        val work2="S_s"
        val work3="S_t"
        val work4="S_u"
        val work5="S_v"
        val work6="S_w"
        val work7="S_x"
        val work8="S_y"
        val work9="S_z"
        val work10="S_aim"
        val work11="S_ball"
        val work12="S_cat"
        val work13="S_don"
        val work14="S_dumb"
        val work15="S_ear"
        val work16="S_fan"
        val work17="S_go"
        val day1="S_hat"
        val date1="S_idol"




    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table $TB_name(ID INTEGER PRIMARY KEY AUTOINCREMENT,S_a TEXT,S_b TEXT,S_c TEXT,S_d TEXT,S_e TEXT,S_f TEXT,S_g TEXT,S_h TEXT,S_i TEXT,S_j TEXT,S_k TEXT ,S_l TEXT,S_m TEXT,S_n TEXT,S_o TEXT,S_p TEXT , S_q TEXT,S_r TEXT,S_s TEXT,S_t TEXT ,S_u TEXT,S_v TEXT,S_w TEXT,S_x TEXT ,S_y TEXT ,S_z TEXT,S_aim TEXT,S_ball TEXT,S_cat TEXT,S_don TEXT,S_dumb TEXT,S_ear TEXT,S_fan TEXT,S_go TEXT,S_hat TEXT,S_idol TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TB_name")
    }
    fun ADD_DATA(time1a:String,
                 time2a:String,
                 time3a:String,
                 time4a:String,
                 time5a:String,
                 time6a:String,
                 time7a:String,
                 time8a:String,
                 time9a:String,
                 time10a:String,
                 time11a:String,
                 time12a:String,
                 time13a:String,
                 time14a:String,
                 time15a:String,
                 time16a:String,
                 time17a:String,
                 work1a:String,
                 work2a:String,
                 work3a:String,
                 work4a:String,
                 work5a:String,
                 work6a:String,
                 work7a:String,
                 work8a:String,
                 work9a:String,
                 work10a:String,
                 work11a:String,
                 work12a:String,
                 work13a:String,
                 work14a:String,
                 work15a:String,
                 work16a:String,
                 work17a:String,
                 day1a:String,
                 date1a:String
    ){

        val DB=this.writableDatabase
        val values= ContentValues()
        values.put(time1,time1a)
        values.put(time2,time2a)
        values.put(time3,time3a)
        values.put(time4,time4a)
        values.put(time5,time5a)
        values.put(time6,time6a)
        values.put(time7,time7a)
        values.put(time8,time8a)
        values.put(time9,time9a)
        values.put(time10,time10a)
        values.put(time11,time11a)
        values.put(time12,time12a)
        values.put(time13,time13a)
        values.put(time14,time14a)
        values.put(time15,time15a)
        values.put(time16,time16a)
        values.put(time17,time17a)
        values.put(work1,work1a)
        values.put(work2,work2a)
        values.put(work3,work3a)
        values.put(work4,work4a)
        values.put(work5,work5a)
        values.put(work6,work6a)
        values.put(work7,work7a)
        values.put(work8,work8a)
        values.put(work9,work9a)
        values.put(work10,work10a)
        values.put(work11,work11a)
        values.put(work12,work12a)
        values.put(work13,work13a)
        values.put(work14,work14a)
        values.put(work15,work15a)
        values.put(work16,work16a)
        values.put(work17,work17a)
        values.put(day1,day1a)
        values.put(date1,date1a)
        DB.insert(TB_name,null,values)

    }
    fun Delete_data(id:String):Int{
        val DB=this.writableDatabase
        val item=DB.delete(TB_name,"id=?", arrayOf(id))
        return item
    }

    fun update(id:String,
               time1a:String,
               time2a:String,
               time3a:String,
               time4a:String,
               time5a:String,
               time6a:String,
               time7a:String,
               time8a:String,
               time9a:String,
               time10a:String,
               time11a:String,
               time12a:String,
               time13a:String,
               time14a:String,
               time15a:String,
               time16a:String,
               time17a:String,
               work1a:String,
               work2a:String,
               work3a:String,
               work4a:String,
               work5a:String,
               work6a:String,
               work7a:String,
               work8a:String,
               work9a:String,
               work10a:String,
               work11a:String,
               work12a:String,
               work13a:String,
               work14a:String,
               work15a:String,
               work16a:String,
               work17a:String,
               day1a:String,
               date1a:String):Boolean
    {
        val DB=this.writableDatabase
        val values= ContentValues()
        values.put(time1,time1a)
        values.put(time2,time2a)
        values.put(time3,time3a)
        values.put(time4,time4a)
        values.put(time5,time5a)
        values.put(time6,time6a)
        values.put(time7,time7a)
        values.put(time8,time8a)
        values.put(time9,time9a)
        values.put(time10,time10a)
        values.put(time11,time11a)
        values.put(time12,time12a)
        values.put(time13,time13a)
        values.put(time14,time14a)
        values.put(time15,time15a)
        values.put(time16,time16a)
        values.put(time17,time17a)
        values.put(work1,work1a)
        values.put(work2,work2a)
        values.put(work3,work3a)
        values.put(work4,work4a)
        values.put(work5,work5a)
        values.put(work6,work6a)
        values.put(work7,work7a)
        values.put(work8,work8a)
        values.put(work9,work9a)
        values.put(work10,work10a)
        values.put(work11,work11a)
        values.put(work12,work12a)
        values.put(work13,work13a)
        values.put(work14,work14a)
        values.put(work15,work15a)
        values.put(work16,work16a)
        values.put(work17,work17a)
        values.put(day1,day1a)
        values.put(date1,date1a)
        DB.update(TB_name,values,"id=?", arrayOf(id))
        return true

    }
    val data_getter:Cursor get() {

        val DB=this.writableDatabase
        var data=DB.rawQuery("select * from " + TB_name,null)
        return data
    }



}





















