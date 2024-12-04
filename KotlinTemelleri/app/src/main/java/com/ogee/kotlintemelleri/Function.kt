package com.ogee.kotlintemelleri

import kotlinx.coroutines.yield

 lateinit var ad : String
fun main(){
    ad ="hasan"
    merhaba()
    println(ad)

    daireAlani(5F)
    ad ="ayşeenur"
    var sonuc = topla(5,8)
    println(sonuc)
    println(ad)
}

fun merhaba(){
    println("say yes to haven")
}

fun daireAlani(r : Float){
    println(r*r*3.1)
}

fun topla(x : Int ,y : Int ) : Int {
    var toplam = x+y
    return toplam
}