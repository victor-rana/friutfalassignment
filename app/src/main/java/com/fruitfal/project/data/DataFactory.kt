

import com.fruitfal.project.data.DataService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class DataFactory {

    val URL_ALL_COMMITS =  BASE_URL + "commits"

    companion object{
        private val BASE_URL = "https://api.github.com/repos/square/retrofit/"

        fun create(): DataService? {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
            return retrofit.create(DataService::class.java)
        }
    }
}