package com.notes.alinfo.Important_notes

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.notes.alinfo.R
import com.notes.alinfo.Subject

class Adapternotes (context: Context, data:ArrayList<Subject>):ArrayAdapter<Subject>(context,0,data)
{
    var data=data
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        itemView = LayoutInflater.from(context).inflate(R.layout.pass_dates_misc, parent, false)
        val item = getItem(position)
        val card = itemView.findViewById<LinearLayout>(R.id.onclicking)
        val idd = itemView.findViewById<TextView>(R.id.id_textview)
        idd.text = item!!.id
        val title = itemView.findViewById<TextView>(R.id.title_textview)
        title.text = item.title
        val desc = itemView.findViewById<TextView>(R.id.desc_textview)
        desc.text = item.desc
        val deletebtn = itemView.findViewById<ImageButton>(R.id.delete_btn)
        val updatebtn = itemView.findViewById<ImageButton>(R.id.update_btn)
        val sharebtn = itemView.findViewById<ImageButton>(R.id.share_btn)
        if(title.text==null) {
            title.visibility = View.GONE
        }
        sharebtn.setOnClickListener {
            val a=item.title
            val b=item.desc
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            val shareBody = "Title: $a\nDescription: $b"
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
            context.startActivity(Intent.createChooser(sharingIntent, "Share Via :"))

        }
        card.setOnClickListener{
        val intent = Intent(context, Show_notes::class.java)
            intent.putExtra("id", item.id)
        intent.putExtra("title", item.title)
        intent.putExtra("desc", item.desc)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }
        var db = SQHelpernotes(context)
        deletebtn.setOnClickListener {
            var alert2=  AlertDialog.Builder(context)
            alert2.setTitle("Delete")
                .setMessage("Do you want to Delete")
                .setIcon(R.drawable.delete)
                .setPositiveButton("Delete",
                    DialogInterface.OnClickListener { dialog, whichButton ->
                        if (db.Delete_data(item!!.id) > 0) {
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
        updatebtn.setOnClickListener  {

                var alert = Dialog(context)
                alert.setContentView(R.layout.edit)
                var a = alert.findViewById<EditText>(R.id.title_update_password)
                var b = alert.findViewById<EditText>(R.id.desc_update_password)
                var btn = alert.findViewById<Button>(R.id.update_btn3)
                a.setText(item!!.title)
                b.setText(item!!.desc)
                alert.show()
                btn.setOnClickListener {
                    var c = a.text.toString()
                    var d = b.text.toString()
                    when{
                        TextUtils.isEmpty(d) -> Toast.makeText(
                            context,
                            "Description is Required",
                            Toast.LENGTH_SHORT
                        ).show()
                        else->{
                            db.update(data[position].id, c, d)
                            notifyDataSetChanged()
                            alert.dismiss()
                            val myIntent = Intent(context,
                                see_notes::class.java)
                            myIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                            context.startActivity(myIntent)
                        }
                    }

                }

        }

        return itemView
    }



}

