package com.ogee.vizeuygulamas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Oyun : AppCompatActivity() {
    private lateinit var kelimeTextView: TextView
    private lateinit var cevapInput: EditText
    private lateinit var cevapButon: Button
    private lateinit var sonucText: TextView

    private val kelimeler = listOf(
        "elma", "armut", "muz", "karpuz", "portakal", "domates", "salata", "patates", "kavun", "çilek"
    )
    private var dogruKelime = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_oyun)

        // xml dosyalarına burdan ulaştık
        kelimeTextView = findViewById(R.id.kelime)
        cevapInput = findViewById(R.id.cevap_input)
        cevapButon = findViewById(R.id.cevap_buton)
        sonucText = findViewById(R.id.sonuc_text)

        // kontrol et butonuna tıkladığımda çalışan yer
        cevapButon.setOnClickListener {
            val cevap = cevapInput.text.toString().trim().toLowerCase()
            if (cevap == dogruKelime) {
                sonucText.text = "Doğru"
                Toast.makeText(this, "Tebrikler! Doğru bildiniz.", Toast.LENGTH_SHORT).show()
            } else {
                sonucText.text = "Yanlış"
                Toast.makeText(this, "Yanlış cevap, tekrar deneyin!", Toast.LENGTH_SHORT).show()
            }
        }

        // Rastgele kelime seçimi
        yeniKelimeSec()
    }

    private fun yeniKelimeSec() {
        // Rastgele bir kelime seç
        dogruKelime = kelimeler.random()

        // Karışık harfleri oluştur
        val karisikHarfler = dogruKelime.toCharArray().apply { shuffle() }.joinToString("")

        // TextView'i güncelle
        kelimeTextView.text = "Karışık Kelime: $karisikHarfler"

        // Sonucu sıfırla
        sonucText.text = ""
    }


}