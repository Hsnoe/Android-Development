package com.ogee.futboltakimi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ogee.futboltakimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var player1= oyuncu("Arthur Masuaku",8,R.drawable.arthur_masuaku)
        var player2= oyuncu("Ciro İmmobile",9,R.drawable.ciro_immobile)
        var player3= oyuncu("Ernest Muci",10,R.drawable.ernst_muci)
        var player4= oyuncu("Fernando Muslera",1,R.drawable.fernando_muslera)
        var player5= oyuncu("Gabriel Paulista",28,R.drawable.gabriel_paulista)
        var player6= oyuncu("Gedson Fernandes",5,R.drawable.gedson_fernandes)
        var player7= oyuncu("Lucas Trorreia",13,R.drawable.lucas_torreria)
        var player8= oyuncu("Mert Gunok",99,R.drawable.mert_gunok)
        var player9= oyuncu("Milot Raschica",3,R.drawable.milot_raschica)
        var player10= oyuncu("Rafa Silva",12,R.drawable.rafa_silva)
        var player11= oyuncu("Semih Kılıçsoy",24,R.drawable.semih_kilicsoy)


        var oyunculistesi = ArrayList<oyuncu>()
        oyunculistesi.add(player1)
        oyunculistesi.add(player2)
        oyunculistesi.add(player3)
        oyunculistesi.add(player4)
        oyunculistesi.add(player5)
        oyunculistesi.add(player6)
        oyunculistesi.add(player7)
        oyunculistesi.add(player8)
        oyunculistesi.add(player9)
        oyunculistesi.add(player10)
        oyunculistesi.add(player11)

        var adapter = MyAdaptor(oyunculistesi)
        binding.rcyclerview.adapter = adapter
        binding.rcyclerview.layoutManager = LinearLayoutManager(this)

    }
}