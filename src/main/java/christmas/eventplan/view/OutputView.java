package christmas.eventplan.view;

import static christmas.constant.view.EventPlanner.PLANNER_AFTER_DISCOUNT;
import static christmas.constant.view.EventPlanner.PLANNER_BEFORE_DISCOUNT;
import static christmas.constant.view.EventPlanner.PLANNER_DISCOUNT;
import static christmas.constant.view.EventPlanner.PLANNER_EVENT_BADGE;
import static christmas.constant.view.EventPlanner.PLANNER_GIFT_MENU;
import static christmas.constant.view.EventPlanner.PLANNER_ORDER_MENU;
import static christmas.constant.view.EventPlanner.PLANNER_PREVIEW;
import static christmas.constant.view.EventPlanner.PLANNER_TOTAL_DISCOUNT;
import static christmas.utils.validate.OutputViewValidator.validateDiscount;
import static christmas.utils.validate.OutputViewValidator.validateGift;
import static christmas.utils.validate.OutputViewValidator.validateTotalDiscount;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class OutputView {

    StringBuilder printResult;
    NumberFormat numberFormat;

    public void printWooTecoEventPreview(String visitDate) {
        System.out.printf((PLANNER_PREVIEW.getPlanner() + "\n\n"), visitDate);
    }

    public void printOrderToMenu(Map<String, Integer> menuOrders) {
        printResult = new StringBuilder();
        Set<Entry<String, Integer>> menus = menuOrders.entrySet();

        printResult
                .append(PLANNER_ORDER_MENU.getPlanner())
                .append("\n");

        for (Map.Entry<String, Integer> menu : menus) {
            printResult
                    .append(menu.getKey())
                    .append(" ")
                    .append(menu.getValue())
                    .append("개\n");
        }

        System.out.println(printResult);
    }

    public void printTotalOrderAmountBeforeDiscount(Map<String, Integer> eventDetails) {
        printResult = new StringBuilder();
        numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);

        printResult
                .append(PLANNER_BEFORE_DISCOUNT.getPlanner())
                .append("\n")
                .append(numberFormat.format(eventDetails.get(PLANNER_BEFORE_DISCOUNT.getPlanner())))
                .append("원\n");

        System.out.println(printResult);
    }

    public void printGiftToMenu(Map<String, Integer> eventDetails) {
        printResult = new StringBuilder();

        printResult
                .append(PLANNER_GIFT_MENU.getPlanner())
                .append("\n");

        printResult
                .append(validateGift(eventDetails));

        System.out.println(printResult);
    }

    public void printDiscountDetails(Map<String, Integer> eventDetails) {
        printResult = new StringBuilder();

        printResult
                .append(PLANNER_DISCOUNT.getPlanner())
                .append("\n");

        printResult
                .append(validateDiscount(eventDetails));

        System.out.println(printResult);
    }

    public void printTotalDiscount(Map<String, Integer> eventDetails) {
        printResult = new StringBuilder();

        printResult
                .append(PLANNER_TOTAL_DISCOUNT.getPlanner())
                .append("\n");

        printResult
                .append(validateTotalDiscount(eventDetails))
                .append("원\n");

        System.out.println(printResult);
    }

    public void printEstimatedAmountAfterDiscount(Map<String, Integer> eventDetails) {
        printResult = new StringBuilder();
        numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);

        printResult
                .append(PLANNER_AFTER_DISCOUNT.getPlanner())
                .append("\n")
                .append(numberFormat.format(eventDetails.get(PLANNER_AFTER_DISCOUNT.getPlanner())))
                .append("원\n");

        System.out.println(printResult);
    }

    public void printEventBadge(String eventBadge) {
        printResult = new StringBuilder();

        printResult
                .append(PLANNER_EVENT_BADGE.getPlanner())
                .append("\n")
                .append(eventBadge);

        System.out.println(printResult);
    }
}
