package org.uqbar.scala.traits.animales

abstract class Animal {
  def reproducirse(): Unit

  def moverse(): Unit
}

abstract class Mamifero extends Animal with Viviparo

abstract class Ave extends Animal with Volador with Oviparo with Bipedo

abstract class Reptil extends Animal with Oviparo

class Pato extends Ave with Acuatico {
  override def moverse() = {
    nadar()
    volar()
    caminar()
  }
}

class Humano extends Mamifero with Bipedo

class Perro extends Mamifero with Cuadrupedo

class Ornitorrinco extends Mamifero with Cuadrupedo with Oviparo

class Delfin extends Mamifero with Acuatico

class Gorila extends Mamifero with Bipedo with Cuadrupedo {
  override def caminar() = {
    caminarEnDosPatas();
    caminarEnCuatroPatas()
  }
}
