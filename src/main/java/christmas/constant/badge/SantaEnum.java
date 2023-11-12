package christmas.constant.badge;

public enum SantaEnum {
    BADGE_SANTA_MIN(20000, ""),
    BADGE_SANTA(0, "산타");

    private int totalBenefit;
    private String badge;

    SantaEnum(int totalBenefit, String badge) {
        this.totalBenefit = totalBenefit;
        this.badge = badge;
    }

    public int getTotalBenefit() {
        return totalBenefit;
    }

    public String getBadge() {
        return badge;
    }
}
