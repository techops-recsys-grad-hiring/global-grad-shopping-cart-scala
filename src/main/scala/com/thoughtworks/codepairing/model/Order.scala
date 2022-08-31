package com.thoughtworks.codepairing.model

case class Order(totalPrice: Double, loyaltyPoints: Int) {

    override def toString(): String = s"""Total price: $totalPrice
                                 |Will receive $loyaltyPoints loyalty points""".stripMargin
}
