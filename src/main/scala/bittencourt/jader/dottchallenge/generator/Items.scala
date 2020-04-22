package bittencourt.jader.dottchallenge.generator

import java.time.{LocalDate, LocalDateTime, LocalTime, Month}
import java.util

import bittencourt.jader.dottchallenge.entity.{DottProduct, Item}

import scala.collection.mutable.ListBuffer
import scala.util.Random

object Items {
  private val mockItems = new util.ArrayList[Item]

  protected def populateItems(): Unit = if (mockItems.size < 15) { // 1 - 3 months
    val product1 = new DottProduct("butter", "food", 0.5d, BigDecimal.valueOf(2.0D), LocalDateTime.of(LocalDate.of(2020, Month.MARCH, 20), LocalTime.of(0, 0, 0)))
    mockItems.add(new Item(BigDecimal.valueOf(1L) + BigDecimal.valueOf(6L) + product1.price,  BigDecimal.valueOf(1L), BigDecimal.valueOf(6L), product1))
    val product2 = new DottProduct("flour", "food", 1.0d, BigDecimal.valueOf(0.65D), LocalDateTime.of(LocalDate.of(2020, Month.FEBRUARY, 1), LocalTime.of(0, 0, 0)))
    mockItems.add(new Item(BigDecimal.valueOf(1L) + BigDecimal.valueOf(6L) + product2.price, BigDecimal.valueOf(1L), BigDecimal.valueOf(6L), product2))
    val product3 = new DottProduct("sugar", "food", 1.0d, BigDecimal.valueOf(0.9D), LocalDateTime.of(LocalDate.of(2020, Month.JANUARY, 1), LocalTime.of(0, 0, 0)))
    mockItems.add(new Item(BigDecimal.valueOf(1L) + BigDecimal.valueOf(6L) + product3.price, BigDecimal.valueOf(1L), BigDecimal.valueOf(6L), product3))
    // 4 - 6 months
    val product4 = new DottProduct("water", "food", 1.0d, BigDecimal.valueOf(0.45D), LocalDateTime.of(LocalDate.of(2019, Month.DECEMBER, 1), LocalTime.of(0, 0, 0)))
    mockItems.add(new Item(BigDecimal.valueOf(1L) + BigDecimal.valueOf(6L) + product4.price, BigDecimal.valueOf(1L), BigDecimal.valueOf(6L), product4))
    val product5 = new DottProduct("rice", "food", 1.0d, BigDecimal.valueOf(0.80D), LocalDateTime.of(LocalDate.of(2019, Month.NOVEMBER, 1), LocalTime.of(0, 0, 0)))
    mockItems.add(new Item(BigDecimal.valueOf(1L) + BigDecimal.valueOf(6L) + product5.price, BigDecimal.valueOf(1L), BigDecimal.valueOf(6L), product5))
    val product6 = new DottProduct("black beans", "food", 1.0d, BigDecimal.valueOf(1.25D), LocalDateTime.of(LocalDate.of(2019, Month.OCTOBER, 1), LocalTime.of(0, 0, 0)))
    mockItems.add(new Item(BigDecimal.valueOf(1L) + BigDecimal.valueOf(6L) + product6.price, BigDecimal.valueOf(1L), BigDecimal.valueOf(6L), product6))
    // 7 - 12 months
    val product7 = new DottProduct("shampoo", "higene", 1.0d, BigDecimal.valueOf(1.0D), LocalDateTime.of(LocalDate.of(2019, Month.SEPTEMBER, 1), LocalTime.of(0, 0, 0)))
    mockItems.add(new Item(BigDecimal.valueOf(3L) + BigDecimal.valueOf(12L) +  product7.price, BigDecimal.valueOf(3L), BigDecimal.valueOf(12L), product7))
    val product8 = new DottProduct("toothpaste", "higene", 0.3d, BigDecimal.valueOf(0.9D), LocalDateTime.of(LocalDate.of(2019, Month.AUGUST, 1), LocalTime.of(0, 0, 0)))
    mockItems.add(new Item(BigDecimal.valueOf(3L) + BigDecimal.valueOf(12L) +  product8.price, BigDecimal.valueOf(3L), BigDecimal.valueOf(12L), product8))
    val product9 = new DottProduct("soap", "higene", 0.15d, BigDecimal.valueOf(0.35D), LocalDateTime.of(LocalDate.of(2019, Month.JULY, 1), LocalTime.of(0, 0, 0)))
    mockItems.add(new Item(BigDecimal.valueOf(3L) + BigDecimal.valueOf(12L) +  product9.price, BigDecimal.valueOf(3L), BigDecimal.valueOf(12L), product9))
    val product10 = new DottProduct("deodorant", "higene", 0.35d, BigDecimal.valueOf(2.4D), LocalDateTime.of(LocalDate.of(2019, Month.JUNE, 1), LocalTime.of(0, 0, 0)))
    mockItems.add(new Item(BigDecimal.valueOf(3L) + BigDecimal.valueOf(12L) +  product10.price, BigDecimal.valueOf(3L), BigDecimal.valueOf(12L), product10))
    val product11 = new DottProduct("toothbrush", "higene", 0.1d, BigDecimal.valueOf(1.3D), LocalDateTime.of(LocalDate.of(2019, Month.APRIL, 1), LocalTime.of(0, 0, 0)))
    mockItems.add(new Item(BigDecimal.valueOf(3L) + BigDecimal.valueOf(12L) +  product11.price, BigDecimal.valueOf(3L), BigDecimal.valueOf(12L), product11))
    val product12 = new DottProduct("hair gel", "higene", 11.0d, BigDecimal.valueOf(0.80D), LocalDateTime.of(LocalDate.of(2019, Month.MARCH, 1), LocalTime.of(0, 0, 0)))
    mockItems.add(new Item(BigDecimal.valueOf(3L) + BigDecimal.valueOf(12L) +  product12.price, BigDecimal.valueOf(3L), BigDecimal.valueOf(12L), product12))
    // > 12 months
    val product13 = new DottProduct("lcd television", "electronics", 15.0d, BigDecimal.valueOf(300.0D), LocalDateTime.of(LocalDate.of(2018, Month.DECEMBER, 1), LocalTime.of(0, 0, 0)))
    mockItems.add(new Item(BigDecimal.valueOf(10L) + BigDecimal.valueOf(23L) +  product13.price, BigDecimal.valueOf(10L), BigDecimal.valueOf(23L), product13))
    val product14 = new DottProduct("nintendo switch", "electronics", 1.0d, BigDecimal.valueOf(150.0D), LocalDateTime.of(LocalDate.of(2018, Month.NOVEMBER, 1), LocalTime.of(0, 0, 0)))
    mockItems.add(new Item(BigDecimal.valueOf(10L) + BigDecimal.valueOf(23L) +  product14.price, BigDecimal.valueOf(10L), BigDecimal.valueOf(23L), product14))
    val product15 = new DottProduct("Samsung Galaxy", "electronics", 0.3d, BigDecimal.valueOf(450.0D), LocalDateTime.of(LocalDate.of(2018, Month.OCTOBER, 1), LocalTime.of(0, 0, 0)))
    mockItems.add(new Item(BigDecimal.valueOf(10L) + BigDecimal.valueOf(23L) +  product15.price, BigDecimal.valueOf(10L), BigDecimal.valueOf(23L), product15))
  }

  def generateRandomItemsList: List[Item] = {
    populateItems()
    val itemList = ListBuffer[Item]()
    val listSize = new Random().nextInt(5) + 1

    for (i <- 0 to listSize)
      itemList += mockItems.get(new Random().nextInt(mockItems.size))

    itemList.toList
  }
}