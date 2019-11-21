# 장고(django) dtl 실습

사용한 데이터

```python
foods = ["짜장면", "탕수육", "짬뽕", "양장피", "군만두", "고추잡채", "볶음밥"]
    my_sentence = "life is short, you need python"
    messages = ['apple', 'banana', 'cucumber', 'mango']
    datetimenow = datetime.now()  # 현재시간
    empty_list = []
```



참고 공식 사이트 :  https://docs.djangoproject.com/en/2.2/ref/templates/builtins/ 



## templates dtl사용 팁



```python
{% for f in foods %} 
{% endfor %}
```



dtl문은 항상 열고 닫아줘야한다.



dtl 주석은 항상 이중으로 쳐 줘야 한다.

```html
<!-- <p>{#{ my_sentence }}</p> -->
```

!-- 와 대괄호 사이에 #으로 이중 주석



## 반복문

```html
<h3>1. 반복문</h3>
{% for f in foods %}
	<p>{{ f }}</p>
{% endfor %}
<hr />


```



#### 반복문 + 카운터

```html
{% for f in foods %}
	<p>{{ forloop.counter }}. {{ f }}</p>
{% endfor %}
<hr />

```



#### empty문 (비어있으면 아래거 출력)

if문과 비슷한 의미다.

```html
{% for user in empty_list %}
	<p>{{ user }} 입니다. </p>
{% empty %}
	<p>현재 가입한 유저가 없습니다.</p>
{% endfor %}
```



##### for 태그 안에 아무것도 없을 때 밑에 설정된 값이 출력됨.





## 조건문

```html
<h3>2. 조건문</h3>
{% if '짜장면' in foods %}
	<p>짜장면엔 단무지 최고!</p>
{% endif %}
```





#### if, elif, forloop

```html
{% for f in foods %}
    {{ forloop.counter}}번째 .. 
    {% if forloop.first %}
        <p>짜장면 + 고춧가루</p>
    {% else %}
        <p>{{ f }}</p>
    {% endif %}
{% endfor %}
```



첫번째는 

짜장면 + 고춧가루

그 외에는 음식 이름만 출력





## 3. lorem ipsum

```html
<h3>3. lorem ipsum</h3>
{% lorem %}

<hr />

{% lorem 3 w %}

<hr />

{% lorem 4 w random %}
<!-- 단어로 랜덤 4개 -->
<hr />

{% lorem 2 p random %}
<!-- 문장으로 랜덤 2개-->
```



외국 시 가져오기 (텍스트)



## 4. length filter 활용



```html
<h3>4. length filter 활용 </h3>
{% for message in messages %}
    {% if message|length > 5 %}
        <p>글씨가 너무 깁니다.</p>
    {% else %}
        <p>{{message}}, {{message|length}}</p>
    {% endif %}
{% endfor %}
```



## 5. 글자수 제한(truncate)



```html
<h3>5. 글자수 제한(truncate)</h3>
<p>{{ my_sentence }}</p>
<p>{{ my_sentence|truncatewords:3 }} 단어 단위로 제한</p>
<p>{{ my_sentence|truncatechars:5 }} 글자 단위로 제한</p>
<p>{{ my_sentence|truncatechars:15 }} 글자 단위로 제한(15번째 까지)</p>
<hr>
```



## 6. 글자 관련 필터



```html
<h3>6. 글자 관련 필터</h3>
<p>{{ 'abc'|length }}</p> <!-- 길이 -->
<p>{{ 'ABC'|lower }}</p> <!-- 소문자 -->
<p>{{ my_sentence|title}}</p> <!-- 앞 글자만 대문자 -->
<p>{{foods|random}}</p> <!-- 랜덤추출 -->
```



![image-20191111154522157](장고(django) dtl 실습.assets/image-20191111154522157.png)





## 7.연산



```html
<h3>7. 연산</h3>
<p>{{ 4|add:6}}</p>
```



더 복잡한 연산을 하고 싶을 때에는 django-mathfilters를 설치.





## 8.날짜 표현



```html
<h3>8. 날짜 표현</h3>
{{ timenow }} <br>
{% now "DATETIME_FORMAT" %} <br>
{% now "SHORT_DATETIME_FORMAT"%} <br>
{% now "DATE_FORMAT" %} <br>
{% now "SHORT_DATE_FORMAT" %}
<hr>
{% now "Y년 m월 d일 (D) h:i "%} : 직접 지정하는 날짜 형식 <br>
<hr>
{% now "Y" as current_year %}
Copyright {{ current_year }}
<hr>
{{ timenow|date:"SHORT_DATE_FORMAT"}}
```





![image-20191111161907956](장고(django) dtl 실습.assets/image-20191111161907956.png)



## 9. 하이퍼링크



```html
<h3>9. 하이퍼링크 </h3>
{{ 'google.com'|urlize }}
```

