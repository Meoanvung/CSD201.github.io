/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Queue_Order;

import Queue_Order.Node;

public class MyQueue {

    protected Node head, tail;

    public MyQueue() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public OrderInfo front() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return (head.info);
    }

    public OrderInfo dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        OrderInfo x = head.info;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return x;
    }

    public void enqueue(OrderInfo x) {
        if (isEmpty()) {
            head = tail = new Node(x);
        } else {
            tail.next = new Node(x);
            tail = tail.next;
        }
    }
}
