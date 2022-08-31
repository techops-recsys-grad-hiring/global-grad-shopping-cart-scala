import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import scala.collection.mutable.ListBuffer

import com.thoughtworks.codepairing.model._

class ShoppingCartSpec extends AnyFlatSpec with Matchers {

    def fixture: fixture = 
        new fixture()
    class fixture() extends {
            val price = 100
            val product = "Product"
            val customer = Customer("test")
        }

    "The ShoppingCart" should "calculate price with no discount" in {
        val products = ListBuffer(Product(fixture.price, "", fixture.product))
        val cart = new ShoppingCart(fixture.customer, products)
        
        val order = cart.checkout()

        order.totalPrice shouldEqual 100.0
    }

    it should "calculate loyalty points with no discount" in {
        val products = ListBuffer(Product(fixture.price, "", fixture.product))
        val cart = new ShoppingCart(fixture.customer, products)

        val order = cart.checkout()

        order.loyaltyPoints shouldEqual 20
    }

    it should "calculate price for 10 percent discount" in {
        val products = ListBuffer(Product(fixture.price, "DIS_10_ABCD", fixture.product))
        val cart = new ShoppingCart(fixture.customer, products)
        
        val order = cart.checkout()

        order.totalPrice shouldEqual 90.0
    }

    it should "calculate loyalt points for 10 percent discount" in {
        val products = ListBuffer(Product(fixture.price, "DIS_10_ABCD", fixture.product))
        val cart = new ShoppingCart(fixture.customer, products)
        val order = cart.checkout()

        order.loyaltyPoints shouldEqual 10
    }

    it should "calculate price for 15 percent discount" in {
        val products = ListBuffer(Product(fixture.price, "DIS_15_ABCD", fixture.product))
        val cart = new ShoppingCart(fixture.customer, products)
        
        val order = cart.checkout()

        order.totalPrice shouldEqual 85.0
    }

    it should "calculate loyalty points for 15 percent discount" in {
        val products = ListBuffer(Product(fixture.price, "DIS_15_ABCD", fixture.product))
        val cart = new ShoppingCart(fixture.customer, products)
        
        val order = cart.checkout()

        order.loyaltyPoints shouldEqual 6
    }
}
