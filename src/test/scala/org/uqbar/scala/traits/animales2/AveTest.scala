package org.uqbar.scala.traits.animales2

import org.scalatest.{FlatSpec, Matchers}

class AveTest extends FlatSpec with Matchers {
  def accionesIniciales(unPato: Ave with Volador with Nadador) {
    //  def accionesIniciales(unPato: Pato) {
    unPato.volar(50)
    unPato.descansar(3)
    unPato.nadar(1)
    unPato.descansar(2)
    unPato.nadar(2)
    unPato.volar(70)
  }

  "un pinguino" should "hacer lo que sabe" in {
    val pingui = new Pinguino
    pingui.velocidadNado = 25
    pingui.descansar(8)
    pingui.comer(150)
    pingui.descansar(5)
    pingui.nadar(3)
    pingui.dormir(9)
    pingui.comer(80)
    pingui.descansar(7)
    pingui.nadar(2)
    //    pingui.volar(38)   // los pinguinos no incorporan ninguna caracteristica que les permita volar

    pingui.haComidoHoy should be(true)
    pingui.totalKmNadados should be(125)
  }

  "un niandu" should "hacer lo que sabe" in {
    val nian = new Niandu
    nian.descansar(5)
    nian.comer(150)
    nian.descansar(3)
    nian.correr(20)
    nian.descansar(2)
    nian.comer(70)
    nian.dormir(7)
    nian.descansar(6)
    nian.comer(100)
    //    nian.volar(38)   // los niandues no incorporan ninguna caracteristica que les permita volar
    //    nian.nadar(21)   // los niandues no incorporan ninguna caracteristica que les permita nadar

    nian.hambre should equal(430)
    nian.cuantoDescansoLaUltimaSemana should equal(16)
  }

  "un condor" should "hacer lo que sabe" in {
    val condorito = new Condor
    condorito.descansar(2)
    condorito.volar(8)
    condorito.descansar(3)
    condorito.comer(320)
    condorito.descansar(4)
    condorito.volar(90)
    condorito.descansar(5)
    condorito.comer(250)
    condorito.dormir(9)
    //    condorito.nadar(15)   // los condores no incorporan ninguna caracteristica que les permita nadar

    condorito.totalKmVolados should be(98)
    condorito.haComidoHoy should be(false)
  }

  "un pato" should "hacer lo que sabe" in {
    val patin = new Pato
    patin.volar(50)
    patin.descansar(3)
    patin.nadar(1)
    patin.descansar(2)
    patin.nadar(2)
    patin.volar(70)

    patin.totalKmVolados should equal(120)
    patin.totalKmNadados should equal(30)
  }

  "un pato vago" should "hacer lo que sabe" in {
    val patinVago = new PatoReVago
    this.accionesIniciales(patinVago)

    patinVago.totalKmVolados should equal(120)
    patinVago.totalKmNadados should equal(30)
    patinVago.cuantoDescansoLaUltimaSemana should equal(11)
  }

  "un niandu marinero" should "hacer lo que sabe" in {
    val nianMari = new Niandu with Nadador
    nianMari.descansar(5)
    nianMari.comer(150)
    nianMari.correr(20)
    nianMari.nadar(21)
    //    nianMari.volar(34)   // los niandues no incorporan ninguna caracteristica que les permita volar

    nianMari.hambre should equal(600)
    nianMari.totalKmNadados should equal(210)
  }

  "un pato con rutina" should "hacer lo que sabe" in {
    val patinConRutina = new Pato with ConRutinasRestringidoAAve
    this.accionesIniciales(patinConRutina)
    patinConRutina.diaRelajado

    patinConRutina.totalKmVolados should equal(120)
    patinConRutina.totalKmNadados should equal(30)
    patinConRutina.cuantoDescansoLaUltimaSemana should equal(22)
    patinConRutina.cuantoComio should equal(160)
  }

  "un pato con rutina estructural" should "hacer lo que sabe" in {
    val patinConRutinaEstructural = new Pato with ConRutinasDeclarandoLoQueNecesito
    this.accionesIniciales(patinConRutinaEstructural)
    patinConRutinaEstructural.diaRelajado

    patinConRutinaEstructural.totalKmVolados should equal(120)
    patinConRutinaEstructural.totalKmNadados should equal(30)
    patinConRutinaEstructural.cuantoDescansoLaUltimaSemana should equal(22)
    patinConRutinaEstructural.cuantoComio should equal(160)
  }

  //  "un pato con rutina extends" should "no compilar" in {
  //    var depo = new Deposito with RutinaDeAveExtends
  //  }

  "prueba con otra rutina" should "compilar cuando corresponda" in {
    val patoruti1 = new Pato with ConRutinas
    val patoruti2 = new Pato with ConRutinasDeclarandoLoQueNecesito
    //    val patoruti3 = new Pato with OtraRutinaParaPersonas    esto no compila porque Pato no extiende de Persona
    patoruti1.pasarUnRatoApacible
    patoruti2.pasarUnRatoApacible
  }

}