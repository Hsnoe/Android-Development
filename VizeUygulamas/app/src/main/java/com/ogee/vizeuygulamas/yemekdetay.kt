package com.ogee.vizeuygulamas

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ogee.vizeuygulamas.databinding.ActivityMainBinding
import com.ogee.vizeuygulamas.databinding.ActivityYemekdetayBinding

class yemekdetay : AppCompatActivity() {
    private lateinit var binding: ActivityYemekdetayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYemekdetayBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var intent =intent
        var name = intent.getStringExtra("isim")
        var malzemeler = intent.getStringExtra("malzemeler")
        var tarif = intent.getStringExtra("tarif")

        binding.yemekadi.text=name
        binding.malzemeler.text=malzemeler
        binding.tarif.text=tarif


        }
    }
