package com.example.freecustomerdev.models

data class AnnouncementList(
    val total: Int, // Общее количество объявлений
    val list: List<Announcement> // Список объявлений
)
