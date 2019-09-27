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




 # 1. 전체 트랜잭션 개수와 상품아이템 유형은 몇개인가?   
    #transaction:786, item:10
 # 2. 가장  발생빈도가 높은 상품아이템은 무엇인가? 
    #의류
 # 3. 지지도를 10%로 설정했을 때의 생성되는 규칙의 가짓수는? 
    #rules: 127
 # 4. 상품 아이템 중에서 가장 발생확률이 높은 아이템과 낮은 아이템은 무엇인가?  
    #의류, 밀크
 # 5. 가장 발생가능성이 높은 <2개 상품간>의 연관규칙은 무엇인가?
    # 베이커리 <-> 의류 (bakery <-> clothes) 
 # 6. 가장 발생가능성이 높은 <2개 상품이상에서> <제 3의 상품으로>의 연관규칙은 무엇인가?
     # {deco,frozen}            => {bakery}  0.1488550
     # {bakery,frozen}          => {deco}    0.1488550
     # {bakery,deco}            => {frozen}  0.1488550
    
  