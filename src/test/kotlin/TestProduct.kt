import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

class TestProduct {
    @Test
    fun `test get product by product id`() {
        val products = Products();
        val product = products.getProductById(1)
        assertEquals("Rice", product.name)
        products.display()
    }

    @Test
    fun `test get product by product id throws exception`() {
        val exception = assertFails { Products().getProductById(5) }
        assertEquals("Product Not Found!", exception.message)
    }
}