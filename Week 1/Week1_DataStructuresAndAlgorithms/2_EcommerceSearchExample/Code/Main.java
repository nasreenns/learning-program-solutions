import java.util.*;

public class Main {

    // Linear Search
    public static Product linearSearch(Product[] products, String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, String name) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(name);

            if (cmp == 0) return products[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Footwear"),
            new Product(103, "Watch", "Accessories"),
            new Product(104, "Mobile", "Electronics"),
            new Product(105, "Bag", "Travel")
        };

        // Linear Search Example
        System.out.println("Linear Search Result:");
        Product found = linearSearch(products, "Watch");
        System.out.println(found != null ? found : "Product not found");

        // Sort for binary search
        Arrays.sort(products, Comparator.comparing(p -> p.productName));

        // Binary Search Example
        System.out.println("\nBinary Search Result:");
        found = binarySearch(products, "Watch");
        System.out.println(found != null ? found : "Product not found");
    }
}