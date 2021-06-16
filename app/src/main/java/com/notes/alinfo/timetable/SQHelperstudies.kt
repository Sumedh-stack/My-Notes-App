package com.notes.alinfo.timetable




import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQHelperstudies(context:Context):SQLiteOpenHelper(context,
    DB_name,null,1)
{


    companion object{//place where we can add variables
    val DB_name="subjectsc.db "
        val TB_name="Subjectc "
        val id="ID"
        val monday_ ="S_monday6"
        val tuesday_="S_tuesday6"
        val wednesday_ ="S_wednesday6"
        val thursday_="S_thursday6"
        val friday_ ="S_friday6"
        val saturday_="S_saturday6"
        val sunday_ ="S_sunday6"



    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table $TB_name(ID INTEGER PRIMARY KEY AUTOINCREMENT,S_monday6 TEXT,S_tuesday6 TEXT,S_wednesday6 TEXT,S_thursday6 TEXT,S_friday6 TEXT,S_saturday6 TEXT,S_sunday6 TEXT)")//execsql will help to prepare table udsyntax
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TB_name")
    }
    fun ADD_DATA2(monday_text:String,tuesday_text:String,wednesday_text:String,thursday_text:String,friday_text:String,saturday_text:String,sunday_text:String){

        val DB=this.writableDatabase
        val values= ContentValues()
        values.put(monday_,monday_text)
        values.put(tuesday_,tuesday_text)
        values.put(wednesday_,wednesday_text)
        values.put(thursday_,thursday_text)
        values.put(friday_,friday_text)
        values.put(saturday_,saturday_text)
        values.put(sunday_,sunday_text)
        DB.insert(TB_name,null,values)

    }
    fun update(id:String,monday_text:String,tuesday_text:String,wednesday_text:String,thursday_text:String,friday_text:String,saturday_text:String,sunday_text:String):Boolean
    {
        val DB=this.writableDatabase
        val values= ContentValues()
        values.put(monday_,monday_text)
        values.put(tuesday_,tuesday_text)
        values.put(wednesday_,wednesday_text)
        values.put(thursday_,thursday_text)
        values.put(friday_,friday_text)
        values.put(saturday_,saturday_text)
        values.put(sunday_,sunday_text)
        DB.update(TB_name,values,"id=?", arrayOf(id))
        return true

    }
        fun Delete_data(id:String):Int{
        val DB=this.writableDatabase
        val item=DB.delete(TB_name,"id=?", arrayOf(id))
        return item
    }
    val data_getter2:Cursor get() {

        val DB=this.writableDatabase
        var data=DB.rawQuery("select * from " + TB_name,null)
        return data
    }


}



