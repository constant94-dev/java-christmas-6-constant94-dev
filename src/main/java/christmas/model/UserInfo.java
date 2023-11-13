package christmas.model;

import java.util.Map;

public class UserInfo {
    private String visitDate;

    private Map<String, Integer> eventDetails;
    private Map<String, Integer> menuOrders;

    public UserInfo(Map<String, Integer> menuOrders, Map<String, Integer> eventDetails, String visitDate) {
        this.menuOrders = menuOrders;
        this.eventDetails = eventDetails;
        this.visitDate = visitDate;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public Map<String, Integer> getMenuOrders() {
        return menuOrders;
    }

    public Map<String, Integer> getEventDetails() {
        return eventDetails;
    }

    public void changeVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public void addMenuOrder(String menuName, int menuCount) {
        this.menuOrders.put(menuName, menuCount);
    }


}
