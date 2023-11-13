package christmas.model;

import java.util.List;

public class OrderInfo {
    private List<String> names;
    private List<Integer> counts;

    public OrderInfo(List<String> names, List<Integer> counts) {
        this.names = names;
        this.counts = counts;
    }

    public void addMenuName(String name) {
        names.add(name);
    }

    public void addMenuCount(int count) {
        counts.add(count);
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

    public List<String> removeToDrink(List<String> drink) {
        return names.stream()
                .distinct()
                .filter(n -> !drink.contains(n))
                .toList();
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
