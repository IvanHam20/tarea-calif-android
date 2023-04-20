package edu.iest.consumir_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import edu.iest.consumir_api.models.ImageRandom
import edu.iest.consumir_api.models.ImagenesRaza
import edu.iest.consumir_api.network.API
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        traerImagenAleatoria()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_images, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.optionMenuListImages){
            Toast.makeText(this,"Option menu 1", Toast.LENGTH_SHORT).show()
            val apiCall = API().crearServicioAPI()
            apiCall.listaImagenesDePerrosPorRaza("hound").enqueue(object: Callback<ImagenesRaza>{
                override fun onResponse(call: Call<ImagenesRaza>,response: Response<ImagenesRaza>) {
                    //Nuestra logica
                    val dogs = response.body()?.message// array
                    Log.d("PRUEBAS", "Status de la respuesta ${response.body()?.status}")
                    if (dogs != null){
                        for (dog in dogs) {
                            Log.d("PRUEBAS", "Perro es $dog")
                        }
                    }
                }

                override fun onFailure(call: Call<ImagenesRaza>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }
        return super.onOptionsItemSelected(item)
    }

    private fun traerImagenAleatoria(){
        val apiCall = API().crearServicioAPI()
        val ivPicasso = findViewById<ImageView>(R.id.ivPicasso)
        apiCall.imagenAleatoria().enqueue(object : Callback<ImageRandom> {
            override fun onResponse(call: Call<ImageRandom>, response:Response<ImageRandom>) {
                Picasso.get().load(response.body()?.message).into(ivPicasso)
                Log.d("API_PRUEBA", "status es " + response.body()?.status)
                Log.d("API_PRUEBA ", "message es " + response.body()?.message)
                // Aqui hacer lo que necesitemos con los datos
            }
            override fun onFailure(call: Call<ImageRandom>, t: Throwable) {
                Toast.makeText(this@MainActivity, "No fue posible conectar a API", Toast.LENGTH_SHORT ).show()
            }
        })
    }
}