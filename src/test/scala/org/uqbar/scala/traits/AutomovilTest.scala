package org.uqbar.scala.traits

import org.scalatest.{FlatSpec, Matchers}
import org.uqbar.scala.traits.bienes.{Automovil, Inquilino, Persona}

class AutomovilTest extends FlatSpec with Matchers {

  val pepe = new Persona("pepe")
  var persona = new Inquilino(2000, "PHM")

  var auto = new Automovil(1500, pepe, "Ford", "Focus", true)
  auto.cilindradaMotor(4000)
  auto.idRegistro("CFK015")

  "auto al principio" should "estar bien seteado" in {
    // como viene un auto
    auto.cilindradaMotor should equal(4000)
    auto.ruedas should equal(4)
    auto.idRegistro should equal("CFK015")
    auto.cargaNeta should equal(1920)
  }

  "auto al principio" should "no estar operativo ni disponible" in {
    auto.operativo should equal(false)
    auto.disponible should equal(false)
  }

  "auto despues de asegurar" should "pasar a estar operativo y disponible" in {
    auto.asegurar(2013)
    auto.operativo should equal(true)
    auto.disponible should equal(true)
  }

  "auto despues de alquilar" should "quedar no disponible" in {
    auto alquilar persona
    auto.inhibir()
    auto.operativo should equal(false)
    auto.disponible should equal(false)
  }

  "auto despues de alquilar e inhibir" should "quedar ni operativo ni disponible" in {
    auto.inhibir()
    auto.operativo should equal(false)
    auto.disponible should equal(false)
  }

  "auto despues de devolver" should "seguir no operativo ni disponible" in {
    auto.devolver()
    auto.operativo should equal(false)
    auto.disponible should equal(false)
  }

  "auto despues de desinhibir" should "volver a estar operativo y disponible" in {
    auto.desinhibir()
    auto.operativo should equal(true)
    auto.disponible should equal(true)
  }

}