import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Order {
    private Product product;
    private int quantity;

    public Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void processOrder() {
        try {
            product.updateStock(quantity);
            System.out.println("Order processed successfully for " + product.getName());

            // Siparişi dosyaya yaz
            writeOrderToFile();
        } catch (InsufficientStockException e) {
            System.out.println("Error processing order: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error writing order to file: " + e.getMessage());
        }
    }

    // Sipariş detaylarını dosyaya yaz
    private void writeOrderToFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("orders.txt", true))) {
            writer.write("Product: " + product.getName() + ", Quantity: " + quantity + ", Total Price: " + (product.getPrice() * quantity));
            writer.newLine();
        }
    }
}
