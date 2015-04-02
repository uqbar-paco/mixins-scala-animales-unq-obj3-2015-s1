package org.uqbar.scala.traits.animales2

import org.scalatest.{FlatSpec, Matchers}

class LinearizationTest extends FlatSpec with Matchers {
  "un pato con deposito" should "hacer lo que sabe" in {
    val depoParaPatos = new Deposito
    depoParaPatos.seCompra(1000)
    val patinConDeposito = new Pato
      with ConRutinasRestringidoAAve with ConsumeComidaDeDeposito
    patinConDeposito.depositoDeComida = depoParaPatos
    patinConDeposito.diaRelajado
    depoParaPatos.stock should equal(840)
  }

  //  abstract class Pepe extends ConsumeComidaDeDeposito
  //
  //  class PepeConcreto extends Pepe {
  //    override def comer(i: Int) {}
  //  }
  //
  //  "prueba" should "compilar" in {
  //    val a = new PepeConcreto
  //  }

  "un pato revago" should "hacer lo que sabe" in {
    val patinComplejo = new PatoReVago
    patinComplejo.comer(600)
    patinComplejo.comer(300)
    patinComplejo.registroDeHoy.totalGramosComidos should equal(900)
    patinComplejo.cuantoDescansoLaUltimaSemana should equal(2)
  }

  "un pato complejo" should "hacer lo que sabe" in {
    val depoParaPatos = new Deposito
    depoParaPatos.seCompra(4000)
    val patinComplejo = new Pato with ConRutinasRestringidoAAve
      with ConsumeComidaDeDeposito with ComePocoSiEstaLleno
    patinComplejo.depositoDeComida = depoParaPatos
    patinComplejo.comer(600)
    patinComplejo.comer(300)
    patinComplejo.registroDeHoy.totalGramosComidos should equal(750)
    patinComplejo.cuantoDescansoLaUltimaSemana should equal(0)
    depoParaPatos.stock should equal(3250)
  }

  "un pato revago y complejo" should "hacer lo que sabe" in {
    val depoParaPatos = new Deposito
    depoParaPatos.seCompra(4000)
    val patinComplejo = new PatoReVago
      with ConsumeComidaDeDeposito with ComePocoSiEstaLleno
    val otroPatin = new PatoReVago
      with ComePocoSiEstaLleno with ConsumeComidaDeDeposito
    patinComplejo.depositoDeComida = depoParaPatos
    patinComplejo.comer(600)
    patinComplejo.comer(300)
    patinComplejo.registroDeHoy.totalGramosComidos should equal(750)
    patinComplejo.cuantoDescansoLaUltimaSemana should equal(2)
    depoParaPatos.stock should equal(3250)
  }

  "los tucanes" should "linearizar segun la teoria" in {
    val tuqui = new TucanPolifuncion
    tuqui.comer(1)
    tuqui.totalKmNadados should equal(10)
    tuqui.totalKmVolados should equal(1)
  }

}