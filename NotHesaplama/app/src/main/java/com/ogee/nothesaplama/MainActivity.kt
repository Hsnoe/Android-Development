package com.ogee.nothesaplama

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // tanımlama
        val editTextVize = findViewById<EditText>(R.id.editTextText)
        val editTextFinal =findViewById<EditText>(R.id.editTextText4)
        val buttonHesapla = findViewById<Button>(R.id.button)
        val textViewSonuc =  findViewById<TextView>(R.id.textView2)

        //tıklama olayı

        buttonHesapla.setOnClickListener{
            val vizeNotuString =editTextVize.text.toString()
            val finalNotuString =editTextFinal.text.toString()

            //boş kontrolü
            if(vizeNotuString.isEmpty() || finalNotuString.isEmpty()){
                Toast.makeText(this,"Ynalış girdiniz tekrar kontrol ediniz",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val vizeNotu = vizeNotuString.toDouble()
            val finalNotu = finalNotuString.toDouble()

            val sonuc = (vizeNotu*0.4)+(finalNotu*0.6)

            textViewSonuc.text ="Sonuç : %.2f".format(sonuc)

        }
    }
}