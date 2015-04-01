package org.uqbar.scala.traits.animales

object AnimalesApp extends App {
  val animales = List(
    new Perro,
    new Humano,
    new Pato,
    new Ornitorrinco,
    new Perro with Oviparo,
    new Pato with Viviparo,
    new Delfin,
    new Gorila
  )

  animales foreach { a =>
    println("Soy un " + a.getClass.getSimpleName)
    a.reproducirse()
    a.moverse()
    println()
  }
}
