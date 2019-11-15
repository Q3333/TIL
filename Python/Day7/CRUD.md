# CRUD



create read update delete



게시판 만들기



article = Article.objects.get(pk=pk)에서

pk = pk는

id_exact=pk 와 같은 의미 (아이디가 pk와 정확히 같을 경우)



#### - Create 

##### 	- new/ 폼을 보여줌

##### 	- create/ submit 했을 때 저장



#### - Read

##### 	- index에서 모든 글 보여주고

##### 	- 해당 글 리스트에서 제목을 클릭하면 자세한 정보를 보여줌 (하이퍼링크), (urls - detail)



#### - Update

#####    - detail 페이지에서 수정하기 버튼으로 접근

##### 	- form에 해당 article의 정보를 채워둔 채로 보여주기

##### 	- 수정하면 detail 페이지로 돌아가 수정한 결과를 보여줌



#### - Delete

##### 	- detail 페이지에서 삭제하기 버튼으로 접근

##### 	- id 값을 받아서 삭제 후 index 페이지로 돌아감.



#### @리스트 정렬

#### 1. 파이썬에서 정렬하기

```python
articles = Article.objects.all()[::-1]
```

[::-1]을 붙이면 역순 정렬이 됨.



#### 2. sql에서 정렬하기

```python
articles = Article.objects.order_by('-id')
```

id를 기준으로 역정렬함.



order_by는 get문에서는 쓸 수 없음.(인스턴스이기 때문)

그러므로 filter로 바꿔주어야 정렬을 할 수 있다.

```
article = Article.objects.filter(pk=pk).order_by('-id')
```

