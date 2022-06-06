package binar.greta.pert6_tugas.network

import binar.greta.pert6_tugas.model.GetAllNewsItem
import retrofit2.http.GET

interface ApiService {
    @GET("news")
    suspend fun getAllNews() : List<GetAllNewsItem>
}