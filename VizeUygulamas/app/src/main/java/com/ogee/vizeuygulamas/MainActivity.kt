package com.ogee.vizeuygulamas

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ogee.vizeuygulamas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var textView5: TextView
    private var countdownTime = 5 // 5 saniye



    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        //süre ayarlaması handler ile
        Handler().postDelayed({
            val intent =Intent(this,ikinciSayfa::class.java)
            startActivity(intent)
            //finish() geriye dönmüyor uygulama geri gitmiyor
        },5000)

        // TextView'i bağla
        textView5 = findViewById(R.id.textView5)

        // Geri sayımı başlat
        startCountdown()


    }

    /// geri sayım kodu ana sayfadan ikinci sayfaya 5 sn yede geçiş (splah screen mantğı)
    private fun startCountdown() {
        val handler = Handler()
        val runnable = object : Runnable {
            override fun run() {
                if (countdownTime > 0) {
                    textView5.text = countdownTime.toString() // Geri sayım güncelle
                    countdownTime-- // Bir saniye eksilt
                    handler.postDelayed(this, 1000) // 1 saniye gecikmeli çalıştır
                } else {
                    // Zaman doldu, diğer sayfaya geç
                    val intent = Intent(this@MainActivity, ikinciSayfa::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
        handler.post(runnable)
    }

    // burda bitti


}