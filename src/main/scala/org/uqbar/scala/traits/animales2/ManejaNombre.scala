package org.uqbar.scala.traits.animales2

trait ManejaNombre {
  var nombreAnterior: String = null
  private var _nombre: String = null

  def cambioNombre = nombreAnterior != null

  def nombreEnMayusculas = if (tieneNombre) nombre.toUpperCase else null

  def tieneNombre = nombre != null

  def iniciales = nombre.split("[ .]").filter(!_.isEmpty).map(_(0)).mkString

  def nombre = _nombre

  def nombre_=(nuevoNombre: String) {
    nombreAnterior = nombre
    _nombre = nuevoNombre
  }


}
