/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Queue_Order;

/**
 *
 * @author DELL
 */
public class OrderInfo {

    public String customerName;
    public String orderDate;
    public String deliveryDate;
    public String orderID;
    public String orderStatus;
    public String orderName;

    public OrderInfo(String customerName, String orderDate, String deliveryDate, String orderID, String orderName) {
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.orderID = orderID;
        this.orderStatus = "Chờ Xử Lý"; // Mặc định trạng thái là "Chờ Xử Lý"
        this.orderName = orderName;
    }

    @Override
    public String toString() {
        return String.format("| %-18s | %-21s | %-13s | %-12s |", orderID, customerName, orderName, orderStatus);
    }
}
