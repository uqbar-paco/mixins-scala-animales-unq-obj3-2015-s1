package org.uqbar.scala.traits.animales2

trait ConRutinas extends ConAccionesBasicas {
  def pasarUnRatoApacible() {
    this.comer(40)
    this.descansar(3)
    this.moverse(1)
  }

  def diaRelajado() {
    this.descansar(3)
    this.comer(40)
    this.descansar(8)
    this.comer(120)
    this.descansar(6)
    this.dormir(7)
  }
}

trait ConRutinasDeclarandoLoQueNecesito {
  def comer(gramos: Int)

  def descansar(horas: Int)

  def moverse(horas: Int)

  def dormir(horas: Int)

  def pasarUnRatoApacible() {
    this.comer(40)
    this.descansar(3)
    this.moverse(1)
  }

  def diaRelajado() {
    this.descansar(3)
    this.comer(40)
    this.descansar(8)
    this.comer(120)
    this.descansar(6)
    this.dormir(7)
  }
}

trait ConRutinasParaPersona extends Persona {
  def pasarUnRatoApacible() {
    this.comer(40)
    this.descansar(3)
    this.moverse(1)
  }

  def diaRelajado() {
    this.descansar(3)
    this.comer(40)
    this.descansar(8)
    this.comer(120)
    this.descansar(6)
    this.dormir(7)
  }
}

trait ConRutinasRestringidoAAve {
  this: Ave =>
  // que pasa si sacamos esta linea
  def diaRelajado() {
    this.descansar(3)
    this.comer(40)
    this.descansar(8)
    this.comer(120)
    this.descansar(6)
    this.dormir(7)
  }
}

trait ConRutinasParaAve extends Ave {
  def diaRelajado() {
    this.descansar(3)
    this.comer(40)
    this.descansar(8)
    this.comer(120)
    this.descansar(6)
    this.dormir(7)
  }
}

trait RutinaVolandoYNadando extends Volador with Nadador {
  //  def volar(km: Int)
  //  def nadar(horas: Int)

  def movete() {
    this.volar(3)
    this.nadar(8)
  }
}













