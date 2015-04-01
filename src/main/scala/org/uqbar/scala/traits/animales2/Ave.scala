package org.uqbar.scala.traits.animales2

import scala.collection.mutable.ListBuffer

//class Ave {
//class Ave extends Comedor {
abstract class Ave extends Comedor with ManejaNombre {
  val registrosDiarios = new ListBuffer[RegistroDiario]()
  var registroDeHoy: RegistroDiario = null

  // codigo de inicializacion
  this.empezarDia()

  def dormir(horas: Int) {
    registroDeHoy.horasSuenio = horas
    this.empezarDia()
  }

  def empezarDia() {
    registroDeHoy = new RegistroDiario()
    registrosDiarios += registroDeHoy
  }

  def comer(gramos: Int) {
    //    println("comiendo " + gramos)
    registroDeHoy.registrarIngestionComida(gramos)
  }

  def moverse(horas: Int)

  def descansar(horas: Int) {
    registroDeHoy.agregarDescanso(horas)
  }

  def haComidoHoy = registroDeHoy.cantComidas > 0

  override def estaLleno = registroDeHoy.totalGramosComidos >= 500

  def cuantoComio = registrosDiarios.map(_.totalGramosComidos).sum

  def cuantoDurmioAnoche =
    if (registrosDiarios.isEmpty) 0 else registrosDiarios.last.horasSuenio

  def cuantoDescansoLaUltimaSemana =
    registrosDiarios.takeRight(7).map(_.horasDescanso).sum
}

class Niandu extends Ave {
  var hambre = 0

  def moverse(horas: Int) {
    correr(horas * 40)
  }

  def correr(km: Int) {
    hambre = hambre + (km * 30)
  }

  override def comer(gramos: Int) {
    super.comer(gramos)
    hambre = (hambre - gramos) max 0
  }
}

class Condor extends Ave with SeMueveVolando

class Pinguino extends Ave with SeMueveNadando

class Pato extends Ave with Volador with Nadador {
  override def comer(gramos: Int) {
    super.comer(gramos)
    Pato.registrarPatoQueComio(this)
  }

  def moverse(horas: Int) {
    nadar(1)
    volar(horas - 1)
  }
}

object Pato {
  def registrarPatoQueComio(pato: Pato) {}
}

class PatoTranca extends Pato {
  override def volar(km: Int) {
    super.volar(km)
    this.descansar(1)
  }
}

class PatoReVago extends PatoTranca {
  override def descansar(horas: Int) {
    super.descansar(horas + 1)
  }

  override def comer(gramos: Int) {
    super.comer(gramos)
    super.descansar(1)
  }
}


class Tucan extends Ave with Nadador with Volador with VuelaDespuesDeComer {
  override def comer(gramos: Int) {
    println("Tucan.comer " + gramos)
    super.comer(gramos)
  }

  override def moverse(horas: Int) {}
}

class TucanPolifuncion extends Tucan with NadaDespuesDeComer

// abstract class Gato extends Comedor with ConsumeComidaDeDeposito
// no compila, contar por qué
