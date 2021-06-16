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
import com.notes.alinfo.given.SQHelpergiven
import com.notes.alinfo.given.Subject22
import com.notes.alinfo.given.see_given


class Adaptergiven (context: Context, data:ArrayList<Subject22>):
    ArrayAdapter<Subject22>(context,0,data)
{
    var data2=data
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView= convertView
        itemView=   LayoutInflater.from(context).inflate(R.layout.item_subject_given,parent,false)
        val item=getItem(position)
        val idd=itemView.findViewById<TextView>(R.id.id_textview4)
        idd.text = item!!.id3
        val check=itemView.findViewById<TextView>(R.id.checking2)
        check.text = item!!.check3
        val amount=itemView.findViewById<TextView>(R.id.amount_textview4)
        amount.text = item!!.amount3
        val name=itemView.findViewById<TextView>(R.id.name_textview4)
        name.text = item!!.name_person3
        val time=itemView.findViewById<TextView>(R.id.time_textview4)
        time.text = item!!.time3
//        val return_=itemView.findViewById<TextView>(R.id.return_textview4)
//        return_.text = item!!.return_money3
        val deletebtn=itemView.findViewById<ImageButton>(R.id.delete_btn4)
        val updatebtn=itemView.findViewById<ImageButton>(R.id.update_btn4)
        val share=itemView.findViewById<ImageButton>(R.id.share_btn4)
        share.setOnClickListener {

                val sharingIntent = Intent(Intent.ACTION_SEND)
                sharingIntent.type = "text/plain"
                val shareBody = "You have to return me " +item!!.amount3+" which i had given to you on "+item!!.time3
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
                context.startActivity(Intent.createChooser(sharingIntent, "Share Via :"))



        }
        var db = SQHelpergiven(context)
        deletebtn.setOnClickListener {
            var alert2=  AlertDialog.Builder(context)
            alert2.setTitle("Delete")
                .setMessage("Do you want to Delete")
                .setIcon(R.drawable.delete)
                .setPositiveButton("Delete",
                    DialogInterface.OnClickListener { dialog, whichButton ->
                        if (db.Delete_data2(item!!.id3) > 0) {
                            this.data2.removeAt(position)
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
            alert.setContentView(R.layout.edit_transaction)
            var a = alert.findViewById<EditText>(R.id.amount2_upd)
            var b = alert.findViewById<EditText>(R.id.name_person2_upd)
            var c = alert.findViewById<EditText>(R.id.time2_upd)

            var btn = alert.findViewById<Button>(R.id.add_trans2_upd)
            a.setText(item!!.amount3)
            b.setText(item!!.name_person3)
            c.setText(item!!.time3)

            alert.show()
            btn.setOnClickListener {
                var e = a.text.toString()
                var f = b.text.toString()
                var g = c.text.toString()

                when{
                    TextUtils.isEmpty(e) -> Toast.makeText(
                        context,
                        "amount is Required",
                        Toast.LENGTH_SHORT
                    ).show()
                    TextUtils.isEmpty(f) -> Toast.makeText(
                        context,
                        "name is Required",
                        Toast.LENGTH_SHORT
                    ).show()
                    TextUtils.isEmpty(g) -> Toast.makeText(
                        context,
                        "Date/time of amount given is Required",
                        Toast.LENGTH_SHORT
                    ).show()

                    else->{
                        db.update(item!!.id3, e,f,g)
                        notifyDataSetChanged()
                        alert.dismiss()
                        val myIntent = Intent(context, see_given::class.java)
                        myIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        context.startActivity(myIntent)
                    }
                }

            }
        }
        return itemView
    }



}

