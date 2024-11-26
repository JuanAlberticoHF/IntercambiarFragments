package com.example.intercambiarfragments

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var boton1: Button
    private lateinit var boton2: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Crear una instancia del fragmento
        val firstFragment = FragmentUno()
        val secondFragment = FragmentDos()


        // Usar supportFragmentManager para manejar transacciones de fragmento
        var transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment, firstFragment)
        transaction.commit()


        boton1 = findViewById(R.id.button1)
        boton2 = findViewById(R.id.button2)
        boton1.setOnClickListener {
            transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment, firstFragment)
            transaction.commit()
        }


        boton2.setOnClickListener {
            transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment, secondFragment)
            transaction.commit()
        }
    }
}
