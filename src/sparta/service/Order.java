package sparta.service;

import sparta.enumtype.OrderStatus;

public class Order {

    private String productName;
    private OrderStatus status;

    public boolean isChangable(OrderStatus nextStatus) {
        return status.checkStatus(nextStatus);
    }

    public Order(String productName, OrderStatus status) {
        this.productName = productName;
        this.status = status;
    }
}
