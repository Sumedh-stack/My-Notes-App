package com.notes.alinfo.given

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class SQHelpergiven(context: Context): SQLiteOpenHelper(context, DB_name,null,1)
{


    companion object{
        val DB_name="Topic.db "
        val TB_name="Topics "
        val id="ID"
        val check="S_check"
        val amount ="S_amount"
        val name="S_name"
        val time="S_time"




    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table $TB_name(ID INTEGER PRIMARY KEY AUTOINCREMENT,S_check TEXT,S_amount TEXT,S_name TEXT,S_time TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS ${TB_name}")
    }
    fun ADD_DATA(check_text:String,amount_text:String,name_text:String,time_text:String){

        val DB=this.writableDatabase
        val values= ContentValues()
        values.put(check,check_text)
        values.put(amount,amount_text)
        values.put(name,name_text)
        values.put(time,time_text)
      //  values.put(return_money,return_money_text)
        DB.insert(TB_name,null,values)
    }
    fun update(id2:String,amount_text:String,name_text:String,time_text:String):Boolean
    {
        val DB=this.writableDatabase
        val values= ContentValues()
        values.put(amount,amount_text)
        values.put(name,name_text)
        values.put(time,time_text)
        //values.put(return_money,return_money_text)
        DB.update(TB_name,values,"id=?", arrayOf(id2))
        return true

    }
    fun Delete_data2(id2:String):Int{
        val sqLiteDatabase=this.writableDatabase
        return sqLiteDatabase.delete(TB_name,"id=?", arrayOf(id2))

    }
    val data_getter:Cursor get() {

        val DB=this.writableDatabase
        var data=DB.rawQuery("select * from " + TB_name,null)
        return data
    }
}