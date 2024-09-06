public class Product {
    private String name;
    private double price;
    private int stock;

    // Constructor
    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    // Stok güncelleme metodu
    public void updateStock(int amount) throws InsufficientStockException {
        if (stock < amount) {
            throw new InsufficientStockException("Not enough stock for product: " + name);
        }
        this.stock -= amount;
    }

    // Ürün adını güncelleme metodu
    public void updateName(String newName) {
        if (newName != null && !newName.trim().isEmpty()) {
            this.name = newName;
            System.out.println("Product name updated to: " + newName);
        } else {
            System.out.println("Invalid product name.");
        }
    }

    // Ürün fiyatını güncelleme metodu
    public void updatePrice(double newPrice) {
        if (newPrice > 0) {
            this.price = newPrice;
            System.out.println("Product price updated to: " + newPrice);
        } else {
            System.out.println("Invalid product price.");
        }
    }

    // Stok miktarını ayarlama (set)
    public void setStock(int newStock) {
        if (newStock >= 0) { // Stok miktarının negatif olmasını önlemek için kontrol
            this.stock = newStock;
            System.out.println("Product stock updated to: " + newStock);
        } else {
            System.out.println("Invalid stock amount.");
        }
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + ", stock=" + stock + '}';
    }
}
