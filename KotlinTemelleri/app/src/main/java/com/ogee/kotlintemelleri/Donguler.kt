package com.ogee.kotlintemelleri

fun main() {

    var x = 10
    var y = 6
    var z = 8

    if(x<y && x<z ){
        println("küçük sayı  $x")
    }
    else if (y<x && y<z){
        println("küçük sayyı  $y")
    }
    else {
        println("küçük sayı   $z")
    }


    for(i in 5 ..10){
        println(i)
    }

    for (i in 1 until 10){
        println(i)
    }

    for (i in "hasan"){
        println(i)
    }

    for (i in 200 downTo 100 step  10){
        println(i)
    }

    var sayac = 1
    while (sayac<10){
        sayac++
        println(sayac)
    }

    for (i in 1..10){
        if (i%2==0){
            continue
        }
        println(i)
    }

    var gün = 5

    when(gün){
        1 -> println("pazartesi")
        2 -> println("salı")
        3 -> println("çarşamba")
        4 -> println("periembe")
        5 -> println("cuma")
        6 -> println("cumartesi")
        7 -> println("pazar")
        else -> println("yanlış sayı girdiniz ")
    }
}