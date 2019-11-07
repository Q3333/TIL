# CSS 관련



#### 사이즈 속성

em : 부모 속성 2배 (바로 위 항목)

rem : 루트 속성의 2배



#### 색깔관련

hex #ffffff

rgb(0,0,0) : 3색

rgba(0,0,0,0.5) : 마지막은 투명도



#### 공백 디자인 관련

보더를 기준으로 내부가 padding

외부가 margin



#### Display 속성

##### 1. block :화면 1줄을 통째로 차지 (width 가 정해지면 나머지를 margin으로 채움)

margin-right:auto 하면 왼쪽 정렬

block 레벨의 태그는 div, h1~h6, p, ol, ul 등



##### 2. inline : 한 라인을 차지하기 보다는 필요한 부분만 채움

span a, strong, img, br, input, select ,button, textarea 등이 있다.

margin 프로퍼티를 지정할 수 없음



##### 3.inline-block : 마진 프로퍼티 설정 가능

```
2개의 짬뽕입니다. 제일 중요한 성질 자체는 inline과 비슷합니다.
동일 라인에 여러 태그를 붙일 때 쓸 수 있습니다.
다만 위 inline의 단점들을 커버하는 것이 inline-block입니다.
- width/height 적용 가능
- margin/padding-top/bottom 적용 가능
- line-height 적용 가능
다만 고려해야 할 것이 있습니다.
- inline-block 끼리 공백이 생기게 되는데, 이때는 상위 div에 { font-size: 0; } 를 적용하면 해결이 됩니다.
- inline-block 끼리 높이가 안맞을시 상위 공백이 생기는데, 이때는 { vertical-align: ---; } 값으로 top 등을 줘서 맞춰주시면 됩니다. 
```





##### 4.none : 해당 요소를 화면에 표시하지 않는다.

hidden과의 차이점 : hidden은 자리,용량차지, none은 둘다 차지 x





#### 위치 관련 설정

##### 1. Static (기본 위치) 

##### 2. relative(상대 위치) : 

##### 3. absolute (절대 위치) : static을 기준으로 하는 것이 아닌 부모 또는 조상 요소를 기준으로 위치가 결정됨.

##### 4. fixed (고정 위치): 부모 요소와 관계 없이 브라우저의 viewport를 기준, 

#### fixed는 스크롤해도 사라지지 않는다.

