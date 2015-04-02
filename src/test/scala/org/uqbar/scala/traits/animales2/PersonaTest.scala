package org.uqbar.scala.traits.animales2

import org.scalatest.{FlatSpec, Matchers}

class PersonaTest extends FlatSpec with Matchers {
  val depoUno = new Deposito

  "una persona" should "cumplir con una rutina" in {
    //    val juancho = new Persona with ConRutinasRestringidoAAve  // no vale porque juancho no es Ave
    //    val juancho = new Persona with ConRutinasParaAve  // no vale porque juancho no es Ave
    val juancho = new Persona with ConRutinasDeclarandoLoQueNecesito // esta si!!
    juancho.diaRelajado()
    juancho.estadoDeAnimo should equal('tranca)
    juancho.comer(820)
    juancho.estadoDeAnimo should equal('contento)
  }

  "una persona" should "saber manejar su nombre" in {
    val tolkien = new Persona
    tolkien should not be 'tieneNombre
    tolkien.tieneNombre should equal(false)
    tolkien should not be 'cambioNombre
    tolkien.nombre = "Nombre Trucho"
    tolkien should be('tieneNombre)
    tolkien should not be 'cambioNombre
    tolkien.nombreEnMayusculas should equal("NOMBRE TRUCHO")
    tolkien.iniciales should equal("NT")

    tolkien.nombre = "John R.R. Tolkien"
    tolkien should be('tieneNombre)
    tolkien should be('cambioNombre)
    tolkien.nombreAnterior should equal("Nombre Trucho")
    tolkien.nombreEnMayusculas should equal("JOHN R.R. TOLKIEN")
    tolkien.iniciales should equal("JRRT")
  }

  "las personas de deposito" should "actualizar correctamente el deposito" in {
    val depoUno = new Deposito
    val luis = new Persona with ConsumeComidaDeDeposito
    val ramona = new Persona with ConsumeComidaDeDeposito
    luis.depositoDeComida = depoUno
    ramona.depositoDeComida = depoUno
    depoUno.seCompra(1000)
    luis.comer(600)
    ramona.comer(150)

    depoUno.stock should equal(250)
    luis.estadoDeAnimo should equal('contento)
  }
}