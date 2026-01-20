package com.kmobile.ancientegypt



import com.kmobile.ancientegypt.data.remote.api.MetApiService
import com.kmobile.ancientegypt.data.repository.MuseumRepository
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory


class AppContainer {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://collectionapi.metmuseum.org/public/collection/v1/")
        .addConverterFactory(JacksonConverterFactory.create())
        .build()

    private val api: MetApiService = retrofit.create(MetApiService::class.java)

    val museumRepository = MuseumRepository(api)
}
