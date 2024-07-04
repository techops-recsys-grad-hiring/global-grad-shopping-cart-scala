import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import com.thoughtworks.codepairing.model._

class ShoppingCartSpec extends AnyFlatSpec with Matchers {

    object Fixture {
        val price = 100
        val product = "Product"
        val customer = Customer("test")
    }

    "The ShoppingCart" should "calculate price with no discount" in {
        val products = List(Product(Fixture.price, "", Fixture.product))
        val cart = new ShoppingCart(Fixture.customer, products)
        
        val order = cart.checkout()

        order.totalPrice shouldEqual 100.0
    }

    it should "calculate loyalty points with no discount" in {
        val products = List(Product(Fixture.price, "", Fixture.product))
        val cart = new ShoppingCart(Fixture.customer, products)

        val order = cart.checkout()

        order.loyaltyPoints shouldEqual 20
    }

    it should "calculate price for 10 percent discount" in {
        val products = List(Product(Fixture.price, "DIS_10_ABCD", Fixture.product))
        val cart = new ShoppingCart(Fixture.customer, products)
        
        val order = cart.checkout()

        order.totalPrice shouldEqual 90.0
    }

    it should "calculate loyalty points for 10 percent discount" in {
        val products = List(Product(Fixture.price, "DIS_10_ABCD", Fixture.product))
        val cart = new ShoppingCart(Fixture.customer, products)
        val order = cart.checkout()

        order.loyaltyPoints shouldEqual 10
    }

    it should "calculate price for 15 percent discount" in {
        val products = List(Product(Fixture.price, "DIS_15_ABCD", Fixture.product))
        val cart = new ShoppingCart(Fixture.customer, products)
        
        val order = cart.checkout()

        order.totalPrice shouldEqual 85.0
    }

    it should "calculate loyalty points for 15 percent discount" in {
        val products = List(Product(Fixture.price, "DIS_15_ABCD", Fixture.product))
        val cart = new ShoppingCart(Fixture.customer, products)
        
        val order = cart.checkout()

        order.loyaltyPoints shouldEqual 6
    }
}
