package org.uqbar.scala.traits.bienes

class Velero(laCarga: Int, elResponsable: Persona, eslora: Int, cantVelas: Int, color: String) extends Vehiculo(laCarga, elResponsable) with Alquilable {
  // Alquilable
  def precioAlquiler: Int = 700

  override def alquilar(inquilino: Inquilino) = {
    println("Alquilando " + this)
    super.alquilar(inquilino)
  }
}
