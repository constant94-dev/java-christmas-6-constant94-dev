package christmas.constant.badge;

public enum TreeEnum {
    BADGE_TREE_MAX(20000, ""),
    BADGE_TREE_MIN(10000, ""),
    BADGE_TREE(0, "트리");

    private int totalBenefit;
    private String badge;

    TreeEnum(int totalBenefit, String badge) {
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
