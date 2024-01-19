package com.example.freecustomerdev.models

data class Announcement(
    val title: String, // Заголовок объявления
    val description: String, // Описание объявления
    val type: AnnouncementType, // Тип объявления
    val tags: List<String>, // Теги объявления
    val url: String, // URL объявления
    val dateTimestamp: Long, // Время публикации объявления
    val startDateTimestamp: Long, // Время начала объявления
    val endDateTimestamp: Long // Время окончания объявления
)
