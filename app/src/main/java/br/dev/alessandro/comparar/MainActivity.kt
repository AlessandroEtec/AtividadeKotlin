package br.dev.alessandro.comparar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var btnBebidas: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnBebidas = findViewById(R.id.btnBebidas)
        btnBebidas.setOnClickListener(){
            startActivity(Intent(this, TelaBebidas::class.java))
        }
    }
}