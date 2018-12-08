package id.semmi.minnanotame

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_kosakata.*
import kotlinx.android.synthetic.main.content_kosakata.*

class KosakataActivity : AppCompatActivity() {
    private lateinit var kosakataAdapter: KosakataAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kosakata)
        setSupportActionBar(toolbar)

        val kosakataList: List<Kosakata> = listOf(
            Kosakata("", "よく", "Seringkali"),
            Kosakata("きます", "着ます", "Memakai (untuk benda yang dikenakan di pinggang ke atas"),
            Kosakata("はきます", "履きます", "Memakai (untuk benda yang dikenakan di pinggang ke bawah") ,
            Kosakata("めがね", "眼鏡", "Kacamata"),
            Kosakata("", "コート", "Mantel jas"),
            Kosakata("", "ジーンズ", "Celana Jeans")
        )

        kosakataAdapter = KosakataAdapter(this, kosakataList)

        kosakata_recycler_view.adapter = kosakataAdapter

        kosakata_recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

}
