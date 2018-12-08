package id.semmi.minnanotame

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        duadua.setOnClickListener {
            val materiBab22 = Intent(this, DetailLectuer::class.java)
            startActivity(materiBab22)
        }
    }
}
