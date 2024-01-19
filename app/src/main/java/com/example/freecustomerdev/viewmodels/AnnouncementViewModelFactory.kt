package com.example.freecustomerdev.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.freecustomerdev.api.ApiService

//хранит ссылку на сервис API. Этот сервис будет передан в AnnouncementViewModel при его создании.
class AnnouncementViewModelFactory(private val apiService: ApiService) : ViewModelProvider.Factory {
    //переопределенная функция create, которая вызывается, когда требуется создать экземпляр ViewModel.
    //Она принимает класс ViewModel, который нужно создать, и возвращает экземпляр этого класса
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        //Это условное выражение проверяет, является ли запрашиваемый класс ViewModel экземпляром AnnouncementViewModel
        if (modelClass.isAssignableFrom(AnnouncementViewModel::class.java)) {
            //Если запрашиваемый класс ViewModel является AnnouncementViewModel,
            //то создается новый экземпляр AnnouncementViewModel с apiService в качестве зависимости и возвращается
            return AnnouncementViewModel(apiService) as T
        }
        //Если запрашиваемый класс ViewModel не является AnnouncementViewModel, то выбрасывается исключение IllegalArgumentException.
        //Это предотвращает создание ViewModel, которые не могут быть обработаны
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}