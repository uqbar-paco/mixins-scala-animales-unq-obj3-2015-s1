package org.uqbar.scala.traits.bienes

import scala.collection.mutable

trait Asegurable extends OperativoONo {
  val aniosAsegurados = mutable.Set[Int]()
  val anioActual = 2013

  def asegurar(anio: Int) = aniosAsegurados += anio

  abstract override def operativo: Boolean = super.operativo && tieneSeguroVigente

  def tieneSeguroVigente = this.tieneSeguroPara(anioActual)

  def tieneSeguroPara(anio: Int) = aniosAsegurados.contains(anio)
}
