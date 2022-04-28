package binar.and.lima.filmchapterenam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import binar.and.lima.filmchapterenam.adapter.AdapterFilm
import binar.and.lima.filmchapterenam.model.GetAllFilmResponseItem
import binar.and.lima.filmchapterenam.network.ApiClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getDataFilm()

    }

    fun getDataFilm(){
        ApiClient.instance.getAllFilm()
            .enqueue(object : retrofit2.Callback<List<GetAllFilmResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetAllFilmResponseItem>>,
                    response: Response<List<GetAllFilmResponseItem>>
                ) {
                    if(response.isSuccessful){
                        val dataFilm = response.body()
                        val adapterFilm  = AdapterFilm(dataFilm!!)
                        val lm = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL,false)
                        rv_film.layoutManager = lm
                        rv_film.adapter = adapterFilm

                    }else{
                        Toast.makeText(this@MainActivity, response.message(), Toast.LENGTH_LONG).show()

                    }

                }

                override fun onFailure(call: Call<List<GetAllFilmResponseItem>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message , Toast.LENGTH_LONG).show()
                }


            })
    }
}