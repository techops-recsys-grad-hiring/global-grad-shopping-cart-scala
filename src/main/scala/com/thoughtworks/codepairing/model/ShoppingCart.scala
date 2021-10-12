package com.thoughtworks.codepairing.model

import scala.collection.mutable.ListBuffer

class ShoppingCart(customer: Customer, products: ListBuffer[Product]) {

    def addProduct(product: Product) = products += product

    def checkout(): Order = {
        var totalPrice = 0.0
        var loyaltyPointsEarned = 0

        for (product <- products) {
            var discount = 0.0
            if (product.productCode.startsWith("DIS_10")) {
                discount = product.price * 0.1
                loyaltyPointsEarned += (product.price / 10).toInt
            } else if (product.productCode.startsWith("DIS_15")) {
                discount = product.price * 0.15
                loyaltyPointsEarned += (product.price / 15).toInt
            } else {
                loyaltyPointsEarned += (product.price / 5).toInt
            }

            totalPrice += product.price - discount
        }

        return Order(totalPrice, loyaltyPointsEarned)
    }

    override def toString() = s"Customer: ${customer.name} \n" + 
                            "Bought: \n" + 
                            products.map(p => s"- ${p.name}, ${p.price}").mkString("\n")
}
