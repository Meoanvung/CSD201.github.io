/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Queue_Order;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MyQueue orderQueue = new MyQueue();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n------ Order Processing System ------");
            System.out.println("1. Place Order");
            System.out.println("2. Process Orders");
            System.out.println("3. View Order Queue");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    placeOrder(orderQueue, scanner);
                    break;

                case 2:
                    try {
                    if (!orderQueue.isEmpty()) {
                        OrderInfo processedOrder = orderQueue.dequeue();
                        System.out.println("Processing order:\n" + processedOrder);
                        processOrderStatus(processedOrder, scanner);
                    } else {
                        System.out.println("No orders to process.");
                    }
                } catch (Exception e) {
                    System.out.println("Error processing order: " + e.getMessage());
                }
                break;

                case 3:
                    viewOrderQueue(orderQueue);
                    break;

                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static void placeOrder(MyQueue orderQueue, Scanner scanner) {

        System.out.println("Enter order details:");
        scanner.nextLine();  // Consume the newline character
        System.out.print("Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Order Date: ");
        String orderDate = scanner.nextLine();
        System.out.print("Delivery Date: ");
        String deliveryDate = scanner.nextLine();
        System.out.print("Order ID: ");
        String orderID = scanner.nextLine();

        // Tạo danh sách liên kết để lưu trữ các tên đơn hàng
        List<String> orderNames = new LinkedList<>();
        orderNames.add("Teddy Bear");
        orderNames.add("Books");
        orderNames.add("Lover");

        // In ra menu con tên đơn hàng
        System.out.println("Choose Order Name:");
        for (int i = 0; i < orderNames.size(); i++) {
            System.out.println((i + 1) + ". " + orderNames.get(i));
        }

        System.out.print("Enter your choice: ");
        int orderNameChoice = scanner.nextInt();

        String orderName;
        if (orderNameChoice >= 1 && orderNameChoice <= orderNames.size()) {
            orderName = orderNames.get(orderNameChoice - 1);
        } else {
            System.out.println("Invalid choice. Setting order name to 'Unknown'");
            orderName = "Unknown";
        }

        OrderInfo orderInfo = new OrderInfo(customerName, orderDate, deliveryDate, orderID, orderName);
        orderQueue.enqueue(orderInfo);

        System.out.println("Order placed successfully!");
    }

    private static void processOrderStatus(OrderInfo order, Scanner scanner) {
        System.out.println("Select order status:");
        System.out.println("1. Chờ Xử Lý");
        System.out.println("2. Đang Giao");
        System.out.println("3. Đã Giao");

        int statusChoice = scanner.nextInt();
        switch (statusChoice) {
            case 1:
                order.orderStatus = "Chờ Xử Lý";
                break;
            case 2:
                order.orderStatus = "Đang Giao";
                break;
            case 3:
                order.orderStatus = "Đã Giao";
                break;
            default:
                System.out.println("Invalid choice. Setting status to Chờ Xử Lý.");
                order.orderStatus = "Chờ Xử Lý";
        }
        System.out.println("Order status updated successfully!");
    }

    private static void viewOrderQueue(MyQueue orderQueue) {
    try {
        if (!orderQueue.isEmpty()) {
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("| Order Id          | Customer Name          | Order Name    | Order Status |");
            System.out.println("----------------------------------------------------------------------------");
            Node current = orderQueue.head;
            while (current != null) {
                System.out.println(current.info.toString());
                current = current.next;
            }
            System.out.println("----------------------------------------------------------------------------");
        } else {
            System.out.println("Order Queue is empty.");
        }
    } catch (Exception e) {
        System.out.println("Error viewing order queue: " + e.getMessage());
    }
}


}
