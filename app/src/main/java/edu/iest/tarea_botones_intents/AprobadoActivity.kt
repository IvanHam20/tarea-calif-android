package edu.iest.tarea_botones_intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class AprobadoActivity : AppCompatActivity() {
    private lateinit var tvAprobado: TextView
    private lateinit var bnRegresar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aprobado)

        var calificacion = intent.getStringExtra("calificacion")
        var texto = "Felicidades aprobaste la materia con $calificacion :)"
        tvAprobado = findViewById<TextView>(R.id.tvAprobado)
        tvAprobado.setText(texto)

        bnRegresar = findViewById<Button>(R.id.bnRegresar)
        bnRegresar.setOnClickListener{
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }
}