package christmas.constant;

public enum DDayEnum {
    DAY_FIRST("1", 1000),
    DAY_SECOND("2", 1100),
    DAY_THIRD("3", 1200),
    DAY_FOURTH("4", 1300),
    DAY_FIFTH("5", 1400),
    DAY_SIXTH("6", 1500),
    DAY_SEVENTH("7", 1600),
    DAY_EIGHTH("8", 1700),
    DAY_NINTH("9", 1800),
    DAY_TENTH("10", 1900),
    DAY_ELEVENTH("11", 2000),
    DAY_TWELFTH("12", 2100),
    DAY_THIRTEENTH("13", 2200),
    DAY_FOURTEENTH("14", 2300),
    DAY_FIFTEENTH("15", 2400),
    DAY_SIXTEENTH("16", 2500),
    DAY_SEVENTEENTH("17", 2600),
    DAY_EIGHTEENTH("18", 2700),
    DAY_NINETEENTH("19", 2800),
    DAY_TWENTIETH("20", 2900),
    DAY_TWENTY_FIRST("21", 3000),
    DAY_TWENTY_SECOND("22", 3100),
    DAY_TWENTY_THIRD("23", 3200),
    DAY_TWENTY_FOURTH("24", 3300),
    DAY_TWENTY_FIFTH("25", 3400),
    DAY_NOT_EXIST("없음", 0);

    private String day;
    private int discount;

    DDayEnum(String day, int discount) {
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
