import java.util.*
import kotlin.system.exitProcess

fun main() {
    val products = Products()
    val cart = Cart()

    do {
        try {
            println("MENU: [1: Products] [2: Add to Cart] [3: Remove from Cart] [4: Display Cart] [0: Exit]")
            when (getInput()) {
                1 -> products.display()
                2 -> {
                    println("Enter product id to add")
                    val product = products.getProductById(getInput())
                    println("Quantity")
                    val qty = getInput()
                    if (qty < product.stock) {
                        cart.addProductToCart(product, qty)
                        println("Product successfully added to cart")
                    } else {
                        println("Requested quantity exceeds available stock!")
                    }
                }
                3 -> {
                    println("Enter product id to remove")
                    cart.removeProductFromCart(products.getProductById(getInput()));
                }
                4 -> cart.display()
                0 -> exitProcess(0)
            }
        } catch (e: NoSuchElementException) {
            println(e.message)
        }

    } while (true)
}

val scanner = Scanner(System.`in`)

fun getInput(): Int {
    return if (scanner.hasNextInt()) {
        scanner.nextInt()
    } else {
        println("Invalid input")
        scanner.next()
        -1
    }
}
