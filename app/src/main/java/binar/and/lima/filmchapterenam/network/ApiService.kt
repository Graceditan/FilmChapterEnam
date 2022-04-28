package binar.and.lima.filmchapterenam.network

import binar.and.lima.filmchapterenam.model.GetAllFilmResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("apifilm.php")
    fun getAllFilm(): Call<List<GetAllFilmResponseItem>>
}