package id.semmi.minnanotame

import retrofit2.http.GET
import java.util.*
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiInterface {
    @GET("/kosakata")
    fun getKosakata() : Observable<List<Kosakata>>

    @GET("/materi")
    fun getMateri() : Observable<List<Materi>>

    @GET("/excercise")
    fun getExcercise() : Observable<List<Excercise>>

    @POST("/excercise/answer")
    fun submitExercise(@Body quiz: Quiz) : Observable<Excercise>
}