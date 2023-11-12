package christmas.eventplan.badge;

import static christmas.constant.badge.SantaEnum.BADGE_SANTA;
import static christmas.constant.badge.SantaEnum.BADGE_SANTA_MIN;
import static christmas.constant.badge.StarEnum.BADGE_NOT_HAVE;
import static christmas.constant.badge.StarEnum.BADGE_STAR;
import static christmas.constant.badge.StarEnum.BADGE_STAR_MAX;
import static christmas.constant.badge.StarEnum.BADGE_STAR_MIN;
import static christmas.constant.badge.TreeEnum.BADGE_TREE;
import static christmas.constant.badge.TreeEnum.BADGE_TREE_MAX;
import static christmas.constant.badge.TreeEnum.BADGE_TREE_MIN;

public class EventBadge {

    private int totalBenefitAmount;

    private String badgeStatus;

    EventBadge(int totalBenefitAmount) {
        this.totalBenefitAmount = totalBenefitAmount;
        this.badgeStatus = grantToBadge(totalBenefitAmount);
    }

    public String grantToBadge(int totalBenefit) {
        if (validateNotBadge(totalBenefit)) {
            return BADGE_NOT_HAVE.getBadge();
        }
        return grantBadgeOn5000(totalBenefit);
    }

    private boolean validateNotBadge(int totalBenefit) {
        return BADGE_STAR_MIN.getTotalBenefit() > totalBenefit;
    }

    private String grantBadgeOn5000(int totalBenefit) {
        if (validateStar(totalBenefit)) {
            return BADGE_STAR.getBadge();
        }
        return grantBadgeOn10000(totalBenefit);
    }

    private boolean validateStar(int totalBenefit) {
        return BADGE_STAR_MIN.getTotalBenefit() <= totalBenefit && BADGE_STAR_MAX.getTotalBenefit() > totalBenefit;
    }

    private String grantBadgeOn10000(int totalBenefit) {
        if (validateTree(totalBenefit)) {
            return BADGE_TREE.getBadge();
        }
        return grantBadgeOn20000(totalBenefit);
    }

    private boolean validateTree(int totalBenefit) {
        return BADGE_TREE_MIN.getTotalBenefit() <= totalBenefit && BADGE_TREE_MAX.getTotalBenefit() > totalBenefit;
    }

    private String grantBadgeOn20000(int totalBenefit) {
        if (validateSanta(totalBenefit)) {
            return BADGE_SANTA.getBadge();
        }
        return BADGE_NOT_HAVE.getBadge();
    }

    private boolean validateSanta(int totalBenefit) {
        return BADGE_SANTA_MIN.getTotalBenefit() <= totalBenefit;
    }
}
