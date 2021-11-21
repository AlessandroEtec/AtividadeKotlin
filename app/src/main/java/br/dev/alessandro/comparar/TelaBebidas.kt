package br.dev.alessandro.comparar

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.*
import kotlin.math.log


class TelaBebidas : AppCompatActivity() {
    var lista = arrayOf(269, 300, 350, 473, 600, 1000)
    lateinit var spinner1: Spinner
    lateinit var spinner2: Spinner
    lateinit var v1: EditText
    lateinit var v2: EditText
    lateinit var resultado: TextView
    lateinit var btnCalcular: Button
    lateinit var bloco1: LinearLayout
    lateinit var bloco2: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_bebidas)
        spinner1 = findViewById(R.id.select1)
        spinner2 = findViewById(R.id.select2)
        v1 = findViewById(R.id.txtV1)
        v2 = findViewById(R.id.txtV2)
        resultado = findViewById(R.id.resultado)
        btnCalcular = findViewById(R.id.btnCalcular)
        bloco1 = findViewById(R.id.bloco1)
        bloco2 = findViewById(R.id.bloco2)
        // var adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item, lista)
        //var adapter = ArrayAdapter.createFromResource(this, R.array.bebidas, android.R.layout.meu_spinner)
        var adapter = ArrayAdapter(this, R.layout.spinner_item, lista)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner1.setAdapter(adapter)
        spinner1.setSelection(0)
        spinner2.setAdapter(adapter)
        spinner2.setSelection(0)
        btnCalcular.setOnClickListener() {
            calcular();
        }
    }

    fun calcular() {
        if (v1.text.toString() == "") {
            Toast.makeText(applicationContext, "Digite o 1º Valor", Toast.LENGTH_SHORT).show()
        } else if (v2.text.toString() == "") {
            Toast.makeText(applicationContext, "Digite o 2º Valor", Toast.LENGTH_SHORT).show()
        } else {
            val valor1 = v1.text.toString().replace(",",".").toDouble()
            val valor2 = v2.text.toString().replace(",",".").toDouble()
            val volume1 = spinner1.selectedItem.toString().toDouble()
            val volume2 = spinner2.selectedItem.toString().toDouble()
            val t1 = valor1 / volume1
            val t2 = valor2 / volume2
            if (t1 < t2) {
                resultado.text = "Melhor opção: " + volume1.toInt()
                bloco1.setBackgroundColor(Color.CYAN)
                bloco2.setBackgroundColor(Color.WHITE)
            } else if (t2 < t1) {
                resultado.text = "Melhor opção: " + volume2.toInt()
                bloco2.setBackgroundColor(Color.CYAN)
                bloco1.setBackgroundColor(Color.WHITE)

            } else {
                bloco1.setBackgroundColor(Color.CYAN)
                bloco2.setBackgroundColor(Color.CYAN)
                resultado.text = "Tanto Faz"
            }
            val view = this.currentFocus
            if (view != null) {
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }
    }
}

