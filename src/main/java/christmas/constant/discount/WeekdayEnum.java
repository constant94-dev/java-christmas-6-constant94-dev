package christmas.constant.discount;

public enum WeekdayEnum {
    DAY_THIRD("3", 2023),
    DAY_FOURTH("4", 2023),
    DAY_FIFTH("5", 2023),
    DAY_SIXTH("6", 2023),
    DAY_SEVENTH("7", 2023),
    DAY_TENTH("10", 2023),
    DAY_ELEVENTH("11", 2023),
    DAY_TWELFTH("12", 2023),
    DAY_THIRTEENTH("13", 2023),
    DAY_FOURTEENTH("14", 2023),
    DAY_SEVENTEENTH("17", 2023),
    DAY_EIGHTEENTH("18", 2023),
    DAY_NINETEENTH("19", 2023),
    DAY_TWENTIETH("20", 2023),
    DAY_TWENTY_FIRST("21", 2023),
    DAY_TWENTY_FOURTH("24", 2023),
    DAY_TWENTY_FIFTH("25", 2023),
    DAY_TWENTY_SIXTH("26", 2023),
    DAY_TWENTY_SEVENTH("27", 2023),
    DAY_TWENTY_EIGHTH("28", 2023),
    DAY_THIRTY_FIRST("31", 2023),
    DAY_NOT_EXIST("없음", 0);

    private String day;
    private int discount;

    WeekdayEnum(String day, int discount) {
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
