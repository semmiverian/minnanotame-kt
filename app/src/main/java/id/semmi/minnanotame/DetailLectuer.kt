package id.semmi.minnanotame

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_detail_lectuer.*
import kotlinx.android.synthetic.main.content_detail_lectuer.*

class DetailLectuer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_lectuer)
        setSupportActionBar(toolbar)

        kosakata.setOnClickListener {
            startActivity(Intent(this, KosakataActivity::class.java))
        }

        materi1.setOnClickListener {
            startActivity(Intent(this, MateriActivity::class.java))
        }

        latihan1.setOnClickListener {
            startActivity(Intent(this, ExcerciseActivity::class.java))
        }
    }

}
