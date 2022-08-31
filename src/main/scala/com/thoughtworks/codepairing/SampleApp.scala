package com.thoughtworks.codepairing

import scala.collection.mutable.ListBuffer
import com.thoughtworks.codepairing.model._

object SampleApp:
  def main(args: Array[String]): Unit = 
    val product1 = Product(10.0, "DIS_10_PRODUCT1", "product 1")
    val product2 = Product(20.0, "DIS_10_PRODUCT2", "product 2")
    val products = ListBuffer(product1, product2)

    val customer = Customer("A Customer")
    val shoppingCart = ShoppingCart(customer, products)

    val product3 = Product(30.0, "DIS_10_PRODUCT3", "product 3")
    shoppingCart.addProduct(product3)
    println(shoppingCart)

    val order = shoppingCart.checkout()
    println(order)
