package org.uqbar.scala.traits.bienes

import scala.language.postfixOps

/**
 * @author phm
 */
object EjemploTraitAlquilable {

  def main(args: Array[String]): Unit = {
    val pepe = new Persona("pepe")
    val velero = new Velero(6500, pepe, 21, 5, "blanquito")
    val persona = new Inquilino(200, "PHM")

    var alquilables: List[Alquilable] = List(velero, new Pelicula())

    // inicialmente disponible
    assert(velero disponible, "El velero no esta disponible!")

    // alquilamos a phm
    velero alquilar persona

    assert(!(velero disponible), "El velero deberia estar alquilado!")
    assert(velero.inquilino.eq(persona))
    assert(persona.balance == 175) // 200 - 25 (del auto)

    // intentamos alquilar nuevamente
    try {
      velero alquilar new Inquilino(150, "Otro Tipo")
      sys.error("deberia haber fallado porque ya estaba alquilada")
    }
    catch {
      case e: Throwable => /* ok */
    }

    val auto = new Automovil(1500, pepe, "Ford", "Focus", true)
    auto.cilindradaMotor(4000)
    // como viene un auto
    assert(auto.cilindradaMotor == 4000, "La cilindrada se seteo mal!, es " + auto.cilindradaMotor)
    assert(auto.cargaNeta == 1920, "La carga se seteo mal!, es " + auto.cargaNeta)
    assert(auto.ruedas == 4, "La cantidad de ruedas se seteo mal!, es " + auto.ruedas)
  }

}

