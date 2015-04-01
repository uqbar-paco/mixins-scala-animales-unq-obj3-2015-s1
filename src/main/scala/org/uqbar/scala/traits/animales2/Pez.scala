package org.uqbar.scala.traits.animales2

abstract class Pez extends Nadador with Comedor

//class Merluza extends Pez with ConsumeComidaDeDeposito {
// no compila, necesita que comer "ya este" para incorporar ConsumeComidaDeDeposito
class Merluza extends Pez {
  def comer(gramos: Int) {}
}

// por lo explicado recien, hace falta un paso mas de herencia para poder
// incorporar ConsumeComidaDeDeposito
class MerluzaDeDeposito extends Merluza with ConsumeComidaDeDeposito
