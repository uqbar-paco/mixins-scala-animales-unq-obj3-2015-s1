package org.uqbar.scala.traits.animales2

class Persona extends Comedor with TieneNombre {
  var estadoDeAnimo = 'masomenos
  var cuantoDescansoHoy = 0

  override def comer(gramos: Int) {
    if (gramos > 500 && gramos < 1000)
      estadoDeAnimo = 'contento
    else if (gramos >= 1000)
      estadoDeAnimo = 'pesado
  }

  def dormir(horas: Int) {
    if ((cuantoDescansoHoy + horas) >= 15) estadoDeAnimo = 'tranca
    cuantoDescansoHoy = 0
  }

  def descansar(horas: Int) {
    cuantoDescansoHoy = cuantoDescansoHoy + horas
  }

  def moverse(horas: Int) {
    if ((estadoDeAnimo == 'pesado) & (horas > 1)) estadoDeAnimo = 'molesto
    if ((estadoDeAnimo == 'tranca) & (horas < 5)) estadoDeAnimo = 'contento
  }

  override def estaLleno = estadoDeAnimo == 'pesado

}

