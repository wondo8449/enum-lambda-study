package sparta.service;

import sparta.enumtype.DiscountEvent;

public class Product {
    private final String name;
    private final int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int calcPrice(DiscountEvent event) {
        int discount;

        switch (event) {
            case NONE -> discount = price;
            case SUMMER -> discount = (int) (price * 0.1);
            case WINTER -> discount = (int) (price * 0.2);
            case BLACK_FRIDAY -> discount = (int) (price * 0.3);
            case NEW_YEAR -> discount = (int) (price * 0.5);
            default -> discount = 0;
        }

        return price - discount;
    }
}
