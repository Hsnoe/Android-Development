package com.ogee.kotlintemelleri

import kotlin.reflect.typeOf

fun main () {

    val sayi1 = 10
    println(sayi1)

    var sayi2 = 10.5 //double
    var sayi3 = 10.7f //float

    var floatsayi1 = sayi2.toFloat()
    println(floatsayi1)

    var durum = true
    var durum2 = false

    println(durum)

    var karakter = "a"

    println(karakter)

    var mesajlar = "kuştan korkan darı ekmez "
    println(mesajlar)

    println("$durum  $mesajlar")

    println("alt satıra geçme, \n    \t tab ekleme ")

    val string = "azdan az çoktan çok gider "
    val uppercase = string.toUpperCase()
    println(uppercase)

    val length =string.length
    println(length)

    val result = string.contains("az")
    println(result)

    //OPERTATÖRLER

    var sayi=10
    var sayi4=7

    println(sayi+sayi4)
    println(sayi-sayi4)
    println(sayi*sayi4)
    println(sayi%sayi4)

    sayi+=sayi4
    println(sayi)

}