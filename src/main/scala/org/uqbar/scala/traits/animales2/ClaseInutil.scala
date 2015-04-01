package org.uqbar.scala.traits.animales2

import scala.language.reflectiveCalls

class ClaseInutil {
  def metodoInutil(n: {def nadar(i: Int); def volar(i: Int)}) {
    n.nadar(3)
    n.volar(4)
  }
}

class Nadito {
  def nadar(i: Int) {}
}

class NadiVolito {
  def nadar(i: Int) {}

  def volar(i: Int) {}
}

class Prueba {
  def metodoDePrueba() {
    new Nadito().nadar(3)
    new ClaseInutil().metodoInutil(new Nadito() with Volador)
    new ClaseInutil().metodoInutil(new NadiVolito())
  }
}







