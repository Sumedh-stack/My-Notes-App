package com.notes.alinfo.Important_notes



import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQHelpernotes(context:Context):SQLiteOpenHelper(context,
    DB_name,null,1)
{


    companion object{//place where we can add variables
    val DB_name="subjects2.db "
        val TB_name="Subject2 "
        val id="ID"
        val title ="S_title2"
        val desc="S_desc2"




    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table $TB_name(ID INTEGER PRIMARY KEY AUTOINCREMENT,S_title2 TEXT,S_desc2 TEXT)")//execsql will help to prepare table udsyntax
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TB_name")
    }
    fun ADD_DATA2(title_text:String,desc_text:String){

        val DB=this.writableDatabase
        val values= ContentValues()
        values.put(title,title_text)
        values.put(desc,desc_text)
        DB.insert(TB_name,null,values)

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
    fun update(id:String,title_text:String,desc_text:String):Boolean
    {
        val DB=this.writableDatabase
        val values= ContentValues()
        values.put(title,title_text)
        values.put(desc,desc_text)
        DB.update(TB_name,values,"id=?", arrayOf(id))
        return true

    }

}





















