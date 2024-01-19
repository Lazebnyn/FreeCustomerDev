package com.example.freecustomerdev.models

data class AnnouncementResponse(
    val retCode: Int, // Код ответа
    val retMsg: String, // Сообщение ответа
    val result: AnnouncementList, // Результат (список объявлений)
    val retExtInfo: Map<String, Any>, // Дополнительная информация ответа
    val time: Long // Время ответа
)
