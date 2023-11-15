package christmas;

import christmas.eventplan.badge.EventBadge;
import christmas.eventplan.discount.Benefit;
import christmas.eventplan.view.InputView;
import christmas.eventplan.view.OutputView;
import christmas.model.OrderInfo;
import christmas.model.UserInfo;

public class ChristmasPromotion {
    private UserInfo userInfo;
    private OrderInfo orderInfo;
    private Benefit benefit;
    private EventBadge eventBadge;

    private InputView inputView;
    private OutputView outputView;

    public void run() {
        ready();
        promotionPlay();
    }

    private void ready() {
        userInfo = new UserInfo();
        orderInfo = new OrderInfo();
        benefit = new Benefit();
        eventBadge = new EventBadge();
        inputView = new InputView();
        outputView = new OutputView();
    }

    private void promotionPlay() {
        inputView.helloWooTeco();
        inputView.visitToDate(userInfo);
        inputView.orderToMenuAndCount(userInfo, orderInfo);

        benefit.createEventBenefit(userInfo, eventBadge);

        outputView.printWooTecoEventPreview(userInfo.getVisitDate());
        outputView.printOrderToMenu(userInfo.getMenuOrders());
        outputView.printTotalOrderAmountBeforeDiscount(userInfo.getEventDetails());
        outputView.printGiftToMenu(userInfo.getEventDetails());
        outputView.printDiscountDetails(userInfo.getEventDetails());
        outputView.printTotalDiscount(userInfo.getEventDetails());
        outputView.printEstimatedAmountAfterDiscount(userInfo.getEventDetails());
        outputView.printEventBadge(eventBadge.getBadgeStatus());
    }
}
