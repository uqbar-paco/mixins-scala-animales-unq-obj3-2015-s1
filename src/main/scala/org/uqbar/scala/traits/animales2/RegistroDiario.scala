package org.uqbar.scala.traits.animales2

class RegistroDiario {
  var horasSuenio: Int = 0
  var cantComidas: Int = 0
  var totalGramosComidos: Int = 0
  var horasDescanso: Int = 0

  def registrarIngestionComida(gramos: Int) = {
    cantComidas = cantComidas + 1
    totalGramosComidos = totalGramosComidos + gramos
  }

  def agregarDescanso(horas: Int) = {
    horasDescanso = horasDescanso + horas
  }
}
