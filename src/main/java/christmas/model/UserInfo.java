package christmas.model;

import java.util.HashMap;
import java.util.Map;

public class UserInfo {
    private String visitDate = "";

    private Map<String, Integer> eventDetails = new HashMap<>();
    private Map<String, Integer> menuOrders = new HashMap<>();

    public UserInfo() {
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

    public Integer getEventDetail(String key) {
        return eventDetails.get(key);
    }

    public void changeVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public void addMenuOrder(String menuName, int menuCount) {
        menuOrders.put(menuName, menuCount);
    }

    public void addEventDetail(String title, int eventResult) {
        eventDetails.put(title, eventResult);
    }

}
