# team08_week4
##전화요금조회 테스트 
+201202160 이상희
+201402369 심예인
+201402418 전소향
+201203399 이형진

<hr/>
이 프로그램은 전화요금을 계산한 요금서를 사용자에게 보여준다는 것을 전제로 만든 프로그램이다. 2주차 과제 때 작성한 클래스다이어그램을 기반으로 작성하였다.

 먼저 *Plan* interface를 생성하여 타입별 필요한 Get메소드를 정의하였고, 이를 *Silver*와 *Gold*에서 implement하였다. Silver와 Gold클래스는 타입별 기본요금, 기본통화량, 추가통화비용, 추가라인비용, family discount 기준수와 비용이 정의되어있다.
 *User*클래스는 사용자의 정보를 저장하는 클래스이다. 사용자가 사용한 통화량,라인수,plan타입,이름을 저장한다. 
 *Calculator*클래스는 User타입객체와 Plan타입(Gold or Silver)객체를 생성해서 요금을 계산하는 클래스이다. 이 클래스 내에서 사용자에게 적용 될 family discount 라인수, 추가라인 수를 구한다. 그리고 총 라인 비용(lineBill), 통화량 비용(minutesBill)을 구해 total비용을 구한다. 
 *BillViewService*클래스는  사용자의 요금서에 나타낼 내용을 정의하는 클래스이다. Plan(Gold or Silver)타입별 요금과 사용자가 사용한 요금, 요금의 계산 과정과 총 지출해야할 total비용을 String으로 나타낸다. 
 *App*클래스는 BillBiewService클래스에서 정의한 내용들을 출력하여 보여주는 클래스이다. 
 