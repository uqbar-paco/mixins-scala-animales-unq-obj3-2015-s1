package org.uqbar.scala.traits.bienes

class Vehiculo(var carga: Int, var responsable: Persona) {
  def cargaNeta = carga

  def consumo: Int = 100

  def eficiencia: Double = cargaNeta / consumo
}


trait VehiculoRodante extends Vehiculo with OperativoONo {
  def ruedas: Int

  override def cargaNeta = {
    if (ruedas > 5)
      super.cargaNeta + 1000
    else if (ruedas > 3)
      super.cargaNeta + 100
    else
      super.cargaNeta
  }

}

trait VehiculoMotorizado extends Vehiculo {
  var cilindradaMotor: Int = 0

  def cilindradaMotor(cilindrada: Int): Unit = {
    this.cilindradaMotor = cilindrada
  }

  override def cargaNeta = {
    if (cilindradaMotor > 3000)
      (super.cargaNeta * 1.2).toInt
    else
      super.cargaNeta
  }

  override def consumo = {
    this.cilindradaMotor / 4
  }
}
