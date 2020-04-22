package bittencourt.jader.dottchallenge.entity

import java.time.LocalDateTime

class Order(
             var customerName: String,
             var contact: String,
             var shippingAddress: String,
             var grandTotal: BigDecimal,
             var placedOrderDate: LocalDateTime,
             var items: List[Item])
