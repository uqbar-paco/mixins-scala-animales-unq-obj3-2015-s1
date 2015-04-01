package org.uqbar.scala.traits.animales

trait Caminante {
  def caminar(): Unit
}

trait Acuatico extends Animal {
  override def moverse() = nadar()

  def nadar() = println("Nada un poco")
}

trait Bipedo extends Animal with Caminante {
  override def moverse() = caminar()

  override def caminar() = caminarEnDosPatas()

  def caminarEnDosPatas() = println("Camina con sus dos patas")
}

trait Cuadrupedo extends Animal with Caminante {
  override def moverse() = caminar()

  override def caminar() = caminarEnCuatroPatas()

  def caminarEnCuatroPatas() = println("Camina en cuatro patas")
}

trait Volador extends Animal {
  override def moverse() = volar()

  def volar() = println("Vuela")
}

trait Oviparo extends Animal {
  override def reproducirse() = println("Pone huevos")
}

trait Viviparo extends Animal {
  override def reproducirse() = println("Pare crías vivas")
}
