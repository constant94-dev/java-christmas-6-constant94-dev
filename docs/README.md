> 크리스마스 프로모션 미션 핵심: 12월 이벤트 계획에 포함된 할인 기능을 제공한다.

## 🎄 크리스마스 프로모션 기능 목록

- [] 크리스마스 프로모션 기능 출발지 - ChristmasPromotion#run()
- [] 크리스마스 디데이 할인
    - [x] 디데이 할인 일자에 맞는 금액 할인 - D_Day#discountOnTotalOrderAmount()
- [] 평일 할인
    - [x] 디저트 메뉴 할인 - Weekday#discountOnDessertMenu()
- [] 주말 할인
    - [x] 메인 메뉴 할인 - Weekend#discountOnMainMenu()
- [] 특별 할인
    - [x] 이벤트 배지 있으면 1,000원 할인 - Special#discountOnBadge()
- [] 증정 이벤트
    - [] 할인 전 금액 12만원 이상일 때 샴페인 증정 - Gift#giftOnChampagne()
- [] 이벤트 배지 부여
    - [] 총 혜택 금액이 5천원 이상일 때 별 배지 부여 - Star#grantBadgeOn5000()
    - [] 총 혜택 금액이 1만원 이상일 때 트리 배지 부여 - Tree#grantBadgeOn10000()
    - [] 총 혜택 금액이 2만원 이상일 때 산타 배지 부여 - Santa#grantBadgeOn20000()

## ♻️ 크리스마스 프로모션 기능 테스트 목록