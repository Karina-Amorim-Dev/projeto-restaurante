package com.example.restaurante

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var status = findViewById<TextView>(R.id.textStatus)
        var contador = findViewById<TextView>(R.id.textContador)
        var btnEntrar = findViewById<Button>(R.id.btnEntrar)
        var btnSair = findViewById<Button>(R.id.btnSair)
        btnEntrar.setOnClickListener {
            var cont = contador.text.toString().toInt()
            cont++
            if(cont <= 10) {
                contador.text = cont.toString()
            }else{
                status.text = "Lotado!"
            }
        }
        btnSair.setOnClickListener {
            var cont = contador.text.toString().toInt()
            cont--
            if(cont >=0 && cont <=10){
                contador.text = cont.toString()
                status.text = "Pode Entrar"
            }
        }
    }
}