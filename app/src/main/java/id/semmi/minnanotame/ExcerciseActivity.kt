package id.semmi.minnanotame

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_excercise.*

class ExcerciseActivity : AppCompatActivity() {
    private lateinit var excerciseAdapter: ExcerciseAdapter
    private val apiRepository = ApiRepository()
    private var excercises = arrayListOf<Excercise>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_excercise)


//        val excercises: List<Excercise> = listOf(
//
//            Excercise("彼女はNasigorengを食べました"),
//            Excercise("彼は東京大学に留学しました"),
//            Excercise("ケンさんはラーメンを食べませんでした"),
//            Excercise("この料理はとてもおいしいです"),
//            Excercise("デウィさんはテニスがあまり上手じゃありません")
//        )


        excerciseAdapter = ExcerciseAdapter(this, excercises) { inputedText: String, selectedIndex: Int ->
            val newExercise = excercises.mapIndexed { index, excercise ->
                if (index == selectedIndex) {
                    Excercise(excercise.question, inputedText)
                } else {
                    excercise
    }
}

Log.d("coba", newExercise.toString())
}

excercise_recycler_view.adapter = excerciseAdapter
excercise_recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


apiRepository.getExcercise()
.subscribe {
    excercises.addAll(it)

    excerciseAdapter.notifyDataSetChanged()
}

        submit_quiz.setOnClickListener {
            apiRepository.submitExcercise(Quiz(nama.text.toString(), excercises))
                .subscribe {
                    Log.d("Success", "Berhasil memasukkan soal quiz")
                    Snackbar.make(coordinator_layout, R.string.snackbar_success, Snackbar.LENGTH_SHORT).show()
                }


        }


    }
}
