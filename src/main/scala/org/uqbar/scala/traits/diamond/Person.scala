package org.uqbar.scala.traits.diamond

class Person(name: String) {
  def display = name
}

trait Graduate extends Person {
  var degree: String = null

  def degree(deg: String): Unit = {
    this.degree = deg
  }

  override def display = super.display + ", " + degree
}

trait Doctor extends Person {
  override def display = "Dr. " + super.display
}

class ResearchDoctor(name: String, degree: String) extends Person(name)
with Graduate with Doctor {
  {
    this.degree(degree)
  }
}

object PersonApp extends App {
  val juan: Person = new Person("Juan")
  val martin: Graduate = new Person("Martin") with Graduate
  martin.degree("Engineer")
  val jose: Doctor = new Person("Jose") with Doctor
  val pedro: ResearchDoctor = new ResearchDoctor("Pedro", "Designer")
  val roque: Graduate = new Person("Roque") with Graduate with Doctor
  roque.degree("Arquitect")

  println(juan.display)
  println(martin.display)
  println(jose.display)
  println(pedro.display)
  println(roque.display)

}
