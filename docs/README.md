> 크리스마스 프로모션 미션 핵심: 12월 이벤트 계획에 포함된 할인 기능을 제공한다.

## 🎄 크리스마스 프로모션 기능 목록

- [] 크리스마스 프로모션 기능 출발지 - ChristmasPromotion#run()
- [] 크리스마스 디데이 할인
    - [x] 디데이 할인 일자에 맞는 금액 할인 - DDay#discountOnTotalOrderAmount()
    - [x] 디데이 할인 날짜 및 할인 금액 열거형 상수 - DDayEnum
- [] 평일 할인
    - [x] 디저트 메뉴 할인 - Weekday#discountOnDessertMenu()
    - [x] 평일 할인 날짜 및 할인 금액 열거형 상수 - WeekdayEnum
- [] 주말 할인
    - [x] 메인 메뉴 할인 - Weekend#discountOnMainMenu()
    - [x] 주말 할인 날짜 및 할인 금액 열거형 상수 - WeekendEnum
- [] 특별 할인
    - [x] 이벤트 배지 있으면 1,000원 할인 - Special#discountOnStarBadge()
    - [x] 특별 할인 날짜 및 할인 금액 열거형 상수 - SpecialEnum
- [] 증정 이벤트
    - [x] 할인 전 금액 12만원 이상일 때 샴페인 증정 - Gift#giftOnChampagne()
    - [x] 증정 이벤트 금액 열거형 상수 - GiftEnum
- [x] 이벤트 배지 부여 - GrantBadge#grantToBadge()
    - [x] 총 혜택 금액이 5천원 미만일 때 검증 - GrantBadge#validateNotBadge()
    - [x] 총 혜택 금액이 5천원 이상일 때 배지 부여 - GrantBadge#grantBadgeOn5000()
    - [x] 총 혜택 금액이 5천원 이상 1만원 미만일 떼 검증 - GrantBadge#validateStar()
    - [x] 총 혜택 금액이 1만원 이상일 때 배지 부여 - GrantBadge#grantBadgeOn10000()
    - [x] 총 혜택 금액이 1만원 이상 2만원 미만일 때 검증 - GrantBadge#validateTree()
    - [x] 총 혜택 금액이 2만원 이상일 때 배지 부여 - GrantBadge#grantBadgeOn20000()
    - [x] 총 혜택 금액이 2만원 이상일 때 검증 - GrantBadge#validateSanta()

## ♻️ 크리스마스 프로모션 기능 테스트 목록

- [] 크리스마스 디데이 할인
    - [x] 크리스마스 디데이 이벤트 기간에 맞는 할인 금액 확인 - DDayTest#discountOnTotalOrderAmount()
    - [x] 크리스마스 디데이 이벤트 기간에 해당하지 않는 경우 할인 안됨 - DDayTest#discountOnOrderNotInDate()
- [] 평일 할인
    - [x] 평일 이벤트 기간에 맞는 할인 금액 확인 - WeekdayTest#discountOnDessertMenu()
    - [x] 평일 이벤트 기간에 해당하지 않는 경우 할인 안됨 - WeekdayTest#discountOnOrderNotInWeekday()
- [] 주말 할인
    - [x] 주말 이벤트 기간에 맞는 할인 금액 확인 - WeekendTest#discountOnMainMenu()
    - [x] 주말 이벤트 기간에 해당하지 않는 경우 할인 안됨 - WeekendTest#discountOnOrderNotInWeekend()
- [] 특별 할인
    - [x] 특별 이벤트 기간에 맞는 할인 금액 확인 - SpecialTest#discountOnStarBadge()
    - [x] 특별 이벤트 기간에 해당하지 않는 경우 할인 안됨 - Special#discountOnCalendarNotHaveStar()
- [] 증정 이벤트
    - [x] 할인 전 총 주문 금액이 12만원 이상일 때, 샴페인 증정 확인 - GiftTest#giftOnChampagne()
    - [x] 할인 전 총 주문 금액이 12만원 이하일 때, 샴페인 증정 안함 - GiftTest#giftNotHaveChampagne()
- [] 이벤트 배지
    - [x] 총 혜택 금액에 따라서 이벤트 배지 부여 - EventBadgeTest#grantToBadge()