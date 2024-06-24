package com.thoughtworks.codepairing.model

case class Product(price: Double, productCode: String, name: String)

case class Order(totalPrice: Double, loyaltyPoints: Int) {

    override def toString() =
        s"""Total price: $totalPrice
           |Will receive $loyaltyPoints loyalty points""".stripMargin
}

case class Customer(name: String)

class ShoppingCart(customer: Customer, products: List[Product]) {

    def addProduct(product: Product): ShoppingCart = new ShoppingCart(customer, product :: products)

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

        Order(totalPrice, loyaltyPointsEarned)
    }

    override def toString() = s"Customer: ${customer.name} \n" + 
                            "Bought: \n" + 
                            products.map(p => s"- ${p.name}, ${p.price}").mkString("\n")
}
