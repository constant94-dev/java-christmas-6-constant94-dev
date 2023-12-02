package christmas.constant.discount;

public enum WeekendEnum {
    DAY_FIRST("1", 2023),
    DAY_SECOND("2", 2023),
    DAY_EIGHTH("8", 2023),
    DAY_NINTH("9", 2023),
    DAY_FIFTEENTH("15", 2023),
    DAY_SIXTEENTH("16", 2023),
    DAY_TWENTY_SECOND("22", 2023),
    DAY_TWENTY_THIRD("23", 2023),
    DAY_TWENTY_NINTH("29", 2023),
    DAY_THIRTIETH("30", 2023),
    DAY_NOT_EXIST("없음", 0);

    private String day;
    private int discount;

    WeekendEnum(String day, int discount) {
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
