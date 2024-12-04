package com.ogee.sparismenu

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //  yemekler ve içecekler RadioGroup
        val radioGroupAnaYemek = findViewById<RadioGroup>(R.id.radioGroup4)
        val radioGroupIcecek = findViewById<RadioGroup>(R.id.radioGroup5)

        // CheckBox'ları bul
        val checkBoxEkstra1 = findViewById<CheckBox>(R.id.checkBox3)
        val checkBoxEkstra2 = findViewById<CheckBox>(R.id.checkBox)

        // Sipariş Ver butonunu bul
        val buttonSiparisVer = findViewById<Button>(R.id.button1)
        buttonSiparisVer.setOnClickListener {
            val selectedItems = mutableListOf<String>()

            // Seçilenler
            val selectedAnaYemekId = radioGroupAnaYemek.checkedRadioButtonId
            if (selectedAnaYemekId != -1) {
                val selectedAnaYemek = findViewById<RadioButton>(selectedAnaYemekId)
                selectedItems.add("Ana Yemek: ${selectedAnaYemek.text}")
            }


            val selectedIcecekId = radioGroupIcecek.checkedRadioButtonId
            if (selectedIcecekId != -1) {
                val selectedIcecek = findViewById<RadioButton>(selectedIcecekId)
                selectedItems.add("İçecek: ${selectedIcecek.text}")
            }


            if (checkBoxEkstra1.isChecked) selectedItems.add("Ekstra: ${checkBoxEkstra1.text}")
            if (checkBoxEkstra2.isChecked) selectedItems.add("Ekstra: ${checkBoxEkstra2.text}")


            val selectedItemsText = selectedItems.joinToString(", ")


            val intent = Intent(this, SiparisGoster::class.java)
            intent.putExtra("selectedItems", selectedItemsText)

            Toast.makeText(this, "Seçtiğiniz Ürünler Sipariş sayfasına kayıt edildi.", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
    }
}
