package com.notes.alinfo.timetable

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import com.notes.alinfo.*

class Adapterstudies ( context: Context, data:ArrayList<Subject3>):ArrayAdapter<Subject3>(context,0,data)
{
    var data=data
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView= convertView
        itemView=   LayoutInflater.from(context).inflate(R.layout.studies_timetable,parent,false)
        val item=getItem(position)
        val idd=itemView.findViewById<TextView>(R.id.work_id2)
        idd.text = item!!.id7
        val card=itemView.findViewById<CardView>(R.id.card)
        val mon_list=itemView.findViewById<TextView>(R.id.work_monday2)
        mon_list.text = item!!.mon
        val tue_list=itemView.findViewById<TextView>(R.id.work_tuesday2)
        tue_list.text = item!!.tues
        val wed_list=itemView.findViewById<TextView>(R.id.work_wednesday2)
        wed_list.text = item!!.wed
        val thurs_list=itemView.findViewById<TextView>(R.id.work_thursday2)
        thurs_list.text = item!!.thurs
        val fri_list=itemView.findViewById<TextView>(R.id.work_friday2)
        fri_list.text = item!!.fri
        val sat_list=itemView.findViewById<TextView>(R.id.work_saturday2)
        sat_list.text = item!!.sat
        val sun_list=itemView.findViewById<TextView>(R.id.work_sunday2)
        sun_list.text = item!!.sun
        val deletebtn=itemView.findViewById<ImageButton>(R.id.delete55)
        val updatebtn=itemView.findViewById<ImageButton>(R.id.update_btn55)
        val sharebtn=itemView.findViewById<ImageButton>(R.id.share_btn55)
        var db = SQHelperstudies(context)
        card.setOnClickListener {
       var intent=Intent(context, Show_timetable::class.java)
            intent.putExtra("a",item!!.mon)
            intent.putExtra("b",item!!.tues)
            intent.putExtra("c",item!!.wed)
            intent.putExtra("d",item!!.thurs)
            intent.putExtra("e",item!!.fri)
            intent.putExtra("f",item!!.sat)
            intent.putExtra("g",item!!.sun)
            context.startActivity(intent)


        }
        deletebtn.setOnClickListener {
            var alert2=  AlertDialog.Builder(context)
            alert2.setTitle("Delete")
                .setMessage("Do you want to Delete")
                .setIcon(R.drawable.delete)
                .setPositiveButton("Delete",
                    DialogInterface.OnClickListener { dialog, whichButton ->
                        if (db.Delete_data(item!!.id7) > 0) {
                            this.data.removeAt(position)
                            notifyDataSetChanged()
                            //  notifyItemRangeChanged(position, this.itemCount)
                        }

                        dialog.dismiss()
                    })
                .setNegativeButton("cancel",
                    DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() })
                .create()
            alert2.show()

        }
        updatebtn.setOnClickListener {
            var alert = Dialog(context)
            alert.setContentView(R.layout.edit_time)
            var a = alert.findViewById<EditText>(R.id.work_monday3)
            var b = alert.findViewById<EditText>(R.id.work_tuesday3)
            var c = alert.findViewById<EditText>(R.id.work_wednesday3)
            var d = alert.findViewById<EditText>(R.id.work_thursday3)
            var e= alert.findViewById<EditText>(R.id.work_friday3)
            var f = alert.findViewById<EditText>(R.id.work_saturday3)
            var g = alert.findViewById<EditText>(R.id.work_sunday3)
            var btn = alert.findViewById<Button>(R.id.add5_update)
            a.setText(item!!.mon)
            b.setText(item!!.tues)
            c.setText(item!!.wed)
            d.setText(item!!.thurs)
            e.setText(item!!.fri)
            f.setText(item!!.sat)
            g.setText(item!!.sun)
            alert.show()
            btn.setOnClickListener {
                var h = a.text.toString()
                var i= b.text.toString()
                var j = c.text.toString()
                var k = d.text.toString()
                var l = e.text.toString()
                var m= f.text.toString()
                var n = g.text.toString()

                db.update(item.id7, h,i,j,k,l,m,n)
                notifyDataSetChanged()
                alert.dismiss()
                val myIntent = Intent(context, see_studies::class.java)
                myIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                context.startActivity(myIntent)
            }
        }
        sharebtn.setOnClickListener {
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            val shareBody = "Monday: " +item!!.mon+"\n" + "Tuesday: "+item!!.tues+"\n"+"Wednesday: " +item!!.wed+"\n" + "Thursday: "+item!!.thurs+"\n"+"Friday: " +item!!.fri+"\n" + "Saturday: "+item!!.sat+"\n" + "Sunday: "+item!!.sun
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
            context.startActivity(Intent.createChooser(sharingIntent, "Share Via :"))



        }
        return itemView
    }



}








