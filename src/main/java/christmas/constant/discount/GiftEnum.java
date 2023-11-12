package christmas.constant;

public enum GiftEnum {
    GIFT_EVENT(120000, 1),
    GIFT_NOT_CHAMPAGNE(0, 0);

    private int totalAmount;
    private int champagne;

    GiftEnum(int totalAmount, int champagne) {
        this.totalAmount = totalAmount;
        this.champagne = champagne;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public int getChampagne() {
        return champagne;
    }
}
