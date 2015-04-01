package org.uqbar.scala.traits.bienes

/**
 * @author phm
 */
class Bicicleta(elResponsable: Persona) extends Vehiculo(40, elResponsable) with VehiculoRodante {
  val ruedas = 2
  var rodado: Int = 17

  override def consumo = {
    this.rodado - 10
  }

  // Alquilable
  def precioAlquiler = 10
}
