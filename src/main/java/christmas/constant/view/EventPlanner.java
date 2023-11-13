package christmas.constant.view;

public enum EventPlanner {
    PLANNER_HEADER("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    PLANNER_VISIT_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    PLANNER_ORDER_NUMBER("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    PLANNER_PREVIEW("12월 %s일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    PLANNER_ORDER_MENU("<주문 메뉴>"),
    PLANNER_BEFORE_DISCOUNT("<할인 전 총주문 금액>"),
    PLANNER_AFTER_DISCOUNT("<할인 후 예상 결제 금액>"),
    PLANNER_GIFT_MENU("<증정 메뉴>"),
    PLANNER_DISCOUNT("<혜택 내역>"),
    PLANNER_TOTAL_DISCOUNT("<총혜택 금액>"),
    PLANNER_EVENT_BADGE("<12월 이벤트 배지>");

    private String planner;

    EventPlanner(String planner) {
        this.planner = planner;
    }

    public String getPlanner() {
        return planner;
    }
}
