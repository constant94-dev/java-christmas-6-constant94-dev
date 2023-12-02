package christmas.utils.validate;

import static christmas.constant.view.EventPlanner.PLANNER_DISCOUNT_DDAY;
import static christmas.constant.view.EventPlanner.PLANNER_DISCOUNT_GIFT;
import static christmas.constant.view.EventPlanner.PLANNER_DISCOUNT_SPECIAL;
import static christmas.constant.view.EventPlanner.PLANNER_DISCOUNT_WEEKDAY;
import static christmas.constant.view.EventPlanner.PLANNER_DISCOUNT_WEEKEND;
import static christmas.constant.view.EventPlanner.PLANNER_GIFT_MENU;
import static christmas.constant.view.EventPlanner.PLANNER_TOTAL_DISCOUNT;
import static christmas.constant.view.OrderAnomaly.NO_BENEFIT;
import static christmas.constant.view.OrderAnomaly.NO_DISCOUNT_DDAY;
import static christmas.constant.view.OrderAnomaly.NO_DISCOUNT_SPECIAL;
import static christmas.constant.view.OrderAnomaly.NO_DISCOUNT_WEEKDAY;
import static christmas.constant.view.OrderAnomaly.NO_DISCOUNT_WEEKEND;
import static christmas.constant.view.OrderAnomaly.NO_GIFT;

import christmas.constant.view.Menu;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public final class OutputViewValidator {
    private static NumberFormat numberFormat;
    private static StringBuilder printResult;

    public static String validateGift(Map<String, Integer> eventDetails) {
        printResult = new StringBuilder();

        if (isGift(eventDetails)) {
            printResult
                    .append(NO_GIFT.getNoEvent())
                    .append("\n");
            return printResult.toString();
        }
        printResult
                .append(Menu.DRINK_CHAMPAGNE.getMenu())
                .append(" ")
                .append(eventDetails.get(PLANNER_GIFT_MENU.getPlanner()))
                .append("개\n");
        return printResult.toString();
    }

    private static boolean isGift(Map<String, Integer> eventDetails) {
        return eventDetails.get(PLANNER_GIFT_MENU.getPlanner()) == NO_GIFT.getNoCount();
    }

    public static String validateDiscount(Map<String, Integer> eventDetails) {

        String printTogether = haveDiscountDDay(eventDetails)
                + haveDiscountWeekday(eventDetails)
                + haveDiscountWeekend(eventDetails)
                + haveDiscountSpecial(eventDetails)
                + haveDiscountGift(eventDetails);

        return notInBenefit(printTogether);
    }

    private static String notInBenefit(String result) {
        if (result.length() == NO_BENEFIT.getNoCount()) {
            return NO_BENEFIT.getNoEvent() + "\n";
        }
        return result;
    }


    private static String haveDiscountDDay(Map<String, Integer> eventDetails) {
        printResult = new StringBuilder();

        if (eventDetails.get(PLANNER_DISCOUNT_DDAY.getPlanner()) == NO_DISCOUNT_DDAY.getNoCount()) {
            return printResult.toString();
        }
        numberFormat = java.text.NumberFormat.getNumberInstance(Locale.KOREA);
        printResult
                .append(PLANNER_DISCOUNT_DDAY.getPlanner())
                .append(": ")
                .append("-")
                .append(numberFormat.format(eventDetails.get(PLANNER_DISCOUNT_DDAY.getPlanner())))
                .append("원\n");
        return printResult.toString();
    }

    private static String haveDiscountWeekday(Map<String, Integer> eventDetails) {
        printResult = new StringBuilder();
        if (eventDetails.get(PLANNER_DISCOUNT_WEEKDAY.getPlanner()) == NO_DISCOUNT_WEEKDAY.getNoCount()) {
            return printResult.toString();
        }
        numberFormat = java.text.NumberFormat.getNumberInstance(Locale.KOREA);
        printResult
                .append(PLANNER_DISCOUNT_WEEKDAY.getPlanner())
                .append(": ")
                .append("-")
                .append(numberFormat.format(eventDetails.get(PLANNER_DISCOUNT_WEEKDAY.getPlanner())))
                .append("원\n");
        return printResult.toString();
    }

    private static String haveDiscountWeekend(Map<String, Integer> eventDetails) {
        printResult = new StringBuilder();
        if (eventDetails.get(PLANNER_DISCOUNT_WEEKEND.getPlanner()) == NO_DISCOUNT_WEEKEND.getNoCount()) {
            return printResult.toString();
        }
        numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
        printResult
                .append(PLANNER_DISCOUNT_WEEKEND.getPlanner())
                .append(": ")
                .append("-")
                .append(numberFormat.format(eventDetails.get(PLANNER_DISCOUNT_WEEKEND.getPlanner())))
                .append("원\n");
        return printResult.toString();
    }

    private static String haveDiscountSpecial(Map<String, Integer> eventDetails) {
        printResult = new StringBuilder();
        if (eventDetails.get(PLANNER_DISCOUNT_SPECIAL.getPlanner()) == NO_DISCOUNT_SPECIAL.getNoCount()) {
            return printResult.toString();
        }
        numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
        printResult
                .append(PLANNER_DISCOUNT_SPECIAL.getPlanner())
                .append(": ")
                .append("-")
                .append(numberFormat.format(eventDetails.get(PLANNER_DISCOUNT_SPECIAL.getPlanner())))
                .append("원\n");
        return printResult.toString();
    }

    private static String haveDiscountGift(Map<String, Integer> eventDetails) {
        printResult = new StringBuilder();
        if (eventDetails.get(PLANNER_DISCOUNT_GIFT.getPlanner()) == NO_GIFT.getNoCount()) {
            return printResult.toString();
        }
        numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
        printResult
                .append(PLANNER_DISCOUNT_GIFT.getPlanner())
                .append(": ")
                .append("-")
                .append(numberFormat.format(eventDetails.get(PLANNER_DISCOUNT_GIFT.getPlanner())))
                .append("원\n");
        return printResult.toString();
    }

    public static String validateTotalDiscount(Map<String, Integer> eventDetails) {
        printResult = new StringBuilder();
        numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);

        if (eventDetails.get(PLANNER_TOTAL_DISCOUNT.getPlanner()) == NO_BENEFIT.getNoCount()) {
            printResult
                    .append(numberFormat.format(eventDetails.get(PLANNER_TOTAL_DISCOUNT.getPlanner())));
            return printResult.toString();
        }
        printResult
                .append("-")
                .append(numberFormat.format(eventDetails.get(PLANNER_TOTAL_DISCOUNT.getPlanner())));
        return printResult.toString();
    }
}
