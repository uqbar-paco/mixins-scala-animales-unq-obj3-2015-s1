package org.uqbar.scala.traits

import org.uqbar.scala.traits.animales.Ornitorrinco
import org.uqbar.scala.traits.bienes._


object TraitsPorObjeto extends App {
  val respo = new Persona("pepe")
  val miBici = new Bicicleta(respo) with Alquilable
  //  		{override def responsable = super[Bicicleta].responsable}
  val miAuto = new Automovil(1500, respo, "Ford", "Falcon", true)
  val miPeli = new Pelicula()
  val miBicho = new Ornitorrinco with Alquilable {
    def precioAlquiler = 100
  }

  val alquilables = List[Alquilable](miBici, miAuto, miPeli, miBicho)
}
