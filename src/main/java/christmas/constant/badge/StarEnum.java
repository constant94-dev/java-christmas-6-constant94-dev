package christmas.constant.badge;

public enum StarEnum {
    BADGE_STAR_MAX(10000, ""),
    BADGE_STAR_MIN(5000, ""),
    BADGE_NOT_HAVE(0, "없음"),
    BADGE_STAR(0, "별");

    private int totalBenefit;
    private String badge;

    StarEnum(int totalBenefit, String badge) {
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
