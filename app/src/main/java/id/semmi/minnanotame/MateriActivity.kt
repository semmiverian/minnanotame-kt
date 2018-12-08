package id.semmi.minnanotame

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_materi.*

class MateriActivity : AppCompatActivity() {
    private lateinit var materiAdapter: MateriAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materi)

        val listKalimat: List<Kalimat> = listOf(
            Kalimat("それはミラさんが借りた本ですか", "Apakah itu buku yang dipinjam Mira?"),
            Kalimat("昨日取った写真を見せてください", "Tolong perlihatkan foto yang (kamu) ambil kemarin")
        )


        val materiList: List<Materi> = listOf(
            Materi("https://i.imgur.com/rz6jK23.png",
                "Pola kalimat ini digunakan untuk menerangkan secara lebih spesifik Kata Benda (orang / benda / tempat / hal) dengan menggunakan frasa anak kalimat.\nPola kalimat ini digunakan untuk menerangkan secara lebih spesifik Kata Benda (orang / benda / tempat / hal) dengan menggunakan frasa anak kalimat",
                "Contoh kalimat",
                listKalimat
            ),

            Materi("https://i.imgur.com/rz6jK23.png",
                "Pada pola kalimat ini, kata benda yang diterangkan oleh anak kalimat memiliki posisi sebagai objek, maka partikel yang digunakan setelah KB adalahを～",
                "Contoh kalimat",
                listKalimat
            ),

            Materi("https://i.imgur.com/rz6jK23.png",
                "Pada pola kalimat ini, kata benda yang diterangkan oleh anak kalimat memiliki posisi sebagai objek, maka partikel yang digunakan setelah KB adalahを～",
                "Contoh kalimat",
                listKalimat
            )
        )

        materiAdapter = MateriAdapter(this, materiList)

        materi_recycler_view.adapter = materiAdapter

        materi_recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }
}
