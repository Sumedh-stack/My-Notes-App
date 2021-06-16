package com.notes.alinfo.Important_notes

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.notes.alinfo.MainActivity
import com.notes.alinfo.R
import kotlinx.android.synthetic.main.activity_show_notes.*

class Show_notes : AppCompatActivity() {
    lateinit var db:SQHelpernotes
    lateinit var title_d:EditText
    lateinit var descs:EditText
    lateinit var title_edit:String
    lateinit var id2:String
    lateinit var desc_edit:String

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_notes)
       id2=intent.getStringExtra("id")
        val title= intent.getStringExtra("title")
        val desc=  intent.getStringExtra("desc")
         title_d=findViewById(R.id.title_show)
         descs=findViewById(R.id.desc_show)
        title_d.setText(title)
        descs.setText(desc)
        var intent2 = Intent(this,see_notes::class.java)

        db=SQHelpernotes(applicationContext)
        back_go.setOnClickListener {
             title_edit=title_d.text.toString()
             desc_edit=descs.text.toString()
            if(desc_edit.isEmpty())
            {
                Toast.makeText(applicationContext,"Description is required",Toast.LENGTH_SHORT).show()
            }
            else{
                db.update(id2,title_edit,desc_edit)
                startActivity(intent2)
            }



        }
        share.setOnClickListener {
            title_edit=title_d.text.toString()
            desc_edit=descs.text.toString()
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            val shareBody = "Title: $title_edit\nDescription: $desc_edit"
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
            startActivity(Intent.createChooser(sharingIntent, "Share Via :"))
        }
        delete_show.setOnClickListener {
            val alert2=  AlertDialog.Builder(this)
            alert2.setTitle("Delete")
                .setMessage("Do you want to Delete")
                .setIcon(R.drawable.delete)
                .setPositiveButton("Delete",
                    DialogInterface.OnClickListener { dialog, whichButton ->
                        if (db.Delete_data(id2) > 0) {
                            startActivity(intent2)
                        }

                        dialog.dismiss()
                    })
                .setNegativeButton("cancel",
                    DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() })
                .create()
            alert2.show()

        }

    }
    override fun onBackPressed() {
        super.onBackPressed()
        title_edit=title_d.text.toString()
        desc_edit=descs.text.toString()
        var intent2 = Intent(this,see_notes::class.java)
        if(desc_edit.isEmpty())
        {
            Toast.makeText(applicationContext,"Description is required",Toast.LENGTH_SHORT).show()
        }
        else{
            db.update(id2,title_edit,desc_edit)
            startActivity(intent2)
        }
    }
}