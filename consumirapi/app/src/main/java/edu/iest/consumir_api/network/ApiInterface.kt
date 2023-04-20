package edu.iest.consumir_api.network

import edu.iest.consumir_api.models.ImageRandom
import edu.iest.consumir_api.models.ImagenesRaza
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("breeds/image/random")
    fun imagenAleatoria(): Call<ImageRandom>

    @GET("breed/{raza}/images")
    fun listaImagenesDePerrosPorRaza(@Path("raza") raza: String): Call<ImagenesRaza>

}