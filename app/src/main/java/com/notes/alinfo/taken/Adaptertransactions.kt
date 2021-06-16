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
import com.notes.alinfo.*
import com.notes.alinfo.taken.SQHelpertransaction
import com.notes.alinfo.taken.see_transactions
import com.notes.alinfo.taken.subject2


class Adaptertransactions (context: Context, data:ArrayList<subject2>):
    ArrayAdapter<subject2>(context,0,data)
{
    var data=data
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView= convertView
        itemView=   LayoutInflater.from(context).inflate(R.layout.item_subject_taken,parent,false)
        val item=getItem(position)
        val idd=itemView.findViewById<TextView>(R.id.id_textview3)
        idd.text = item!!.id2
        val check=itemView.findViewById<TextView>(R.id.checking)
        check.text = item!!.check
        val amount=itemView.findViewById<TextView>(R.id.amount_textview3)
        amount.text = item!!.amount
        val name=itemView.findViewById<TextView>(R.id.name_textview3)
        name.text = item!!.name_person
        val time=itemView.findViewById<TextView>(R.id.time_textview3)
        time.text = item!!.time
//        val return_=itemView.findViewById<TextView>(R.id.return_textview3)
//        return_.text = item!!.return_money
        val deletebtn=itemView.findViewById<ImageButton>(R.id.delete_btn3)
        val updatebtn=itemView.findViewById<ImageButton>(R.id.update_btn3)
        val share=itemView.findViewById<ImageButton>(R.id.share_btn3)
        share.setOnClickListener {
            val sharingIntent = Intent(Intent.ACTION_SEND)
                sharingIntent.type = "text/plain"
                val shareBody = "I have to give you " +item!!.amount+" which i had taken from you on/at "+item!!.time
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
                context.startActivity(Intent.createChooser(sharingIntent, "Share Via :"))

        }
        var db = SQHelpertransaction(context)
        deletebtn.setOnClickListener {
            var alert2=  AlertDialog.Builder(context)
            alert2.setTitle("Delete")
                .setMessage("Do you want to Delete")
                .setIcon(R.drawable.delete)
                .setPositiveButton("Delete",
                    DialogInterface.OnClickListener { dialog, whichButton ->
                        if (db.Delete_data(item!!.id2) > 0) {
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
            alert.setContentView(R.layout.edit_transaction)
            var a = alert.findViewById<EditText>(R.id.amount2_upd)
            var b = alert.findViewById<EditText>(R.id.name_person2_upd)
            var c = alert.findViewById<EditText>(R.id.time2_upd)

            var btn = alert.findViewById<Button>(R.id.add_trans2_upd)
            a.setText(item!!.amount)
            b.setText(item!!.name_person)
            c.setText(item!!.time)

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
                        "Date/time of amount taken is Required",
                        Toast.LENGTH_SHORT
                    ).show()

                    else->{
                        db.update(item!!.id2, e,f,g)
                        notifyDataSetChanged()
                        alert.dismiss()
                        val myIntent = Intent(context, see_transactions::class.java)
                        myIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        context.startActivity(myIntent)
                    }
                }

            }
        }
        return itemView
    }



}

