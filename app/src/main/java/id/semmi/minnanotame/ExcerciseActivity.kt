package id.semmi.minnanotame

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_excercise.*

class ExcerciseActivity : AppCompatActivity() {
    private lateinit var excerciseAdapter: ExcerciseAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_excercise)


        val excercises: List<Excercise> = listOf(

            Excercise("彼女はNasigorengを食べました"),
            Excercise("彼は東京大学に留学しました"),
            Excercise("ケンさんはラーメンを食べませんでした"),
            Excercise("この料理はとてもおいしいです"),
            Excercise("デウィさんはテニスがあまり上手じゃありません")
        )


        excerciseAdapter = ExcerciseAdapter(this, excercises)

        excercise_recycler_view.adapter = excerciseAdapter
        excercise_recycler_view.layoutManager =  LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}
