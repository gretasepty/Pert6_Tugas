package binar.greta.pert6_tugas.data

import binar.greta.pert6_tugas.model.GetAllNewsItem
import binar.greta.pert6_tugas.network.ApiService
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsapi : ApiService) {
    suspend fun getNews() : List<GetAllNewsItem>{
        return newsapi.getAllNews()
    }
}