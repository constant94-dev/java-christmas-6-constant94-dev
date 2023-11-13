package christmas.constant.view;

public enum Menu {
    APPETIZER_SOUP("양송이수프", 6000),
    APPETIZER_TAPAS("타파스", 5500),
    APPETIZER_SALAD("시저샐러드", 8000),
    MAIN_STEAK("티본스테이크", 55000),
    MAIN_BARBECUE("바비큐립", 54000),
    MAIN_SEA_PASTA("해산물파스타", 35000),
    MAIN_CHRISTMAS_PASTA("크리스마스파스타", 25000),
    DESSERT_CAKE("초코케이크", 15000),
    DESSERT_ICE_CREAM("아이스크림", 5000),
    DRINK_COKE("제로콜라", 3000),
    DRINK_WINE("레드와인", 60000),
    DRINK_CHAMPAGNE("샴페인", 25000),
    NOT_EXIST_MENU("없음", 0);

    private String menu;
    private int price;

    Menu(String menu, int price) {
        this.menu = menu;
        this.price = price;
    }

    public String getMenu() {
        return menu;
    }

    public int getPrice() {
        return price;
    }
}
