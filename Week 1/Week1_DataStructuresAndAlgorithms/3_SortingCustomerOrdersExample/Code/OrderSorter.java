import java.util.*;

public class OrderSorter {

    //Bubble Sort
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    // swap
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    //Quick Sort
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    public static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    
    public static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order(101, "Ananya", 2500),
            new Order(102, "Arjun", 5000),
            new Order(103, "Zara", 1500),
            new Order(104, "Varma", 8000),
            new Order(105, "Riya", 3000)
        };

       
        Order[] ordersForQuickSort = Arrays.copyOf(orders, orders.length);

        System.out.println("Original Orders:");
        printOrders(orders);

       
        bubbleSort(orders);
        System.out.println("Sorted by Bubble Sort:");
        printOrders(orders);

       
        quickSort(ordersForQuickSort, 0, ordersForQuickSort.length - 1);
        System.out.println("Sorted by Quick Sort:");
        printOrders(ordersForQuickSort);
    }
}
