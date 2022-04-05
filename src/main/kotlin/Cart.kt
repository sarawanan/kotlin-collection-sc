data class CartItem(val productId: Int, val productName: String, val qty: Int, val price: Double)

class Cart {
    val items = mutableListOf<CartItem>()

    fun addProductToCart(product: Product, qty: Int) {
        items.add(CartItem(product.id, product.name, qty, product.price * qty))
        product.stock = product.stock - qty
    }

    fun removeProductFromCart(product: Product) {
        val cartItem = items.firstOrNull { it.productId == product.id} ?: throw NoSuchElementException("Item Not Found!")
        items.remove(cartItem)
        product.stock = product.stock + cartItem.qty
    }

    fun display() {
        items.forEach {
            println("Product ID:${it.productId} - Product Name: ${it.productName} - Qty: ${it.qty} - Price: ${it.price}")
        }
        println("Total Price: ${items.sumOf(CartItem::price)}")
    }
}
