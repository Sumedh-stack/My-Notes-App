package com.notes.alinfo.timetable

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.notes.alinfo.R

class Adapter (context: Context, data:ArrayList<Subject4>): ArrayAdapter<Subject4>(context,0,data)
{
    var data=data
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView= convertView
        itemView=   LayoutInflater.from(context).inflate(R.layout.timetable_view,parent,false)
        val item=getItem(position)
        val mon_list=itemView.findViewById<TextView>(R.id.work_monday5)
        mon_list.text = item!!.mon
        val tue_list=itemView.findViewById<TextView>(R.id.work_tuesday5)
        tue_list.text = item!!.tues
        val wed_list=itemView.findViewById<TextView>(R.id.work_wednesday5)
        wed_list.text = item!!.wed
        val thurs_list=itemView.findViewById<TextView>(R.id.work_thursday5)
        thurs_list.text = item!!.thurs
        val fri_list=itemView.findViewById<TextView>(R.id.work_friday5)
        fri_list.text = item!!.fri
        val sat_list=itemView.findViewById<TextView>(R.id.work_saturday5)
        sat_list.text = item!!.sat
        val sun_list=itemView.findViewById<TextView>(R.id.work_sunday5)
        sun_list.text = item!!.sun

        return itemView
    }



}

