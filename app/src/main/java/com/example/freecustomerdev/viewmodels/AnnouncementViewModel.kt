package com.example.freecustomerdev.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freecustomerdev.api.ApiService
import com.example.freecustomerdev.models.AnnouncementResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

//приватное свойство класса, которое хранит ссылку на сервис API
class AnnouncementViewModel(private val apiService: ApiService) : ViewModel() {

    //хранит текущее состояние объявлений
    private val _announcements = MutableStateFlow<AnnouncementResponse?>(null)
    //предоставляет доступ только для чтения к _announcements
    val announcements: StateFlow<AnnouncementResponse?> get() = _announcements

    //хранит текущее состояние ошибкихранит текущее состояние ошибки
    private val _error = MutableStateFlow<String?>(null)
    //публичное свойство, которое предоставляет доступ только для чтения к _error
    val error: StateFlow<String?> get() = _error

//    Это блок инициализации, который вызывается при создании экземпляра AnnouncementViewModel.
//    Он вызывает функцию loadAnnouncements(), чтобы загрузить объявления сразу после создания ViewModel
    init {
        loadAnnouncements()
    }

    //Это приватная функция, которая загружает объявления из API.
    //Она запускает сопрограмму в viewModelScope, которая выполняет запрос к API и сохраняет ответ в _announcements.
    //Если происходит ошибка, она перехватывается и сообщение об ошибке сохраняется в _error
    private fun loadAnnouncements() {
        viewModelScope.launch {
            try {
                val response = apiService.getAnnouncements()
                _announcements.value = response
            } catch (e: Exception) {
                _error.value = e.localizedMessage
            }
        }
    }
}