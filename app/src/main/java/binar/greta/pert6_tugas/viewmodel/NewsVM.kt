package binar.greta.pert6_tugas.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import binar.greta.pert6_tugas.data.NewsRepository
import binar.greta.pert6_tugas.model.GetAllNewsItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsVM @Inject constructor(private val api : NewsRepository) : ViewModel(){
    private val newsState = MutableStateFlow(emptyList<GetAllNewsItem>())

    val datastate : StateFlow<List<GetAllNewsItem>>
    get() = newsState

    init {
        viewModelScope.launch {
            val news = api.getNews()
            newsState.value = news
        }
    }
}