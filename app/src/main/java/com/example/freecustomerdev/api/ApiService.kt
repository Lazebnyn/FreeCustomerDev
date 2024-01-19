package com.example.freecustomerdev.api
import com.example.freecustomerdev.models.AnnouncementResponse
import retrofit2.http.GET

interface ApiService {
    @GET("v5/announcements/index?locale=en-US&limit=10")
    suspend fun getAnnouncements(): AnnouncementResponse
}