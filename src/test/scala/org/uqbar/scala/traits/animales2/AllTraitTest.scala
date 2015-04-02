package org.uqbar.scala.traits.animales2

import org.scalatest.{FlatSpec, Matchers}

class AllTraitTest extends FlatSpec with Matchers {

  "maneja nombre" should "funcionar bien" in {
    val pepe = new AnyRef with ManejaNombre with Volador
    pepe.nombre = "Juan Tontin Uno"
    pepe.nombre = "Juan Tontin Dos"
    pepe.totalKmVolados shouldBe 0
    pepe.cambioNombre shouldBe true
  }
}