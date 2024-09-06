import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Ürünleri oluşturma
        Product laptop = new Product("Laptop", 5000.00, 10);
        Product phone = new Product("Phone", 3000.00, 5);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nE-Ticaret Sistemi");
            System.out.println("1. Ürün Bilgilerini Görüntüle");
            System.out.println("2. Ürün Güncelle");
            System.out.println("3. Sipariş Ver");
            System.out.println("4. Çıkış");

            System.out.print("Seçiminizi yapın (1/2/3/4): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Konsoldan kalan yeni satır karakterini temizle

            switch (choice) {
                case 1:
                    displayProductInfo(laptop);
                    displayProductInfo(phone);
                    break;

                case 2:
                    updateProduct(scanner, laptop, phone);
                    break;

                case 3:
                    placeOrder(scanner, laptop, phone);
                    break;

                case 4:
                    System.out.println("Çıkılıyor...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }
    }

    private static void displayProductInfo(Product... products) {
        System.out.println("\nÜrün Bilgileri:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static void updateProduct(Scanner scanner, Product laptop, Product phone) {
        System.out.print("Güncellemek istediğiniz ürünü seçin (Laptop/Phone): ");
        String productName = scanner.nextLine();

        Product selectedProduct = null;
        if (productName.equalsIgnoreCase("Laptop")) {
            selectedProduct = laptop;
        } else if (productName.equalsIgnoreCase("Phone")) {
            selectedProduct = phone;
        } else {
            System.out.println("Geçersiz ürün adı.");
            return;
        }

        System.out.println("1. Ürün Adını Güncelle");
        System.out.println("2. Ürün Fiyatını Güncelle");
        System.out.println("3. Ürün Stokunu Güncelle");
        System.out.print("Seçiminizi yapın (1/2/3): ");
        int updateChoice = scanner.nextInt();
        scanner.nextLine();  // Konsoldan kalan yeni satır karakterini temizle

        switch (updateChoice) {
            case 1:
                System.out.print("Yeni ürün adını girin: ");
                String newName = scanner.nextLine();
                selectedProduct.updateName(newName);
                break;

            case 2:
                System.out.print("Yeni ürün fiyatını girin: ");
                double newPrice = scanner.nextDouble();
                selectedProduct.updatePrice(newPrice);
                break;

            case 3:
                System.out.print("Yeni stok miktarını girin: ");
                int newStock = scanner.nextInt();
                selectedProduct.setStock(newStock);
                break;

            default:
                System.out.println("Geçersiz seçim.");
        }
    }

    private static void placeOrder(Scanner scanner, Product laptop, Product phone) {
        System.out.print("Sipariş vermek istediğiniz ürünü seçin (Laptop/Phone): ");
        String productName = scanner.nextLine();

        Product selectedProduct = null;
        if (productName.equalsIgnoreCase("Laptop")) {
            selectedProduct = laptop;
        } else if (productName.equalsIgnoreCase("Phone")) {
            selectedProduct = phone;
        } else {
            System.out.println("Geçersiz ürün adı.");
            return;
        }

        System.out.print("Sipariş miktarını girin: ");
        int quantity = scanner.nextInt();

        Order order = new Order(selectedProduct, quantity);
        order.processOrder();
    }
}
