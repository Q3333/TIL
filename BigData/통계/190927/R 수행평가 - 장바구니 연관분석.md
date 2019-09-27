

# 장바구니 연관분석

연관성 규칙은 상품 혹은 서비스 간의 관계를 살펴보고 이로부터 유용한 규칙을 찾아내고자 할 때 이용될 수 있는 기법이다.
데이터들의 빈도수와 동시발생 확률을 이용하여 한 항목들의 그룹과 다른 항목들의 그룹 사이에 강한 연관성이 있음을 밝혀주는 기법이다.

예제 데이터 : B 마트에서 판매된 트랜잭션 데이터 파일
mybasket.csv

변수 : 의류, 냉동식품, 주류, 야채, 제과, 육류, 과자, 생활장식, 우유

분석문제 :
\1. 전체 트랜잭션 개수와 상품아이템 유형은 몇개인가? 

\2. 가장 발생빈도가 높은 상품아이템은 무엇인가? 
\3. 지지도를 10%로 설정했을 때의 생성되는 규칙의 가짓수는? 
\4. 상품 아이템 중에서 가장 발생확률이 높은 아이템과 낮은 아이템은 무엇인가? 
\5. 가장 발생가능성이 높은 <2개 상품간>의 연관규칙은 무엇인가? 
\6. 가장 발생가능성이 높은 <2개 상품이상에서> <제 3의 상품으로>의 연관규칙은 무엇인가?  



전체 코드:

```r
library(arules)
result <- read.transactions("./datas/mybasket.csv", format="basket", sep=",")
result
summary(result)
image(result)
data <- as(result, "data.frame")
rules <- apriori(result, parameter=list(supp=0.1, conf=0.1))
inspect(rules)

library(arulesViz)
plot(rules)
plot(rules, method="grouped")  #lhs가로축 조건과 rhs세로축-결과로 구성한 메트릭스 그래프
plot(rules, method="graph", control=list(type="items"))
plot(rules, method="graph", interactive=TRUE , control=list(type="items"))




  1. 전체 트랜잭션 개수와 상품아이템 유형은 몇개인가?   
    #transaction:786, item:10
  2. 가장  발생빈도가 높은 상품아이템은 무엇인가? 
    #의류
  3. 지지도를 10%로 설정했을 때의 생성되는 규칙의 가짓수는? 
    #rules: 127
  4. 상품 아이템 중에서 가장 발생확률이 높은 아이템과 낮은 아이템은 무엇인가?  
    #의류, 밀크
  5. 가장 발생가능성이 높은 <2개 상품간>의 연관규칙은 무엇인가?
    # 베이커리 <-> 의류 (bakery <-> clothes) 
  6. 가장 발생가능성이 높은 <2개 상품이상에서> <제 3의 상품으로>의 연관규칙은 무엇인가?
     # {deco,frozen}            => {bakery}  0.1488550
     # {bakery,frozen}          => {deco}    0.1488550
     # {bakery,deco}            => {frozen}  0.1488550
    
  
```





1. 답

![1569564366448](assets/1569564366448.png)



10개유형, 786개의 트랜잭션



2. 답

   ![1569564221379](../../%ED%86%B5%EA%B3%84/190927/assets/1569564221379.png)

   

의류가 0.4910941로 가장 높음.



3. 답

![1569564260364](assets/1569564260364.png)



127개의 규칙 가짓수를 가지고 있다.



4. 답

   ![1569564221379](assets/1569564221379.png)



낮음 : 우유

높음 : 의류



5. 답

   ![1569564198234](assets/1569564198234.png)

6. 답 



![1569564140931](C:\Users\student\AppData\Roaming\Typora\typora-user-images\1569564140931.png)