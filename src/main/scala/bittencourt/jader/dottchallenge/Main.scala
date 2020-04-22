package bittencourt.jader.dottchallenge

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import bittencourt.jader.dottchallenge.entity.Order
import bittencourt.jader.dottchallenge.generator.Data
import bittencourt.jader.dottchallenge.validator.Validator

object Main {
  private var startDate = LocalDateTime.now()
  private var endDate = LocalDateTime.now()

  def main(args: Array[String]): Unit = { // validates if the minimum number of parameters was provided
    if (areParametersIncorrect(args)) return
    // validates if the provided date are parsable
    if (areDatesIncorrect(args)) return
    val orders = Data.generateOrders
    println("xxxxxxxxxxxxxxxxx")
    println("Total unfiltered orders: " + orders.size)
    val filteredOrders = filterOrdersByDate(orders)
    println("Total filtered orders: " + filteredOrders.size)
    println("Orders filtered based on: " + startDate.toString + " and " + endDate.toString)
    println("xxxxxxxxxxxxxxxxx")
    calculateDefaultOrderGroups(filteredOrders)
    calculateCustomIntervals(filteredOrders, args)
  }

  private def calculateDefaultOrderGroups(filteredOrders: List[Order]) = {
    println("DEFAULT GROUP FILTERS")
    calculateOrdersByInterval(filteredOrders, 1, 3)
    calculateOrdersByInterval(filteredOrders, 4, 6)
    calculateOrdersByInterval(filteredOrders, 7, 12)
    calculateOrdersByInterval(filteredOrders, ">", 12)
    calculateOrdersByInterval(filteredOrders, "<", 2)
    println("xxxxxxxxxxxxxxxxx")
  }

  private def calculateCustomIntervals(filteredOrders: List[Order], args: Array[String]) = {
    println("CUSTOM INTERVAL FILTERS")
    if (Validator.containsCorrectAdditionalArguments(args)) {
      for (i <- 2 until args.length)
        if (args(i).contains("-")) {
          val parameters = args(i).split("-")
          calculateOrdersByInterval(filteredOrders, parameters(0).toLong, parameters(1).toLong)
        }
        else if (args(i).contains(">")) {
          val parameters = args(i).split(">")
          calculateOrdersByInterval(filteredOrders, ">", parameters(1).toLong)
        }
        else if (args(i).contains("<")) {
          val parameters = args(i).split("<")
          calculateOrdersByInterval(filteredOrders, "<", parameters(1).toLong)
        }
    }
    println("xxxxxxxxxxxxxxxxx")
  }

  private def calculateOrdersByInterval(filteredOrders: List[Order], startingInterval: Long, endingInterval: Long) = {
    val result = filteredOrders.toStream
      .filter((order: Order) => order.items.toStream.
          exists((item) => item.product.creationDate.isBefore(LocalDateTime.now.minusMonths(startingInterval)) &&
          item.product.creationDate.isAfter(LocalDateTime.now.minusMonths(endingInterval)))
      ).toList.length
    println(startingInterval + " - " + endingInterval + " months: " + result)
  }

  private def calculateOrdersByInterval(filteredOrders: List[Order], comparator: String, interval: Long) = {
    var result = 0
    if (">" == comparator)
      result = filteredOrders.toStream
        .filter((order: Order) => order.items.toStream
          .exists(item => item.product.creationDate.isBefore(LocalDateTime.now.minusMonths(interval))))
        .toList.length
    else if ("<" == comparator)
      result = filteredOrders.toStream
        .filter((order: Order) => order.items.toStream
          .exists(item => item.product.creationDate.isAfter(LocalDateTime.now.minusMonths(interval)))).toList.length
    println(comparator + " " + interval + " months: " + result)
  }

  private def areParametersIncorrect(args: Array[String]): Boolean = {
    if (args.length < 2) {
      println("Wrong parameters. \n" + "You Must Provide at least startDate and endDate, using LocalDateTime formats as: YYYY-MM-DD HH:MM:SS")
      return true
    }
    false
  }

  private def areDatesIncorrect(args: Array[String]): Boolean = {
    try {
      val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

      startDate = LocalDateTime.parse(args(0), formatter)
      endDate = LocalDateTime.parse(args(1), formatter)
      return false
    } catch {
      case e: Exception =>
        println("An error ooccurred while trying to parse the provided dates. \n"
          + "You Must Provide at least startDate and endDate, using LocalDateTime formats as: YYYY-MM-DD HH:MM:SS")
    }
    true
  }

  private def filterOrdersByDate(orders: List[Order]) = orders.toStream.
    filter((order: Order) => order.placedOrderDate.isAfter(startDate))
    .filter((order: Order) => order.placedOrderDate.isBefore(endDate)).toList
}