package org.uqbar.scala.traits.animales2

class Deposito {
  var stock = 0

  def seCompra(gramos: Int) {
    stock = stock + gramos
  }

  def seConsume(gramos: Int) {
    stock = stock - gramos
  }
}


trait ConsumeComidaDeDepositoSoloAve extends Ave {
  var depositoDeComida: Deposito = null

  override def comer(gramos: Int) {
    depositoDeComida.seConsume(gramos)
    super.comer(gramos)
  }
}


//trait ConsumeComidaDeDeposito {
//  def comer(gramos: Int)    // no anda con esto, no se por que
//  this: Comedor =>          // no anda tampoco con esto, y tampoco se por que
trait ConsumeComidaDeDeposito extends Comedor {
  var depositoDeComida: Deposito = new Deposito()

  abstract override def comer(gramos: Int) {
    depositoDeComida.seConsume(gramos)
    super.comer(gramos)
  }
}

