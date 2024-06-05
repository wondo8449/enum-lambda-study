import sparta.SampleUsers;
import sparta.User;
import sparta.enumtype.DiscountEvent;
import sparta.enumtype.OrderStatus;
import sparta.service.Coupon;
import sparta.service.Order;
import sparta.service.Product;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        orderTest();
        //lambdaTest();
        //enumTest();
    }

    private static void orderTest() {
        final Order order1 = new Order("아이폰", OrderStatus.PRODUCT_ORDER);
        final Order order2 = new Order("아이패드", OrderStatus.DELIVERY_COMPLETED);
        final Order order3 = new Order("맥북", OrderStatus.EXCHANGE);

        final boolean productOrderTest1 = order1.isChangable(OrderStatus.DELIVERY_PRODUCT);
        final boolean productOrderTest2 = order1.isChangable(OrderStatus.ORDER_ACCEPTED);

        final boolean deliveryCompletedTest1 = order2.isChangable(OrderStatus.PURCHASE_DECISION);
        final boolean deliveryCompletedTest2 = order2.isChangable(OrderStatus.ORDER_CANCEL);
        final boolean deliveryCompletedTest3 = order2.isChangable(OrderStatus.EXCHANGE);

        final boolean exchangeTest1 = order3.isChangable(OrderStatus.REDELIVERY);
        final boolean exchangeTest2 = order3.isChangable(OrderStatus.REFUND);

        System.out.println("상품 주문 -> 상품 발송 : " + productOrderTest1);
        System.out.println("상품 주문 -> 주문 접수 : " + productOrderTest2);

        System.out.println("배송 완료 -> 구매 결정 : " + deliveryCompletedTest1);
        System.out.println("배송 완료 -> 주문 취소 : " + deliveryCompletedTest2);
        System.out.println("배송 완료 -> 교환 : " + deliveryCompletedTest3);

        System.out.println("교환 -> 재배송 : " + exchangeTest1);
        System.out.println("교환 -> 반품 : " + exchangeTest2);
    }

    private static void enumTest() {
        final Coupon coupon = new Coupon("특가쿠폰", 5000);
        final Product product = new Product("아이폰135 Super Ultra Pro Max", 20_000_000);

        final int couponPrice = coupon.calcPrice(DiscountEvent.SUMMER);
        final int productPrice = product.calcPrice(DiscountEvent.WINTER);

        System.out.println("couponPrice = " + couponPrice);
        System.out.println("productPrice = " + productPrice);
    }

    private static void lambdaTest() {
        final SampleUsers users = new SampleUsers();
        users.init();

        List<User> users1 = users.ageGreaterThan(30);
        List<User> users2 = users.ageEquals(30);
        List<User> users3 = users.ageBetween(10, 20);
        List<User> users4 = users.genderEquals("여성");
        List<User> users5 = users.burgerEquals("맥도날드");

        List<User> lUser1 = users.getUsersBy((user) -> user.getAge() > 30);
        List<User> lUser2 = users.getUsersBy((user) -> user.getAge() == 30);
        List<User> lUser3 = users.getUsersBy((user) -> user.getAge() >= 10 && user.getAge() <= 20);
        List<User> lUser4 = users.getUsersBy((user) -> "여성".equalsIgnoreCase(user.getGender()));
        List<User> lUser5 = users.getUsersBy((user) -> "맥도날드".equalsIgnoreCase(user.getBurger()));

        // 30세 초과
        System.out.println("#####   30세 초과   #####");
        System.out.println("01: " + users1);
        System.out.println("L1: " + lUser1);
        System.out.println();

        // 30세
        System.out.println("#####   30세   #####");
        System.out.println("02: " + users2);
        System.out.println("L2: " + lUser2);
        System.out.println();

        // 10 ~ 20세 사이
        System.out.println("#####   10 ~ 20세 사이   #####");
        System.out.println("03: " + users3);
        System.out.println("L3: " + lUser3);
        System.out.println();

        // 여성
        System.out.println("#####   여성   #####");
        System.out.println("04: " + users4);
        System.out.println("L4: " + lUser4);
        System.out.println();

        // 맥도날드
        System.out.println("#####   맥도날드   #####");
        System.out.println("04: " + users5);
        System.out.println("L4: " + lUser5);
        System.out.println();

        /*
        // 국적
        System.out.println("#####   국적   #####");
        */

        /*
        // 반민초(이단)
        System.out.println("#####   이단   #####");*/
    }
}
