package com.ogee.kotlintemelleri

fun main() {

    var ogrenci = ogrenciClass(0,"hasan","Öge")
    var ogrenci2 = ogrenciClass(1,"aysenur","toprak")
    println(ogrenci)
    println(ogrenci2)

    println(ogrenci.notHesapla(10,35))
}