package edu.iest.tarea_botones_intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var etCalif: EditText
    private var calificacion: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etCalif = findViewById(R.id.etCalif)

        var bnEnviar = findViewById<Button>(R.id.bnEnviar)
        bnEnviar.setOnClickListener{
            calificacion = etCalif.text.toString()
            if (Integer.valueOf(calificacion) in 7..10){
                val i = Intent(this, AprobadoActivity::class.java)
                i.putExtra("calificacion", calificacion)
                startActivity(i)
            } else if (Integer.valueOf(calificacion)  < 7) {
                val i = Intent(this, ReprobadoActivity::class.java)
                i.putExtra("calificacion", calificacion)
                startActivity(i)
            } else {
                Toast.makeText(this, "El numero introducido esta incorrecto", Toast.LENGTH_LONG).show()
            }
        }
    }
}