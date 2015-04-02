package org.uqbar.scala.traits

import org.scalatest.{FlatSpec, Matchers}
import org.uqbar.scala.traits.bienes._

class VeleroTest extends FlatSpec with Matchers {

  "velero" should "alquilarse adecuadamente" in {
    val pepe = new Persona("pepe")
    val velero = new Velero(6500, pepe, 21, 5, "blanquito")
    var persona = new Inquilino(2000, "PHM")

    var alquilables: List[Alquilable] = List(velero, new Pelicula())

    // inicialmente disponible
    velero.disponible should equal(true)

    // alquilamos a phm
    velero alquilar persona

    velero.disponible should equal(false)
    velero.inquilino should equal(persona)
    persona.balance should equal(1300) // 2000 - 700 (del velero)

    // intentamos alquilar nuevamente
    a[Throwable] should be thrownBy {
      velero alquilar new Inquilino(150, "Otro Tipo")
    }
  }

}