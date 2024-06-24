package com.thoughtworks.codepairing

import com.thoughtworks.codepairing.model._

object SampleApp {
    def main(args: Array[String]): Unit = {
        val product1 = Product(10.0, "DIS_10_PRODUCT1", "product 1")
        val product2 = Product(20.0, "DIS_10_PRODUCT2", "product 2")
        val products = List(product1, product2)

        val customer = Customer("A Customer")
        val shoppingCart = new ShoppingCart(customer, products)

        val product3 = Product(30.0, "DIS_10_PRODUCT3", "product 3")
        val shoppingCart2 = shoppingCart.addProduct(product3)
        println(shoppingCart2)

        val order = shoppingCart2.checkout()
        println(order)
    }
}
