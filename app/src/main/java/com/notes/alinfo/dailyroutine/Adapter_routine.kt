package com.notes.alinfo.dailyroutine

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.notes.alinfo.R


class Adapter_routine(context : Context, data : ArrayList<Subject_routine>):ArrayAdapter<Subject_routine>(context,0,data)
{
    var data=data
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView= convertView
        itemView=   LayoutInflater.from(context).inflate(R.layout.daily,parent,false)
        val item=getItem(position)
        val idd=itemView.findViewById<TextView>(R.id.id_daily)
        idd.text = item!!.id5
        val timea=itemView.findViewById<TextView>(R.id.Time1)
        timea.text = item.time1a
        val timeb=itemView.findViewById<TextView>(R.id.Time2)
        timeb.text = item.time2a
        val timec=itemView.findViewById<TextView>(R.id.Time3)
        timec.text = item.time3a
        val timed=itemView.findViewById<TextView>(R.id.Time4)
        timed.text = item.time4a
        val timee=itemView.findViewById<TextView>(R.id.Time5)
        timee.text = item.time5a
        val timef=itemView.findViewById<TextView>(R.id.Time6)
        timef.text = item.time6a
        val timeg=itemView.findViewById<TextView>(R.id.Time7)
        timeg.text = item.time7a
        val timeh=itemView.findViewById<TextView>(R.id.Time8)
        timeh.text = item.time8a
        val timei=itemView.findViewById<TextView>(R.id.Time9)
        timei.text = item.time9a
        val timej=itemView.findViewById<TextView>(R.id.Time10)
        timej.text = item.time10a
        val timek=itemView.findViewById<TextView>(R.id.Time11)
        timek.text = item.time11a
        val timel=itemView.findViewById<TextView>(R.id.Time12)
        timel.text = item.time12a
        val timem=itemView.findViewById<TextView>(R.id.Time13)
        timem.text = item.time13a
        val timen=itemView.findViewById<TextView>(R.id.Time14)
        timen.text = item.time14a
        val timeo=itemView.findViewById<TextView>(R.id.Time15)
        timeo.text = item.time15a
        val timep=itemView.findViewById<TextView>(R.id.Time16)
        timep.text = item.time16a
        val timeq=itemView.findViewById<TextView>(R.id.Time17)
        timeq.text = item.time17a
        val worka=itemView.findViewById<TextView>(R.id.work1)
        worka.text = item.work1a
        val workb=itemView.findViewById<TextView>(R.id.work2)
        workb.text = item.work2a
        val workc=itemView.findViewById<TextView>(R.id.work3)
        workc.text = item.work3a
        val workd=itemView.findViewById<TextView>(R.id.work4)
        workd.text = item.work4a
        val worke=itemView.findViewById<TextView>(R.id.work5)
        worke.text = item.work5a
        val workf=itemView.findViewById<TextView>(R.id.work6)
        workf.text = item.work6a
        val workg=itemView.findViewById<TextView>(R.id.work7)
        workg.text = item.work7a
        val workh=itemView.findViewById<TextView>(R.id.work8)
        workh.text = item.work8a
        val worki=itemView.findViewById<TextView>(R.id.work9)
        worki.text = item.work9a
        val workj=itemView.findViewById<TextView>(R.id.work10)
        workj.text = item.work10a
        val workk=itemView.findViewById<TextView>(R.id.work11)
        workk.text = item.work11a
        val workl=itemView.findViewById<TextView>(R.id.work12)
        workl.text = item.work12a
        val workm=itemView.findViewById<TextView>(R.id.work13)
        workm.text = item.work13a
        val workn=itemView.findViewById<TextView>(R.id.work14)
        workn.text = item.work14a
        val worko=itemView.findViewById<TextView>(R.id.work15)
        worko.text = item.work15a
        val workp=itemView.findViewById<TextView>(R.id.work16)
        workp.text = item.work16a
        val workq=itemView.findViewById<TextView>(R.id.work17)
        workq.text = item.work17a
        val day=itemView.findViewById<TextView>(R.id.days)
        day.text= item.day
        val date=itemView.findViewById<TextView>(R.id.dates)
        date.text= item.date
        val deletebtn=itemView.findViewById<ImageButton>(R.id.delete_btn4_dail)
        val updatebtn=itemView.findViewById<ImageButton>(R.id.update_btn4_dail)
        val sharebtn=itemView.findViewById<ImageButton>(R.id.share_btn4_dail)

        sharebtn.setOnClickListener {
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            val shareBody = "Today's Routine\n" + item.time1a+": "+ item.work1a+"\n"+ item.time2a+": "+ item.work2a+"\n"+ item.time3a+": "+item.work3a+"\n"+item.time4a+": "+item.work4a+"\n"+item.time5a+": "+item.work5a+"\n"+ item.time6a+": "+item.work6a+"\n"+item.time7a+": "+item.work7a+"\n"+item.time8a+": "+item.work8a+"\n"+item.time9a+": "+item.work9a+"\n"+item.time10a+": "+item.work10a+"\n"+item.time11a+": "+item.work11a+"\n"+item.time12a+": "+item.work12a+"\n"+item.time13a+": "+item.work13a+"\n"+item.time14a+": "+item.work14a+"\n"+item.time15a+": "+item.work15a+"\n"+item.time16a+": "+item.work16a+"\n"+item.time17a+": "+item.work17a
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
            context.startActivity(Intent.createChooser(sharingIntent, "Share Via :"))

        }
        val db = SQHelperroutine(context)
        deletebtn.setOnClickListener {
            val alert2=  AlertDialog.Builder(context)
            alert2.setTitle("Delete")
                .setMessage("Do you want to Delete")
                .setIcon(R.drawable.delete)
                .setPositiveButton("Delete",
                    DialogInterface.OnClickListener { dialog, whichButton ->
                        if (db.Delete_data(item.id5) > 0) {
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
            val alert = Dialog(context)
            alert.setContentView(R.layout.update_daily)
            val a = alert.findViewById<EditText>(R.id.Time1)
            val b = alert.findViewById<EditText>(R.id.Time2)
            val c = alert.findViewById<EditText>(R.id.Time3)
            val d = alert.findViewById<EditText>(R.id.Time4)
            val e = alert.findViewById<EditText>(R.id.Time5)
            val f = alert.findViewById<EditText>(R.id.Time6)
            val g = alert.findViewById<EditText>(R.id.Time7)
            val h = alert.findViewById<EditText>(R.id.Time8)
            val i = alert.findViewById<EditText>(R.id.Time9)
            val j = alert.findViewById<EditText>(R.id.Time10)
            val k= alert.findViewById<EditText>(R.id.Time11)
            val f1 = alert.findViewById<EditText>(R.id.Time12)
            val g1 = alert.findViewById<EditText>(R.id.Time13)
            val h1 = alert.findViewById<EditText>(R.id.Time14)
            val i1 = alert.findViewById<EditText>(R.id.Time15)
            val j1 = alert.findViewById<EditText>(R.id.Time16)
            val k1= alert.findViewById<EditText>(R.id.Time17)
            val l = alert.findViewById<EditText>(R.id.work1)
            val m = alert.findViewById<EditText>(R.id.work2)
            val n = alert.findViewById<EditText>(R.id.work3)
            val o = alert.findViewById<EditText>(R.id.work4)
            val p = alert.findViewById<EditText>(R.id.work5)
            val q = alert.findViewById<EditText>(R.id.work6)
            val r = alert.findViewById<EditText>(R.id.work7)
            val s = alert.findViewById<EditText>(R.id.work8)
            val t = alert.findViewById<EditText>(R.id.work9)
            val u = alert.findViewById<EditText>(R.id.work10)
            val v = alert.findViewById<EditText>(R.id.work11)
            val q1 = alert.findViewById<EditText>(R.id.work12)
            val r1 = alert.findViewById<EditText>(R.id.work13)
            val s1 = alert.findViewById<EditText>(R.id.work14)
            val t1= alert.findViewById<EditText>(R.id.work15)
            val u1 = alert.findViewById<EditText>(R.id.work16)
            val v1 = alert.findViewById<EditText>(R.id.work17)
            val w=alert.findViewById<EditText>(R.id.day_Adap)
            val x=alert.findViewById<EditText>(R.id.date_adapt)
            val btn = alert.findViewById<Button>(R.id.add_upd3)
            a.setText(item.time1a)
            b.setText(item.time2a)
            c.setText(item.time3a)
            d.setText(item.time4a)
            e.setText(item.time5a)
            f.setText(item.time6a)
            g.setText(item.time7a)
            h.setText(item.time8a)
            i.setText(item.time9a)
            j.setText(item.time10a)
            k.setText(item.time11a)
            f1.setText(item.time12a)
            g1.setText(item.time13a)
            h1.setText(item.time14a)
            i1.setText(item.time15a)
            j1.setText(item.time16a)
            k1.setText(item.time17a)
            l.setText(item.work1a)
            m.setText(item.work2a)
            n.setText(item.work3a)
            o.setText(item.work4a)
            p.setText(item.work5a)
            q.setText(item.work6a)
            r.setText(item.work7a)
            s.setText(item.work8a)
            t.setText(item.work9a)
            u.setText(item.work10a)
            v.setText(item.work11a)
            q1.setText(item.work12a)
            r1.setText(item.work13a)
            s1.setText(item.work14a)
            t1.setText(item.work15a)
            u1.setText(item.work16a)
            v1.setText(item.work17a)
            w.setText(item.day)
            x.setText(item.date)
            alert.show()
            btn.setOnClickListener {
                val a=a.text.toString()
                val b=b.text.toString()
                val c=c.text.toString()
                val d=d.text.toString()
                val e=e.text.toString()
                val f=f.text.toString()
                val g=g.text.toString()
                val h=h.text.toString()
                val i=i.text.toString()
                val j=j.text.toString()
                val k=k.text.toString()
                val f1=f1.text.toString()
                val g1=g1.text.toString()
                val h1=h1.text.toString()
                val i1=i1.text.toString()
                val j1=j1.text.toString()
                val k1=k1.text.toString()
                val l=l.text.toString()
                val m=m.text.toString()
                val n=n.text.toString()
                val o=o.text.toString()
                val p=p.text.toString()
                val q=q.text.toString()
                val r=r.text.toString()
                val s=s.text.toString()
                val t=t.text.toString()
                val u=u.text.toString()
                val v=v.text.toString()
                val q1=q1.text.toString()
                val r1=r1.text.toString()
                val s1=s1.text.toString()
                val t1=t1.text.toString()
                val u1=u1.text.toString()
                val v1=v1.text.toString()
                val w=w.text.toString()
                val x=x.text.toString()

                db.update(data[position].id5,a,b,c,d,e,f,g,h,i,j,k,f1,g1,h1,i1,j1,k1,l,m,n,o,p,q,r,s,t,u,v,q1,r1,s1,t1,u1,v1,w,x)
                notifyDataSetChanged()
                alert.dismiss()
                val myIntent = Intent(context, see_routine::class.java)
                myIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                context.startActivity(myIntent)


            }
        }
        return itemView
    }



}









