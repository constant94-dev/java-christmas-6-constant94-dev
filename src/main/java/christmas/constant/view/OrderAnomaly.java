package christmas.constant.view;

public enum OrderAnomaly {
    ONLY_TO_DRINK("음료만 주문", 0),
    NO_GIFT("없음", 0),
    NO_BENEFIT("없음", 0),
    NO_BADGE("없음", 0),
    NO_DISCOUNT_DDAY("없음", 0),
    NO_DISCOUNT_WEEKDAY("없음", 0),
    NO_DISCOUNT_WEEKEND("없음", 0),
    NO_DISCOUNT_SPECIAL("없음", 0),
    NO_DISCOUNT_GIFT("없음", 0);

    private String noEvent;
    private int noCount;

    OrderAnomaly(String noEvent, int noCount) {
        this.noEvent = noEvent;
        this.noCount = noCount;
    }

    public String getNoEvent() {
        return noEvent;
    }

    public int getNoCount() {
        return noCount;
    }
}
