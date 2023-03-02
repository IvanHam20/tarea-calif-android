package edu.iest.tarea_botones_intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ReprobadoActivity : AppCompatActivity() {

    private lateinit var tvReprobado: TextView
    private lateinit var bnRegresar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reprobado)

        var calificacion = intent.getStringExtra("calificacion")
        var texto = "Obtuviste un $calificacion ;("
        tvReprobado = findViewById<TextView>(R.id.tvReprobado)
        tvReprobado.setText(texto)

        bnRegresar = findViewById<Button>(R.id.bnRegresar)
        bnRegresar.setOnClickListener{
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }
}