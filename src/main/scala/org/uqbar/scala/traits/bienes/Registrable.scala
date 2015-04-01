package org.uqbar.scala.traits.bienes

trait OperativoONo {
  def operativo: Boolean = true
}

trait Registrable extends OperativoONo {
  var idRegistro: String = null
  var estaInhibido: Boolean = false

  def idRegistro(id: String): Unit = {
    this.idRegistro = id
  }

  def inhibir() = {
    estaInhibido = true
  }

  def desinhibir() = {
    estaInhibido = false
  }

  abstract override def operativo: Boolean = super.operativo && !estaInhibido
}
