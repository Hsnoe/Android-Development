package com.ogee.vizeuygulamas

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ogee.vizeuygulamas.databinding.ActivityUcuncusayfaBinding

class ucuncusayfa : AppCompatActivity() {
    private lateinit var binding: ActivityUcuncusayfaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUcuncusayfaBinding .inflate(layoutInflater)
        val view = binding.root
        enableEdgeToEdge()
        setContentView(binding.root)

        var baklasarmasi= yemekler("Bakla Sarmasi","Asma yaprak,kemikli et parçası,baharat,piriç,domates,salça,tuz","Tokat denildiğinde akla gelen ilk malzemelerden birinin Tokat yaprağı olması ise dolmanın Tokat mutfağı için vazgeçilmez olduğunu gösteriyor. Tokat bağlarından taze olarak toplanın asma yaprakları ile hazırlanan baklalı dolma, iç bakla ile hazırlanıyor. En önemli özelliği kemikli etlerin tencereye dizildikten sonra üzerine dolmaların dizilmesi ve kemik suyunda pişirilmesidir.\n" +
                "\n" +
                "Baklalı dolmanın iç harcı klasik dolmalardan farklı. İç bakla ve bulgur ile hazırlanan harç, kemikli etin lezzeti ile bir araya getirilir. Baklalı dolma genellikle evlerde hazırlanan bir lezzettir. Ancak ev yemekleri hazırlayan restoranlarda günün her saati bulunabilir.\n" +
                "\n" +
                "Pehlili Pilav")
        var tokatkebabi= yemekler("Tokat Kebabı","500 gram kuzu eti\n" +
                "3 adet patlıcan\n" +
                "1 adet patates\n" +
                "7- 8 tane biber\n" +
                "2 adet domates\n" +
                "4 -5 diş sarımsak\n" +
                "Tuz","Etler kuşbaşından büyük doğranır, tuzlanır isterseniz kemikli de olabilir.\n" +
                "Patlıcanlar enlemesine ikiye bölünür, ikiye yada üçe kesilir tuzlu suda bekletilir.\n" +
                "Patatesler ince dilimlenir, domatesler soyulur, küp küp doğranır, tuzlanır, sarımsaklar soyulur.\n" +
                "Tepsiye sırasıyla patlıcan, et, patates şeklinde dizilir ortasına domatesler üzerine de sarımsak ve biberler dizilir.\n" +
                "220 derecede kızarana kadar yaklaşık 1 saat pişirilir istediğiniz bir tepside olabilir güveçte yapılmaz ben tepsim büyük olduğu için güveçte yaptım orjinali tabi ki odun ateşinde şişlerde pişirilir ve bu şekilde servis edilir.\n")
        var madimakyemegi= yemekler("Madimak Yemegi","Yarım kg madımak\n" +
                "4 yemek kaşığı sıvı yağ\n" +
                "2 adet kuru soğan\n" +
                "2 diş sarımsak\n" +
                "1 yemek kaşığı domates salçası\n" +
                "Yarım çay bardağı bulgur\n" +
                "Tuz\n" +
                "Pulbiber","Kuzukulağıgiller familyasına ait olan otsu bitki olarak bilinen madımağın yemeğini mutlaka denemelisiniz. Sağlık açısından oldukça faydalı olan madımak yemeğinin lezzeti de bir o kadar güzeldir. Madımağı pazarlardan temin edebileceğiniz gibi eğer bildiğiniz yakın çevreniz de varsa kendinizde toplayabilirsiniz. Fazla fazla toplayıp öğünlük olarak poşetlere koyabilir ve dondurucularınızda da saklayabilirsiniz.\n" +
                "\n" +
                "Sağlığına dikkat edenler için güzel bir yemek olan madımak yanında yoğurt ile hem menülerinizi hemde damaklarınızı şenlendirecektir.")

        /// liste oluşturup tek tek ulaşcaz
        var yemeklerliste = ArrayList<yemekler>()
        yemeklerliste.add(baklasarmasi)
        yemeklerliste.add(tokatkebabi)
        yemeklerliste.add(madimakyemegi)

       // adapter veri ile xml dosyalarını tanımlamak için
        //mapping fonksioynu


        var adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,yemeklerliste.map { yemekler -> yemekler.isim })
        binding.listView.adapter = adapter

        //yemek detayları burda gözüktü sayfa sayfa bağlanmak yerine tek sayfada dinamik bir yapı oluşturduk
        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            var intent = Intent(this,yemekdetay::class.java)

            intent.putExtra("isim",yemeklerliste.get(position).isim)
            intent.putExtra("malzemeler",yemeklerliste.get(position).malzemeler)
            intent.putExtra("tarif",yemeklerliste.get(position).tarif)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }

    // menu yapımı bir tanesi menumüze eklicez menu inflater tasarım kısmına bir veri yüklicz
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var menuInflater = menuInflater
        menuInflater.inflate(R.menu.menuekle,menu)
        return super.onCreateOptionsMenu(menu)
    }

    // bir taneside ordan seçilen değere göre işlem yapacağımız
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.oyun -> {  // Oyun menüsüne tıklanınca OyunActivity başlatılacak
                val intent = Intent(this,Oyun::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }









}