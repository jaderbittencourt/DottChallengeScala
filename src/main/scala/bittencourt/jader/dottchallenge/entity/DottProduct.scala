package bittencourt.jader.dottchallenge.entity

import java.time.LocalDateTime

class DottProduct(
               var name: String,
               var category: String,
               var weight: BigDecimal,
               var price: BigDecimal,
               var creationDate: LocalDateTime)