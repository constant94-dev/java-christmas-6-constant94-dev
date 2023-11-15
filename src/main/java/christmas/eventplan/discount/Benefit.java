package christmas.eventplan.discount;

import static christmas.constant.discount.GiftEnum.GIFT_EVENT;
import static christmas.constant.view.EventPlanner.PLANNER_AFTER_DISCOUNT;
import static christmas.constant.view.EventPlanner.PLANNER_BEFORE_DISCOUNT;
import static christmas.constant.view.EventPlanner.PLANNER_DISCOUNT_DDAY;
import static christmas.constant.view.EventPlanner.PLANNER_DISCOUNT_GIFT;
import static christmas.constant.view.EventPlanner.PLANNER_DISCOUNT_SPECIAL;
import static christmas.constant.view.EventPlanner.PLANNER_DISCOUNT_WEEKDAY;
import static christmas.constant.view.EventPlanner.PLANNER_DISCOUNT_WEEKEND;
import static christmas.constant.view.EventPlanner.PLANNER_GIFT_MENU;
import static christmas.constant.view.EventPlanner.PLANNER_TOTAL_DISCOUNT;
import static christmas.constant.view.OrderAnomaly.NO_BADGE;
import static christmas.constant.view.OrderAnomaly.NO_DISCOUNT_DDAY;
import static christmas.constant.view.OrderAnomaly.NO_DISCOUNT_SPECIAL;
import static christmas.constant.view.OrderAnomaly.NO_DISCOUNT_WEEKDAY;
import static christmas.constant.view.OrderAnomaly.NO_DISCOUNT_WEEKEND;
import static christmas.constant.view.OrderAnomaly.NO_GIFT;

import christmas.constant.discount.DDayEnum;
import christmas.constant.discount.SpecialEnum;
import christmas.constant.discount.WeekendEnum;
import christmas.constant.view.Menu;
import christmas.eventplan.badge.EventBadge;
import christmas.model.UserInfo;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Benefit {
    private DDay dDay;
    private Gift gift;
    private Special special;
    private Weekday weekday;
    private Weekend weekend;

    public Benefit() {
        dDay = new DDay();
        gift = new Gift();
        special = new Special();
        weekday = new Weekday();
        weekend = new Weekend();
    }

    public void createEventBenefit(UserInfo userInfo, EventBadge eventBadge) {
        createBeforeOfTotalDiscount(userInfo);
        createDdayDiscount(userInfo);
        createWeekdayDiscount(userInfo);
        createWeekendDiscount(userInfo);
        createSpecialDiscount(userInfo);
        createGiftDiscount(userInfo);

        userInfo.addEventDetail(PLANNER_TOTAL_DISCOUNT.getPlanner(), createTotalBenefitAmount(userInfo));
        userInfo.addEventDetail(PLANNER_AFTER_DISCOUNT.getPlanner(), createDiscountTotalAmount(userInfo));
        createEventBadge(userInfo, eventBadge);
    }

    private void createGiftDiscount(UserInfo userInfo) {
        int giftBenefit = gift.giftOnChampagne(userInfo.getEventDetail(PLANNER_BEFORE_DISCOUNT.getPlanner()));

        isGiftNotInBenefit(userInfo, giftBenefit);
    }

    private void isGiftNotInBenefit(UserInfo userInfo, int giftBenefit) {
        if (isGiftInBenefit(userInfo, giftBenefit)) {
            userInfo.addEventDetail(PLANNER_GIFT_MENU.getPlanner(), giftBenefit);
            userInfo.addEventDetail(PLANNER_DISCOUNT_GIFT.getPlanner(), NO_GIFT.getNoCount());
        }
    }

    private boolean isGiftInBenefit(UserInfo userInfo, int giftBenefit) {
        if (giftBenefit == GIFT_EVENT.getChampagne()) {
            userInfo.addEventDetail(PLANNER_GIFT_MENU.getPlanner(), giftBenefit);
            userInfo.addEventDetail(PLANNER_DISCOUNT_GIFT.getPlanner(), Menu.DRINK_CHAMPAGNE.getPrice());
            return false;
        }
        return true;
    }

    private void createSpecialDiscount(UserInfo userInfo) {
        int specialBenefit = special.discountOnStarBadge(userInfo.getVisitDate());

        isSpecialNotInBenefit(userInfo, specialBenefit);
    }

    private void isSpecialNotInBenefit(UserInfo userInfo, int specialBenefit) {
        if (isSpecialInBenefit(userInfo, specialBenefit)) {
            userInfo.addEventDetail(PLANNER_DISCOUNT_SPECIAL.getPlanner(), specialBenefit);
        }
    }

    private boolean isSpecialInBenefit(UserInfo userInfo, int specialBenefit) {
        if (specialBenefit == SpecialEnum.DAY_NOT_EXIST.getDiscount()) {
            userInfo.addEventDetail(PLANNER_DISCOUNT_SPECIAL.getPlanner(), NO_DISCOUNT_SPECIAL.getNoCount());
            return false;
        }
        return true;
    }

    private void createWeekendDiscount(UserInfo userInfo) {
        int weekEndBenefit = weekend.discountOnWeekend(userInfo.getVisitDate());

        isWeekendNotInBenefit(userInfo, weekEndBenefit);
    }

    private void isWeekendNotInBenefit(UserInfo userInfo, int weekEndBenefit) {
        if (isWeekendInBenefit(userInfo, weekEndBenefit)) {
            userInfo.addEventDetail(
                    PLANNER_DISCOUNT_WEEKEND.getPlanner(),
                    weekend.discountOnMainMenu(userInfo)
            );
        }
    }

    private boolean isWeekendInBenefit(UserInfo userInfo, int weekEndBenefit) {
        if (weekEndBenefit == WeekendEnum.DAY_NOT_EXIST.getDiscount()) {
            userInfo.addEventDetail(PLANNER_DISCOUNT_WEEKEND.getPlanner(), NO_DISCOUNT_WEEKEND.getNoCount());
            return false;
        }
        return true;
    }

    private void createWeekdayDiscount(UserInfo userInfo) {
        int weekDayBenefit = weekday.discountOnWeekday(userInfo.getVisitDate());

        isWeekdayNotInBenefit(userInfo, weekDayBenefit);
    }

    private void isWeekdayNotInBenefit(UserInfo userInfo, int weekDayBenefit) {
        if (isWeekdayInBenefit(userInfo, weekDayBenefit)) {
            userInfo.addEventDetail(
                    PLANNER_DISCOUNT_WEEKDAY.getPlanner(),
                    weekday.discountOnDessertMenu(userInfo)
            );
        }
    }

    private boolean isWeekdayInBenefit(UserInfo userInfo, int weekDayBenefit) {
        if (weekDayBenefit == WeekendEnum.DAY_NOT_EXIST.getDiscount()) {
            userInfo.addEventDetail(PLANNER_DISCOUNT_WEEKDAY.getPlanner(), NO_DISCOUNT_WEEKDAY.getNoCount());
            return false;
        }
        return true;
    }

    private void createDdayDiscount(UserInfo userInfo) {
        int dDayBenefit = dDay.discountOnTotalOrderAmount(userInfo.getVisitDate());

        isDdayNotInBenefit(userInfo, dDayBenefit);
    }

    private void isDdayNotInBenefit(UserInfo userInfo, int dDayBenefit) {
        if (isDdayInBenefit(userInfo, dDayBenefit)) {
            userInfo.addEventDetail(PLANNER_DISCOUNT_DDAY.getPlanner(), dDayBenefit);
        }
    }

    private boolean isDdayInBenefit(UserInfo userInfo, int dDayBenefit) {
        if (dDayBenefit == DDayEnum.DAY_NOT_EXIST.getDiscount()) {
            userInfo.addEventDetail(PLANNER_DISCOUNT_DDAY.getPlanner(), NO_DISCOUNT_DDAY.getNoCount());
            return false;
        }
        return true;
    }

    private void createBeforeOfTotalDiscount(UserInfo userInfo) {
        int totalAmount = getTotalOrderAmount(userInfo.getMenuOrders());
        userInfo.addEventDetail(PLANNER_BEFORE_DISCOUNT.getPlanner(), totalAmount);
    }

    public int createDiscountTotalAmount(UserInfo userInfo) {
        int totalDiscount = userInfo.getEventDetail(PLANNER_TOTAL_DISCOUNT.getPlanner());
        int totalBeforeAmount = userInfo.getEventDetail(PLANNER_BEFORE_DISCOUNT.getPlanner());

        int totalAfterAmount = (totalBeforeAmount - totalDiscount);

        return calculateEventToGift(userInfo, totalAfterAmount);
    }

    private int calculateEventToGift(UserInfo userInfo, int totalAfterAmount) {
        if (isChampagne(userInfo)) {
            return totalAfterAmount + Menu.DRINK_CHAMPAGNE.getPrice();
        }
        return totalAfterAmount;
    }

    private boolean isChampagne(UserInfo userInfo) {
        return userInfo.getEventDetail(PLANNER_DISCOUNT_GIFT.getPlanner()) != GIFT_EVENT.getChampagne();
    }

    public int createTotalBenefitAmount(UserInfo userInfo) {
        List<String> discountDetails = List.of(
                PLANNER_DISCOUNT_DDAY.getPlanner(),
                PLANNER_DISCOUNT_WEEKDAY.getPlanner(),
                PLANNER_DISCOUNT_WEEKEND.getPlanner(),
                PLANNER_DISCOUNT_SPECIAL.getPlanner(),
                PLANNER_DISCOUNT_GIFT.getPlanner()
        );

        int totalBenefitAmount = 0;
        Set<Entry<String, Integer>> eventDetails = userInfo.getEventDetails().entrySet();

        for (Entry<String, Integer> event : eventDetails) {
            totalBenefitAmount += hasTotalBenefitAmount(discountDetails, event);
        }

        return totalBenefitAmount;
    }

    private int hasTotalBenefitAmount(List<String> discountDetails, Entry<String, Integer> event) {
        String result = discountDetails.stream()
                .filter(d -> event.getKey().equals(d))
                .findFirst()
                .orElse(NO_BADGE.getNoEvent());

        return totalBenefitAmountCalculate(result, event);
    }

    private int totalBenefitAmountCalculate(String result, Entry<String, Integer> event) {
        if (result.equals(event.getKey())) {
            return event.getValue();
        }
        return 0;
    }

    public String createEventBadge(UserInfo userInfo, EventBadge eventBadge) {
        String badge = eventBadge.grantToBadge(userInfo.getEventDetail(PLANNER_TOTAL_DISCOUNT.getPlanner()));
        eventBadge.changeBadgeStatus(badge);
        return eventBadge.getBadgeStatus();
    }

    public int getTotalOrderAmount(Map<String, Integer> menuOrders) {
        Set<Entry<String, Integer>> menus = menuOrders.entrySet();
        int totalAmount = 0;

        for (Entry<String, Integer> menu : menus) {
            totalAmount += hasTotalOrderAmount(menu);
        }

        return totalAmount;
    }

    private int hasTotalOrderAmount(Entry<String, Integer> menu) {
        Menu menuEnum = Arrays.stream(Menu.values())
                .filter(m -> m.getMenu().equals(menu.getKey()))
                .findFirst()
                .orElse(Menu.NOT_EXIST_MENU);

        return totalAmountCalculate(menuEnum, menu);
    }

    private int totalAmountCalculate(Menu menuEnum, Entry<String, Integer> menu) {
        return menuEnum.getPrice() * menu.getValue();
    }
}
