# java-blackjack
블랙잭 게임 미션 저장소

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)



## 블랙잭 1단계 기능 구현

### 게임 초기 상태

- [x] 게임에 참여할 사람 이름을 입력받는다.
  - [x] 입력받는 메시지 출력
   - [x] 쉼표 기준으로 분리
   - [x] 중복은 예외처리

- [x] 딜러와 모든 플레이어에게 카드를 두 장씩 배분한다.

  - [x] 배분 메시지 출력

  - [x] 카드 덱 구현

  - [x] 카드 구현

    - 이미 나누어준 카드는 제외한다.

    - [x] 카드 숫자 원시값을 포장한다.
    - [x] 카드 심볼 원시값을 포장한다.

  - [x] 받을 때마다 전체 카드를 출력한다.

### 게임 진행

- [x] 플레이어는 n 할 때까지 카드를 한 장 더 받을 수 있다.
  - [x] n 이면 중단, y 이면 계속
  - [x] y 또는 n 입력받는다.
  - [x] 받을 때마다 전체 카드 출력
- [x] 딜러는 17 이상이 될 때까지 카드를 한 장 더 받는다. (자동)
  - [x] 딜러가 카드를 받았다는 메시지 출력

### 게임 종료

- [x] 승패를 결정한다.
  - [x] 유저마다 덱 합을 구해 비교
  - [x] 전체 카드와 합을 출력
  - [x] 딜러, 플레이어별 승패 출력
---

## 블랙잭 2단계 기능 구현
### 게임 초기 상태
- [x] 플레이어가 배팅 금액을 입력한다. 
  - [x] 숫자만 받는다.
  - [x] 0 보다 커야 한다.
### 게임 진행
- 1단계와 동일하다.
### 게임 종료
- [x] 플레이어 카드가 두 장이고 블랙잭일 때
  - [x] 배팅 금액의 1.5배를 딜러에게 받는다.
  - [x] 딜러는 마이너스 된다.
- [x] 딜러와 플레이어 동시에 블랙잭일 때 
  - [x] 플레이어는 금액을 돌려받는다. == 수익 0
  - [x] 딜러의 수익도 마이너스 되지 않는다. == 수익 0
- [x] 플레이어가 이겼을 때
  - [x] 플레이어 배팅 금액만큼 수익
  - [x] 플레이어 배팅 금액만큼 딜러 수익 마이너스
- [x] 딜러가 이겼을 때
  - [x] 플레이어 배팅 금액만큼 수익 마이너스
  - [x] 플레이어 배팅 금액만큼 딜러 수익
- [x] 딜러가 버스트일 때
  - [x] 버스트인 플레이어는 패배한다.
  - [x] (버스트인 플레이어를 제외한) 플레이어 배팅 금액만큼 수익
  - [x] 플레이어 배팅 금액만큼 딜러 수익 마이너스
- [x] 플레이어가 버스트일 때
  - [x] 딜러의 패와 상관없이 패배한다.
  - [x] 플레이어 수익 마이너스
  - [x] 플레이어 배팅 금액만큼 딜러 수익
### 추가 리팩토링
- [x] `승패무`를 enum으로 변경한다.
- [x] 디미터 법칙 학습과 적용
- [x] 뷰 리팩토링
  - [x] 빠진 출력 수정
  - [x] 추가 카드 로직 변경