package id.semmi.minnanotame

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_materi.*

class MateriActivity : AppCompatActivity() {
    private lateinit var materiAdapter: MateriAdapter
    private var materiList = arrayListOf<Materi>()
    private val apiRepository = ApiRepository()

    private val BASE_URL = "http://35.231.148.14"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materi)

//        val listKalimat: List<Kalimat> = listOf(
//            Kalimat("それはミラさんが借りた本ですか", "Apakah itu buku yang dipinjam Mira?"),
//            Kalimat("昨日取った写真を見せてください", "Tolong perlihatkan foto yang (kamu) ambil kemarin")
//        )


//        val materiList: List<Materi> = listOf(
//            Materi("https://i.imgur.com/rz6jK23.png",
//                "Pola kalimat ini digunakan untuk menerangkan secara lebih spesifik Kata Benda (orang / benda / tempat / hal) dengan menggunakan frasa anak kalimat.\nPola kalimat ini digunakan untuk menerangkan secara lebih spesifik Kata Benda (orang / benda / tempat / hal) dengan menggunakan frasa anak kalimat",
//                "Contoh kalimat",
//                listKalimat
//            ),
//
//            Materi("https://i.imgur.com/rz6jK23.png",
//                "Pada pola kalimat ini, kata benda yang diterangkan oleh anak kalimat memiliki posisi sebagai objek, maka partikel yang digunakan setelah KB adalahを～",
//                "Contoh kalimat",
//                listKalimat
//            ),
//
//            Materi("https://i.imgur.com/rz6jK23.png",
//                "Pada pola kalimat ini, kata benda yang diterangkan oleh anak kalimat memiliki posisi sebagai objek, maka partikel yang digunakan setelah KB adalahを～",
//                "Contoh kalimat",
//                listKalimat
//            )
//        )

        materiAdapter = MateriAdapter(this, materiList)

        materi_recycler_view.adapter = materiAdapter

        materi_recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        apiRepository.getMateri()
            .subscribe({
                val mappedMateri = it.map {
                    val newImageLink = "${BASE_URL}/${it.image.substring(7)}"
                    Log.d("a", "$newImageLink")


                    val newKalimat = it.kalimat.map {
                        val newImageLink = "${BASE_URL}/${it.image.substring(7)}"

                        Kalimat(newImageLink, it.description)
                    }


                    Materi(newImageLink, it.description, it.title, newKalimat)
                }

                Log.d("b", mappedMateri.toString())

                materiList.addAll(mappedMateri)
                materiAdapter.notifyDataSetChanged()
            }, {
                Log.e("erroe", it.message)
            })
    }
}
