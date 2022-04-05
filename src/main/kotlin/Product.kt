data class Product(val id:Int, val name: String, val price: Double, var stock: Int)

class Products {
    private val products = listOf(Product(1, "Rice", 100.00, 10),
        Product(2, "Wheat", 80.00, 20),
        Product(3, "Sugar", 60.00, 30),
        Product(4, "Bread", 40.00, 40))

    fun getProductById(id: Int) =
        products.firstOrNull { it.id == id } ?: throw NoSuchElementException("Product Not Found!")

    fun display() {
        products.forEach {
            println("Product ID: ${it.id} - Name: ${it.name} - Price: ${it.price} - Stock: ${it.stock}")
        }
    }
}