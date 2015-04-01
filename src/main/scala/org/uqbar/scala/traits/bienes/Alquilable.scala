package org.uqbar.scala.traits.bienes

import scala.language.postfixOps

/**
 * Un objeto que se puede alquilar.
 * Implementa la logica para saber si ya esta
 * alquilado, quien es la persona que actualmente
 * tiene en posesion este objeto, y posiblemente
 * podria manejar el concepto de reservas futuras, etc.
 *
 * @author phm
 */
trait Alquilable {
  var inquilino: Inquilino = null

  // restriccion sobre la clase en que se va a aplicar
  def precioAlquiler: Int

  def alquilar(inquilino: Inquilino) = {
    if (!disponible) {
      sys.error("Este objeto '" + this + "' ya esta alquilado a: " + this.inquilino)
    }
    inquilino debitar precioAlquiler
    this inquilino = inquilino
  }

  def devolver() = {
    this.inquilino = null
  }

  def disponible = inquilino == null
}


/**
 * Un objeto que se puede alquilar, y que a partir de eso te sabe decir
 * si esta o no operativo
 */
trait Alquilable2 extends Alquilable with OperativoONo {
  override def disponible: Boolean = super.disponible && operativo

  //  var seccion : Seccion = null
  //  def responsable = seccion.jefe
}

//class Seccion(var nombre: String, var jefe: Persona) {
//}
