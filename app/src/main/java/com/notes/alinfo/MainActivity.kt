package com.notes.alinfo

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.notes.alinfo.Important_notes.see_notes
import com.notes.alinfo.dailyroutine.see_routine
import com.notes.alinfo.timetable.see_studies
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.settings.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var d=0
lateinit var transactions:Button
    lateinit var passwords:Button
    lateinit var study:Button
    lateinit var dates:Button
    lateinit var lang:Button
    lateinit var miscellaneous:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadLocate() // call LoadLocate
        setContentView(R.layout.activity_main)
        transactions = findViewById(R.id.transactions)
        passwords = findViewById(R.id.passwords)
        study = findViewById(R.id.study)
        dates = findViewById(R.id.dates)
       // lang = findViewById(R.id.lang)
        val actionBar = supportActionBar
        actionBar!!.title = resources.getString(R.string.app_name)

var g=getSharedPreferences("start", MODE_PRIVATE)
 d=g.getInt("started",0)
if(d==0)
    showChangeLang()

        transactions.setOnClickListener {
            startActivity(Intent(this@MainActivity, option_transactions::class.java))
        }
        passwords.setOnClickListener {
            startActivity(
                Intent(
                    this@MainActivity,
                    see_routine::class.java
                )
            )
        }
        study.setOnClickListener {
            startActivity(
                Intent(
                    this@MainActivity,
                    see_studies::class.java
                )
            )
        }
        dates.setOnClickListener {
            startActivity(
                Intent(
                    this@MainActivity,
                    see_notes::class.java
                )
            )
        }
//        miscellaneous.setOnClickListener {
//            startActivity(Intent(this@MainActivity, editmiscellenous::class.java))
//        }
        buttong.setOnClickListener {
            var alert = Dialog(this@MainActivity)
            alert.setContentView(R.layout.settings)
            alert.show()
            alert.button.setOnClickListener {
                var intent = Intent(Intent.ACTION_SEND)
                var recipients = arrayOf("appson321@gmail.com")
                intent.putExtra(Intent.EXTRA_EMAIL, recipients)
                intent.putExtra(Intent.EXTRA_SUBJECT, "")
                intent.putExtra(Intent.EXTRA_TEXT, "")
                intent.putExtra(Intent.EXTRA_CC, "appson321@gmail.com")
                intent.setType("text/html")
                intent.setPackage("com.google.android.gm")
                startActivity(intent)

            }
            alert.textView_share.setOnClickListener {
                val sharingIntent = Intent(Intent.ACTION_SEND)
                sharingIntent.type = "text/plain"
                val shareBody = "App link"
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
                startActivity(Intent.createChooser(sharingIntent, "Share Via :"))
            }
            alert.textView_feedback.setOnClickListener {
                var intent = Intent(Intent.ACTION_SEND)
                var recipients = arrayOf("appson321@gmail.com")
                intent.putExtra(Intent.EXTRA_EMAIL, recipients)
                intent.putExtra(Intent.EXTRA_SUBJECT, "")
                intent.putExtra(Intent.EXTRA_TEXT, "")
                intent.putExtra(Intent.EXTRA_CC, "appson321@gmail.com")
                intent.setType("text/html")
                intent.setPackage("com.google.android.gm")
                startActivity(intent)
            }
            alert.textView_changelang.setOnClickListener {
                showChangeLang()
            }
            alert.translate.setOnClickListener {
                showChangeLang()

            }
        }


    }
    private fun showChangeLang() {

        val listItmes =   arrayOf("English","हिन्दी", "मराठी", "French", "Spanish", "ગુજરતી")

        val mBuilder = AlertDialog.Builder(this@MainActivity)
        mBuilder.setTitle("Choose Language")
        mBuilder.setSingleChoiceItems(listItmes, -1) { dialog, which ->
            d=1
            var editor=getSharedPreferences("start", MODE_PRIVATE).edit()
editor.putInt("started",d)
editor.apply()
            if (which == 0) {
                setLocate("en")
                recreate()
            } else if (which == 1) {
                setLocate("hi")
                recreate()
            } else if (which == 2) {
                setLocate("Mr")
                recreate()
            } else if (which == 3) {
                setLocate("fr")
                recreate()
            }
            else if (which == 4) {
                setLocate("es")
                recreate()
            }
            else if (which == 5) {
                setLocate("gu")
                recreate()
            }
            dialog.dismiss()
        }
        val mDialog = mBuilder.create()

        mDialog.show()

    }

    private fun setLocate(Lang: String) {

        val locale = Locale(Lang)

        Locale.setDefault(locale)

        val config = Configuration()

        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)

        val editor = getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
        editor.putString("My_Lang", Lang)
        editor.apply()
    }

    private fun loadLocate() {
        val sharedPreferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE)
        val language = sharedPreferences.getString("My_Lang", "")
        if (language != null) {
            setLocate(language)
        }
    }
//    private fun changeLanguagebox() {
//        val listitems =
//            arrayOf("English","हिन्दी", "मराठी", "French", "Spanish")
//        val mbuilder = AlertDialog.Builder(this@MainActivity)
//        mbuilder.setTitle("Choose Language")
//        mbuilder.setSingleChoiceItems(listitems, -1, DialogInterface.OnClickListener(){ dialogInterface : DialogInterface, i : Int ->
//
//            if (i == 0) {
//                setLocale("en")
//                recreate()
//           //   startActivity(Intent(this,MainActivity::class.java))
//            }
//            if (i == 1) {
//                setLocale("hi")
//                recreate()
//             // startActivity(Intent(this,MainActivity::class.java))
//            }
//            if (i == 2) {
//                setLocale("mr")
//                recreate()
//           //startActivity(Intent(this,MainActivity::class.java))
//
//            }
//            if (i == 3) {
//                setLocale("fr")
//                recreate()
//              //  startActivity(Intent(this,MainActivity::class.java))
//            }
//            if (i == 4) {
//                setLocale("es")
//                recreate()
//             // startActivity(Intent(this,MainActivity::class.java))
//            }
//
//            dialogInterface.dismiss()
//
//        } )
//var alert=mbuilder.create()
//        alert.show()
//
//
//        }
//
//
//
//    private fun setLocale(lang : String) {
//        val locale = Locale(lang)
//        Locale.setDefault(locale)
//        val config = Configuration()
//        config.locale = locale
//        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
//        val editor = getSharedPreferences("Settings", MODE_PRIVATE).edit()
//        editor.putString("My_Lang", lang)
//        editor.apply()
//
//    }
//    fun LoadLocale() {
//        val prefs = getSharedPreferences("Settings", MODE_PRIVATE)
//        val language = prefs.getString("My_Lang", "")
//        setLocale(language!!)
//    }
    fun share(view: View?) {
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        val shareBody = "https://play.google.com/store/apps/details?id=com.notes.alinfo"
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
     startActivity(Intent.createChooser(sharingIntent, "Share Via :"))
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val homeIntent = Intent(Intent.ACTION_MAIN)
        homeIntent.addCategory(Intent.CATEGORY_HOME)
        homeIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(homeIntent)
    }
}
