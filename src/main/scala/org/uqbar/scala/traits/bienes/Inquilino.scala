package org.uqbar.scala.traits.bienes

import scala.language.implicitConversions

/**
 * @author phm
 */

class Persona(var nombre: String) {
}

class Inquilino(var balance: Int, nombre: String) extends Persona(nombre) {

  def debitar(cantidad: Int) = {
    this.balance -= cantidad
  }

  override def toString = nombre

}

object PersonaImplicits {
  implicit def Persona(nombre: String): Persona = new Persona(nombre)
}
