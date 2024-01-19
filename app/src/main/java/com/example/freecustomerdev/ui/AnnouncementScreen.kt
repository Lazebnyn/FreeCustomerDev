package com.example.freecustomerdev.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.freecustomerdev.api.RetrofitInstance
import com.example.freecustomerdev.models.Announcement
import com.example.freecustomerdev.viewmodels.AnnouncementViewModel
import com.example.freecustomerdev.viewmodels.AnnouncementViewModelFactory
import java.util.Date

@Composable
fun AnnouncementScreen() {
    //создается экземпляр ViewModel с помощью фабрики ViewModel
    val viewModel: AnnouncementViewModel = viewModel(
        factory = AnnouncementViewModelFactory(RetrofitInstance.apiService)
    )
    //Подписывается поток объявлений из ViewModel и собирается в состояние, которое может быть использовано в Composable.
    val announcements = viewModel.announcements.collectAsState()
    //Проверяется, есть ли ошибка. Если есть ошибка, то она отоброжается. В противном случае, отображается список объявлений.
    val error = viewModel.error.collectAsState()

    if (error.value != null) {
        Text(text = "Ошибка: ${error.value}")
    } else {
        //используется для отображения списка элементов
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(announcements.value?.result?.list ?: listOf()) { announcement ->
                AnnouncementItem(announcement)
            }
        }
    }
}

@Composable
fun AnnouncementItem(announcement: Announcement) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = announcement.title, style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = announcement.description, style = MaterialTheme.typography.body1)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Тип: ${announcement.type.title}", style = MaterialTheme.typography.body2)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Теги: ${announcement.tags.joinToString(", ")}", style = MaterialTheme.typography.body2)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "URL: ${announcement.url}", style = MaterialTheme.typography.body2)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Дата публикации: ${Date(announcement.dateTimestamp)}", style = MaterialTheme.typography.body2)
        }
    }
}