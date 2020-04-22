package bittencourt.jader.dottchallenge.generator

import java.util.Random

object Addresses {
  private val addressList: List[String] = List("Lisbon", "Porto", "Aveiro", "Beja", "Braga", "Bragança",
    "Castelo Branco", "Coimbra", "Évora", "Faro", "Funchal", "Guarda", "Leiria", "Ponta Delgada", "Portalegre",
    "Santarém", "Setúbal", "Viana do Castelo", "Vila Real", "Viseu")

  def getRandomAddress: String = addressList(new Random().nextInt(addressList.size))
}