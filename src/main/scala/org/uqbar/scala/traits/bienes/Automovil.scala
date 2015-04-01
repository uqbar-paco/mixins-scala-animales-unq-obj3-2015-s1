package org.uqbar.scala.traits.bienes

/**
 *
 * @author phm
 */
class Automovil(laCarga: Int, elResponsable: Persona, marca: String, modelo: String, var tieneGnc: Boolean) extends Vehiculo(laCarga, elResponsable)
with VehiculoRodante with VehiculoMotorizado with Alquilable2 with Registrable with Asegurable {
  {
    this.cilindradaMotor = 1500
  }
  val ruedas = 4
  // OperativoONo
  var estaEnReparaciones = false

  override def toString = "Auto " + marca + " " + modelo

  // Alquilable
  def precioAlquiler: Int = 25

  override def operativo = super.operativo && !estaEnReparaciones

  def entrarEnReparaciones() = {
    estaEnReparaciones = true
  }

  def salirDeReparaciones() = {
    estaEnReparaciones = false
  }

  //	override def responsable = super[VehiculoRodante].responsable
}
