package christmas.model;

import java.util.ArrayList;
import java.util.List;

public class OrderInfo {
    private List<String> names = new ArrayList<>();
    private List<Integer> counts = new ArrayList<>();
    private List<String> splitMenus = new ArrayList<>();

    public OrderInfo() {
    }

    public void addSplitMenus(String splitMenu) {
        splitMenus.add(splitMenu);
    }

    public void addMenuName(String name) {
        names.add(name);
    }

    public void addMenuCount(int count) {
        counts.add(count);
    }

    public List<String> getSplitMenus() {
        return splitMenus;
    }

    public List<String> getNames() {
        return names;
    }

    public List<Integer> getCounts() {
        return counts;
    }

    public int getNameSize() {
        return names.size();
    }

    public long removeToDrink(List<String> drink) {
        if (!isOrderEmpty()) {
            return names.stream()
                    .distinct()
                    .filter(n -> !drink.contains(n))
                    .count();
        }

        return 1;
    }

    private boolean isOrderEmpty() {
        return (getNameSize() == 0);
    }

    public int maxToCount() {
        return counts.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public long duplicateName() {
        return names.stream()
                .distinct()
                .count();
    }
}
