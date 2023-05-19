package com.arturomarmolejo.weathercomposechallenge.data.rest

import com.arturomarmolejo.weathercomposechallenge.data.model.weather.WeatherResponse
import com.arturomarmolejo.weathercomposechallenge.utils.API_KEY
import com.arturomarmolejo.weathercomposechallenge.utils.API_KEY_QUERY
import com.arturomarmolejo.weathercomposechallenge.utils.CITY_QUERY
import com.arturomarmolejo.weathercomposechallenge.utils.LAT_QUERY
import com.arturomarmolejo.weathercomposechallenge.utils.LON_QUERY
import com.arturomarmolejo.weathercomposechallenge.utils.METRIC_QUERY
import com.arturomarmolejo.weathercomposechallenge.utils.WEATHER_PATH
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * [ServiceApi] -
 * Defines methods to call the API with Retrofit
 */
interface ServiceApi {

    /**
     * [getWeatherWithLocation] -
     * Get Weather information from the API
     * @param lat Double
     * @param lon Double
     * @param units String
     * @param apiKey String
     * @return Response<WeatherResponse>
     */
    @GET(WEATHER_PATH)
    suspend fun getWeatherWithLocation(
        @Query(LAT_QUERY) lat: Double,
        @Query(LON_QUERY) lon: Double,
        @Query(METRIC_QUERY) units: String,
        @Query(API_KEY_QUERY) apiKey: String = API_KEY
    ): Response<WeatherResponse>

    /**
     * [getWeatherWithCity] -
     * Get Weather information from the API
     * @param city city of the search
     * @param units String
     * @param apiKey String
     * @return Response<WeatherResponse>
     */
    @GET(WEATHER_PATH)
    suspend fun getWeatherWithCity(
        @Query(CITY_QUERY) city: String,
        @Query(METRIC_QUERY) units: String,
        @Query(API_KEY_QUERY) apiKey: String = API_KEY
    ): Response<WeatherResponse>

}