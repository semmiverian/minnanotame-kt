package id.semmi.minnanotame

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiRepository {
//    val baseURL: String = "http://10.0.2.2:3000"
    val baseURL: String = "http://35.231.148.14"

    fun provideOkHttpClientBuilder(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient.Builder {
        return OkHttpClient.Builder().addNetworkInterceptor(httpLoggingInterceptor)
    }

    fun provideInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    }

    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .client(OkHttpClient.Builder().addNetworkInterceptor(provideInterceptor()).build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    fun api(): ApiInterface {
        return provideRetrofit().create(ApiInterface::class.java)
    }


    fun getKosakata(): Observable<List<Kosakata>> {
        val kosakataObserver: Observable<List<Kosakata>> = api().getKosakata()
        return kosakataObserver
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getMateri(): Observable<List<Materi>> {
        val materiObserver: Observable<List<Materi>> = api().getMateri()

        return materiObserver
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getExcercise(): Observable<List<Excercise>> {
        val excerciseObserver: Observable<List<Excercise>> = api().getExcercise()

        return excerciseObserver
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun submitExcercise(quiz: Quiz) : Observable<Excercise> {
        val quizObserver : Observable<Excercise> = api().submitExercise(quiz)

        return quizObserver
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    }


}