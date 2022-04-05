import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class TestCart {
    @Test
    fun `test add product to cart`() {
        val products = Products()
        val product = products.getProductById(1)
        val cart = Cart()
        cart.addProductToCart(product, 2)
        assertEquals(8, product.stock)
        assertEquals(1, cart.items.size)
        cart.display()
        products.display()
        assertEquals(1, cart.items.size)
        assertEquals("Rice", cart.items[0].productName)
        assertEquals(8, product.stock)
    }

    @Test
    fun `test remove product from cart`() {
        val products = Products()
        val rice = products.getProductById(1)
        val wheat = products.getProductById(2)
        val cart = Cart()
        cart.addProductToCart(rice, 2)
        cart.addProductToCart(wheat, 4)
        cart.display()
        products.display()
        assertEquals(2, cart.items.size)
        assertEquals("Wheat", cart.items[1].productName)
        assertEquals(8, rice.stock)
        cart.removeProductFromCart(rice)
        cart.display()
        products.display()
        assertEquals(1, cart.items.size)
        assertEquals("Wheat", cart.items[0].productName)
        assertEquals(10, rice.stock)
    }

    @Test
    fun `test remove product from cart throws exception`() {
        val products = Products()
        val rice = products.getProductById(1)
        val wheat = products.getProductById(2)
        val cart = Cart()
        cart.addProductToCart(rice, 2)
        cart.display()
        assertEquals(1, cart.items.size)
        assertEquals("Rice", cart.items[0].productName)
        val exception = assertThrows<NoSuchElementException> {
            cart.removeProductFromCart(wheat)
        }
        assertEquals("Item Not Found!", exception.message)
    }
}