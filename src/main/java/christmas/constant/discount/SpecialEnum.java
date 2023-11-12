package christmas.constant;

public enum SpecialEnum {
    DAY_THIRD("3", 1000),
    DAY_TENTH("10", 1000),
    DAY_SEVENTEENTH("17", 1000),
    DAY_TWENTY_FOURTH("24", 1000),
    DAY_TWENTY_FIFTH("25", 1000),
    DAY_THIRTY_FIRST("31", 1000),
    DAY_NOT_EXIST("없음", 0);

    private String day;
    private int discount;

    SpecialEnum(String day, int discount) {
        this.day = day;
        this.discount = discount;
    }

    public String getDay() {
        return day;
    }

    public int getDiscount() {
        return discount;
    }
}
