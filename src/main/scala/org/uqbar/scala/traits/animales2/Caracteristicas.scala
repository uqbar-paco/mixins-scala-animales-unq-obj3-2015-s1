package org.uqbar.scala.traits.animales2

trait Comedor {
  def comer(gramos: Int)

  def estaLleno: Boolean = false
}

trait Volador {
  var totalKmVolados: Int = 0
  var velocidadVuelo: Int = 30

  def volar(km: Int) {
    totalKmVolados = totalKmVolados + km
  }
}

trait SeMueveVolando extends Volador {
  def moverse(horas: Int) {
    volar(horas * velocidadVuelo)
  }
}

trait Nadador {
  var totalHorasNadadas: Int = 0
  var velocidadNado: Int = 10

  def nadar(horas: Int) {
    totalHorasNadadas = totalHorasNadadas + horas
  }

  def totalKmNadados = this.totalHorasNadadas * this.velocidadNado
}

trait SeMueveNadando extends Nadador {
  def moverse(horas: Int) {
    nadar(horas)
  }
}


trait ComePocoSiEstaLleno extends Comedor {
  abstract override def comer(gramos: Int) = {
    super.comer(if (this.estaLleno) gramos / 2 else gramos)
  }
}

trait VuelaDespuesDeComer extends Ave with Volador {
  override def comer(gramos: Int) = {
    println("VuelaDespuesDeComer.comer " + gramos)
    super.comer(gramos)
    this.volar(1)
  }
}

trait NadaDespuesDeComer extends Ave with Nadador {
  override def comer(gramos: Int) = {
    println("NadaDespuesDeComer.comer " + gramos)
    super.comer(gramos)
    this.nadar(1)
  }
}

