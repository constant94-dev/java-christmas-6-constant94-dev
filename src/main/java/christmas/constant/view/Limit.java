package christmas.constant.view;

public enum Limit {
    MENU_COUNT_MAX(20),
    MENU_COUNT_MIN(1);

    private int count;

    Limit(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
