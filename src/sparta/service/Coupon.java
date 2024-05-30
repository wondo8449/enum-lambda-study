package sparta.service;

import sparta.enumtype.DiscountEvent;

public class Coupon {
    private final String name;
    private final int couponPrice;

    public Coupon(String name, int couponPrice) {
        this.name = name;
        this.couponPrice = couponPrice;
    }

    public int calcPrice(DiscountEvent event) {
        int benefit;

        switch (event) {
            case NONE -> benefit = couponPrice;
            case SUMMER -> benefit = (int) (couponPrice * 0.1);
            case WINTER -> benefit = (int) (couponPrice * 0.2);
            case BLACK_FRIDAY -> benefit = (int) (couponPrice * 0.3);
            case NEW_YEAR -> benefit = (int) (couponPrice * 0.5);
            default -> benefit = 0;
        }

        return couponPrice + benefit;
    }
}
