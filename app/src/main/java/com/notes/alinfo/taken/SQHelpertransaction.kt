package com.notes.alinfo.taken

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQHelpertransaction(context:Context):SQLiteOpenHelper(context,
    DB_name,null,1)
{


    companion object{
        val DB_name="subjectsg.db "
        val TB_name="Subjectg "
        val id="ID"
        val check="S_check"
        val amount ="S_amount"
        val name="S_name"
        val time="S_time"
       // val return_money="S_return"



    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table $TB_name(ID INTEGER PRIMARY KEY AUTOINCREMENT,S_check TEXT,S_amount TEXT,S_name TEXT,S_time TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TB_name")
    }
    fun ADD_DATA(check_text:String,amount_text:String,name_text:String,time_text:String){

        val DB=this.writableDatabase
        val values= ContentValues()
        values.put(check,check_text)
        values.put(amount,amount_text)
        values.put(name,name_text)
        values.put(time,time_text)
       // values.put(return_money,return_money_text)
        DB.insert(TB_name,null,values)
    }
    fun update(id:String,amount_text:String,name_text:String,time_text:String):Boolean
    {
        val DB=this.writableDatabase
        val values= ContentValues()
        values.put(amount,amount_text)
        values.put(name,name_text)
        values.put(time,time_text)
       // values.put(return_money,return_money_text)
        DB.update(TB_name,values,"id=?", arrayOf(id))
        return true

    }
    fun Delete_data(id:String):Int{
        val DB=this.writableDatabase
        val item=DB.delete(TB_name,"id=?", arrayOf(id))
        return item
    }
    val data_getter:Cursor get() {

        val DB=this.writableDatabase
        var data=DB.rawQuery("select * from " + TB_name,null)
        return data
    }

}














