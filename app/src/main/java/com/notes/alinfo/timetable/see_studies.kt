
package com.notes.alinfo.timetable

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

import com.notes.alinfo.MainActivity
import com.notes.alinfo.R
import kotlinx.android.synthetic.main.activity_see_studies.*


class see_studies : AppCompatActivity() {
    lateinit var DB: SQHelperstudies
    lateinit var data: Cursor
    lateinit var items:ArrayList<Subject3>
  //  private lateinit var mInterstitialAd: InterstitialAd
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_studies)



//        MobileAds.initialize(this) {}
//
//        mInterstitialAd = InterstitialAd(this)
//        mInterstitialAd.adUnitId = "ca-app-pub-2474376873043059/3508875375"
//        mInterstitialAd.loadAd(AdRequest.Builder().build())















        val go =findViewById<Button>(R.id.go_studies)
        go.setOnClickListener{
            var intent = Intent(this@see_studies,
                MainActivity::class.java)
            startActivity(intent)
//            if (mInterstitialAd.isLoaded) {
//                mInterstitialAd.show()
//            } else {
//                Log.d("TAG", "The interstitial wasn't loaded yet.")
//            }
        }
        items=ArrayList()
        DB= SQHelperstudies(applicationContext)
        data=DB.data_getter2
        showData()

        val adapter=
            Adapterstudies(this@see_studies, items)
        var  list=findViewById<ListView>(R.id.list_studies)
        list.adapter=adapter
        plus_studies.setOnClickListener {
            startActivity(Intent(this@see_studies,
                add_studies::class.java))
        }
    }
    fun showData()
    {
        if(data.count==0)
        {
            Toast.makeText(applicationContext,"There is no item", Toast.LENGTH_SHORT).show()

        }

        while(data.moveToNext()){

            items.add(
                Subject3(
                    data.getString(0),
                    data.getString(1),
                    data.getString(2),
                    data.getString(3),
                    data.getString(4),
                    data.getString(5),
                    data.getString(6),
                    data.getString(7)
                )
            )

        }





    }
    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this,MainActivity::class.java))
    }
    override fun onStart() {
        super.onStart()
        showData()
    }

}



