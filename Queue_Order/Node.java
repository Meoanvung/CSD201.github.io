/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Queue_Order;

/**
 *
 * @author DELL
 */
public class Node {
    public OrderInfo info;
    public Node next;

    public Node(OrderInfo x, Node p) {
        info = x;
        next = p;
    }

    public Node(OrderInfo x) {
        this(x, null);
    }
}
