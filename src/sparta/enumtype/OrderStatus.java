package sparta.enumtype;

import java.util.function.Function;

public enum OrderStatus {

    // 구매 결정
    PURCHASE_DECISION(nextStatus -> false),

    // 재배송
    REDELIVERY(nextStatus -> false),

    // 환불
    REFUND(nextStatus -> false),

    // 반품
    RETURN(nextStatus -> { if(REFUND == nextStatus) { return true; } else { return false; }}),

    // 교환
    EXCHANGE(nextStatus -> { if(REDELIVERY == nextStatus) { return true; } else { return false; }}),

    // 배송 완료
    DELIVERY_COMPLETED(nextStatus -> {
        if(PURCHASE_DECISION == nextStatus || EXCHANGE == nextStatus || RETURN == nextStatus) {
            return true;
        } else {
            return false;
        }
    }),

    // 상품 발송
    DELIVERY_PRODUCT(nextStatus -> { if(DELIVERY_COMPLETED == nextStatus) { return true; } else { return false; }}),

    // 주문 취소
    ORDER_CANCEL(nextStatus -> false),

    // 주문 접수
    ORDER_ACCEPTED(nextStatus -> {
        if(ORDER_CANCEL == nextStatus || DELIVERY_PRODUCT == nextStatus) {
            return true;
        } else {
            return false;
        }
    }),

    // 상품 주문
    PRODUCT_ORDER(nextStatus -> { if(ORDER_ACCEPTED == nextStatus) { return true; } else { return false; }});

    private final Function<OrderStatus, Boolean> expression;

    OrderStatus(Function<OrderStatus, Boolean> expression) {
        this.expression = expression;
    }

    public boolean checkStatus(OrderStatus nextStatus) {
        return expression.apply(nextStatus);
    }
}
