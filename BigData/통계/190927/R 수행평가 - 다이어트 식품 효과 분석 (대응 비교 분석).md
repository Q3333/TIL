#############다이어트 식품 효과 분석 ################
짝을 이루는 두 집단의 평균이 서로 같은지, 다른지를 검증하는 것을 대응 두집단 평균차이 분석이라고 한다.

한 집단을 대상으로 사전-사후 효과 비교 시 많이 사용되고 있는 방법

예제 데이터 : 새로운 다이어트 효능식품을 복용한 시험참가자의 몸무게 변화를 조사한 데이터
myeffect.csv

변수명 : id, before(다이어트 효능식품 복용 전 몸무게), after( 다이어트 효능식품 복용 후 몸무게 )

분석문제 :
  1. 복용 전과 복용 후의 시험 참가자와 빈도수와 몸무게 평균값을 구하시오
2. 실제 한 달 간의 시험기간을 완수한 시험참가자들만의 데이터를 별도로 추출하시오
3. 2개의 몸무게 집단 데이터 간의 분포모양이 비슷한지를 검정하시오
4. 복용 전과 복용 후에 효과 차이가 있는지를 검정하시오



답 : 

```r
data <- read.csv("./datas/myeffect.csv", header=TRUE)
head(data)
str(data)  #before, after 컬럼, 관측치 100개
length(data$after)

result <- subset(data, after<200, c(before, after))
length(result$after)   # 결측치 9개 제외됨 (999인 값들)

result

x<-result$before
y<-result$after
mean(x)  #65.61968 - before
mean(y)  #57.94016 - after

mean(x) - mean(y)

#동질성 검정
var.test(x, y, paired=TRUE)
해석 : 검정 통계량 p-value 값은  0.7056744로 유의수준 0.05보다 크기 때문에
두 집단간의 분포형태가 동일하다

#평균 차이 검정
t.test(x, y, paired=TRUE, alter="two.sided", conf.int=TRUE, conf.level=0.95)
해석 : 검정 통계량 p-value 값은  2.2e-16 로 유의수준 0.05보다 매우 작기 때문에
두 집단간의 평균에 차이가 있다 

t.test(x, y, paired=TRUE, alter="greater", conf.int=TRUE, conf.level=0.95)
해석 : 검정 통계량 p-value 값은 2.2e-16 로 유의수준 0.05보다 매우 작기 때문에
x 집단 평균이 y집단의 평균보다 크다고 할 수 있다




#분석문제 :
#1. 복용 전과 복용 후의 시험 참가자와 빈도수와 몸무게 평균값을 구하시오
 # 도중 포기 없이 완수한 참가자들의 빈도 : 0.9651163
 # 몸무게 평균값  #65.61968 - before /  #57.94016 - after
  
#2. 실제 한 달 간의 시험기간을 완수한 시험참가자들만의 데이터를 별도로 추출하시오
#  result <- subset(data, after<200, c(before, after))
#  length(result$after)   # 결측치 9개 제외됨 (999인 값들)
# 위 코드로 9명의 참가자를 제외했다.

#3. 2개의 몸무게 집단 데이터 간의 분포모양이 비슷한지를 검정하시오
 # 동질성 검정 결과 분포 형태가 동일하다.

#4. 복용 전과 복용 후에 효과 차이가 있는지를 검정하시오
  # 복용 후  7.679518 만큼의 체중감량효과가 있었다. -> 효과 차이 있음
  
```



  # 
