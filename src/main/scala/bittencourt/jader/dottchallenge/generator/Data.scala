package bittencourt.jader.dottchallenge.generator

import bittencourt.jader.dottchallenge.entity.{Item, Order}

import scala.collection.mutable.ListBuffer

object Data {
  private def calculateGrandTotal(items: List[Item]) = items.toStream.map(_.cost).sum

  def generateOrders: List[Order] = {
    var orders = ListBuffer[Order]()

    CustomerName.getNames.forEach((name: String) => {
        val items = Items.generateRandomItemsList
        orders += new Order(name, name + "@gmail.com", Addresses.getRandomAddress, calculateGrandTotal(items), PlacedOrderDate.getRandomPlacedOrderDate, items)
      }
    )
    orders.toList
  }
}